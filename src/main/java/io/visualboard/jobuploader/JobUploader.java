package io.visualboard.jobuploader;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class JobUploader {

    private final static EndpointReader reader = new EndpointReader();
    private final static EndpointWriter writer = new EndpointWriter();

    public static void main(String[] args) {
        String readEndpoint = args[0];
        String writeEndpoint = "https://" + args[1] + ".visualboard.app/api/v1/job-uploads";
        String apiKey = args[2];

        System.out.println("Client's endpoint : " + readEndpoint);
        System.out.println("VisualBoard's upload endpoint : " + writeEndpoint);
        System.out.println("VisualBoard's API key: " + apiKey);

        // Step one: Read the job orders from the client endpoint
        List<ClientJob> clientJobs = reader.read(readEndpoint);
        if(clientJobs.isEmpty())
            return;
        // Convert clientJobs to JobToUpload
        List<JobToUpload> jobsToUpload = clientJobs.stream().map(jobMapper).collect(toList());
        // Step two: Write job orders to VisualBoard endpoint
        writer.write(jobsToUpload, writeEndpoint, apiKey);
    }

    // Converts a ClientJob to JobToUpload
    private static final Function<ClientJob, JobToUpload> jobMapper = (clientJob) -> {
        JobToUpload jobToUpload = new JobToUpload();
        jobToUpload.setReference(clientJob.getJob());
        jobToUpload.setOperationReference(clientJob.getCt());
        jobToUpload.setPartReference(clientJob.getnP());
        jobToUpload.setQuantity(new BigDecimal(clientJob.getOrderQuantity()));
        return jobToUpload;
    };
}