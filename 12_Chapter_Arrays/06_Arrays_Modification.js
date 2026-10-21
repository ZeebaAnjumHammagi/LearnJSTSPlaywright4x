// Accessing & Modifying

let statuses = ["pass", "fail", "skip"];

console.log(statuses[0]); // Output: pass
console.log(statuses[2]); // Output: skip

console.log(statuses.at(-1)); // Output: skip (negative index)     
console.log(statuses.at(-2)); // Output: fail (negative index)
console.log(statuses.at(-4)); // Output: undefined (negative index out of bounds

// Modify
statuses[1] = "blocked";
console.log(statuses); // Output: ["pass", "blocked", "skip"]

console.log(statuses.length); // Output: 3 because we have 3 elements in the array