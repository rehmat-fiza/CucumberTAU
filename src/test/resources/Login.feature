
  Feature: Login functionality
  In order to do internet banking
  As a valid para bank customer
  I want login succefully

  Scenario: Login successful
    Given I am in the login page of the para bank application
    When I enter valid <username> and <password> with <userFullName>
    Then I should be taken to the overview page
    
   
    Examples:
    |username|password|userFullNmae|  
    |"Rehmat Fiza"|"Fiza@123"|Rehmat Fiza|
