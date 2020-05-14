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
import io.swagger.client.model.Address;
import java.io.IOException;
import java.util.UUID;

/**
 * DutyStation
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-05-14T14:53:44.624-07:00")
public class DutyStation {
  @SerializedName("id")
  private UUID id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("addressId")
  private UUID addressId = null;

  @SerializedName("address")
  private Address address = null;

  @SerializedName("eTag")
  private String eTag = null;

  public DutyStation id(UUID id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "c56a4180-65aa-42ec-a945-5fd21dec0538", value = "")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public DutyStation name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "Fort Bragg North Station", value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DutyStation addressId(UUID addressId) {
    this.addressId = addressId;
    return this;
  }

   /**
   * Get addressId
   * @return addressId
  **/
  @ApiModelProperty(example = "c56a4180-65aa-42ec-a945-5fd21dec0538", value = "")
  public UUID getAddressId() {
    return addressId;
  }

  public void setAddressId(UUID addressId) {
    this.addressId = addressId;
  }

  public DutyStation address(Address address) {
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(value = "")
  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public DutyStation eTag(String eTag) {
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
    DutyStation dutyStation = (DutyStation) o;
    return Objects.equals(this.id, dutyStation.id) &&
        Objects.equals(this.name, dutyStation.name) &&
        Objects.equals(this.addressId, dutyStation.addressId) &&
        Objects.equals(this.address, dutyStation.address) &&
        Objects.equals(this.eTag, dutyStation.eTag);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, addressId, address, eTag);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DutyStation {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    addressId: ").append(toIndentedString(addressId)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
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

