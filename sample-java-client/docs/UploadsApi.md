# UploadsApi

All URIs are relative to *http://localhost/prime/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createUpload**](UploadsApi.md#createUpload) | **POST** /payment-requests/{paymentRequestID}/uploads | Create a new upload for a payment request


<a name="createUpload"></a>
# **createUpload**
> Upload createUpload(paymentRequestID, file)

Create a new upload for a payment request

Uploads represent a single digital file, such as a JPEG, PNG, or PDF.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UploadsApi;


UploadsApi apiInstance = new UploadsApi();
String paymentRequestID = "paymentRequestID_example"; // String | UUID of payment request to use.
File file = new File("/path/to/file.txt"); // File | The file to upload.
try {
    Upload result = apiInstance.createUpload(paymentRequestID, file);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UploadsApi#createUpload");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **paymentRequestID** | **String**| UUID of payment request to use. |
 **file** | **File**| The file to upload. |

### Return type

[**Upload**](Upload.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

