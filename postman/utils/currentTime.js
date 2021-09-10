/**
  * currentTime is a function that returns the current time as a string
  * comprised of "HH:MM:SS".
  */
function currentTime() {
  let timeString = "",
      seperator = ":",
      timeFunctions = [
        "getHours",
        "getMinutes",
        "getSeconds",
      ];
  const dd = new Date();
  for (let i = 0; i < timeFunctions.length; i++) {
    // README: We pad the time function output with a left zero just in case we
    // get single digit values back. See this link for more information:
    // https://stackoverflow.com/a/3605248
    timeString += `0${dd[timeFunctions[i]]()}`.slice(-2);
    if (i < timeFunctions.length - 1) {
      timeString += seperator;
    }
  }
  return timeString;
}

module.exports = currentTime;
