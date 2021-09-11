var addDays = require('../../utils/addDays');

const payload = {
  scheduledPickupDate: addDays(27),
  // This will not be used if the Shipment already has a destination address.
  destinationAddress: {
    streetAddress1: "7 Q Street",
    city: "Corpus Christi",
    state: "TX",
    postalCode: "78412",
    country: "US",
  },
};

module.exports = payload;
