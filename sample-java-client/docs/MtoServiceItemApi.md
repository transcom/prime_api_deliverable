# MtoServiceItemApi

All URIs are relative to *http://localhost/prime/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createMTOServiceItem**](MtoServiceItemApi.md#createMTOServiceItem) | **POST** /mto-service-items | createMTOServiceItem


<a name="createMTOServiceItem"></a>
# **createMTOServiceItem**
> MTOServiceItem createMTOServiceItem(body)

createMTOServiceItem

Creates a new instance of mtoServiceItem, which come from the list of services that can be provided. Upon creation these items are associated with a Move Task Order and an MTO Shipment. Must include UUIDs for the MTO and MTO Shipment connected to this service item. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MtoServiceItemApi;


MtoServiceItemApi apiInstance = new MtoServiceItemApi();
MTOServiceItem body = new MTOServiceItem(); // MTOServiceItem | 
try {
    MTOServiceItem result = apiInstance.createMTOServiceItem(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MtoServiceItemApi#createMTOServiceItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**MTOServiceItem**](MTOServiceItem.md)|  | [optional]

### Return type

[**MTOServiceItem**](MTOServiceItem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

