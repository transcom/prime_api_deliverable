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


import io.swagger.client.model.Body;
import io.swagger.client.model.Error;
import io.swagger.client.model.MoveTaskOrder;
import io.swagger.client.model.MoveTaskOrders;
import io.swagger.client.model.ValidationError;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoveTaskOrderApi {
    private ApiClient apiClient;

    public MoveTaskOrderApi() {
        this(Configuration.getDefaultApiClient());
    }

    public MoveTaskOrderApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for fetchMTOUpdates
     * @param since Only return move task orders updated since this time. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call fetchMTOUpdatesCall(Integer since, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/move-task-orders";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (since != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("since", since));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call fetchMTOUpdatesValidateBeforeCall(Integer since, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = fetchMTOUpdatesCall(since, progressListener, progressRequestListener);
        return call;

    }

    /**
     * fetchMTOUpdates
     * Gets all move task orders where &#x60;isAvailableToPrime&#x60; is TRUE. This prevents viewing any move task orders that have not been made available to the Prime. 
     * @param since Only return move task orders updated since this time. (optional)
     * @return MoveTaskOrders
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public MoveTaskOrders fetchMTOUpdates(Integer since) throws ApiException {
        ApiResponse<MoveTaskOrders> resp = fetchMTOUpdatesWithHttpInfo(since);
        return resp.getData();
    }

    /**
     * fetchMTOUpdates
     * Gets all move task orders where &#x60;isAvailableToPrime&#x60; is TRUE. This prevents viewing any move task orders that have not been made available to the Prime. 
     * @param since Only return move task orders updated since this time. (optional)
     * @return ApiResponse&lt;MoveTaskOrders&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<MoveTaskOrders> fetchMTOUpdatesWithHttpInfo(Integer since) throws ApiException {
        com.squareup.okhttp.Call call = fetchMTOUpdatesValidateBeforeCall(since, null, null);
        Type localVarReturnType = new TypeToken<MoveTaskOrders>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * fetchMTOUpdates (asynchronously)
     * Gets all move task orders where &#x60;isAvailableToPrime&#x60; is TRUE. This prevents viewing any move task orders that have not been made available to the Prime. 
     * @param since Only return move task orders updated since this time. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call fetchMTOUpdatesAsync(Integer since, final ApiCallback<MoveTaskOrders> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = fetchMTOUpdatesValidateBeforeCall(since, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<MoveTaskOrders>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateMTOPostCounselingInformation
     * @param moveTaskOrderID ID of move task order to use. (required)
     * @param body  (required)
     * @param ifMatch Optimistic locking is implemented via the &#x60;If-Match&#x60; header. If the ETag header does not match the value of the resource on the server, the server rejects the change with a &#x60;412 Precondition Failed&#x60; error.  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call updateMTOPostCounselingInformationCall(String moveTaskOrderID, Body body, String ifMatch, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/move-task-orders/{moveTaskOrderID}/post-counseling-info"
            .replaceAll("\\{" + "moveTaskOrderID" + "\\}", apiClient.escapeString(moveTaskOrderID.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (ifMatch != null)
        localVarHeaderParams.put("If-Match", apiClient.parameterToString(ifMatch));

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
        return apiClient.buildCall(localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateMTOPostCounselingInformationValidateBeforeCall(String moveTaskOrderID, Body body, String ifMatch, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'moveTaskOrderID' is set
        if (moveTaskOrderID == null) {
            throw new ApiException("Missing the required parameter 'moveTaskOrderID' when calling updateMTOPostCounselingInformation(Async)");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling updateMTOPostCounselingInformation(Async)");
        }
        
        // verify the required parameter 'ifMatch' is set
        if (ifMatch == null) {
            throw new ApiException("Missing the required parameter 'ifMatch' when calling updateMTOPostCounselingInformation(Async)");
        }
        

        com.squareup.okhttp.Call call = updateMTOPostCounselingInformationCall(moveTaskOrderID, body, ifMatch, progressListener, progressRequestListener);
        return call;

    }

    /**
     * updateMTOPostCounselingInformation
     * Updates move task order after the counseling stage. Allows update of fields ppmType and ppmEstimatedWeight.
     * @param moveTaskOrderID ID of move task order to use. (required)
     * @param body  (required)
     * @param ifMatch Optimistic locking is implemented via the &#x60;If-Match&#x60; header. If the ETag header does not match the value of the resource on the server, the server rejects the change with a &#x60;412 Precondition Failed&#x60; error.  (required)
     * @return MoveTaskOrder
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public MoveTaskOrder updateMTOPostCounselingInformation(String moveTaskOrderID, Body body, String ifMatch) throws ApiException {
        ApiResponse<MoveTaskOrder> resp = updateMTOPostCounselingInformationWithHttpInfo(moveTaskOrderID, body, ifMatch);
        return resp.getData();
    }

    /**
     * updateMTOPostCounselingInformation
     * Updates move task order after the counseling stage. Allows update of fields ppmType and ppmEstimatedWeight.
     * @param moveTaskOrderID ID of move task order to use. (required)
     * @param body  (required)
     * @param ifMatch Optimistic locking is implemented via the &#x60;If-Match&#x60; header. If the ETag header does not match the value of the resource on the server, the server rejects the change with a &#x60;412 Precondition Failed&#x60; error.  (required)
     * @return ApiResponse&lt;MoveTaskOrder&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<MoveTaskOrder> updateMTOPostCounselingInformationWithHttpInfo(String moveTaskOrderID, Body body, String ifMatch) throws ApiException {
        com.squareup.okhttp.Call call = updateMTOPostCounselingInformationValidateBeforeCall(moveTaskOrderID, body, ifMatch, null, null);
        Type localVarReturnType = new TypeToken<MoveTaskOrder>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * updateMTOPostCounselingInformation (asynchronously)
     * Updates move task order after the counseling stage. Allows update of fields ppmType and ppmEstimatedWeight.
     * @param moveTaskOrderID ID of move task order to use. (required)
     * @param body  (required)
     * @param ifMatch Optimistic locking is implemented via the &#x60;If-Match&#x60; header. If the ETag header does not match the value of the resource on the server, the server rejects the change with a &#x60;412 Precondition Failed&#x60; error.  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateMTOPostCounselingInformationAsync(String moveTaskOrderID, Body body, String ifMatch, final ApiCallback<MoveTaskOrder> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = updateMTOPostCounselingInformationValidateBeforeCall(moveTaskOrderID, body, ifMatch, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<MoveTaskOrder>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
