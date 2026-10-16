let num = prompt("Enter a number:");
num = Number(num);  // convert string to number

if (num % 2 === 0) {
    console.log(num + " is Even");
} else {
    console.log(num + " is Odd");
}
//This code will not work in Node.js because prompt is not available in Node.js. 
// It is a browser-specific function.