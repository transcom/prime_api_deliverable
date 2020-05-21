/*
 * Milmove Prime API
 * The Prime API is a RESTful API that enables the Prime contractor to request information about upcoming moves, update the details and status of those moves, and make payment requests. It uses Mutual TLS for authentication procedures.  All endpoints are located at `primelocal/prime/v1/`. 
 *
 * OpenAPI spec version: 0.0.1
 * Contact: dp3@truss.works
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.PaymentRequestStatus;
import io.swagger.client.model.ProofOfServiceDocs;
import java.io.IOException;
import java.util.UUID;

/**
 * PaymentRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-05-15T13:04:32.719-07:00")
public class PaymentRequest {
  @SerializedName("proofOfServiceDocs")
  private ProofOfServiceDocs proofOfServiceDocs = null;

  @SerializedName("id")
  private UUID id = null;

  @SerializedName("isFinal")
  private Boolean isFinal = false;

  @SerializedName("moveTaskOrderID")
  private UUID moveTaskOrderID = null;

  @SerializedName("rejectionReason")
  private String rejectionReason = null;

  @SerializedName("status")
  private PaymentRequestStatus status = null;

  @SerializedName("paymentRequestNumber")
  private String paymentRequestNumber = null;

  @SerializedName("eTag")
  private String eTag = null;

  public PaymentRequest proofOfServiceDocs(ProofOfServiceDocs proofOfServiceDocs) {
    this.proofOfServiceDocs = proofOfServiceDocs;
    return this;
  }

   /**
   * Get proofOfServiceDocs
   * @return proofOfServiceDocs
  **/
  @ApiModelProperty(value = "")
  public ProofOfServiceDocs getProofOfServiceDocs() {
    return proofOfServiceDocs;
  }

  public void setProofOfServiceDocs(ProofOfServiceDocs proofOfServiceDocs) {
    this.proofOfServiceDocs = proofOfServiceDocs;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "c56a4180-65aa-42ec-a945-5fd21dec0538", value = "")
  public UUID getId() {
    return id;
  }

  public PaymentRequest isFinal(Boolean isFinal) {
    this.isFinal = isFinal;
    return this;
  }

   /**
   * Get isFinal
   * @return isFinal
  **/
  @ApiModelProperty(value = "")
  public Boolean isIsFinal() {
    return isFinal;
  }

  public void setIsFinal(Boolean isFinal) {
    this.isFinal = isFinal;
  }

  public PaymentRequest moveTaskOrderID(UUID moveTaskOrderID) {
    this.moveTaskOrderID = moveTaskOrderID;
    return this;
  }

   /**
   * Get moveTaskOrderID
   * @return moveTaskOrderID
  **/
  @ApiModelProperty(example = "c56a4180-65aa-42ec-a945-5fd21dec0538", value = "")
  public UUID getMoveTaskOrderID() {
    return moveTaskOrderID;
  }

  public void setMoveTaskOrderID(UUID moveTaskOrderID) {
    this.moveTaskOrderID = moveTaskOrderID;
  }

  public PaymentRequest rejectionReason(String rejectionReason) {
    this.rejectionReason = rejectionReason;
    return this;
  }

   /**
   * Get rejectionReason
   * @return rejectionReason
  **/
  @ApiModelProperty(example = "documentation was incomplete", value = "")
  public String getRejectionReason() {
    return rejectionReason;
  }

  public void setRejectionReason(String rejectionReason) {
    this.rejectionReason = rejectionReason;
  }

  public PaymentRequest status(PaymentRequestStatus status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  public PaymentRequestStatus getStatus() {
    return status;
  }

  public void setStatus(PaymentRequestStatus status) {
    this.status = status;
  }

   /**
   * Get paymentRequestNumber
   * @return paymentRequestNumber
  **/
  @ApiModelProperty(example = "1234-5678-1", value = "")
  public String getPaymentRequestNumber() {
    return paymentRequestNumber;
  }

  public PaymentRequest eTag(String eTag) {
    this.eTag = eTag;
    return this;
  }

   /**
   * Get eTag
   * @return eTag
  **/
  @ApiModelProperty(value = "")
  public String getETag() {
    return eTag;
  }

  public void setETag(String eTag) {
    this.eTag = eTag;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentRequest paymentRequest = (PaymentRequest) o;
    return Objects.equals(this.proofOfServiceDocs, paymentRequest.proofOfServiceDocs) &&
        Objects.equals(this.id, paymentRequest.id) &&
        Objects.equals(this.isFinal, paymentRequest.isFinal) &&
        Objects.equals(this.moveTaskOrderID, paymentRequest.moveTaskOrderID) &&
        Objects.equals(this.rejectionReason, paymentRequest.rejectionReason) &&
        Objects.equals(this.status, paymentRequest.status) &&
        Objects.equals(this.paymentRequestNumber, paymentRequest.paymentRequestNumber) &&
        Objects.equals(this.eTag, paymentRequest.eTag);
  }

  @Override
  public int hashCode() {
    return Objects.hash(proofOfServiceDocs, id, isFinal, moveTaskOrderID, rejectionReason, status, paymentRequestNumber, eTag);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentRequest {\n");
    
    sb.append("    proofOfServiceDocs: ").append(toIndentedString(proofOfServiceDocs)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    isFinal: ").append(toIndentedString(isFinal)).append("\n");
    sb.append("    moveTaskOrderID: ").append(toIndentedString(moveTaskOrderID)).append("\n");
    sb.append("    rejectionReason: ").append(toIndentedString(rejectionReason)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    paymentRequestNumber: ").append(toIndentedString(paymentRequestNumber)).append("\n");
    sb.append("    eTag: ").append(toIndentedString(eTag)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

