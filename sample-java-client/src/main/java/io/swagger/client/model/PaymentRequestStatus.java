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
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Gets or Sets PaymentRequestStatus
 */
@JsonAdapter(PaymentRequestStatus.Adapter.class)
public enum PaymentRequestStatus {
  
  PENDING("PENDING"),
  
  REVIEWED("REVIEWED"),
  
  SENT_TO_GEX("SENT_TO_GEX"),
  
  RECEIVED_BY_GEX("RECEIVED_BY_GEX"),
  
  PAID("PAID");

  private String value;

  PaymentRequestStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static PaymentRequestStatus fromValue(String text) {
    for (PaymentRequestStatus b : PaymentRequestStatus.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

  public static class Adapter extends TypeAdapter<PaymentRequestStatus> {
    @Override
    public void write(final JsonWriter jsonWriter, final PaymentRequestStatus enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public PaymentRequestStatus read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return PaymentRequestStatus.fromValue(String.valueOf(value));
    }
  }
}

