# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.MoveTaskOrderApi;

import java.io.File;
import java.util.*;

public class MoveTaskOrderApiExample {

    public static void main(String[] args) {
        
        MoveTaskOrderApi apiInstance = new MoveTaskOrderApi();
        Integer since = 56; // Integer | Only return move task orders updated since this time.
        try {
            MoveTaskOrders result = apiInstance.fetchMTOUpdates(since);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MoveTaskOrderApi#fetchMTOUpdates");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://localhost/prime/v1*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*MoveTaskOrderApi* | [**fetchMTOUpdates**](docs/MoveTaskOrderApi.md#fetchMTOUpdates) | **GET** /move-task-orders | fetchMTOUpdates
*MoveTaskOrderApi* | [**updateMTOPostCounselingInformation**](docs/MoveTaskOrderApi.md#updateMTOPostCounselingInformation) | **PATCH** /move-task-orders/{moveTaskOrderID}/post-counseling-info | updateMTOPostCounselingInformation
*MtoServiceItemApi* | [**createMTOServiceItem**](docs/MtoServiceItemApi.md#createMTOServiceItem) | **POST** /mto-service-items | createMTOServiceItem
*MtoShipmentApi* | [**createMTOShipment**](docs/MtoShipmentApi.md#createMTOShipment) | **POST** /mto-shipments | createMTOShipment
*MtoShipmentApi* | [**updateMTOShipment**](docs/MtoShipmentApi.md#updateMTOShipment) | **PUT** /mto-shipments/{mtoShipmentID} | updateMTOShipment
*PaymentRequestsApi* | [**createPaymentRequest**](docs/PaymentRequestsApi.md#createPaymentRequest) | **POST** /payment-requests | createPaymentRequest
*UploadsApi* | [**createUpload**](docs/UploadsApi.md#createUpload) | **POST** /payment-requests/{paymentRequestID}/uploads | createUpload


## Documentation for Models

 - [Address](docs/Address.md)
 - [Body](docs/Body.md)
 - [ClientError](docs/ClientError.md)
 - [CreatePaymentRequestPayload](docs/CreatePaymentRequestPayload.md)
 - [CreateShipmentPayload](docs/CreateShipmentPayload.md)
 - [Customer](docs/Customer.md)
 - [CustomerContactType](docs/CustomerContactType.md)
 - [DimensionType](docs/DimensionType.md)
 - [DutyStation](docs/DutyStation.md)
 - [Entitlements](docs/Entitlements.md)
 - [Error](docs/Error.md)
 - [MTOAgent](docs/MTOAgent.md)
 - [MTOAgentType](docs/MTOAgentType.md)
 - [MTOAgents](docs/MTOAgents.md)
 - [MTOServiceItem](docs/MTOServiceItem.md)
 - [MTOServiceItemDimension](docs/MTOServiceItemDimension.md)
 - [MTOServiceItemModelType](docs/MTOServiceItemModelType.md)
 - [MTOServiceItemStatus](docs/MTOServiceItemStatus.md)
 - [MTOShipment](docs/MTOShipment.md)
 - [MTOShipmentType](docs/MTOShipmentType.md)
 - [MTOShipments](docs/MTOShipments.md)
 - [MoveOrder](docs/MoveOrder.md)
 - [MoveTaskOrder](docs/MoveTaskOrder.md)
 - [MoveTaskOrders](docs/MoveTaskOrders.md)
 - [PaymentRequest](docs/PaymentRequest.md)
 - [PaymentRequestStatus](docs/PaymentRequestStatus.md)
 - [PaymentRequests](docs/PaymentRequests.md)
 - [ProofOfServiceDocs](docs/ProofOfServiceDocs.md)
 - [ReServiceCode](docs/ReServiceCode.md)
 - [ServiceItem](docs/ServiceItem.md)
 - [ServiceItemParams](docs/ServiceItemParams.md)
 - [UpdatePaymentRequestStatus](docs/UpdatePaymentRequestStatus.md)
 - [Upload](docs/Upload.md)
 - [MTOServiceItemBasic](docs/MTOServiceItemBasic.md)
 - [MTOServiceItemDDFSIT](docs/MTOServiceItemDDFSIT.md)
 - [MTOServiceItemDOFSIT](docs/MTOServiceItemDOFSIT.md)
 - [MTOServiceItemDomesticCrating](docs/MTOServiceItemDomesticCrating.md)
 - [MTOServiceItemShuttle](docs/MTOServiceItemShuttle.md)
 - [ValidationError](docs/ValidationError.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

dp3@truss.works

