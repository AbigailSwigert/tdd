<h1>The Problem Solving Framework : 'UPER'</h1>

* U = "Understand"
* P = "Plan"
* E = "Execute"
* R = "Reflect" / "Refactor"

<h2>1. Understanding the Problem</h2>

* Create a console app that calculates and prints sales tax and total price of items
* The console app needs to follow OOP, OOD, and TDD
* All prices need to round to the nearest .05
* Need to check which tax rate to use on each item

<h2>
    2. Planning the Solution
</h2>

* Write a test that fails
* Write code that passes the test
* Write a new test
* Repeat
* Create a class for items that includes quantity, name, type, and price
* Check type to determine tax rate
* Create method that calculates price * tax rate to give total price
* Create method that calculates total taxes for a set of items, and total price for the set of items and prints it

<h2>
    3. Executing the Plan
</h2>

* Created Item class, Receipt class, ReceiptGenerator class, and ReceiptGeneratorTest class
* Began making tests for empty carts
* Began making tests for carts with single items
* Made test for carts with multiple items
* added functionality to print all item prices after tax, total tax, and total due

<h2>
    4. Reflection / Refactor
</h2>

* I won't really know how I did until I get feedback as I have no idea what constitutes good TDD