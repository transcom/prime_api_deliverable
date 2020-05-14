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
 * Gets or Sets MTOAgentType
 */
@JsonAdapter(MTOAgentType.Adapter.class)
public enum MTOAgentType {
  
  RELEASING_AGENT("RELEASING_AGENT"),
  
  RECEIVING_AGENT("RECEIVING_AGENT");

  private String value;

  MTOAgentType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static MTOAgentType fromValue(String text) {
    for (MTOAgentType b : MTOAgentType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

  public static class Adapter extends TypeAdapter<MTOAgentType> {
    @Override
    public void write(final JsonWriter jsonWriter, final MTOAgentType enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public MTOAgentType read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return MTOAgentType.fromValue(String.valueOf(value));
    }
  }
}

