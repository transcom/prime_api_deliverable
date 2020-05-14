# MtoServiceItemApi

All URIs are relative to *http://localhost/prime/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createMTOServiceItem**](MtoServiceItemApi.md#createMTOServiceItem) | **POST** /move-task-orders/{moveTaskOrderID}/mto-shipments/{mtoShipmentID}/mto-service-items | Creates MTO service items that is added to a Move Task Order and MTO Shipment


<a name="createMTOServiceItem"></a>
# **createMTOServiceItem**
> MTOServiceItem createMTOServiceItem(moveTaskOrderID, mtoShipmentID, body)

Creates MTO service items that is added to a Move Task Order and MTO Shipment

Creates a new instance of mtoServiceItem, which come from the list of services that can be provided. Upon creation these items are associated with a Move Task Order and an MTO Shipment. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MtoServiceItemApi;


MtoServiceItemApi apiInstance = new MtoServiceItemApi();
UUID moveTaskOrderID = new UUID(); // UUID | UUID of Move Task Order to use.
UUID mtoShipmentID = new UUID(); // UUID | UUID of MTO Shipment to use.
MTOServiceItem body = new MTOServiceItem(); // MTOServiceItem | 
try {
    MTOServiceItem result = apiInstance.createMTOServiceItem(moveTaskOrderID, mtoShipmentID, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MtoServiceItemApi#createMTOServiceItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **moveTaskOrderID** | [**UUID**](.md)| UUID of Move Task Order to use. |
 **mtoShipmentID** | [**UUID**](.md)| UUID of MTO Shipment to use. |
 **body** | [**MTOServiceItem**](MTOServiceItem.md)|  | [optional]

### Return type

[**MTOServiceItem**](MTOServiceItem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

