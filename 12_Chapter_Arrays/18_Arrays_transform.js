// Map and Filters
// every vs some

// every — ALL must pass
console.log([80, 90, 85].every(i => i >= 70)); // true because all elements are greater than or equal to 70
console.log([80, 60, 85].every(i => i >= 70)); // false because 60 is less than 70


// some — AT LEAST ONE must pass
console.log([80, 60, 85].some(s => s < 70)); // true because 60 is less than 70
console.log([80, 90, 85].some(s => s < 70)); // false because all elements are greater than or equal to 70