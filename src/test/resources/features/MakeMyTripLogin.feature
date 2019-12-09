@MMTLogin
Feature: MMT login validations	
	Scenario Outline: MMT login positive scenarios
	Given Open mmt home page
	When Enter username as "<username>"
	And Enter password as "<password>"
	Then Login should be successful
	
	Examples:
	| username 						| password |
	| jaspreetsinghproacc@gmail.com | Qwerty@123 |
