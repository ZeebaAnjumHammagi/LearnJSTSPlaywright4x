// Task 1
let a = 100;
console.log(a++ + ++a +a++ + ++a); // 100 + 102 + 102 + 104 = 408
console.log(a);

// Task 2
let b = 37;
console.log(--b + b--);
console.log(b);

// Task 3
let c = 5; 
let d = c-- - --c; 
console.log(d, c);

// Task 4
let i = 1; 
let r = i++ > 1 ? i++ : ++i; 
console.log(r, i);
