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
import io.swagger.client.model.MTOServiceItemDimension;
import io.swagger.client.model.MTOServiceItemModelType;
import io.swagger.client.model.MTOServiceItemStatus;
import java.io.IOException;
import java.util.UUID;

/**
 * Describes a domestic crating/uncrating service item subtype of a MTOServiceItem.
 */
@ApiModel(description = "Describes a domestic crating/uncrating service item subtype of a MTOServiceItem.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-05-06T14:55:33.605Z")
public class MTOServiceItemDomesticCrating extends MTOServiceItem {
  /**
   * Gets or Sets reServiceCode
   */
  @JsonAdapter(ReServiceCodeEnum.Adapter.class)
  public enum ReServiceCodeEnum {
    DCRT("DCRT"),
    
    DCRTSA("DCRTSA"),
    
    DUCRT("DUCRT");

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

  @SerializedName("item")
  private MTOServiceItemDimension item = null;

  @SerializedName("crate")
  private MTOServiceItemDimension crate = null;

  @SerializedName("description")
  private String description = null;

  public MTOServiceItemDomesticCrating reServiceCode(ReServiceCodeEnum reServiceCode) {
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

  public MTOServiceItemDomesticCrating item(MTOServiceItemDimension item) {
    this.item = item;
    return this;
  }

   /**
   * Get item
   * @return item
  **/
  @ApiModelProperty(required = true, value = "")
  public MTOServiceItemDimension getItem() {
    return item;
  }

  public void setItem(MTOServiceItemDimension item) {
    this.item = item;
  }

  public MTOServiceItemDomesticCrating crate(MTOServiceItemDimension crate) {
    this.crate = crate;
    return this;
  }

   /**
   * Get crate
   * @return crate
  **/
  @ApiModelProperty(required = true, value = "")
  public MTOServiceItemDimension getCrate() {
    return crate;
  }

  public void setCrate(MTOServiceItemDimension crate) {
    this.crate = crate;
  }

  public MTOServiceItemDomesticCrating description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(example = "Decorated horse head to be crated.", required = true, value = "")
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
    MTOServiceItemDomesticCrating mtOServiceItemDomesticCrating = (MTOServiceItemDomesticCrating) o;
    return Objects.equals(this.reServiceCode, mtOServiceItemDomesticCrating.reServiceCode) &&
        Objects.equals(this.item, mtOServiceItemDomesticCrating.item) &&
        Objects.equals(this.crate, mtOServiceItemDomesticCrating.crate) &&
        Objects.equals(this.description, mtOServiceItemDomesticCrating.description) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reServiceCode, item, crate, description, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MTOServiceItemDomesticCrating {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    reServiceCode: ").append(toIndentedString(reServiceCode)).append("\n");
    sb.append("    item: ").append(toIndentedString(item)).append("\n");
    sb.append("    crate: ").append(toIndentedString(crate)).append("\n");
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
