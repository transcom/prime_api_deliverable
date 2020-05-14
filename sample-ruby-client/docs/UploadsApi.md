# SwaggerClient::UploadsApi

All URIs are relative to *http://localhost/prime/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_upload**](UploadsApi.md#create_upload) | **POST** /payment-requests/{paymentRequestID}/uploads | Create a new upload for a payment request


# **create_upload**
> Upload create_upload(payment_request_id, file)

Create a new upload for a payment request

Uploads represent a single digital file, such as a JPEG, PNG, or PDF.

### Example
```ruby
# load the gem
require 'swagger_client'

api_instance = SwaggerClient::UploadsApi.new

payment_request_id = 'payment_request_id_example' # String | UUID of payment request to use.

file = File.new('/path/to/file.txt') # File | The file to upload.


begin
  #Create a new upload for a payment request
  result = api_instance.create_upload(payment_request_id, file)
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling UploadsApi->create_upload: #{e}"
end
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **payment_request_id** | **String**| UUID of payment request to use. | 
 **file** | **File**| The file to upload. | 

### Return type

[**Upload**](Upload.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json



