let scores = [45, 82, 91, 60, 73];

let grades = scores.map(i => i > 70 ? "Pass" : "Fail");
console.log(grades); 
// Output: ['Fail', 'Pass', 'Pass', 'Fail', 'Pass']


// Filter
let passing = scores.filter(s => s >= 70);
console.log(passing);
// Output: [82, 91, 73]