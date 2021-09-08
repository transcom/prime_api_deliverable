var addDays = require('../../utils/addDays');

const payload = {
  actualPickupDate: addDays(17),
  scheduledPickupDate: addDays(27),
  destinationAddress: {
    streetAddress1: "7 Q Street",
    city: "Corpus Christi",
    state: "TX",
    postalCode: "78412",
    country: "US",
  },
};

module.exports = payload;
