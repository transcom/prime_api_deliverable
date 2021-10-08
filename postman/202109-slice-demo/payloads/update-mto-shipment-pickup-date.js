const addDays = require('../../utils/addDays');

const payload = {
  actualPickupDate: addDays(-7),
};

module.exports = payload;
