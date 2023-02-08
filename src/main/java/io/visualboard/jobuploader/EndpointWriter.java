package io.visualboard.jobuploader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Uploads job orders to VisualBoard
 */
public class EndpointWriter {

    private static final DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

    /**
     * Uploads a list of jobs to VisualBoard and creates a response JSON file
     */
    void write(List<JobToUpload> jobsToUpload, String endpointUrl, String apiKey) {
        System.out.println("Writing jobs to " + endpointUrl);
        // Create a request object with the list of jobsToUpload
        EndpointWriteRequest uploadRequest = new EndpointWriteRequest();
        uploadRequest.setJobToUploadList(jobsToUpload);
        // Convert the upload request object to a JSON string
        String uploadRequestJson = convertUploadRequesToJSONString(uploadRequest);
        // Create the HTTP request
        HttpRequest request = createHttpRequest(uploadRequestJson, endpointUrl, apiKey);
        // Call server and get the response as a JSON string
        String responseAsJson = callServerToUpload(request);
        // Convert the response to Java Object and log it
        EndpointWriteResponse response = convertResponseFromJson(responseAsJson);
        logResponseToFile(response);
    }

    private void logResponseToFile(EndpointWriteResponse response) {
        ObjectMapper objectMapper = new ObjectMapper();
        // create an instance of DefaultPrettyPrinter
        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
        String fileName = dateFmt.format(LocalDateTime.now());
        try {
            writer.writeValue(Paths.get(fileName + ".json").toFile(), response);
        } catch (StreamWriteException e) {
            System.out.println("Error logging upload response as JSON: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            System.out.println("Error logging upload response as JSON: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error logging upload response as JSON: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private EndpointWriteResponse convertResponseFromJson(String responseAsJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(responseAsJson, EndpointWriteResponse.class);
        } catch (JsonMappingException e) {
            System.out.println("Error converting response to object " + e.getMessage());
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            System.out.println("Error converting response to object " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private String callServerToUpload(HttpRequest request) {
        HttpClient client = HttpClient.newHttpClient();
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException e) {
            System.out.println("Error calling server to upload: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            System.out.println("Error calling server to upload: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private HttpRequest createHttpRequest(String bodyJson, String endpointUrl, String apiKey) {
        return HttpRequest.newBuilder()
                .uri(getUploadEndpointURI(endpointUrl))
                .timeout(Duration.ofSeconds(5l))
                .POST(HttpRequest.BodyPublishers.ofString(bodyJson))
                .header("x-api-key", apiKey)
                .header("Content-type", "application/json")
                .build();
    }

    private URI getUploadEndpointURI(String endpointUrl) {
        try {
            return new URI(endpointUrl);
        } catch (URISyntaxException e) {
            System.out.println("Error getting VisualBoard upload endpoint: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private String convertUploadRequesToJSONString(EndpointWriteRequest request) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(request);
        } catch (JsonProcessingException e) {
            System.out.println("Error converting JobUploadRequest to JSON string: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
