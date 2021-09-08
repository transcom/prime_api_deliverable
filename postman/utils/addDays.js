/**
  * addDays is a function that accepts an integer and returns a date string in
  * the format of YYYY-MM-DD. This function is unsafe as it does no type
  * checking before adding the days argument to the current date.
  */
function addDays(days) {
  let year,
      day,
      month,
      dateObject = new Date(Date.now());
  dateObject.setDate(dateObject.getDate() + days);

  year = dateObject.getFullYear();
  // README: We pad the month or day with a zero and then get the last two
  // digits. See this link for more information:
  // https://stackoverflow.com/a/3605248
  month = `0${dateObject.getMonth() + 1}`.slice(-2);
  day = `0${dateObject.getDate()}`.slice(-2);

  return `${year}-${month}-${day}`;
}

module.exports = addDays;
