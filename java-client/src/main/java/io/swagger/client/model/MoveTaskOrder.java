/*
 * move.mil Prime API
 * The API for move.mil Prime actions.
 *
 * OpenAPI spec version: 0.1.0
 * 
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
import io.swagger.client.model.Customer;
import io.swagger.client.model.Entitlements;
import io.swagger.client.model.ServiceItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.threeten.bp.LocalDate;

/**
 * MoveTaskOrder
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-10-07T19:09:34.737Z")
public class MoveTaskOrder {
  @SerializedName("id")
  private UUID id = null;

  @SerializedName("code")
  private String code = null;

  @SerializedName("moveID")
  private UUID moveID = null;

  @SerializedName("moveDate")
  private LocalDate moveDate = null;

  /**
   * Gets or Sets status
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    APPROVED("APPROVED"),
    
    REJECTED("REJECTED"),
    
    SUBMITTED("SUBMITTED");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return StatusEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("status")
  private StatusEnum status = null;

  @SerializedName("entitlements")
  private Entitlements entitlements = null;

  /**
   * Gets or Sets moveTaskOrdersType
   */
  @JsonAdapter(MoveTaskOrdersTypeEnum.Adapter.class)
  public enum MoveTaskOrdersTypeEnum {
    NON_TEMPORARY_STORAGE("NON_TEMPORARY_STORAGE"),
    
    PRIME("PRIME");

    private String value;

    MoveTaskOrdersTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static MoveTaskOrdersTypeEnum fromValue(String text) {
      for (MoveTaskOrdersTypeEnum b : MoveTaskOrdersTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<MoveTaskOrdersTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final MoveTaskOrdersTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public MoveTaskOrdersTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return MoveTaskOrdersTypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("moveTaskOrdersType")
  private MoveTaskOrdersTypeEnum moveTaskOrdersType = null;

  @SerializedName("customer")
  private Customer customer = null;

  @SerializedName("requestedPickupDate")
  private LocalDate requestedPickupDate = null;

  @SerializedName("originDutyStation")
  private UUID originDutyStation = null;

  @SerializedName("originPPSO")
  private UUID originPPSO = null;

  @SerializedName("destinationDutyStation")
  private UUID destinationDutyStation = null;

  @SerializedName("destinationPPSO")
  private UUID destinationPPSO = null;

  @SerializedName("remarks")
  private String remarks = null;

  @SerializedName("serviceItems")
  private List<ServiceItem> serviceItems = null;

  @SerializedName("createdAt")
  private LocalDate createdAt = null;

  @SerializedName("updatedAt")
  private LocalDate updatedAt = null;

  @SerializedName("deletedAt")
  private LocalDate deletedAt = null;

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

  public MoveTaskOrder code(String code) {
    this.code = code;
    return this;
  }

   /**
   * Get code
   * @return code
  **/
  @ApiModelProperty(example = "USMC-0001", value = "")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public MoveTaskOrder moveID(UUID moveID) {
    this.moveID = moveID;
    return this;
  }

   /**
   * Get moveID
   * @return moveID
  **/
  @ApiModelProperty(example = "c56a4180-65aa-42ec-a945-5fd21dec0538", value = "")
  public UUID getMoveID() {
    return moveID;
  }

  public void setMoveID(UUID moveID) {
    this.moveID = moveID;
  }

  public MoveTaskOrder moveDate(LocalDate moveDate) {
    this.moveDate = moveDate;
    return this;
  }

   /**
   * Get moveDate
   * @return moveDate
  **/
  @ApiModelProperty(value = "")
  public LocalDate getMoveDate() {
    return moveDate;
  }

  public void setMoveDate(LocalDate moveDate) {
    this.moveDate = moveDate;
  }

  public MoveTaskOrder status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public MoveTaskOrder entitlements(Entitlements entitlements) {
    this.entitlements = entitlements;
    return this;
  }

   /**
   * Get entitlements
   * @return entitlements
  **/
  @ApiModelProperty(value = "")
  public Entitlements getEntitlements() {
    return entitlements;
  }

  public void setEntitlements(Entitlements entitlements) {
    this.entitlements = entitlements;
  }

  public MoveTaskOrder moveTaskOrdersType(MoveTaskOrdersTypeEnum moveTaskOrdersType) {
    this.moveTaskOrdersType = moveTaskOrdersType;
    return this;
  }

   /**
   * Get moveTaskOrdersType
   * @return moveTaskOrdersType
  **/
  @ApiModelProperty(value = "")
  public MoveTaskOrdersTypeEnum getMoveTaskOrdersType() {
    return moveTaskOrdersType;
  }

  public void setMoveTaskOrdersType(MoveTaskOrdersTypeEnum moveTaskOrdersType) {
    this.moveTaskOrdersType = moveTaskOrdersType;
  }

  public MoveTaskOrder customer(Customer customer) {
    this.customer = customer;
    return this;
  }

   /**
   * Get customer
   * @return customer
  **/
  @ApiModelProperty(value = "")
  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public MoveTaskOrder requestedPickupDate(LocalDate requestedPickupDate) {
    this.requestedPickupDate = requestedPickupDate;
    return this;
  }

   /**
   * Get requestedPickupDate
   * @return requestedPickupDate
  **/
  @ApiModelProperty(value = "")
  public LocalDate getRequestedPickupDate() {
    return requestedPickupDate;
  }

  public void setRequestedPickupDate(LocalDate requestedPickupDate) {
    this.requestedPickupDate = requestedPickupDate;
  }

  public MoveTaskOrder originDutyStation(UUID originDutyStation) {
    this.originDutyStation = originDutyStation;
    return this;
  }

   /**
   * Get originDutyStation
   * @return originDutyStation
  **/
  @ApiModelProperty(example = "1f2270c7-7166-40ae-981e-b200ebdf3054", value = "")
  public UUID getOriginDutyStation() {
    return originDutyStation;
  }

  public void setOriginDutyStation(UUID originDutyStation) {
    this.originDutyStation = originDutyStation;
  }

  public MoveTaskOrder originPPSO(UUID originPPSO) {
    this.originPPSO = originPPSO;
    return this;
  }

   /**
   * Get originPPSO
   * @return originPPSO
  **/
  @ApiModelProperty(example = "1f2270c7-7166-40ae-981e-b200ebdf3054", value = "")
  public UUID getOriginPPSO() {
    return originPPSO;
  }

  public void setOriginPPSO(UUID originPPSO) {
    this.originPPSO = originPPSO;
  }

  public MoveTaskOrder destinationDutyStation(UUID destinationDutyStation) {
    this.destinationDutyStation = destinationDutyStation;
    return this;
  }

   /**
   * Get destinationDutyStation
   * @return destinationDutyStation
  **/
  @ApiModelProperty(example = "1f2270c7-7166-40ae-981e-b200ebdf3054", value = "")
  public UUID getDestinationDutyStation() {
    return destinationDutyStation;
  }

  public void setDestinationDutyStation(UUID destinationDutyStation) {
    this.destinationDutyStation = destinationDutyStation;
  }

  public MoveTaskOrder destinationPPSO(UUID destinationPPSO) {
    this.destinationPPSO = destinationPPSO;
    return this;
  }

   /**
   * Get destinationPPSO
   * @return destinationPPSO
  **/
  @ApiModelProperty(example = "1f2270c7-7166-40ae-981e-b200ebdf3054", value = "")
  public UUID getDestinationPPSO() {
    return destinationPPSO;
  }

  public void setDestinationPPSO(UUID destinationPPSO) {
    this.destinationPPSO = destinationPPSO;
  }

  public MoveTaskOrder remarks(String remarks) {
    this.remarks = remarks;
    return this;
  }

   /**
   * Get remarks
   * @return remarks
  **/
  @ApiModelProperty(example = "Requires more gentle care", value = "")
  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public MoveTaskOrder serviceItems(List<ServiceItem> serviceItems) {
    this.serviceItems = serviceItems;
    return this;
  }

  public MoveTaskOrder addServiceItemsItem(ServiceItem serviceItemsItem) {
    if (this.serviceItems == null) {
      this.serviceItems = new ArrayList<ServiceItem>();
    }
    this.serviceItems.add(serviceItemsItem);
    return this;
  }

   /**
   * Get serviceItems
   * @return serviceItems
  **/
  @ApiModelProperty(value = "")
  public List<ServiceItem> getServiceItems() {
    return serviceItems;
  }

  public void setServiceItems(List<ServiceItem> serviceItems) {
    this.serviceItems = serviceItems;
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

  public MoveTaskOrder deletedAt(LocalDate deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

   /**
   * Get deletedAt
   * @return deletedAt
  **/
  @ApiModelProperty(value = "")
  public LocalDate getDeletedAt() {
    return deletedAt;
  }

  public void setDeletedAt(LocalDate deletedAt) {
    this.deletedAt = deletedAt;
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
        Objects.equals(this.code, moveTaskOrder.code) &&
        Objects.equals(this.moveID, moveTaskOrder.moveID) &&
        Objects.equals(this.moveDate, moveTaskOrder.moveDate) &&
        Objects.equals(this.status, moveTaskOrder.status) &&
        Objects.equals(this.entitlements, moveTaskOrder.entitlements) &&
        Objects.equals(this.moveTaskOrdersType, moveTaskOrder.moveTaskOrdersType) &&
        Objects.equals(this.customer, moveTaskOrder.customer) &&
        Objects.equals(this.requestedPickupDate, moveTaskOrder.requestedPickupDate) &&
        Objects.equals(this.originDutyStation, moveTaskOrder.originDutyStation) &&
        Objects.equals(this.originPPSO, moveTaskOrder.originPPSO) &&
        Objects.equals(this.destinationDutyStation, moveTaskOrder.destinationDutyStation) &&
        Objects.equals(this.destinationPPSO, moveTaskOrder.destinationPPSO) &&
        Objects.equals(this.remarks, moveTaskOrder.remarks) &&
        Objects.equals(this.serviceItems, moveTaskOrder.serviceItems) &&
        Objects.equals(this.createdAt, moveTaskOrder.createdAt) &&
        Objects.equals(this.updatedAt, moveTaskOrder.updatedAt) &&
        Objects.equals(this.deletedAt, moveTaskOrder.deletedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, code, moveID, moveDate, status, entitlements, moveTaskOrdersType, customer, requestedPickupDate, originDutyStation, originPPSO, destinationDutyStation, destinationPPSO, remarks, serviceItems, createdAt, updatedAt, deletedAt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MoveTaskOrder {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    moveID: ").append(toIndentedString(moveID)).append("\n");
    sb.append("    moveDate: ").append(toIndentedString(moveDate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    entitlements: ").append(toIndentedString(entitlements)).append("\n");
    sb.append("    moveTaskOrdersType: ").append(toIndentedString(moveTaskOrdersType)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    requestedPickupDate: ").append(toIndentedString(requestedPickupDate)).append("\n");
    sb.append("    originDutyStation: ").append(toIndentedString(originDutyStation)).append("\n");
    sb.append("    originPPSO: ").append(toIndentedString(originPPSO)).append("\n");
    sb.append("    destinationDutyStation: ").append(toIndentedString(destinationDutyStation)).append("\n");
    sb.append("    destinationPPSO: ").append(toIndentedString(destinationPPSO)).append("\n");
    sb.append("    remarks: ").append(toIndentedString(remarks)).append("\n");
    sb.append("    serviceItems: ").append(toIndentedString(serviceItems)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    deletedAt: ").append(toIndentedString(deletedAt)).append("\n");
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

