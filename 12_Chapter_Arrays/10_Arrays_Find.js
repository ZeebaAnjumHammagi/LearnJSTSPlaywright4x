let nums = [10,25,30,45];
let result = nums.find(temp => temp > 20);
console.log(result); // 25  (30 and 45 are also greater 
// than 20, but find() returns the first match)


// findIndex
let index = nums.findIndex(n => n > 20); // 1 (25 is the first match, which is at index 1)
console.log(index);

nums.findLast(n => n > 20); //  45
nums.findLastIndex(n => n > 20); // 3