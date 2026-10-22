// Sorting Arrays with arrow functions
let nums = [10,1,21,2];
nums.sort((a,b) => a-b); // it sorts the array in ascending order
console.log(nums); // Output: [1, 2, 10, 21] (numeric sort)
nums.sort((a,b) => b-a); // it sorts the array in descending order
console.log(nums); // Output: [21, 10, 2, 1] (numeric sort)


// Sorting strings with arrow functions
let fruits = ['apple','banana',"cherry"];
fruits.sort((a, b) => a.localeCompare(b)) // it sorts the array in ascending order
console.log(fruits); // Output: ['apple', 'banana', 'cherry']
// a,b => a.localeCompare(b) is used to sort strings in ascending order
fruits.sort((a, b) => b.localeCompare(a)) // it sorts the array in descending order
console.log(fruits); // Output: ['cherry', 'banana', 'apple']
// b,a => b.localeCompare(a) is used to sort strings in descending order        


// arrow Functions