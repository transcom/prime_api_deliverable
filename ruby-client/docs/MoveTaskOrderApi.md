# SwaggerClient::MoveTaskOrderApi

All URIs are relative to *https://localhost/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**complete_counseling**](MoveTaskOrderApi.md#complete_counseling) | **POST** /move_task_orders/{move_task_order_id}/complete_counseling | Completes counseling for a move task order by id
[**create_service_item**](MoveTaskOrderApi.md#create_service_item) | **POST** /move_task_orders/{move_task_order_id}/service_items | Creates a service item for a move order by id
[**index_move_task_orders**](MoveTaskOrderApi.md#index_move_task_orders) | **GET** /move_task_orders | List all move task rders


# **complete_counseling**
> MoveTaskOrder complete_counseling(move_task_order_id, opts)

Completes counseling for a move task order by id

Completes counseling for a move task order by id

### Example
```ruby
# load the gem
require 'swagger_client'

api_instance = SwaggerClient::MoveTaskOrderApi.new

move_task_order_id = 'move_task_order_id_example' # String | 

opts = { 
  options: SwaggerClient::Options.new # Options | 
}

begin
  #Completes counseling for a move task order by id
  result = api_instance.complete_counseling(move_task_order_id, opts)
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling MoveTaskOrderApi->complete_counseling: #{e}"
end
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **move_task_order_id** | [**String**](.md)|  | 
 **options** | [**Options**](Options.md)|  | [optional] 

### Return type

[**MoveTaskOrder**](MoveTaskOrder.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json



# **create_service_item**
> ServiceItem create_service_item(move_task_order_id, opts)

Creates a service item for a move order by id

Creates a service item for a move order by id

### Example
```ruby
# load the gem
require 'swagger_client'

api_instance = SwaggerClient::MoveTaskOrderApi.new

move_task_order_id = 'move_task_order_id_example' # String | 

opts = { 
  filter: ['filter_example'], # Array<String> | 
  page: 56, # Integer | 
  per_page: 56 # Integer | 
}

begin
  #Creates a service item for a move order by id
  result = api_instance.create_service_item(move_task_order_id, opts)
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling MoveTaskOrderApi->create_service_item: #{e}"
end
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **move_task_order_id** | [**String**](.md)|  | 
 **filter** | [**Array&lt;String&gt;**](String.md)|  | [optional] 
 **page** | **Integer**|  | [optional] 
 **per_page** | **Integer**|  | [optional] 

### Return type

[**ServiceItem**](ServiceItem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json



# **index_move_task_orders**
> MoveTaskOrders index_move_task_orders(opts)

List all move task rders

Returns a list of move task orders

### Example
```ruby
# load the gem
require 'swagger_client'

api_instance = SwaggerClient::MoveTaskOrderApi.new

opts = { 
  filter: ['filter_example'], # Array<String> | 
  page: 56, # Integer | 
  per_page: 56 # Integer | 
}

begin
  #List all move task rders
  result = api_instance.index_move_task_orders(opts)
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling MoveTaskOrderApi->index_move_task_orders: #{e}"
end
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filter** | [**Array&lt;String&gt;**](String.md)|  | [optional] 
 **page** | **Integer**|  | [optional] 
 **per_page** | **Integer**|  | [optional] 

### Return type

[**MoveTaskOrders**](MoveTaskOrders.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json



