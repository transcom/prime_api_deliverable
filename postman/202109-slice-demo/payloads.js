const addDays = require('../utils/addDays');

const payloads = {
  "create-payment-request": "{{paymentRequestPayload}}",
  "payment-request": {
    isFinal: false,
    moveTaskOrderID: "",
    serviceItems: []
  },
  "add-reweigh-weight": {
    // "weight": 4000, // optional commenting out since not part of slice demo
    "verificationReason": "The reweigh was not performed because the shipment was already delivered"
  },
  "create-sit-mto-service-items": {
    "moveTaskOrderID": "{{moveTaskOrderID}}",
    "mtoShipmentID": "{{mtoShipmentID}}",
    "modelType": "MTOServiceItemDestSIT",
    "reServiceCode": "DDFSIT",
    "firstAvailableDeliveryDate1": "{{sitDate}}",
    "timeMilitary1": "0942Z",
    "firstAvailableDeliveryDate2": "{{sitDate}}",
    "timeMilitary2": "0942Z",
    "sitEntryDate": "{{sitDate}}",
  },
  "mto-shipments-sit-extensions": {
    requestReason: "NONAVAILABILITY_OF_CIVILIAN_HOUSING",
    contractorRemarks: "Customer is in the middle of closing on a house, expects it to be in 10 days.",
    requestedDays: 30,
  },
  "update-mto-shipment-actual-weight": {
    actualPickupDate: addDays(0),
    primeActualWeight: "{{primeActualWeight}}",
  },
  "update-mto-shipment-destination-address": {
    destinationAddress: {
      streetAddress1: "7 Q Street",
      city: "Corpus Christi",
      state: "TX",
      postalCode: "78412",
      country: "US",
    },
  },
  "update-mto-shipment-estimated-weight": {
    primeEstimatedWeight: "{{primeEstimatedWeight}}",
  },
  "update-mto-shipment-scheduled-date": {
    scheduledPickupDate: addDays(7),
  },
};

module.exports = payloads;
