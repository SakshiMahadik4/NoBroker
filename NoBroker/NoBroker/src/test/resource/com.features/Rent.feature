@NoBroker
Feature: Testing RENT functionality on NoBroker

  Background: 
    Given User is on the homepage

  #1
  @rent @location-filters @positive
  Scenario: Search rental properties with location and availability filters
    When User navigates to the Rent page
    And enters a location from excel file
      | Data.xlsx |
    And apply all filters given below
    Then Relevant rental listings should be displayed

  #2
  @rent @validation @negative
  Scenario: Show warning when no locality is entered
    When User navigates to the Rent page
    And leaves the locality field empty
    And clicks on the search button
    Then System should display error message

  #3
  @rent @no-results @negative
  Scenario: Show message when filters yield no property results
    When User navigates to the Rental Properties page
    		| Data.xlsx |
    And applies filters BHK and price
    Then Message should be displayed

  #4
  @rent @loan @positive
  Scenario Outline: Apply loan with valid fields on property listing page
    When User navigates to a property listing page 
   		| Data.xlsx |
    And clicks on Apply Loan
    And fills the loan form with valid data from <sheetNo> and row <rowNo>
    And submits the form
    Then A pop-up confirming eligibility should be displayed

    Examples: 
      | sheetNo | rowNo |
      |       1 |     1 |
	
	#5
	@rent @description @positive
	Scenario: View property description in listing details
	When User navigates to a property Listing page
		| Data.xlsx	|
	And scrolls down in a property card
	Then Property description should be visible with detailed information
	
	
  #6
  @rent @loan-apply @negative
  Scenario: Show error for incomplete Loan Form submission
    When User navigates to property listing page
			| Data.xlsx |
    And submits the loan form with incomplete or invalid inputs
    Then An error message should be displayed
	
