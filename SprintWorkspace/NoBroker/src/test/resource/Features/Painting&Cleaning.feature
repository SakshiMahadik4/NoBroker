Feature: Verification of Painting & Cleaning module

@search
  Scenario: To validate search funcionality
    Given user is on home services page
    When user click the search button
    And user enter data in the search bar
    Then user should see relevant services for my data

@SelectCity    
  Scenario: Validate city dropdown visibility and selection
    Given user is on home Services page
    When user click on the city dropdown
    And  user select the city 
    Then user should see services available in that city
  
