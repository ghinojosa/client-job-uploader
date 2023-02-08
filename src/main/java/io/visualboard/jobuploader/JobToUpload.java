package io.visualboard.jobuploader;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * Represents a job order that is being uploaded to VisualBoard
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JobToUpload {

    @JsonProperty("reference")
    private String reference;

    @JsonProperty("partReference")
    private String partReference;

    @JsonProperty("operationReference")
    private String operationReference;

    @JsonProperty("quantity")
    private BigDecimal quantity = BigDecimal.ZERO;

    public JobToUpload() {  }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPartReference() {
        return partReference;
    }

    public void setPartReference(String partReference) {
        this.partReference = partReference;
    }

    public String getOperationReference() {
        return operationReference;
    }

    public void setOperationReference(String operationReference) {
        this.operationReference = operationReference;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
