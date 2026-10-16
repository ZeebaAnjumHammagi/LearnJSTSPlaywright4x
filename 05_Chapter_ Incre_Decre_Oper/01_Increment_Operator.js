// Types of increment operators in JavaScript
// 1. Pre Increment
// 2. Post Increment    

// Pre Increment
let a = 10;
let b = ++a;
console.log(b);
console.log(a);

// Post Increment
let c = 10;
let d = c++;
console.log(d);
console.log(c);

//Example 01
let x= 10;
console.log(++x + x);
console.log(x);

//Example 02
let y = 10;
console.log(++y + y + y++);
console.log(y);

//Example 03
let i = 1;
let result = i++ + ++i;
console.log(result,i );

//Example 04