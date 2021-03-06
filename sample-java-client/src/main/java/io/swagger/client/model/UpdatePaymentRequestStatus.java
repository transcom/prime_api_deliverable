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
import java.io.IOException;

/**
 * UpdatePaymentRequestStatus
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-05-15T13:04:32.719-07:00")
public class UpdatePaymentRequestStatus {
  @SerializedName("rejectionReason")
  private String rejectionReason = null;

  @SerializedName("status")
  private PaymentRequestStatus status = null;

  @SerializedName("eTag")
  private String eTag = null;

  public UpdatePaymentRequestStatus rejectionReason(String rejectionReason) {
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

  public UpdatePaymentRequestStatus status(PaymentRequestStatus status) {
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

  public UpdatePaymentRequestStatus eTag(String eTag) {
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
    UpdatePaymentRequestStatus updatePaymentRequestStatus = (UpdatePaymentRequestStatus) o;
    return Objects.equals(this.rejectionReason, updatePaymentRequestStatus.rejectionReason) &&
        Objects.equals(this.status, updatePaymentRequestStatus.status) &&
        Objects.equals(this.eTag, updatePaymentRequestStatus.eTag);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rejectionReason, status, eTag);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdatePaymentRequestStatus {\n");
    
    sb.append("    rejectionReason: ").append(toIndentedString(rejectionReason)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

