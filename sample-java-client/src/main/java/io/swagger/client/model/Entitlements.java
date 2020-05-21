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
import java.io.IOException;
import java.util.UUID;

/**
 * Entitlements
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-05-15T13:04:32.719-07:00")
public class Entitlements {
  @SerializedName("id")
  private UUID id = null;

  @SerializedName("authorizedWeight")
  private Integer authorizedWeight = null;

  @SerializedName("dependentsAuthorized")
  private Boolean dependentsAuthorized = null;

  @SerializedName("nonTemporaryStorage")
  private Boolean nonTemporaryStorage = null;

  @SerializedName("privatelyOwnedVehicle")
  private Boolean privatelyOwnedVehicle = null;

  @SerializedName("proGearWeight")
  private Integer proGearWeight = null;

  @SerializedName("proGearWeightSpouse")
  private Integer proGearWeightSpouse = null;

  @SerializedName("storageInTransit")
  private Integer storageInTransit = null;

  @SerializedName("totalWeight")
  private Integer totalWeight = null;

  @SerializedName("totalDependents")
  private Integer totalDependents = null;

  @SerializedName("eTag")
  private String eTag = null;

  public Entitlements id(UUID id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "571008b1-b0de-454d-b843-d71be9f02c04", value = "")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Entitlements authorizedWeight(Integer authorizedWeight) {
    this.authorizedWeight = authorizedWeight;
    return this;
  }

   /**
   * Get authorizedWeight
   * @return authorizedWeight
  **/
  @ApiModelProperty(example = "2000", value = "")
  public Integer getAuthorizedWeight() {
    return authorizedWeight;
  }

  public void setAuthorizedWeight(Integer authorizedWeight) {
    this.authorizedWeight = authorizedWeight;
  }

  public Entitlements dependentsAuthorized(Boolean dependentsAuthorized) {
    this.dependentsAuthorized = dependentsAuthorized;
    return this;
  }

   /**
   * Get dependentsAuthorized
   * @return dependentsAuthorized
  **/
  @ApiModelProperty(example = "true", value = "")
  public Boolean isDependentsAuthorized() {
    return dependentsAuthorized;
  }

  public void setDependentsAuthorized(Boolean dependentsAuthorized) {
    this.dependentsAuthorized = dependentsAuthorized;
  }

  public Entitlements nonTemporaryStorage(Boolean nonTemporaryStorage) {
    this.nonTemporaryStorage = nonTemporaryStorage;
    return this;
  }

   /**
   * Get nonTemporaryStorage
   * @return nonTemporaryStorage
  **/
  @ApiModelProperty(example = "false", value = "")
  public Boolean isNonTemporaryStorage() {
    return nonTemporaryStorage;
  }

  public void setNonTemporaryStorage(Boolean nonTemporaryStorage) {
    this.nonTemporaryStorage = nonTemporaryStorage;
  }

  public Entitlements privatelyOwnedVehicle(Boolean privatelyOwnedVehicle) {
    this.privatelyOwnedVehicle = privatelyOwnedVehicle;
    return this;
  }

   /**
   * Get privatelyOwnedVehicle
   * @return privatelyOwnedVehicle
  **/
  @ApiModelProperty(example = "false", value = "")
  public Boolean isPrivatelyOwnedVehicle() {
    return privatelyOwnedVehicle;
  }

  public void setPrivatelyOwnedVehicle(Boolean privatelyOwnedVehicle) {
    this.privatelyOwnedVehicle = privatelyOwnedVehicle;
  }

  public Entitlements proGearWeight(Integer proGearWeight) {
    this.proGearWeight = proGearWeight;
    return this;
  }

   /**
   * Get proGearWeight
   * @return proGearWeight
  **/
  @ApiModelProperty(example = "2000", value = "")
  public Integer getProGearWeight() {
    return proGearWeight;
  }

  public void setProGearWeight(Integer proGearWeight) {
    this.proGearWeight = proGearWeight;
  }

  public Entitlements proGearWeightSpouse(Integer proGearWeightSpouse) {
    this.proGearWeightSpouse = proGearWeightSpouse;
    return this;
  }

   /**
   * Get proGearWeightSpouse
   * @return proGearWeightSpouse
  **/
  @ApiModelProperty(example = "500", value = "")
  public Integer getProGearWeightSpouse() {
    return proGearWeightSpouse;
  }

  public void setProGearWeightSpouse(Integer proGearWeightSpouse) {
    this.proGearWeightSpouse = proGearWeightSpouse;
  }

  public Entitlements storageInTransit(Integer storageInTransit) {
    this.storageInTransit = storageInTransit;
    return this;
  }

   /**
   * Get storageInTransit
   * @return storageInTransit
  **/
  @ApiModelProperty(example = "90", value = "")
  public Integer getStorageInTransit() {
    return storageInTransit;
  }

  public void setStorageInTransit(Integer storageInTransit) {
    this.storageInTransit = storageInTransit;
  }

  public Entitlements totalWeight(Integer totalWeight) {
    this.totalWeight = totalWeight;
    return this;
  }

   /**
   * Get totalWeight
   * @return totalWeight
  **/
  @ApiModelProperty(example = "500", value = "")
  public Integer getTotalWeight() {
    return totalWeight;
  }

  public void setTotalWeight(Integer totalWeight) {
    this.totalWeight = totalWeight;
  }

  public Entitlements totalDependents(Integer totalDependents) {
    this.totalDependents = totalDependents;
    return this;
  }

   /**
   * Get totalDependents
   * @return totalDependents
  **/
  @ApiModelProperty(example = "2", value = "")
  public Integer getTotalDependents() {
    return totalDependents;
  }

  public void setTotalDependents(Integer totalDependents) {
    this.totalDependents = totalDependents;
  }

  public Entitlements eTag(String eTag) {
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
    Entitlements entitlements = (Entitlements) o;
    return Objects.equals(this.id, entitlements.id) &&
        Objects.equals(this.authorizedWeight, entitlements.authorizedWeight) &&
        Objects.equals(this.dependentsAuthorized, entitlements.dependentsAuthorized) &&
        Objects.equals(this.nonTemporaryStorage, entitlements.nonTemporaryStorage) &&
        Objects.equals(this.privatelyOwnedVehicle, entitlements.privatelyOwnedVehicle) &&
        Objects.equals(this.proGearWeight, entitlements.proGearWeight) &&
        Objects.equals(this.proGearWeightSpouse, entitlements.proGearWeightSpouse) &&
        Objects.equals(this.storageInTransit, entitlements.storageInTransit) &&
        Objects.equals(this.totalWeight, entitlements.totalWeight) &&
        Objects.equals(this.totalDependents, entitlements.totalDependents) &&
        Objects.equals(this.eTag, entitlements.eTag);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, authorizedWeight, dependentsAuthorized, nonTemporaryStorage, privatelyOwnedVehicle, proGearWeight, proGearWeightSpouse, storageInTransit, totalWeight, totalDependents, eTag);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Entitlements {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    authorizedWeight: ").append(toIndentedString(authorizedWeight)).append("\n");
    sb.append("    dependentsAuthorized: ").append(toIndentedString(dependentsAuthorized)).append("\n");
    sb.append("    nonTemporaryStorage: ").append(toIndentedString(nonTemporaryStorage)).append("\n");
    sb.append("    privatelyOwnedVehicle: ").append(toIndentedString(privatelyOwnedVehicle)).append("\n");
    sb.append("    proGearWeight: ").append(toIndentedString(proGearWeight)).append("\n");
    sb.append("    proGearWeightSpouse: ").append(toIndentedString(proGearWeightSpouse)).append("\n");
    sb.append("    storageInTransit: ").append(toIndentedString(storageInTransit)).append("\n");
    sb.append("    totalWeight: ").append(toIndentedString(totalWeight)).append("\n");
    sb.append("    totalDependents: ").append(toIndentedString(totalDependents)).append("\n");
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

