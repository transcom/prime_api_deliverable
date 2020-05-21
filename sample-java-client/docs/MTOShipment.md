
# MTOShipment

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**moveTaskOrderID** | [**UUID**](UUID.md) |  |  [optional]
**id** | [**UUID**](UUID.md) |  |  [optional]
**createdAt** | **String** |  |  [optional]
**updatedAt** | **String** |  |  [optional]
**approvedDate** | [**LocalDate**](LocalDate.md) | date when the shipment was given the status \&quot;APPROVED\&quot; |  [optional]
**scheduledPickupDate** | [**LocalDate**](LocalDate.md) |  |  [optional]
**requestedPickupDate** | [**LocalDate**](LocalDate.md) |  |  [optional]
**firstAvailableDeliveryDate** | [**LocalDate**](LocalDate.md) |  |  [optional]
**primeActualWeight** | **Integer** |  |  [optional]
**primeEstimatedWeight** | **Integer** |  |  [optional]
**primeEstimatedWeightRecordedDate** | [**LocalDate**](LocalDate.md) |  |  [optional]
**actualPickupDate** | [**LocalDate**](LocalDate.md) |  |  [optional]
**requiredDeliveryDate** | [**LocalDate**](LocalDate.md) |  |  [optional]
**agents** | [**MTOAgents**](MTOAgents.md) |  |  [optional]
**customerRemarks** | **String** |  |  [optional]
**shipmentType** | [**MTOShipmentType**](MTOShipmentType.md) |  |  [optional]
**pickupAddress** | [**Address**](Address.md) |  |  [optional]
**destinationAddress** | [**Address**](Address.md) |  |  [optional]
**secondaryPickupAddress** | [**Address**](Address.md) |  |  [optional]
**secondaryDeliveryAddress** | [**Address**](Address.md) |  |  [optional]
**eTag** | **String** |  |  [optional]
**status** | [**StatusEnum**](#StatusEnum) |  |  [optional]
**rejectionReason** | **String** |  |  [optional]
**pointOfContact** | **String** | Email or id of a contact person for this update. |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
APPROVED | &quot;APPROVED&quot;
SUBMITTED | &quot;SUBMITTED&quot;
REJECTED | &quot;REJECTED&quot;



