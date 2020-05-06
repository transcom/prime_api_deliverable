# MtoShipmentApi

All URIs are relative to *http://localhost/prime/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**updateMTOShipment**](MtoShipmentApi.md#updateMTOShipment) | **PUT** /move-task-orders/{moveTaskOrderID}/mto-shipments/{mtoShipmentID} | Updates MTO shipment


<a name="updateMTOShipment"></a>
# **updateMTOShipment**
> MTOShipment updateMTOShipment(moveTaskOrderID, mtoShipmentID, body, ifMatch)

Updates MTO shipment

Updates MTO shipment.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MtoShipmentApi;


MtoShipmentApi apiInstance = new MtoShipmentApi();
UUID moveTaskOrderID = new UUID(); // UUID | UUID of the move task order being used.
UUID mtoShipmentID = new UUID(); // UUID | UUID of the move task order shipment being updated.
MTOShipment body = new MTOShipment(); // MTOShipment | 
String ifMatch = "ifMatch_example"; // String | Optimistic locking is implemented via the `If-Match` header. If the ETag header does not match the value of the resource on the server, the server rejects the change with a `412 Precondition Failed` error. 
try {
    MTOShipment result = apiInstance.updateMTOShipment(moveTaskOrderID, mtoShipmentID, body, ifMatch);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MtoShipmentApi#updateMTOShipment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **moveTaskOrderID** | [**UUID**](.md)| UUID of the move task order being used. |
 **mtoShipmentID** | [**UUID**](.md)| UUID of the move task order shipment being updated. |
 **body** | [**MTOShipment**](MTOShipment.md)|  |
 **ifMatch** | **String**| Optimistic locking is implemented via the &#x60;If-Match&#x60; header. If the ETag header does not match the value of the resource on the server, the server rejects the change with a &#x60;412 Precondition Failed&#x60; error.  |

### Return type

[**MTOShipment**](MTOShipment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

