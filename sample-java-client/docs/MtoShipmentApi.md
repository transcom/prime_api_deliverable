# MtoShipmentApi

All URIs are relative to *http://localhost/prime/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createMTOShipment**](MtoShipmentApi.md#createMTOShipment) | **POST** /mto-shipments | createMTOShipment
[**updateMTOShipment**](MtoShipmentApi.md#updateMTOShipment) | **PUT** /mto-shipments/{mtoShipmentID} | updateMTOShipment


<a name="createMTOShipment"></a>
# **createMTOShipment**
> MTOShipment createMTOShipment(body)

createMTOShipment

Creates a MTO shipment for the specified Move Task Order. Required fields include: * Shipment Type * Customer requested pick-up date * Pick-up Address * Delivery Address * Releasing / Receiving agents  Optional fields include: * Customer Remarks * Releasing / Receiving agents * An array of optional accessorial service item codes 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MtoShipmentApi;


MtoShipmentApi apiInstance = new MtoShipmentApi();
CreateShipmentPayload body = new CreateShipmentPayload(); // CreateShipmentPayload | 
try {
    MTOShipment result = apiInstance.createMTOShipment(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MtoShipmentApi#createMTOShipment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**CreateShipmentPayload**](CreateShipmentPayload.md)|  | [optional]

### Return type

[**MTOShipment**](MTOShipment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateMTOShipment"></a>
# **updateMTOShipment**
> MTOShipment updateMTOShipment(mtoShipmentID, body, ifMatch)

updateMTOShipment

Updates an existing shipment for a Move Task Order (MTO). Only the following fields can be updated using this endpoint:  * &#x60;scheduledPickupDate&#x60; * &#x60;actualPickupDate&#x60; * &#x60;firstAvailableDeliveryDate&#x60; * &#x60;destinationAddress&#x60; * &#x60;pickupAddress&#x60; * &#x60;secondaryDeliveryAddress&#x60; * &#x60;secondaryPickupAddress&#x60; * &#x60;primeEstimatedWeight&#x60; * &#x60;primeActualWeight&#x60; * &#x60;shipmentType&#x60; * &#x60;agents&#x60; - all subfields except &#x60;mtoShipmentID&#x60;, &#x60;createdAt&#x60;, &#x60;updatedAt&#x60;. You cannot add new agents to a shipment.  Note that some fields cannot be manually changed but will still be updated automatically, such as &#x60;primeEstimatedWeightRecordedDate&#x60; and &#x60;requiredDeliveryDate&#x60;. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MtoShipmentApi;


MtoShipmentApi apiInstance = new MtoShipmentApi();
UUID mtoShipmentID = new UUID(); // UUID | UUID of the shipment being updated.
MTOShipment body = new MTOShipment(); // MTOShipment | 
String ifMatch = "ifMatch_example"; // String | Optimistic locking is implemented via the `If-Match` header. If the ETag header does not match the value of the resource on the server, the server rejects the change with a `412 Precondition Failed` error. 
try {
    MTOShipment result = apiInstance.updateMTOShipment(mtoShipmentID, body, ifMatch);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MtoShipmentApi#updateMTOShipment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **mtoShipmentID** | [**UUID**](.md)| UUID of the shipment being updated. |
 **body** | [**MTOShipment**](MTOShipment.md)|  |
 **ifMatch** | **String**| Optimistic locking is implemented via the &#x60;If-Match&#x60; header. If the ETag header does not match the value of the resource on the server, the server rejects the change with a &#x60;412 Precondition Failed&#x60; error.  |

### Return type

[**MTOShipment**](MTOShipment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

