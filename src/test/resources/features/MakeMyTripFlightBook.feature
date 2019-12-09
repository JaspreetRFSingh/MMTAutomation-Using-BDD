@MMTFlightSearch
Feature: MMT Flight Booking
	Scenario Outline: MMT flight search positive scenarios
	Given Open MMT "<way>" page and click flights tag
	When Enter source city as "<from>"
	And Enter destination city as "<destination>"
	And Enter values in input fields on "<date>" and hit search
	And select the flight
	Then Continue the booking and check whether the flight booking progress bar is at right page.
	
	Examples:
	| way   | from  | destination | date 			 |
	| home  | Delhi | Mumbai 	  | 16 February 2020 |