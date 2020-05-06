# SwaggerClient::MtoServiceItemApi

All URIs are relative to *http://localhost/prime/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_mto_service_item**](MtoServiceItemApi.md#create_mto_service_item) | **POST** /move-task-orders/{moveTaskOrderID}/mto-shipments/{mtoShipmentID}/mto-service-items | Creates MTO service items that is added to a Move Task Order and MTO Shipment


# **create_mto_service_item**
> MTOServiceItem create_mto_service_item(move_task_order_id, mto_shipment_id, opts)

Creates MTO service items that is added to a Move Task Order and MTO Shipment

Creates a new instance of mtoServiceItem, which come from the list of services that can be provided. Upon creation these items are associated with a Move Task Order and an MTO Shipment. 

### Example
```ruby
# load the gem
require 'swagger_client'

api_instance = SwaggerClient::MtoServiceItemApi.new

move_task_order_id = 'move_task_order_id_example' # String | UUID of Move Task Order to use.

mto_shipment_id = 'mto_shipment_id_example' # String | UUID of MTO Shipment to use.

opts = { 
  body: SwaggerClient::MTOServiceItem.new # MTOServiceItem | 
}

begin
  #Creates MTO service items that is added to a Move Task Order and MTO Shipment
  result = api_instance.create_mto_service_item(move_task_order_id, mto_shipment_id, opts)
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling MtoServiceItemApi->create_mto_service_item: #{e}"
end
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **move_task_order_id** | [**String**](.md)| UUID of Move Task Order to use. | 
 **mto_shipment_id** | [**String**](.md)| UUID of MTO Shipment to use. | 
 **body** | [**MTOServiceItem**](MTOServiceItem.md)|  | [optional] 

### Return type

[**MTOServiceItem**](MTOServiceItem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json



