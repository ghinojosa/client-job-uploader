package io.visualboard.jobuploader;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * This class must contain the job order format used by the client's ERP or MRP
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientJob {

    /**
     * Job reference
     */
    @JsonProperty("job")
    private String job;

    /**
     * Operation reference
     */
    @JsonProperty("ct")
    private String ct;

    /**
     * Part reference
     */
    @JsonProperty("NP")
    private String nP;

    /**
     * Order quantity
     */
    @JsonProperty("Order_Quantity")
    private String orderQuantity;

    /**
     * Display text
     */
    @JsonProperty("Sched_Start")
    private String schedStart;

    public ClientJob() { }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }

    public String getnP() {
        return nP;
    }

    public void setnP(String nP) {
        this.nP = nP;
    }

    public String getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(String orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getSchedStart() {
        return schedStart;
    }

    public void setSchedStart(String schedStart) {
        this.schedStart = schedStart;
    }
}
