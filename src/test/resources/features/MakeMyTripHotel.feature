@MMTHotelSearch
Feature: MMT Hotel Page Testing
	Scenario Outline: User searches for hotel and get results	
	Given Hotels link is opened from Homepage
	When Enter data in input fields in area "<area>".
	And Click on search button
	And Apply filters and sort by price
	And Clear filters
	Then page should return a list of hotels with all filters cleared

	Examples:
	|area|
	|Amer|