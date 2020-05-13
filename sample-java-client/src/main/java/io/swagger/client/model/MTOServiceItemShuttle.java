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
import io.swagger.client.model.MTOServiceItem;
import io.swagger.client.model.MTOServiceItemModelType;
import io.swagger.client.model.MTOServiceItemStatus;
import java.io.IOException;
import java.util.UUID;

/**
 * Describes a shuttle service item.
 */
@ApiModel(description = "Describes a shuttle service item.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-05-06T14:55:33.605Z")
public class MTOServiceItemShuttle extends MTOServiceItem {
  /**
   * Gets or Sets reServiceCode
   */
  @JsonAdapter(ReServiceCodeEnum.Adapter.class)
  public enum ReServiceCodeEnum {
    DOSHUT("DOSHUT"),
    
    DDSHUT("DDSHUT");

    private String value;

    ReServiceCodeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ReServiceCodeEnum fromValue(String text) {
      for (ReServiceCodeEnum b : ReServiceCodeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<ReServiceCodeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ReServiceCodeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ReServiceCodeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ReServiceCodeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("reServiceCode")
  private ReServiceCodeEnum reServiceCode = null;

  @SerializedName("reason")
  private String reason = null;

  @SerializedName("description")
  private String description = null;

  public MTOServiceItemShuttle reServiceCode(ReServiceCodeEnum reServiceCode) {
    this.reServiceCode = reServiceCode;
    return this;
  }

   /**
   * Get reServiceCode
   * @return reServiceCode
  **/
  @ApiModelProperty(required = true, value = "")
  public ReServiceCodeEnum getReServiceCode() {
    return reServiceCode;
  }

  public void setReServiceCode(ReServiceCodeEnum reServiceCode) {
    this.reServiceCode = reServiceCode;
  }

  public MTOServiceItemShuttle reason(String reason) {
    this.reason = reason;
    return this;
  }

   /**
   * Get reason
   * @return reason
  **/
  @ApiModelProperty(example = "Storage items need to be picked up.", required = true, value = "")
  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public MTOServiceItemShuttle description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(example = "Things to be moved to the place by shuttle.", required = true, value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MTOServiceItemShuttle mtOServiceItemShuttle = (MTOServiceItemShuttle) o;
    return Objects.equals(this.reServiceCode, mtOServiceItemShuttle.reServiceCode) &&
        Objects.equals(this.reason, mtOServiceItemShuttle.reason) &&
        Objects.equals(this.description, mtOServiceItemShuttle.description) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reServiceCode, reason, description, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MTOServiceItemShuttle {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    reServiceCode: ").append(toIndentedString(reServiceCode)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
