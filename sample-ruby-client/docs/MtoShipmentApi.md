# SwaggerClient::MtoShipmentApi

All URIs are relative to *http://localhost/prime/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**update_mto_shipment**](MtoShipmentApi.md#update_mto_shipment) | **PUT** /move-task-orders/{moveTaskOrderID}/mto-shipments/{mtoShipmentID} | Updates MTO shipment


# **update_mto_shipment**
> MTOShipment update_mto_shipment(move_task_order_id, mto_shipment_id, body, if_match)

Updates MTO shipment

Updates MTO shipment.

### Example
```ruby
# load the gem
require 'swagger_client'

api_instance = SwaggerClient::MtoShipmentApi.new

move_task_order_id = 'move_task_order_id_example' # String | UUID of the move task order being used.

mto_shipment_id = 'mto_shipment_id_example' # String | UUID of the move task order shipment being updated.

body = SwaggerClient::MTOShipment.new # MTOShipment | 

if_match = 'if_match_example' # String | Optimistic locking is implemented via the `If-Match` header. If the ETag header does not match the value of the resource on the server, the server rejects the change with a `412 Precondition Failed` error. 


begin
  #Updates MTO shipment
  result = api_instance.update_mto_shipment(move_task_order_id, mto_shipment_id, body, if_match)
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling MtoShipmentApi->update_mto_shipment: #{e}"
end
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **move_task_order_id** | [**String**](.md)| UUID of the move task order being used. | 
 **mto_shipment_id** | [**String**](.md)| UUID of the move task order shipment being updated. | 
 **body** | [**MTOShipment**](MTOShipment.md)|  | 
 **if_match** | **String**| Optimistic locking is implemented via the &#x60;If-Match&#x60; header. If the ETag header does not match the value of the resource on the server, the server rejects the change with a &#x60;412 Precondition Failed&#x60; error.  | 

### Return type

[**MTOShipment**](MTOShipment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json



