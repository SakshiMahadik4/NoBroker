Feature: Property Search and Interaction on Buy Page


@valid @positive
  Scenario Outline: Verify property search by valid city, locality, BHK type, and property status
    Given the user is on the Buy page
    When the user searches for properties with a valid city 
    And user searches for locality in selected city from excel with "<RowIndex>"
    And the user applies BHK type 
    And the user applies property status filter
    Then matching property listings should be displayed
    
    Examples:
    |RowIndex|
    |1       |

@filters @positive
  Scenario: Verify filters like price, property type, furnishing, and parking work correctly
    Given the user is on the Buy page and viewing listings
    When the user applies filters for a price filter 
    And the user applies Property type filter
    And the user applies Furnishing filter
    And the user applies Parking filter 
    Then the listings should update to reflect the applied filters

@contact @positive
  Scenario: Verify user can contact owner using Get Owner Details button
    Given the user is logged in and viewing a property listing
    When the user clicks the Get Owner Details button
    Then the owners contact information should be displayed

@wishlist @positive
  Scenario: Verify user can wishlist a property
    Given the user is logged in and viewing a property listing page
    When the user clicks the Wishlist button
    And the user opens the wishlist page
    Then the property should be listed in the users wishlist

@invalidData @negative
  Scenario: Validate response for invalid locality search 
    Given the user is on the NoBroker Buy page
    When the user selects a valid city
    And the user enters invalid locality
    And clicks the search button
    Then the system should display an appropriate message Please select a locality within pune

