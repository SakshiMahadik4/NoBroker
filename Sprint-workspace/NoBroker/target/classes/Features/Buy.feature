Feature: Property Search and Interaction on Buy Page

@valid
  Scenario: Verify property search by valid city, locality, BHK type, and property status
    Given the user is on the Buy page
    When the user searches for properties with a valid city 
    And user searches for locality in selected city
    And the user applies BHK type 
    And the user applies property status filter
    Then matching property listings should be displayed

@filters
  Scenario: Verify filters like price, property type, furnishing, and parking work correctly
    Given the user is on the Buy page and viewing listings
    When the user applies filters for a price filter 
    And the user applies Property type filter
    And the user applies Furnishing filter
    And the user applies Parking filter 
    Then the listings should update to reflect the applied filters

@contact
  Scenario: Verify user can contact owner using Get Owner Details button
    Given the user is logged in and viewing a property listing
    When the user clicks the "Get Owner Details" button
    Then the owner's contact information should be displayed

@wishlist
  Scenario: Verify user can wishlist a property
    Given the user is logged in and viewing a property listing
    When the user clicks the "Wishlist" button
    And the user opens the wishlist pagd
    Then the property should be listed in the user's wishlist

@schedule 
  Scenario: Verify user can schedule visit for a property
    Given the user is logged in and viewing a property listing
    When the user clicks "Schedule Visit"
    And selects a date from the calendar
    Then the visit should be scheduled and confirmation should be shown

@invalid
  Scenario: Verify unregistered user cannot contact owner or wishlist a property
    Given the user is not logged in and viewing a property listing
    When the user tries to contact owner or wishlist the property
    Then the system should prompt the user to log in or register to perform those actions