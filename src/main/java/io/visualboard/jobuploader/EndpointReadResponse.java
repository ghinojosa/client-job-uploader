package io.visualboard.jobuploader;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * This object contains the response from reading the client's endpoint with the list of jobs
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointReadResponse {

    @JsonProperty("cells")
    private List<ClientJob> cells;

    public EndpointReadResponse() { }

    public List<ClientJob> getCells() {
        return cells;
    }

    public void setCells(List<ClientJob> cells) {
        this.cells = cells;
    }
}
