Feature: Test
  Add User and delete User
  			
Background:
   Given browser is initialized
   And user navigates to the website "https://www.way2automation.com/angularjs-protractor/webtables/"

  Scenario: Create a New User 
  	And click on Add Button
  	And user enter the "FirstName" "kumar"
  	And user enter the "LastName" "anand"
  	And user enter the "UserName" "kumaranand"
  	And user enter the "Password" "kumaranand@123"
  	And user Select the Customer "Company BBB"
  	And user Select the Role "Admin"
  	And user enter the "Email" "AdmIn@gmail.com"
    And user enter the "Mobilephone" "9876543210"
    And user clicks "Save"
    Then check user "kumar" is created 
    #Then close driver
  	
  	
  Scenario: delete a  User 
  	And click the user "Novak"
  	Then check user "Novak" is deleted 
  	#Then close driver
  	