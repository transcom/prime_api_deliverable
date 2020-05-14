/*
 * move.mil API
 * The Prime API for move.mil
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


import io.swagger.client.model.Error;
import java.io.File;
import io.swagger.client.model.ResponsesPermissionDenied;
import io.swagger.client.model.Upload;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UploadsApi {
    private ApiClient apiClient;

    public UploadsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public UploadsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for createUpload
     * @param paymentRequestID UUID of payment request to use. (required)
     * @param file The file to upload. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call createUploadCall(String paymentRequestID, File file, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/payment-requests/{paymentRequestID}/uploads"
            .replaceAll("\\{" + "paymentRequestID" + "\\}", apiClient.escapeString(paymentRequestID.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        if (file != null)
        localVarFormParams.put("file", file);

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "multipart/form-data"
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
    private com.squareup.okhttp.Call createUploadValidateBeforeCall(String paymentRequestID, File file, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'paymentRequestID' is set
        if (paymentRequestID == null) {
            throw new ApiException("Missing the required parameter 'paymentRequestID' when calling createUpload(Async)");
        }
        
        // verify the required parameter 'file' is set
        if (file == null) {
            throw new ApiException("Missing the required parameter 'file' when calling createUpload(Async)");
        }
        

        com.squareup.okhttp.Call call = createUploadCall(paymentRequestID, file, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Create a new upload for a payment request
     * Uploads represent a single digital file, such as a JPEG, PNG, or PDF.
     * @param paymentRequestID UUID of payment request to use. (required)
     * @param file The file to upload. (required)
     * @return Upload
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Upload createUpload(String paymentRequestID, File file) throws ApiException {
        ApiResponse<Upload> resp = createUploadWithHttpInfo(paymentRequestID, file);
        return resp.getData();
    }

    /**
     * Create a new upload for a payment request
     * Uploads represent a single digital file, such as a JPEG, PNG, or PDF.
     * @param paymentRequestID UUID of payment request to use. (required)
     * @param file The file to upload. (required)
     * @return ApiResponse&lt;Upload&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Upload> createUploadWithHttpInfo(String paymentRequestID, File file) throws ApiException {
        com.squareup.okhttp.Call call = createUploadValidateBeforeCall(paymentRequestID, file, null, null);
        Type localVarReturnType = new TypeToken<Upload>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create a new upload for a payment request (asynchronously)
     * Uploads represent a single digital file, such as a JPEG, PNG, or PDF.
     * @param paymentRequestID UUID of payment request to use. (required)
     * @param file The file to upload. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createUploadAsync(String paymentRequestID, File file, final ApiCallback<Upload> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = createUploadValidateBeforeCall(paymentRequestID, file, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Upload>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
