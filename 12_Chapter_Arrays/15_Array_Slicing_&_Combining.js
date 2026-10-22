// Slice & Combining

let arr = [1, 2, 3, 4, 5];
// slice(start, end) — returns new array, 
// does NOT mutate actual -> ( start, end-1) = index = 0
// Don't give the end, it will automatically 
// take from start to end.

console.log(arr.slice(1, 3)); // 1 is start index position and 3-1 is conidered as end position
console.log(arr);

console.log(arr.slice(2)); // 2 is start index position and end is not given, so it will take from 2 to end of the array
console.log(arr.slice(-2)); // -2 is start index position and end is not given, so it will take from -2 to end of the array
console.log(arr.slice(-3)); // -3 is start index position and end is not given, so it will take from -3 to end of the arra
console.log(arr.slice(0)); // 0 is start index position and end is not given, so it will take from 0 to end of the array
console.log(arr.slice(-5)); // -5 is start index position and end is not given, so it will take from -5 to end of the arra
console.log(arr.slice(-3,-5)); // as

