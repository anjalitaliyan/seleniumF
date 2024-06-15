

Feature: Error Validation
 


 @ErrorValidation
  Scenario Outline: Verifying error validation with given Username and Password
    Given Using these steps for landing page
    When Logged in with <username> and <password>
    Then "Incorrect email or password." message is displayed.

    Examples: 
      |username 										| password  					|
      | anjalitaliyan999@gmail.com 	|  Anjali@900	        |
