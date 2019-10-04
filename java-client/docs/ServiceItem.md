
# ServiceItem

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | [**UUID**](UUID.md) |  |  [optional]
**moveTaskOrderID** | [**UUID**](UUID.md) |  |  [optional]
**status** | [**StatusEnum**](#StatusEnum) |  |  [optional]
**feeType** | [**FeeTypeEnum**](#FeeTypeEnum) |  |  [optional]
**total** | **Integer** |  |  [optional]
**quantity** | **Integer** |  |  [optional]
**rate** | **Integer** |  |  [optional]
**description** | **String** |  |  [optional]
**submittedAt** | [**LocalDate**](LocalDate.md) |  |  [optional]
**approvedAt** | [**LocalDate**](LocalDate.md) |  |  [optional]
**rejectedAt** | [**LocalDate**](LocalDate.md) |  |  [optional]
**createdAt** | [**LocalDate**](LocalDate.md) |  |  [optional]
**updatedAt** | [**LocalDate**](LocalDate.md) |  |  [optional]
**deletedAt** | [**LocalDate**](LocalDate.md) |  |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
APPROVED | &quot;APPROVED&quot;
SUBMITTED | &quot;SUBMITTED&quot;
REJECTED | &quot;REJECTED&quot;


<a name="FeeTypeEnum"></a>
## Enum: FeeTypeEnum
Name | Value
---- | -----
COUNSELING | &quot;COUNSELING&quot;
CRATING | &quot;CRATING&quot;
TRUCKING | &quot;TRUCKING&quot;
SHUTTLE | &quot;SHUTTLE&quot;



