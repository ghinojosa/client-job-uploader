package io.visualboard.jobuploader;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * Represents the result of each job order being uploaded
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JobUploaded {

    @JsonProperty("jobId")
    private Long jobId;

    @JsonProperty("reference")
    private String reference;

    @JsonProperty("position")
    private int position = 0;

    @JsonProperty("lineId")
    private Integer lineId;

    @JsonProperty("lineName")
    private String lineName;

    @JsonProperty("cellId")
    private Integer cellId;

    @JsonProperty("cellName")
    private String cellName;

    @JsonProperty("operationId")
    private Integer operationId;

    @JsonProperty("operationName")
    private String operationName;

    @JsonProperty("partId")
    private Integer partId;

    @JsonProperty("partName")
    private String partName;

    @JsonProperty("quantity")
    private BigDecimal quantity;

    @JsonProperty("displayText")
    private String displayText;

    @JsonProperty("priority")
    private int priority = 0;

    @JsonProperty("result")
    private String result;

    @JsonProperty("resultId")
    private Integer resultId;

    @JsonProperty("error")
    private String error;

    @JsonProperty("errorId")
    private Integer errorId;

    public JobUploaded() { }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public Integer getCellId() {
        return cellId;
    }

    public void setCellId(Integer cellId) {
        this.cellId = cellId;
    }

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public Integer getPartId() {
        return partId;
    }

    public void setPartId(Integer partId) {
        this.partId = partId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getErrorId() {
        return errorId;
    }

    public void setErrorId(Integer errorId) {
        this.errorId = errorId;
    }
}
