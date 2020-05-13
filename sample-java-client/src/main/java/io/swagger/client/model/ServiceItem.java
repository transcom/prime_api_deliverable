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
import io.swagger.client.model.ServiceItemParams;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * ServiceItem
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-05-06T14:55:33.605Z")
public class ServiceItem {
  @SerializedName("id")
  private UUID id = null;

  @SerializedName("params")
  private List<ServiceItemParams> params = null;

  @SerializedName("eTag")
  private String eTag = null;

  public ServiceItem id(UUID id) {
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

  public ServiceItem params(List<ServiceItemParams> params) {
    this.params = params;
    return this;
  }

  public ServiceItem addParamsItem(ServiceItemParams paramsItem) {
    if (this.params == null) {
      this.params = new ArrayList<ServiceItemParams>();
    }
    this.params.add(paramsItem);
    return this;
  }

   /**
   * Get params
   * @return params
  **/
  @ApiModelProperty(value = "")
  public List<ServiceItemParams> getParams() {
    return params;
  }

  public void setParams(List<ServiceItemParams> params) {
    this.params = params;
  }

  public ServiceItem eTag(String eTag) {
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
    ServiceItem serviceItem = (ServiceItem) o;
    return Objects.equals(this.id, serviceItem.id) &&
        Objects.equals(this.params, serviceItem.params) &&
        Objects.equals(this.eTag, serviceItem.eTag);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, params, eTag);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceItem {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    params: ").append(toIndentedString(params)).append("\n");
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
