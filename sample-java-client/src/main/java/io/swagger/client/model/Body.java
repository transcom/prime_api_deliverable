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

/**
 * Body
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-05-14T14:53:44.624-07:00")
public class Body {
  @SerializedName("moveTaskOrderID")
  private String moveTaskOrderID = null;

  /**
   * Sets a ppmType to an allowed value.
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

  @SerializedName("pointOfContact")
  private String pointOfContact = null;

  public Body moveTaskOrderID(String moveTaskOrderID) {
    this.moveTaskOrderID = moveTaskOrderID;
    return this;
  }

   /**
   * UUID for the move task order to use.
   * @return moveTaskOrderID
  **/
  @ApiModelProperty(value = "UUID for the move task order to use.")
  public String getMoveTaskOrderID() {
    return moveTaskOrderID;
  }

  public void setMoveTaskOrderID(String moveTaskOrderID) {
    this.moveTaskOrderID = moveTaskOrderID;
  }

  public Body ppmType(PpmTypeEnum ppmType) {
    this.ppmType = ppmType;
    return this;
  }

   /**
   * Sets a ppmType to an allowed value.
   * @return ppmType
  **/
  @ApiModelProperty(value = "Sets a ppmType to an allowed value.")
  public PpmTypeEnum getPpmType() {
    return ppmType;
  }

  public void setPpmType(PpmTypeEnum ppmType) {
    this.ppmType = ppmType;
  }

  public Body ppmEstimatedWeight(Integer ppmEstimatedWeight) {
    this.ppmEstimatedWeight = ppmEstimatedWeight;
    return this;
  }

   /**
   * The estimated weight determined post counseling.
   * @return ppmEstimatedWeight
  **/
  @ApiModelProperty(value = "The estimated weight determined post counseling.")
  public Integer getPpmEstimatedWeight() {
    return ppmEstimatedWeight;
  }

  public void setPpmEstimatedWeight(Integer ppmEstimatedWeight) {
    this.ppmEstimatedWeight = ppmEstimatedWeight;
  }

  public Body pointOfContact(String pointOfContact) {
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
    Body body = (Body) o;
    return Objects.equals(this.moveTaskOrderID, body.moveTaskOrderID) &&
        Objects.equals(this.ppmType, body.ppmType) &&
        Objects.equals(this.ppmEstimatedWeight, body.ppmEstimatedWeight) &&
        Objects.equals(this.pointOfContact, body.pointOfContact);
  }

  @Override
  public int hashCode() {
    return Objects.hash(moveTaskOrderID, ppmType, ppmEstimatedWeight, pointOfContact);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body {\n");
    
    sb.append("    moveTaskOrderID: ").append(toIndentedString(moveTaskOrderID)).append("\n");
    sb.append("    ppmType: ").append(toIndentedString(ppmType)).append("\n");
    sb.append("    ppmEstimatedWeight: ").append(toIndentedString(ppmEstimatedWeight)).append("\n");
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

