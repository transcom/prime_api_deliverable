
# CreateShipmentPayload

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**moveTaskOrderID** | [**UUID**](UUID.md) |  | 
**shipmentType** | [**MTOShipmentType**](MTOShipmentType.md) |  |  [optional]
**requestedPickupDate** | [**LocalDate**](LocalDate.md) |  |  [optional]
**customerRemarks** | **String** |  |  [optional]
**pickupAddress** | [**Address**](Address.md) |  |  [optional]
**destinationAddress** | [**Address**](Address.md) |  |  [optional]
**agents** | [**MTOAgents**](MTOAgents.md) |  |  [optional]
**pointOfContact** | **String** | Email or id of a contact person for this update |  [optional]
**mtoServiceItems** | [**List&lt;MTOServiceItem&gt;**](MTOServiceItem.md) |  |  [optional]



