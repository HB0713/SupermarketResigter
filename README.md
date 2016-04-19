#Java + Junit + Ant Template Project

The Supermarket Register project is written in Java and configured with Junit and Ant. It is integrated with Continous Integration Travis CI.

##Quick Start

Clone or download this repo
Run ant to get the unit tests going


##Project Structure

####The project includes a application code source folder "src" and a unit test source folder "test"

* "src" includes three packages:
	* product -- define the product the infomation of name, code and price
	* database.product -- use a hashtable to save all the products information. It can add, delete, update, read the product, working like a database.
	* checkout.product -- checkout actions. Two methods in it calculate the tax and final price.

* "test" has the unit tests of Product Table(add, delete, update) and Checkout(tax and final price). 


##Project Install and run

To install and run it locally, you will need jre(>=1.7) and ant installed and configured in PATH. You will also add junit(4) to the classpath to run the unit test.

* How to run it:
	* The ProductTable class(src/databse/product) includes a main method to calculate tax and final price with the given input. You can run it directly to see how it works.
	* Unit Test. The unit test covers product table and checkout classes(methods). "TestProductTable" includes the test suits of all: add, delete, update and checkout.
	  You can run each of the unit test or run "TestProductTable" directly.
	* Ant Build. You can run ant command in the project directory: ant test. Ant triggers and runs all the unit tests.
	
##Continuous Integration

The project is built Travis-CI. Travis-CI uses the ".travis.xml" configuration file to build and execute the unit tests. It sends email to notify the team if test failed.  



