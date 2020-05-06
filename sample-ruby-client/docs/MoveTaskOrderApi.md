# SwaggerClient::MoveTaskOrderApi

All URIs are relative to *http://localhost/prime/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**fetch_mto_updates**](MoveTaskOrderApi.md#fetch_mto_updates) | **GET** /move-task-orders | Gets all move task orders where &#x60;isAvailableToPrime&#x60; is TRUE
[**get_move_task_order_customer**](MoveTaskOrderApi.md#get_move_task_order_customer) | **GET** /move-task-orders/{moveTaskOrderID}/customer | Gets the customer associated with a move task order ID
[**update_mto_post_counseling_information**](MoveTaskOrderApi.md#update_mto_post_counseling_information) | **PATCH** /move-task-orders/{moveTaskOrderID}/post-counseling-info | Updates move task order&#39;s post counseling information


# **fetch_mto_updates**
> MoveTaskOrders fetch_mto_updates(opts)

Gets all move task orders where `isAvailableToPrime` is TRUE

Gets all move task orders where `isAvailableToPrime` is TRUE. This prevents viewing any move task orders that have not been made available to the Prime. 

### Example
```ruby
# load the gem
require 'swagger_client'

api_instance = SwaggerClient::MoveTaskOrderApi.new

opts = { 
  since: 56 # Integer | Only return move task orders updated since this time.
}

begin
  #Gets all move task orders where `isAvailableToPrime` is TRUE
  result = api_instance.fetch_mto_updates(opts)
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling MoveTaskOrderApi->fetch_mto_updates: #{e}"
end
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



# **get_move_task_order_customer**
> Customer get_move_task_order_customer(move_task_order_id)

Gets the customer associated with a move task order ID

Gets the customer associated with a move task order ID.

### Example
```ruby
# load the gem
require 'swagger_client'

api_instance = SwaggerClient::MoveTaskOrderApi.new

move_task_order_id = 'move_task_order_id_example' # String | ID of move order to use.


begin
  #Gets the customer associated with a move task order ID
  result = api_instance.get_move_task_order_customer(move_task_order_id)
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling MoveTaskOrderApi->get_move_task_order_customer: #{e}"
end
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **move_task_order_id** | **String**| ID of move order to use. | 

### Return type

[**Customer**](Customer.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json



# **update_mto_post_counseling_information**
> MoveTaskOrder update_mto_post_counseling_information(move_task_order_id, body, if_match)

Updates move task order's post counseling information

Updates move task order fields ppmType, ppmEstimatedWeight, and pointOfContact.

### Example
```ruby
# load the gem
require 'swagger_client'

api_instance = SwaggerClient::MoveTaskOrderApi.new

move_task_order_id = 'move_task_order_id_example' # String | ID of move task order to use.

body = SwaggerClient::Body.new # Body | 

if_match = 'if_match_example' # String | Optimistic locking is implemented via the `If-Match` header. If the ETag header does not match the value of the resource on the server, the server rejects the change with a `412 Precondition Failed` error. 


begin
  #Updates move task order's post counseling information
  result = api_instance.update_mto_post_counseling_information(move_task_order_id, body, if_match)
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling MoveTaskOrderApi->update_mto_post_counseling_information: #{e}"
end
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **move_task_order_id** | **String**| ID of move task order to use. | 
 **body** | [**Body**](Body.md)|  | 
 **if_match** | **String**| Optimistic locking is implemented via the &#x60;If-Match&#x60; header. If the ETag header does not match the value of the resource on the server, the server rejects the change with a &#x60;412 Precondition Failed&#x60; error.  | 

### Return type

[**MoveTaskOrder**](MoveTaskOrder.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json



