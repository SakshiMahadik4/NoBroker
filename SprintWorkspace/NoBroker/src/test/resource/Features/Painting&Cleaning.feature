Feature: Verification of Painting & Cleaning module

@search
  Scenario: To validate search funcionality
    Given The user is on home services page
    When user click the search button
    And user enter data in the search bar
    Then user should see relevant services for my data

@SelectCity    
  Scenario: Validate city dropdown visibility and selection
    Given user is on home Services page
    When user click on the city dropdown
    And  user select the city 
    Then user should see services available in that city

@PaintingService
 Scenario: Validate that the user can request an estimate for a selected painting service
    Given the user is on the home services page
    When the user clicks on the Painting Services option
    And the user clicks on the painting services list
    And the user requests an estimate for the selected painting service
    And user logged in
    Then the user should be navigated to the confirm loaction page

 @CorporateEnquiry
 Scenario Outline: 
    Given User is on services page
    When the user clicks sales agreement option
    And the user clicks menu and selects corporate enquiry
    And the user clicks know more button
    And the user fills the form with "<RowIndex>"
    And user submit the form
    Then Form should be submittted successfully
    
    Examples:
    | RowIndex|
    |1        |
  
 @Cleaningservice
  Scenario: Validate the cleaning services checkout process
    Given the user is on the home services page
    When the user clicks on the Book option
    And the user adds the cleaning service to the cart
    And the user logged in 
    And the user proceeds to checkout
    Then it should be navigated to schedule to your service page
 

