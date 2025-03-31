# **WGU D287: Java Frameworks**

### **C. Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.**

_Note: Do not remove any elements that were included in the screen. You may add any additional elements you would like or any images, colors, and styles, although it is not required._

* In the mainscreen.html I updated the shop name title to be "The Lawnmower Shop" (line 14) and products to "types of lawnmowers and lawn care products" (line 54) and parts to "Lawnmower parts and accessories" (line 21).




### **D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.**

* Created an about.html page for "The lawnmower Shop" that included visuals and styling of the page along with a mission statement and paragraph about the companies' mission. 
* Created an about.java controller page that includes the @controller and @Getmapping for the about.html page. I ensured that the link for the home page worked to navigate from the about.html page to the mainscreen.html page. 
* Added navigation for home to about page on lines 18-21 of mainscreen.html. I ensured all navigation links work. 

### **E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.**

_Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part._

All below work was done in BootStrapData.java: 
* Created and if statement to make sure inventory is added only when the part (line 43) and product (line 117) are empty.
* Added 5 parts and saved them to the repository in lines 44 to line 114
* Line 88 and 89 created a list to search through parts
* Added a loop in lines 91 through 110 that checks for parts names that equals the name that was assigned.
* Created products and added them to the repository in lines 118 to 127. 


### **F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:**

•  The “Buy Now” button must be next to the buttons that update and delete products.
• The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
•  Display a message that indicates the success or failure of a purchase._

* Added the buy now button to the mainscreen.html in lines 92-95.
* Created the BuyNowController.java file.
* Created the PurchaseSuccess.html and PurchaseError.html pages. 
* I ensured that the buy now button works and subtracts from inventory and populates the purchase success or purchase error page. 



### **G.  Modify the parts to track maximum and minimum inventory by doing the following:**

•  Add additional fields to the part entity for maximum and minimum inventory.
•  Modify the sample inventory to include the maximum and minimum fields.
•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
•  Rename the file the persistent storage is saved to.
•  Modify the code to enforce that the inventory is between or at the minimum and maximum value._

All work below was done in Part.java:
* On lines 32-38 I created the error messages that inventory cannot be below 0. I initialized minInt and maxInt and mapped it to database.
* On lines 50-51 and 59-60 created the constructors for minInt and maxInt.
* On lines 95-109 created the getters and setters for min and max inventory. 
* On lines 137-139 created boolean method to check validly of min and max inventory. 
* On lines 41 and 47 initialized the int minInv and int maxInv.

All work below was done in BootStrapData.java:
* On lines 50-51, 61-62, 72-73, 83-84, and 94-95 set min and maximum inventory for each part. 

All work below was done in InhousePartForm.html:
* On lines 24-28 I added the text inputs for minimum and maximum inventory.

All work below was done in OutsourcedPartForm.html:
* On lines 27-31 I added the text inputs for minimum and maximum inventory.

All work below was done in AddInHousePartController.java:
* On lines 47-50 added the minimum and maximum fields to the controller with error message using the isInvValid method.

All work below was done in AddOutsourcedPartController.java:
* On lines 48-51 added the minimum and maximum fields to the controller with error message using the isInvValid method.

* Updated the database name in file explorer to The_Lawnmower_Shop and mapped it within the applications.properties file on line 6.
* Added last name to line 6 of applications.properties as instructed by a course instructor. 


### **H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:** 

_•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
•  Display error messages when adding and updating parts if the inventory is greater than the maximum._

All work below was done in Part.java:
* On lines 141-159 added a condition to validate that inventory is above the minimum and below the maximum allowed. If these values go below the minimum or below maximum an error message will populate. 


All work below was done in AddInHousePartController.java:
* On lines 52-57 added the validation method to the controller. 

All work below was done in AddOutsourcedPartController.java:
* On lines 53-59 added the validation method to the controller. 

All work below was done in EnufPArtsValidator.java:
* On lines 37-76, I added validation checks to ensure that part inventory does not fall below the minimum or exceed the maximum. If the inventory is outside the allowed range, an error message will populate. I also added a validator to ensure that updating products wouldn't cause parts to be outside the allowed range. If this happens, an error message will populate. I also added an error message for iff part returns a null value. 


All work below was done in OutsourcedPartForm.html:
* I've added the error message that displays when a part's inventory goes above the maximum allowed or below the minimum allowed on line 33.

All work below was done in InhousePartForm.html:
* I've added the error message that displays when a part's inventory goes above the maximum allowed or below the minimum allowed on line 30.


### **I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.**

All work below was done in PartsTest.java:
* On lines 160-167 created a test to ensure that the minimum inventory was set and retrieved correctly. 
* On lines 169-176 created a test to ensure that the maximum inventory was set and retrieved correctly.




### **J.  Remove the class files for any unused validators in order to clean your code.**

* The DeletePartValidator was the only validator that was unused so I deleted it from the project. 


### **K.  Demonstrate professional communication in the content and presentation of your submission.**