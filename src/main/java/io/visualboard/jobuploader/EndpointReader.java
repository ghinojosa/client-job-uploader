package io.visualboard.jobuploader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Returns a list of {@link ClientJob} from the client's endpoint
 */
public class EndpointReader {

    /**
     * Returns a list of {@link ClientJob} from the client's endpoint
     */
    List<ClientJob> read(String endpointUrl) {
        System.out.println("Reading jobs from " + endpointUrl);
        // Create a http request in order ro obtain the list of jobs
        HttpRequest request = HttpRequest.newBuilder()
                .uri(getURI(endpointUrl))
                .timeout(Duration.ofSeconds(3l))
                .GET()
                .build();
        // Send the request and process the response
        HttpResponse<String> response = sendRequest(request);
        // Get the JSON from the response body, and convert to list of ClientJobs
        String jsonBody = response.body();
        ClientJob[] jobs = readJobsFromJson(jsonBody);
        return new ArrayList<>(Arrays.asList(jobs));
    }

    // Returns an array containing job orders from the client's endpoint
    private ClientJob[] readJobsFromJson(String jsonBody) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonBody, ClientJob[].class);
        } catch(JsonProcessingException ex) {
            System.out.println("Error reading jobs from JSON: " + ex.getMessage());
            return null;
        }
    }

    private HttpResponse<String> sendRequest(HttpRequest request) {
        HttpClient client = HttpClient.newHttpClient();
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            System.out.println("Error sending GET request to client's endpoint " + e.getMessage());
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            System.out.println("Error sending GET request to client's endpoint " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private URI getURI(String endpointUrl) {
        try {
            return new URI(endpointUrl);
        } catch (URISyntaxException ex) {
            System.out.println("Error getting URI for client's endpoint " + ex.getMessage());
            return null;
        }
    }
}
