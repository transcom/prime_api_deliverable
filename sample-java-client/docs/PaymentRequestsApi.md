# PaymentRequestsApi

All URIs are relative to *http://localhost/prime/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createPaymentRequest**](PaymentRequestsApi.md#createPaymentRequest) | **POST** /payment-requests | createPaymentRequest


<a name="createPaymentRequest"></a>
# **createPaymentRequest**
> PaymentRequest createPaymentRequest(body)

createPaymentRequest

Creates a new instance of a paymentRequest. A newly created payment request is assigned the status &#x60;PENDING&#x60;. A move task order can have multiple payment requests, and a final payment request can be marked using boolean &#x60;isFinal&#x60;. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PaymentRequestsApi;


PaymentRequestsApi apiInstance = new PaymentRequestsApi();
CreatePaymentRequestPayload body = new CreatePaymentRequestPayload(); // CreatePaymentRequestPayload | 
try {
    PaymentRequest result = apiInstance.createPaymentRequest(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentRequestsApi#createPaymentRequest");
    e.printStackTrace();
}
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

