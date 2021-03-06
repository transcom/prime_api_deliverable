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
 * Gets or Sets ReServiceCode
 */
@JsonAdapter(ReServiceCode.Adapter.class)
public enum ReServiceCode {
  
  CS("CS"),
  
  DBHF("DBHF"),
  
  DBTF("DBTF"),
  
  DCRT("DCRT"),
  
  DCRTSA("DCRTSA"),
  
  DDASIT("DDASIT"),
  
  DDDSIT("DDDSIT"),
  
  DDFSIT("DDFSIT"),
  
  DDP("DDP"),
  
  DDSHUT("DDSHUT"),
  
  DLH("DLH"),
  
  DMHF("DMHF"),
  
  DNPKF("DNPKF"),
  
  DOASIT("DOASIT"),
  
  DOFSIT("DOFSIT"),
  
  DOP("DOP"),
  
  DOPSIT("DOPSIT"),
  
  DOSHUT("DOSHUT"),
  
  DPK("DPK"),
  
  DSH("DSH"),
  
  DUCRT("DUCRT"),
  
  DUPK("DUPK"),
  
  FSC("FSC"),
  
  IBHF("IBHF"),
  
  IBTF("IBTF"),
  
  ICOLH("ICOLH"),
  
  ICOUB("ICOUB"),
  
  ICRT("ICRT"),
  
  ICRTSA("ICRTSA"),
  
  IDASIT("IDASIT"),
  
  IDDSIT("IDDSIT"),
  
  IDFSIT("IDFSIT"),
  
  IDSHUT("IDSHUT"),
  
  IHPK("IHPK"),
  
  IHUPK("IHUPK"),
  
  INPKF("INPKF"),
  
  IOASIT("IOASIT"),
  
  IOCLH("IOCLH"),
  
  IOCUB("IOCUB"),
  
  IOFSIT("IOFSIT"),
  
  IOOLH("IOOLH"),
  
  IOOUB("IOOUB"),
  
  IOPSIT("IOPSIT"),
  
  IOSHUT("IOSHUT"),
  
  IUBPK("IUBPK"),
  
  IUBUPK("IUBUPK"),
  
  IUCRT("IUCRT"),
  
  MS("MS"),
  
  NSTH("NSTH"),
  
  NSTUB("NSTUB");

  private String value;

  ReServiceCode(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static ReServiceCode fromValue(String text) {
    for (ReServiceCode b : ReServiceCode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

  public static class Adapter extends TypeAdapter<ReServiceCode> {
    @Override
    public void write(final JsonWriter jsonWriter, final ReServiceCode enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public ReServiceCode read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return ReServiceCode.fromValue(String.valueOf(value));
    }
  }
}

