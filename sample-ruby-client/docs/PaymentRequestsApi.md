# SwaggerClient::PaymentRequestsApi

All URIs are relative to *http://localhost/prime/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_payment_request**](PaymentRequestsApi.md#create_payment_request) | **POST** /payment-requests | Creates a payment request


# **create_payment_request**
> PaymentRequest create_payment_request(opts)

Creates a payment request

Creates a new instance of a paymentRequest. A newly created payment request is assigned the status `PENDING`. A move task order can have multiple payment requests, and a final payment request can be marked using boolean `isFinal`. 

### Example
```ruby
# load the gem
require 'swagger_client'

api_instance = SwaggerClient::PaymentRequestsApi.new

opts = { 
  body: SwaggerClient::CreatePaymentRequestPayload.new # CreatePaymentRequestPayload | 
}

begin
  #Creates a payment request
  result = api_instance.create_payment_request(opts)
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling PaymentRequestsApi->create_payment_request: #{e}"
end
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**CreatePaymentRequestPayload**](CreatePaymentRequestPayload.md)|  | [optional] 

### Return type

[**PaymentRequest**](PaymentRequest.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json



