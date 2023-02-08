package io.visualboard.jobuploader;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointWriteRequest {

    @JsonProperty("jobToUploadList")
    private List<JobToUpload> jobToUploadList;

    public List<JobToUpload> getJobToUploadList(){
        return jobToUploadList;
    }

    public void setJobToUploadList(List<JobToUpload> list) {
        jobToUploadList = list;
    }

}
