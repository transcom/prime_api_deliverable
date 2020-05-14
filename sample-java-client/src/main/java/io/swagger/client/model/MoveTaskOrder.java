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
import io.swagger.client.model.MTOServiceItem;
import io.swagger.client.model.MTOShipments;
import io.swagger.client.model.MoveOrder;
import io.swagger.client.model.PaymentRequests;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.threeten.bp.LocalDate;

/**
 * MoveTaskOrder
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-05-14T14:53:44.624-07:00")
public class MoveTaskOrder {
  @SerializedName("id")
  private UUID id = null;

  @SerializedName("createdAt")
  private LocalDate createdAt = null;

  @SerializedName("moveOrderID")
  private UUID moveOrderID = null;

  @SerializedName("moveOrder")
  private MoveOrder moveOrder = null;

  @SerializedName("referenceId")
  private String referenceId = null;

  @SerializedName("isAvailableToPrime")
  private Boolean isAvailableToPrime = null;

  @SerializedName("isCanceled")
  private Boolean isCanceled = null;

  @SerializedName("updatedAt")
  private LocalDate updatedAt = null;

  @SerializedName("paymentRequests")
  private PaymentRequests paymentRequests = null;

  @SerializedName("mtoServiceItems")
  private List<MTOServiceItem> mtoServiceItems = new ArrayList<MTOServiceItem>();

  @SerializedName("mtoShipments")
  private MTOShipments mtoShipments = null;

  /**
   * Gets or Sets ppmType
   */
  @JsonAdapter(PpmTypeEnum.Adapter.class)
  public enum PpmTypeEnum {
    FULL("FULL"),
    
    PARTIAL("PARTIAL");

    private String value;

    PpmTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static PpmTypeEnum fromValue(String text) {
      for (PpmTypeEnum b : PpmTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<PpmTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PpmTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public PpmTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return PpmTypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("ppmType")
  private PpmTypeEnum ppmType = null;

  @SerializedName("ppmEstimatedWeight")
  private Integer ppmEstimatedWeight = null;

  @SerializedName("eTag")
  private String eTag = null;

  public MoveTaskOrder id(UUID id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "1f2270c7-7166-40ae-981e-b200ebdf3054", value = "")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public MoveTaskOrder createdAt(LocalDate createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Get createdAt
   * @return createdAt
  **/
  @ApiModelProperty(value = "")
  public LocalDate getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDate createdAt) {
    this.createdAt = createdAt;
  }

  public MoveTaskOrder moveOrderID(UUID moveOrderID) {
    this.moveOrderID = moveOrderID;
    return this;
  }

   /**
   * Get moveOrderID
   * @return moveOrderID
  **/
  @ApiModelProperty(example = "c56a4180-65aa-42ec-a945-5fd21dec0538", value = "")
  public UUID getMoveOrderID() {
    return moveOrderID;
  }

  public void setMoveOrderID(UUID moveOrderID) {
    this.moveOrderID = moveOrderID;
  }

  public MoveTaskOrder moveOrder(MoveOrder moveOrder) {
    this.moveOrder = moveOrder;
    return this;
  }

   /**
   * Get moveOrder
   * @return moveOrder
  **/
  @ApiModelProperty(value = "")
  public MoveOrder getMoveOrder() {
    return moveOrder;
  }

  public void setMoveOrder(MoveOrder moveOrder) {
    this.moveOrder = moveOrder;
  }

  public MoveTaskOrder referenceId(String referenceId) {
    this.referenceId = referenceId;
    return this;
  }

   /**
   * Get referenceId
   * @return referenceId
  **/
  @ApiModelProperty(example = "1001-3456", value = "")
  public String getReferenceId() {
    return referenceId;
  }

  public void setReferenceId(String referenceId) {
    this.referenceId = referenceId;
  }

  public MoveTaskOrder isAvailableToPrime(Boolean isAvailableToPrime) {
    this.isAvailableToPrime = isAvailableToPrime;
    return this;
  }

   /**
   * Get isAvailableToPrime
   * @return isAvailableToPrime
  **/
  @ApiModelProperty(value = "")
  public Boolean isIsAvailableToPrime() {
    return isAvailableToPrime;
  }

  public void setIsAvailableToPrime(Boolean isAvailableToPrime) {
    this.isAvailableToPrime = isAvailableToPrime;
  }

  public MoveTaskOrder isCanceled(Boolean isCanceled) {
    this.isCanceled = isCanceled;
    return this;
  }

   /**
   * Get isCanceled
   * @return isCanceled
  **/
  @ApiModelProperty(value = "")
  public Boolean isIsCanceled() {
    return isCanceled;
  }

  public void setIsCanceled(Boolean isCanceled) {
    this.isCanceled = isCanceled;
  }

  public MoveTaskOrder updatedAt(LocalDate updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Get updatedAt
   * @return updatedAt
  **/
  @ApiModelProperty(value = "")
  public LocalDate getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDate updatedAt) {
    this.updatedAt = updatedAt;
  }

  public MoveTaskOrder paymentRequests(PaymentRequests paymentRequests) {
    this.paymentRequests = paymentRequests;
    return this;
  }

   /**
   * Get paymentRequests
   * @return paymentRequests
  **/
  @ApiModelProperty(required = true, value = "")
  public PaymentRequests getPaymentRequests() {
    return paymentRequests;
  }

  public void setPaymentRequests(PaymentRequests paymentRequests) {
    this.paymentRequests = paymentRequests;
  }

  public MoveTaskOrder mtoServiceItems(List<MTOServiceItem> mtoServiceItems) {
    this.mtoServiceItems = mtoServiceItems;
    return this;
  }

  public MoveTaskOrder addMtoServiceItemsItem(MTOServiceItem mtoServiceItemsItem) {
    this.mtoServiceItems.add(mtoServiceItemsItem);
    return this;
  }

   /**
   * Get mtoServiceItems
   * @return mtoServiceItems
  **/
  @ApiModelProperty(required = true, value = "")
  public List<MTOServiceItem> getMtoServiceItems() {
    return mtoServiceItems;
  }

  public void setMtoServiceItems(List<MTOServiceItem> mtoServiceItems) {
    this.mtoServiceItems = mtoServiceItems;
  }

  public MoveTaskOrder mtoShipments(MTOShipments mtoShipments) {
    this.mtoShipments = mtoShipments;
    return this;
  }

   /**
   * Get mtoShipments
   * @return mtoShipments
  **/
  @ApiModelProperty(required = true, value = "")
  public MTOShipments getMtoShipments() {
    return mtoShipments;
  }

  public void setMtoShipments(MTOShipments mtoShipments) {
    this.mtoShipments = mtoShipments;
  }

  public MoveTaskOrder ppmType(PpmTypeEnum ppmType) {
    this.ppmType = ppmType;
    return this;
  }

   /**
   * Get ppmType
   * @return ppmType
  **/
  @ApiModelProperty(value = "")
  public PpmTypeEnum getPpmType() {
    return ppmType;
  }

  public void setPpmType(PpmTypeEnum ppmType) {
    this.ppmType = ppmType;
  }

  public MoveTaskOrder ppmEstimatedWeight(Integer ppmEstimatedWeight) {
    this.ppmEstimatedWeight = ppmEstimatedWeight;
    return this;
  }

   /**
   * Get ppmEstimatedWeight
   * @return ppmEstimatedWeight
  **/
  @ApiModelProperty(value = "")
  public Integer getPpmEstimatedWeight() {
    return ppmEstimatedWeight;
  }

  public void setPpmEstimatedWeight(Integer ppmEstimatedWeight) {
    this.ppmEstimatedWeight = ppmEstimatedWeight;
  }

  public MoveTaskOrder eTag(String eTag) {
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
    MoveTaskOrder moveTaskOrder = (MoveTaskOrder) o;
    return Objects.equals(this.id, moveTaskOrder.id) &&
        Objects.equals(this.createdAt, moveTaskOrder.createdAt) &&
        Objects.equals(this.moveOrderID, moveTaskOrder.moveOrderID) &&
        Objects.equals(this.moveOrder, moveTaskOrder.moveOrder) &&
        Objects.equals(this.referenceId, moveTaskOrder.referenceId) &&
        Objects.equals(this.isAvailableToPrime, moveTaskOrder.isAvailableToPrime) &&
        Objects.equals(this.isCanceled, moveTaskOrder.isCanceled) &&
        Objects.equals(this.updatedAt, moveTaskOrder.updatedAt) &&
        Objects.equals(this.paymentRequests, moveTaskOrder.paymentRequests) &&
        Objects.equals(this.mtoServiceItems, moveTaskOrder.mtoServiceItems) &&
        Objects.equals(this.mtoShipments, moveTaskOrder.mtoShipments) &&
        Objects.equals(this.ppmType, moveTaskOrder.ppmType) &&
        Objects.equals(this.ppmEstimatedWeight, moveTaskOrder.ppmEstimatedWeight) &&
        Objects.equals(this.eTag, moveTaskOrder.eTag);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createdAt, moveOrderID, moveOrder, referenceId, isAvailableToPrime, isCanceled, updatedAt, paymentRequests, mtoServiceItems, mtoShipments, ppmType, ppmEstimatedWeight, eTag);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MoveTaskOrder {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    moveOrderID: ").append(toIndentedString(moveOrderID)).append("\n");
    sb.append("    moveOrder: ").append(toIndentedString(moveOrder)).append("\n");
    sb.append("    referenceId: ").append(toIndentedString(referenceId)).append("\n");
    sb.append("    isAvailableToPrime: ").append(toIndentedString(isAvailableToPrime)).append("\n");
    sb.append("    isCanceled: ").append(toIndentedString(isCanceled)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    paymentRequests: ").append(toIndentedString(paymentRequests)).append("\n");
    sb.append("    mtoServiceItems: ").append(toIndentedString(mtoServiceItems)).append("\n");
    sb.append("    mtoShipments: ").append(toIndentedString(mtoShipments)).append("\n");
    sb.append("    ppmType: ").append(toIndentedString(ppmType)).append("\n");
    sb.append("    ppmEstimatedWeight: ").append(toIndentedString(ppmEstimatedWeight)).append("\n");
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

