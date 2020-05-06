
# MoveTaskOrder

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | [**UUID**](UUID.md) |  |  [optional]
**createdAt** | [**LocalDate**](LocalDate.md) |  |  [optional]
**moveOrderID** | [**UUID**](UUID.md) |  |  [optional]
**moveOrder** | [**MoveOrder**](MoveOrder.md) |  |  [optional]
**referenceId** | **String** |  |  [optional]
**isAvailableToPrime** | **Boolean** |  |  [optional]
**isCanceled** | **Boolean** |  |  [optional]
**updatedAt** | [**LocalDate**](LocalDate.md) |  |  [optional]
**paymentRequests** | [**PaymentRequests**](PaymentRequests.md) |  | 
**mtoServiceItems** | [**List&lt;MTOServiceItem&gt;**](MTOServiceItem.md) |  | 
**mtoShipments** | [**MTOShipments**](MTOShipments.md) |  | 
**ppmType** | [**PpmTypeEnum**](#PpmTypeEnum) |  |  [optional]
**ppmEstimatedWeight** | **Integer** |  |  [optional]
**eTag** | **String** |  |  [optional]


<a name="PpmTypeEnum"></a>
## Enum: PpmTypeEnum
Name | Value
---- | -----
FULL | &quot;FULL&quot;
PARTIAL | &quot;PARTIAL&quot;



