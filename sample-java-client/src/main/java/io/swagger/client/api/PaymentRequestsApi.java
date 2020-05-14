/*
 * Milmove Prime API
 * The Prime API is a RESTful API that enables the Prime contractor to request information about upcoming moves, update the details and status of those moves, and make payment requests. It uses Mutual TLS for authentication procedures.  All endpoints are located at `primelocal/prime/v1/`. 
 *
 * OpenAPI spec version: 0.0.1
 * Contact: dp3@truss.works
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.swagger.client.model.ClientError;
import io.swagger.client.model.CreatePaymentRequestPayload;
import io.swagger.client.model.Error;
import io.swagger.client.model.PaymentRequest;
import io.swagger.client.model.ValidationError;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentRequestsApi {
    private ApiClient apiClient;

    public PaymentRequestsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public PaymentRequestsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for createPaymentRequest
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call createPaymentRequestCall(CreatePaymentRequestPayload body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/payment-requests";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call createPaymentRequestValidateBeforeCall(CreatePaymentRequestPayload body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = createPaymentRequestCall(body, progressListener, progressRequestListener);
        return call;

    }

    /**
     * createPaymentRequest
     * Creates a new instance of a paymentRequest. A newly created payment request is assigned the status &#x60;PENDING&#x60;. A move task order can have multiple payment requests, and a final payment request can be marked using boolean &#x60;isFinal&#x60;. 
     * @param body  (optional)
     * @return PaymentRequest
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PaymentRequest createPaymentRequest(CreatePaymentRequestPayload body) throws ApiException {
        ApiResponse<PaymentRequest> resp = createPaymentRequestWithHttpInfo(body);
        return resp.getData();
    }

    /**
     * createPaymentRequest
     * Creates a new instance of a paymentRequest. A newly created payment request is assigned the status &#x60;PENDING&#x60;. A move task order can have multiple payment requests, and a final payment request can be marked using boolean &#x60;isFinal&#x60;. 
     * @param body  (optional)
     * @return ApiResponse&lt;PaymentRequest&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<PaymentRequest> createPaymentRequestWithHttpInfo(CreatePaymentRequestPayload body) throws ApiException {
        com.squareup.okhttp.Call call = createPaymentRequestValidateBeforeCall(body, null, null);
        Type localVarReturnType = new TypeToken<PaymentRequest>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * createPaymentRequest (asynchronously)
     * Creates a new instance of a paymentRequest. A newly created payment request is assigned the status &#x60;PENDING&#x60;. A move task order can have multiple payment requests, and a final payment request can be marked using boolean &#x60;isFinal&#x60;. 
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createPaymentRequestAsync(CreatePaymentRequestPayload body, final ApiCallback<PaymentRequest> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = createPaymentRequestValidateBeforeCall(body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<PaymentRequest>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
