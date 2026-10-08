# JavaScript Keywords and Identifiers

## What is a keyword?

A **keyword** is a word JavaScript reserves for its syntax and built-in language features. You cannot use a keyword as the name of a variable, function, class, or other binding.

Examples include `const`, `if`, `return`, `function`, and `class`.

```js
const userName = "Sam";

if (userName) {
  console.log(userName);
}
```

This is invalid because `if` is a keyword:

```js
// Invalid: `if` is a keyword
const if = "hello";
```

## What is an identifier?

An **identifier** is a name you create for a variable, function, class, parameter, or similar item.

```js
const userName = "Sam"; // userName is an identifier

function greet(person) { // greet and person are identifiers
  return `Hello, ${person}`;
}
```

## Identifier rules

- An identifier can contain letters, digits, underscores (`_`), and dollar signs (`$`).
- It cannot start with a digit.
- It cannot contain spaces or hyphens.
- It cannot be a reserved keyword when used as a binding name.
- JavaScript identifiers are case-sensitive: `score`, `Score`, and `SCORE` are different names.
- JavaScript also supports many Unicode characters in identifiers. For readability, most code uses English letters, `_`, and `$`.
- Starting names with `_` or `$` is allowed, though those characters can have project-specific conventions.

### Valid identifiers

```js
let firstName = "Ava";
let _count = 3;
let $price = 25;
let item2 = "book";
let café = "coffee";
```

### Invalid identifiers

```js
// Invalid: starts with a digit
let 2items = "two";

// Invalid: contains a hyphen (JavaScript reads this as subtraction)
let first-name = "Ava";

// Invalid: contains a space
let first name = "Ava";

// Invalid: reserved keyword used as a variable name
let return = 10;

A hyphen (-) cannot be used in a JavaScript identifier; JavaScript treats it as the subtraction operator.

let firstName = "Ava"; // Valid
let first-name = "Ava"; // Invalid

Use an underscore instead: first_name.
```

## Keywords and reserved words

Some words are reserved by JavaScript even when they are not commonly used as everyday syntax. For example, `class`, `const`, `return`, and `while` are keywords. Words such as `enum` are reserved, while `await` and `yield` have context-dependent restrictions.

Avoid using language keywords or reserved words as variable and function names. The exact restrictions can depend on whether code is in strict mode, a module, or a particular language context.

Words such as `async` can also have special meaning in certain contexts:

```js
async function loadData() {
  return "done";
}
```

## Keywords can sometimes appear as property names

A keyword cannot be used as a binding name, but it can often be used as an object property name or after the dot in a property access:

```js
const settings = { default: true };
console.log(settings.default);
```

Here, `default` is a property name, not a variable declaration.

## Keywords vs. identifiers

| Keywords | Identifiers |
|---|---|
| Reserved by JavaScript for language syntax or features | Names chosen by the programmer |
| Have a predefined meaning in the language | Refer to the program items they name |
| Examples: `if`, `const`, `return`, `class` | Examples: `userName`, `total`, `greet` |
| Cannot be used as ordinary binding names | Must follow identifier naming rules |

## Naming conventions

Naming conventions are recommendations, not identifier rules:

- Use `camelCase` for variables and functions: `firstName`, `getTotal`.
- Use `PascalCase` for classes: `ShoppingCart`.
- Use descriptive names: `itemCount` is clearer than `x`.
- Avoid names that differ only by capitalization.

