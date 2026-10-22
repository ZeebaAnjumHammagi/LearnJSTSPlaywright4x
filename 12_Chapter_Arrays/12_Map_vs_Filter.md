Map() vs Filter() Methods in JavaScript

In JavaScript, the map() and filter() methods are powerful array functions that allow you to transform and filter arrays easily. We will discuss the required concepts about each method in this article.

What is map() in JavaScript?
The map() method creates a new array by applying a given function to each element of the original array. It transforms each element according to the logic defined in the callback function without altering the original array.

Syntax:
array.map(function_to_be_applied)
array.map(function (args) {
    // code;
})
Example 1: In this example, we will transform each element by multiplying with 3.

const numbers = [5, 10, 15, 20, 25, 30];
​
const multipliedNumbers = 
    numbers.map(num => num * 3);
console.log(multipliedNumbers)

Output
[ 15, 30, 45, 60, 75, 90 ]
Example 2: In this example, we will transform all values making them uppercase alphabets.





const fruits = [
    { name: 'apple', color: 'red' },
    { name: 'banana', color: 'yellow' },
    { name: 'kiwi', color: 'green' },
    { name: 'orange', color: 'orange' },
    { name: 'pineapple', color: 'yellow' }
];
​
const transformedFruits = fruits.map(fruit => ({
    fruitName: fruit.name.toUpperCase(),
    fruitColor: fruit.color.toUpperCase()
}));
​
console.log(transformedFruits);
Output:

[
  { fruitName: 'APPLE', fruitColor: 'RED' },
  { fruitName: 'BANANA', fruitColor: 'YELLOW' },
  { fruitName: 'KIWI', fruitColor: 'GREEN' },
  { fruitName: 'ORANGE', fruitColor: 'ORANGE' },
  { fruitName: 'PINEAPPLE', fruitColor: 'YELLOW' }
]
What is filter() in JavaScript?
The filter() method creates a new array containing only elements that satisfy a specified condition. It does not change the original array and is useful for selecting specific elements from an array based on certain criteria.

Syntax:

array.filter(function_to_be_applied)
array.filter(function (args) {
    // condition;
}) 
Example 1: In this example, we will filter the values greater than 20.





const numbers = [5, 10, 15, 20, 25, 30];
​
const numbersGreaterThan20 = 
    numbers.filter(num => num > 20);
​
console.log(numbersGreaterThan20);

Output
[ 25, 30 ]
Example 2: In this example, we will filter the fruites having the color yellow.





// Using filter to get fruits which are yellow in color
const fruits = [
    { name: 'apple', color: 'red' },
    { name: 'banana', color: 'yellow' },
    { name: 'kiwi', color: 'green' },
    { name: 'orange', color: 'orange' },
    { name: 'pineapple', color: 'yellow' }
];
​
const yellowFruits = 
    fruits.filter(fruit => fruit.color === 'yellow');
​
console.log(yellowFruits);

Output
[
  { name: 'banana', color: 'yellow' },
  { name: 'pineapple', color: 'yellow' }
]

Differences of Map() and Filter() methods
map()

filter()

Creates a new array with the same length as the original array, but with each element transformed by the callback function.

Creates a new array with only the elements that pass the conditions implemented by the callback function.

Used when you want to transform each element in an array

Used when you want to select only certain elements that meet a specific condition.

Returns a new array with the same length as the original array.

Returns a new array with a length that is equal to or less than the original array.

The map() and filter() methods are fundamental tools in JavaScript for working with arrays. While both are used to create new arrays, their purposes are distinct:

Use map() when you need to transform or manipulate every element in an array.
Use filter() when you want to select specific elements that meet a particular condition.

