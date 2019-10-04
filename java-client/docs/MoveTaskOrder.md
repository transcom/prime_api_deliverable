
# MoveTaskOrder

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | [**UUID**](UUID.md) |  |  [optional]
**code** | **String** |  |  [optional]
**moveID** | [**UUID**](UUID.md) |  |  [optional]
**moveDate** | [**LocalDate**](LocalDate.md) |  |  [optional]
**status** | [**StatusEnum**](#StatusEnum) |  |  [optional]
**entitlements** | [**Entitlements**](Entitlements.md) |  |  [optional]
**moveTaskOrdersType** | [**MoveTaskOrdersTypeEnum**](#MoveTaskOrdersTypeEnum) |  |  [optional]
**customer** | [**Customer**](Customer.md) |  |  [optional]
**requestedPickupDate** | [**LocalDate**](LocalDate.md) |  |  [optional]
**originDutyStation** | [**UUID**](UUID.md) |  |  [optional]
**originPPSO** | [**UUID**](UUID.md) |  |  [optional]
**destinationDutyStation** | [**UUID**](UUID.md) |  |  [optional]
**destinationPPSO** | [**UUID**](UUID.md) |  |  [optional]
**remarks** | **String** |  |  [optional]
**serviceItems** | [**List&lt;ServiceItem&gt;**](ServiceItem.md) |  |  [optional]
**createdAt** | [**LocalDate**](LocalDate.md) |  |  [optional]
**updatedAt** | [**LocalDate**](LocalDate.md) |  |  [optional]
**deletedAt** | [**LocalDate**](LocalDate.md) |  |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
APPROVED | &quot;APPROVED&quot;
REJECTED | &quot;REJECTED&quot;
SUBMITTED | &quot;SUBMITTED&quot;


<a name="MoveTaskOrdersTypeEnum"></a>
## Enum: MoveTaskOrdersTypeEnum
Name | Value
---- | -----
NON_TEMPORARY_STORAGE | &quot;NON_TEMPORARY_STORAGE&quot;
PRIME | &quot;PRIME&quot;



