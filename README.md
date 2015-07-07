# CS4354Assignment1
CS4354 Assignment 1
Assignment #1: Implement a Java program
Manage a Video Store Inventory
CS 4354 Summer II 2015
Instructor: Jill Seaman
Due: before class Friday, 7/10/2015 (upload electronic copy by 9:30am)
Problem:
Write a Java program that will allow a user to manage the inventory of a store that sells
DVDs.
The inventory for the video store will contain the following information for each movie
(each title) in the inventory:
SKU (stock-keeping unit, an integer, must be unique)
quantity (number of copies in inventory, greater than or equal to 0)
price (dollars and cents, greater than 0)
title (may contain spaces in it)
The program should offer the user a menu with the following options:
1. Add a movie to the inventory (prompt user for input values in this order: sku,
quantity, price, title).
2. Remove a movie from the inventory (by sku).
3. Display the information for a movie (given the sku).
4. Display the inventory in a table (in any order).
5. Quit
The program should perform the operation selected by number and then re-display the
menu. If the operation fails (i.e. attempt to remove a movie not in the inventory) your
program should display an error message.
Do not change the menu numbers associated with the operations.
Your program should store the inventory in a file between executions of the program, so
that when the program is run again it will start up with the same inventory contents as
when it last terminated (use serialization!). Your program must run even if the file is
not present (initial inventory is empty).
Optional !! for number 4, output headers and make the data line up in columns under
the headers.
NOTES:
• You may use an IDE (Eclipse, netbeans, etc) or just an editor and command line
operations (javac, java) in unix or windows/dos to develop your program.
• This assignment is to be done with your partner (in groups of 2).
• Use good design (don’t put everything in one class, attributes should be private,
try NOT to use getters and setters). I recommend using three classes.
• Use a package for your classes and put your files in the appropriate directory
structure.
• Prices should be output in standard money format: ($7.95).
• Be sure to validate the input.
• Do NOT create more than one Scanner object (do all the input in one class).
• Follow the style guidelines from the class website. Use javadoc comments for
all of your classes and methods.
Logistics:
Please submit your files in a single zip file (assign1_xxxxxx_yyyyyy.zip). The xxxxxx
and yyyyyy are your TX State NetIDs (mine is js236, you have two, one for each
partner).
Submit: an electronic copy only, using the Assignments tool on the TRACS website for
this class. Submit using the TRACS account of just ONE member of your partnership.
