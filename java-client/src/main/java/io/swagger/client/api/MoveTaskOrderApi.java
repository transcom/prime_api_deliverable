/*
 * move.mil Prime API
 * The API for move.mil Prime actions.
 *
 * OpenAPI spec version: 0.1.0
 * 
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
import io.swagger.client.model.MoveTaskOrder;
import io.swagger.client.model.MoveTaskOrders;
import io.swagger.client.model.Options;
import io.swagger.client.model.ServiceItem;
import java.util.UUID;
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
     * Build call for completeCounseling
     * @param moveTaskOrderId  (required)
     * @param options  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call completeCounselingCall(UUID moveTaskOrderId, Options options, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = options;

        // create path and map variables
        String localVarPath = "/move_task_orders/{move_task_order_id}/complete_counseling"
            .replaceAll("\\{" + "move_task_order_id" + "\\}", apiClient.escapeString(moveTaskOrderId.toString()));

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
    private com.squareup.okhttp.Call completeCounselingValidateBeforeCall(UUID moveTaskOrderId, Options options, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'moveTaskOrderId' is set
        if (moveTaskOrderId == null) {
            throw new ApiException("Missing the required parameter 'moveTaskOrderId' when calling completeCounseling(Async)");
        }
        

        com.squareup.okhttp.Call call = completeCounselingCall(moveTaskOrderId, options, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Completes counseling for a move task order by id
     * Completes counseling for a move task order by id
     * @param moveTaskOrderId  (required)
     * @param options  (optional)
     * @return MoveTaskOrder
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public MoveTaskOrder completeCounseling(UUID moveTaskOrderId, Options options) throws ApiException {
        ApiResponse<MoveTaskOrder> resp = completeCounselingWithHttpInfo(moveTaskOrderId, options);
        return resp.getData();
    }

    /**
     * Completes counseling for a move task order by id
     * Completes counseling for a move task order by id
     * @param moveTaskOrderId  (required)
     * @param options  (optional)
     * @return ApiResponse&lt;MoveTaskOrder&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<MoveTaskOrder> completeCounselingWithHttpInfo(UUID moveTaskOrderId, Options options) throws ApiException {
        com.squareup.okhttp.Call call = completeCounselingValidateBeforeCall(moveTaskOrderId, options, null, null);
        Type localVarReturnType = new TypeToken<MoveTaskOrder>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Completes counseling for a move task order by id (asynchronously)
     * Completes counseling for a move task order by id
     * @param moveTaskOrderId  (required)
     * @param options  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call completeCounselingAsync(UUID moveTaskOrderId, Options options, final ApiCallback<MoveTaskOrder> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = completeCounselingValidateBeforeCall(moveTaskOrderId, options, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<MoveTaskOrder>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for createServiceItem
     * @param moveTaskOrderId  (required)
     * @param serviceItem Unique identifier of the user making the request (optional)
     * @param filter  (optional)
     * @param page  (optional)
     * @param perPage  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call createServiceItemCall(UUID moveTaskOrderId, ServiceItem serviceItem, List<String> filter, Integer page, Integer perPage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = serviceItem;

        // create path and map variables
        String localVarPath = "/move_task_orders/{move_task_order_id}/service_items"
            .replaceAll("\\{" + "move_task_order_id" + "\\}", apiClient.escapeString(moveTaskOrderId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "filter", filter));
        if (page != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("page", page));
        if (perPage != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("perPage", perPage));

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
    private com.squareup.okhttp.Call createServiceItemValidateBeforeCall(UUID moveTaskOrderId, ServiceItem serviceItem, List<String> filter, Integer page, Integer perPage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'moveTaskOrderId' is set
        if (moveTaskOrderId == null) {
            throw new ApiException("Missing the required parameter 'moveTaskOrderId' when calling createServiceItem(Async)");
        }
        

        com.squareup.okhttp.Call call = createServiceItemCall(moveTaskOrderId, serviceItem, filter, page, perPage, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Creates a service item for a move order by id
     * Creates a service item for a move order by id
     * @param moveTaskOrderId  (required)
     * @param serviceItem Unique identifier of the user making the request (optional)
     * @param filter  (optional)
     * @param page  (optional)
     * @param perPage  (optional)
     * @return ServiceItem
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ServiceItem createServiceItem(UUID moveTaskOrderId, ServiceItem serviceItem, List<String> filter, Integer page, Integer perPage) throws ApiException {
        ApiResponse<ServiceItem> resp = createServiceItemWithHttpInfo(moveTaskOrderId, serviceItem, filter, page, perPage);
        return resp.getData();
    }

    /**
     * Creates a service item for a move order by id
     * Creates a service item for a move order by id
     * @param moveTaskOrderId  (required)
     * @param serviceItem Unique identifier of the user making the request (optional)
     * @param filter  (optional)
     * @param page  (optional)
     * @param perPage  (optional)
     * @return ApiResponse&lt;ServiceItem&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ServiceItem> createServiceItemWithHttpInfo(UUID moveTaskOrderId, ServiceItem serviceItem, List<String> filter, Integer page, Integer perPage) throws ApiException {
        com.squareup.okhttp.Call call = createServiceItemValidateBeforeCall(moveTaskOrderId, serviceItem, filter, page, perPage, null, null);
        Type localVarReturnType = new TypeToken<ServiceItem>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Creates a service item for a move order by id (asynchronously)
     * Creates a service item for a move order by id
     * @param moveTaskOrderId  (required)
     * @param serviceItem Unique identifier of the user making the request (optional)
     * @param filter  (optional)
     * @param page  (optional)
     * @param perPage  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createServiceItemAsync(UUID moveTaskOrderId, ServiceItem serviceItem, List<String> filter, Integer page, Integer perPage, final ApiCallback<ServiceItem> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = createServiceItemValidateBeforeCall(moveTaskOrderId, serviceItem, filter, page, perPage, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ServiceItem>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for indexMoveTaskOrders
     * @param requestor Unique identifier of the user making the request (required)
     * @param filter  (optional)
     * @param page  (optional)
     * @param perPage  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call indexMoveTaskOrdersCall(String requestor, List<String> filter, Integer page, Integer perPage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/move_task_orders";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (requestor != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("requestor", requestor));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "filter", filter));
        if (page != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("page", page));
        if (perPage != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("perPage", perPage));

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call indexMoveTaskOrdersValidateBeforeCall(String requestor, List<String> filter, Integer page, Integer perPage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'requestor' is set
        if (requestor == null) {
            throw new ApiException("Missing the required parameter 'requestor' when calling indexMoveTaskOrders(Async)");
        }
        

        com.squareup.okhttp.Call call = indexMoveTaskOrdersCall(requestor, filter, page, perPage, progressListener, progressRequestListener);
        return call;

    }

    /**
     * List all move task rders
     * Returns a list of move task orders
     * @param requestor Unique identifier of the user making the request (required)
     * @param filter  (optional)
     * @param page  (optional)
     * @param perPage  (optional)
     * @return MoveTaskOrders
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public MoveTaskOrders indexMoveTaskOrders(String requestor, List<String> filter, Integer page, Integer perPage) throws ApiException {
        ApiResponse<MoveTaskOrders> resp = indexMoveTaskOrdersWithHttpInfo(requestor, filter, page, perPage);
        return resp.getData();
    }

    /**
     * List all move task rders
     * Returns a list of move task orders
     * @param requestor Unique identifier of the user making the request (required)
     * @param filter  (optional)
     * @param page  (optional)
     * @param perPage  (optional)
     * @return ApiResponse&lt;MoveTaskOrders&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<MoveTaskOrders> indexMoveTaskOrdersWithHttpInfo(String requestor, List<String> filter, Integer page, Integer perPage) throws ApiException {
        com.squareup.okhttp.Call call = indexMoveTaskOrdersValidateBeforeCall(requestor, filter, page, perPage, null, null);
        Type localVarReturnType = new TypeToken<MoveTaskOrders>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List all move task rders (asynchronously)
     * Returns a list of move task orders
     * @param requestor Unique identifier of the user making the request (required)
     * @param filter  (optional)
     * @param page  (optional)
     * @param perPage  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call indexMoveTaskOrdersAsync(String requestor, List<String> filter, Integer page, Integer perPage, final ApiCallback<MoveTaskOrders> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = indexMoveTaskOrdersValidateBeforeCall(requestor, filter, page, perPage, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<MoveTaskOrders>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
