	Feature: Testing RENT functionality on NoBroker
	
	Background:
	Given User is on the homepage
	
	#1
	#@rent @location-filters @positive
	#Scenario: Search rental properties with location and availability filters
	#When User navigates to the Rent page
	#And enters a location "<Location>"
	#And apply all filters given below 
	#Then Relevant rental listings should be displayed
	
	#Examples:
	 # | Location | 
	 # | "wakad" |
	 # | "ravet" |
	
	#2
	@rent @validation @negative
	Scenario: Show warning when no locality is entered
	When User navigates to the Rent page
	And leaves the locality field empty
	And clicks on the search button
	Then System should display "PLEASE SELECT A LOCALITY WITHIN CITY"
	
	#3
	@rent @no-results @negative
	Scenario Outline: Show message when filters yield no property results
	When User navigates to the Rent page
	And applies filters BHK and price
	Then Message should be displayed
	
	#4
	@rent @loan @positive
	Scenario: Apply loan with valid fields on property listing page
	When User navigates to a property listing page
	And clicks on Apply Loan
	And fills the loan form with valid data
	And submits the form
	Then A pop-up confirming eligibility should be displayed
	
	#5
	@rent @property-description @UI
	Scenario: View property description in listing details
	When User navigates to a property listing page
	And scrolls down in a property card
	Then Property description should be visible with detailed information