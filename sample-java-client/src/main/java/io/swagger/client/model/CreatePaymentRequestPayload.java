/*
 * move.mil API
 * The Prime API for move.mil
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
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.ServiceItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * CreatePaymentRequestPayload
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-05-06T14:55:33.605Z")
public class CreatePaymentRequestPayload {
  @SerializedName("isFinal")
  private Boolean isFinal = false;

  @SerializedName("moveTaskOrderID")
  private UUID moveTaskOrderID = null;

  @SerializedName("serviceItems")
  private List<ServiceItem> serviceItems = new ArrayList<ServiceItem>();

  @SerializedName("pointOfContact")
  private String pointOfContact = null;

  public CreatePaymentRequestPayload isFinal(Boolean isFinal) {
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

  public CreatePaymentRequestPayload moveTaskOrderID(UUID moveTaskOrderID) {
    this.moveTaskOrderID = moveTaskOrderID;
    return this;
  }

   /**
   * Get moveTaskOrderID
   * @return moveTaskOrderID
  **/
  @ApiModelProperty(example = "c56a4180-65aa-42ec-a945-5fd21dec0538", required = true, value = "")
  public UUID getMoveTaskOrderID() {
    return moveTaskOrderID;
  }

  public void setMoveTaskOrderID(UUID moveTaskOrderID) {
    this.moveTaskOrderID = moveTaskOrderID;
  }

  public CreatePaymentRequestPayload serviceItems(List<ServiceItem> serviceItems) {
    this.serviceItems = serviceItems;
    return this;
  }

  public CreatePaymentRequestPayload addServiceItemsItem(ServiceItem serviceItemsItem) {
    this.serviceItems.add(serviceItemsItem);
    return this;
  }

   /**
   * Get serviceItems
   * @return serviceItems
  **/
  @ApiModelProperty(required = true, value = "")
  public List<ServiceItem> getServiceItems() {
    return serviceItems;
  }

  public void setServiceItems(List<ServiceItem> serviceItems) {
    this.serviceItems = serviceItems;
  }

  public CreatePaymentRequestPayload pointOfContact(String pointOfContact) {
    this.pointOfContact = pointOfContact;
    return this;
  }

   /**
   * Email or id of a contact person for this update.
   * @return pointOfContact
  **/
  @ApiModelProperty(value = "Email or id of a contact person for this update.")
  public String getPointOfContact() {
    return pointOfContact;
  }

  public void setPointOfContact(String pointOfContact) {
    this.pointOfContact = pointOfContact;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreatePaymentRequestPayload createPaymentRequestPayload = (CreatePaymentRequestPayload) o;
    return Objects.equals(this.isFinal, createPaymentRequestPayload.isFinal) &&
        Objects.equals(this.moveTaskOrderID, createPaymentRequestPayload.moveTaskOrderID) &&
        Objects.equals(this.serviceItems, createPaymentRequestPayload.serviceItems) &&
        Objects.equals(this.pointOfContact, createPaymentRequestPayload.pointOfContact);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isFinal, moveTaskOrderID, serviceItems, pointOfContact);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreatePaymentRequestPayload {\n");
    
    sb.append("    isFinal: ").append(toIndentedString(isFinal)).append("\n");
    sb.append("    moveTaskOrderID: ").append(toIndentedString(moveTaskOrderID)).append("\n");
    sb.append("    serviceItems: ").append(toIndentedString(serviceItems)).append("\n");
    sb.append("    pointOfContact: ").append(toIndentedString(pointOfContact)).append("\n");
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

