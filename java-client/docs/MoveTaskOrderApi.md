# MoveTaskOrderApi

All URIs are relative to *https://localhost/admin/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**completeCounseling**](MoveTaskOrderApi.md#completeCounseling) | **POST** /move_task_orders/{move_task_order_id}/complete_counseling | Completes counseling for a move task order by id
[**createServiceItem**](MoveTaskOrderApi.md#createServiceItem) | **POST** /move_task_orders/{move_task_order_id}/service_items | Creates a service item for a move order by id
[**indexMoveTaskOrders**](MoveTaskOrderApi.md#indexMoveTaskOrders) | **GET** /move_task_orders | List all move task rders


<a name="completeCounseling"></a>
# **completeCounseling**
> MoveTaskOrder completeCounseling(moveTaskOrderId, options)

Completes counseling for a move task order by id

Completes counseling for a move task order by id

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MoveTaskOrderApi;


MoveTaskOrderApi apiInstance = new MoveTaskOrderApi();
UUID moveTaskOrderId = new UUID(); // UUID | 
Options options = new Options(); // Options | 
try {
    MoveTaskOrder result = apiInstance.completeCounseling(moveTaskOrderId, options);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MoveTaskOrderApi#completeCounseling");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **moveTaskOrderId** | [**UUID**](.md)|  |
 **options** | [**Options**](Options.md)|  | [optional]

### Return type

[**MoveTaskOrder**](MoveTaskOrder.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createServiceItem"></a>
# **createServiceItem**
> ServiceItem createServiceItem(moveTaskOrderId, filter, page, perPage)

Creates a service item for a move order by id

Creates a service item for a move order by id

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MoveTaskOrderApi;


MoveTaskOrderApi apiInstance = new MoveTaskOrderApi();
UUID moveTaskOrderId = new UUID(); // UUID | 
List<String> filter = Arrays.asList("filter_example"); // List<String> | 
Integer page = 56; // Integer | 
Integer perPage = 56; // Integer | 
try {
    ServiceItem result = apiInstance.createServiceItem(moveTaskOrderId, filter, page, perPage);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MoveTaskOrderApi#createServiceItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **moveTaskOrderId** | [**UUID**](.md)|  |
 **filter** | [**List&lt;String&gt;**](String.md)|  | [optional]
 **page** | **Integer**|  | [optional]
 **perPage** | **Integer**|  | [optional]

### Return type

[**ServiceItem**](ServiceItem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="indexMoveTaskOrders"></a>
# **indexMoveTaskOrders**
> MoveTaskOrders indexMoveTaskOrders(filter, page, perPage)

List all move task rders

Returns a list of move task orders

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MoveTaskOrderApi;


MoveTaskOrderApi apiInstance = new MoveTaskOrderApi();
List<String> filter = Arrays.asList("filter_example"); // List<String> | 
Integer page = 56; // Integer | 
Integer perPage = 56; // Integer | 
try {
    MoveTaskOrders result = apiInstance.indexMoveTaskOrders(filter, page, perPage);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MoveTaskOrderApi#indexMoveTaskOrders");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filter** | [**List&lt;String&gt;**](String.md)|  | [optional]
 **page** | **Integer**|  | [optional]
 **perPage** | **Integer**|  | [optional]

### Return type

[**MoveTaskOrders**](MoveTaskOrders.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

