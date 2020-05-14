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
import io.swagger.annotations.ApiModel;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Describes all statuses for a MTOServiceItem.
 */
@JsonAdapter(MTOServiceItemStatus.Adapter.class)
public enum MTOServiceItemStatus {
  
  SUBMITTED("SUBMITTED"),
  
  APPROVED("APPROVED"),
  
  REJECTED("REJECTED");

  private String value;

  MTOServiceItemStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static MTOServiceItemStatus fromValue(String text) {
    for (MTOServiceItemStatus b : MTOServiceItemStatus.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

  public static class Adapter extends TypeAdapter<MTOServiceItemStatus> {
    @Override
    public void write(final JsonWriter jsonWriter, final MTOServiceItemStatus enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public MTOServiceItemStatus read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return MTOServiceItemStatus.fromValue(String.valueOf(value));
    }
  }
}

