# MoveTaskOrderApi

All URIs are relative to *http://localhost/prime/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**fetchMTOUpdates**](MoveTaskOrderApi.md#fetchMTOUpdates) | **GET** /move-task-orders | Gets all move task orders where &#x60;isAvailableToPrime&#x60; is TRUE
[**getMoveTaskOrderCustomer**](MoveTaskOrderApi.md#getMoveTaskOrderCustomer) | **GET** /move-task-orders/{moveTaskOrderID}/customer | Gets the customer associated with a move task order ID
[**updateMTOPostCounselingInformation**](MoveTaskOrderApi.md#updateMTOPostCounselingInformation) | **PATCH** /move-task-orders/{moveTaskOrderID}/post-counseling-info | Updates move task order&#39;s post counseling information


<a name="fetchMTOUpdates"></a>
# **fetchMTOUpdates**
> MoveTaskOrders fetchMTOUpdates(since)

Gets all move task orders where &#x60;isAvailableToPrime&#x60; is TRUE

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

<a name="getMoveTaskOrderCustomer"></a>
# **getMoveTaskOrderCustomer**
> Customer getMoveTaskOrderCustomer(moveTaskOrderID)

Gets the customer associated with a move task order ID

Gets the customer associated with a move task order ID.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MoveTaskOrderApi;


MoveTaskOrderApi apiInstance = new MoveTaskOrderApi();
String moveTaskOrderID = "moveTaskOrderID_example"; // String | ID of move order to use.
try {
    Customer result = apiInstance.getMoveTaskOrderCustomer(moveTaskOrderID);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MoveTaskOrderApi#getMoveTaskOrderCustomer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **moveTaskOrderID** | **String**| ID of move order to use. |

### Return type

[**Customer**](Customer.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateMTOPostCounselingInformation"></a>
# **updateMTOPostCounselingInformation**
> MoveTaskOrder updateMTOPostCounselingInformation(moveTaskOrderID, body, ifMatch)

Updates move task order&#39;s post counseling information

Updates move task order fields ppmType, ppmEstimatedWeight, and pointOfContact.

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

