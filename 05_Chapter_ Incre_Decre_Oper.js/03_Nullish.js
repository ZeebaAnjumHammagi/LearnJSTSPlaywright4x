// Nullish Coalescing Operator (??) Example
// The nullish coalescing operator (??) is a logical operator that returns 
// its right-hand side operand when its left-hand side operand is null or
//  undefined, and otherwise returns its left-hand side operand.
let amul = null;
let val = amul ?? "NANDANI Milk";
console.log(val);

let api_response = null;
let responsedata = api_response ?? "{}";
console.log(responsedata);

// not a nullish value, so it will return the left-hand side operand
let api_response1 = "Pramod";
let responsedata1 = api_response1 ?? "{}";
console.log(responsedata1);