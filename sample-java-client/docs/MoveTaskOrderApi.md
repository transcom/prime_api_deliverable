# MoveTaskOrderApi

All URIs are relative to *http://localhost/prime/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**fetchMTOUpdates**](MoveTaskOrderApi.md#fetchMTOUpdates) | **GET** /move-task-orders | fetchMTOUpdates
[**updateMTOPostCounselingInformation**](MoveTaskOrderApi.md#updateMTOPostCounselingInformation) | **PATCH** /move-task-orders/{moveTaskOrderID}/post-counseling-info | updateMTOPostCounselingInformation


<a name="fetchMTOUpdates"></a>
# **fetchMTOUpdates**
> MoveTaskOrders fetchMTOUpdates(since)

fetchMTOUpdates

Gets all move task orders where &#x60;isAvailableToPrime&#x60; is TRUE. This prevents viewing any move task orders that have not been made available to the Prime. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MoveTaskOrderApi;


MoveTaskOrderApi apiInstance = new MoveTaskOrderApi();
Integer since = 56; // Integer | Only return move task orders updated since this time.
try {
    MoveTaskOrders result = apiInstance.fetchMTOUpdates(since);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MoveTaskOrderApi#fetchMTOUpdates");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **since** | **Integer**| Only return move task orders updated since this time. | [optional]

### Return type

[**MoveTaskOrders**](MoveTaskOrders.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateMTOPostCounselingInformation"></a>
# **updateMTOPostCounselingInformation**
> MoveTaskOrder updateMTOPostCounselingInformation(moveTaskOrderID, body, ifMatch)

updateMTOPostCounselingInformation

Updates move task order after the counseling stage. Allows update of fields ppmType and ppmEstimatedWeight.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MoveTaskOrderApi;


MoveTaskOrderApi apiInstance = new MoveTaskOrderApi();
String moveTaskOrderID = "moveTaskOrderID_example"; // String | ID of move task order to use.
Body body = new Body(); // Body | 
String ifMatch = "ifMatch_example"; // String | Optimistic locking is implemented via the `If-Match` header. If the ETag header does not match the value of the resource on the server, the server rejects the change with a `412 Precondition Failed` error. 
try {
    MoveTaskOrder result = apiInstance.updateMTOPostCounselingInformation(moveTaskOrderID, body, ifMatch);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MoveTaskOrderApi#updateMTOPostCounselingInformation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **moveTaskOrderID** | **String**| ID of move task order to use. |
 **body** | [**Body**](Body.md)|  |
 **ifMatch** | **String**| Optimistic locking is implemented via the &#x60;If-Match&#x60; header. If the ETag header does not match the value of the resource on the server, the server rejects the change with a &#x60;412 Precondition Failed&#x60; error.  |

### Return type

[**MoveTaskOrder**](MoveTaskOrder.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

