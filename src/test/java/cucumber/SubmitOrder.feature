

Feature: Purchase the order from ecommerce website
 

Background: 
Given Using these steps for landing page


@Regression
  Scenario: Positive Tests for placing the order
    Given Logged in with <username> and <password>
    When Added the product <productName> to the cart
    And checkout the  <productName> and submit the order
    Then "THANKYOU for the order." message displayed on the confirmation page.
   

  

    Examples: 
      |username 										| password  					|productName  		 |
      | anjalitaliyan999@gmail.com 	|  Anjali@999         | IPHONE 13 PRO    |
      