let results = ["pass", "fail", "pass", "error", "fail"];

results.indexOf("fail"); //1 because "fail" is at index 1
results.indexOf("skip");  // -1

// lastIndexOf — searches from the end
results.lastIndexOf("fail"); // 4 because "fail" is at index 4 (last occurrence)

// includes — returns boolean
results.includes("error"); // true because "error" is in the array
