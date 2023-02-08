package io.visualboard.jobuploader;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the response after attempting to upload one or more job order
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointWriteResponse {

    @JsonProperty("jobsAdded")
    private int jobsAdded = 0;

    @JsonProperty("jobsUnchanged")
    private int jobsUnchanged = 0;

    @JsonProperty("jobsUpdated")
    private int jobsUpdated = 0;

    @JsonProperty("errorCount")
    private int errorCount = 0;

    @JsonProperty("jobUploadedList")
    private List<JobUploaded> jobUploadedList = new ArrayList<>();

    public EndpointWriteResponse() { }

    public int getJobsAdded() {
        return jobsAdded;
    }

    public void setJobsAdded(int jobsAdded) {
        this.jobsAdded = jobsAdded;
    }

    public int getJobsUnchanged() {
        return jobsUnchanged;
    }

    public void setJobsUnchanged(int jobsUnchanged) {
        this.jobsUnchanged = jobsUnchanged;
    }

    public int getJobsUpdated() {
        return jobsUpdated;
    }

    public void setJobsUpdated(int jobsUpdated) {
        this.jobsUpdated = jobsUpdated;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }

    public List<JobUploaded> getJobUploadedList() {
        return jobUploadedList;
    }

    public void setJobUploadedList(List<JobUploaded> jobUploadedList) {
        this.jobUploadedList = jobUploadedList;
    }
}
