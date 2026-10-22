let [first, second, third] = [10, 20, 30];

console.log(first); // 10
console.log(second); // 20
console.log(third); // 30

// Array destructuring allows you to unpack values from 
// arrays into distinct variables. In this example, the
//  values 10, 20, and 30 are assigned to the variables 
// first, second, and third respectively.

let [a, b, ...rest] = [10, 20, 30, 40, 50];
console.log(a);    // 10
console.log(b);    // 20
console.log(rest); // [30, 40, 50]


let [, , thirdOnly] = [10, 20, 30];
console.log(thirdOnly); // 30