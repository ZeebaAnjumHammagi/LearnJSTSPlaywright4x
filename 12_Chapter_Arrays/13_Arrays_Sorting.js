let fruits = ["banana", "apple", "cherry"];
console.log(fruits);
fruits.sort();
console.log(fruits); // Output: ['apple', 'banana', 'cherry']
//  alphabetical by default 

// Sorting numbers
//let score = [4,3,2];
//console.log(score.sort()); // Output: [2, 3, 4] (numeric sort works because all are single digit numbers)

// Natural Sorting, Lexicographic Sort
let nums = [10,1,21,2];
nums.sort();
console.log(nums); // Output: [1, 10, 2, 21] (lexicographic sort)


let n = [11,-11];
console.log(n.sort()); // Output: [-11, 11] (lexicographic sort)