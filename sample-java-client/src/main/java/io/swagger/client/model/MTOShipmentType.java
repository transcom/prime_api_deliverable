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
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Gets or Sets MTOShipmentType
 */
@JsonAdapter(MTOShipmentType.Adapter.class)
public enum MTOShipmentType {
  
  HHG("HHG"),
  
  INTERNATIONAL_HHG("INTERNATIONAL_HHG"),
  
  INTERNATIONAL_UB("INTERNATIONAL_UB");

  private String value;

  MTOShipmentType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static MTOShipmentType fromValue(String text) {
    for (MTOShipmentType b : MTOShipmentType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

  public static class Adapter extends TypeAdapter<MTOShipmentType> {
    @Override
    public void write(final JsonWriter jsonWriter, final MTOShipmentType enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public MTOShipmentType read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return MTOShipmentType.fromValue(String.valueOf(value));
    }
  }
}
