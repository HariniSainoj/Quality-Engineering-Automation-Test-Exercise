Feature: Amazon Test Scenario

Scenario: List all the Samsung phones with specifications: Camera Resolution - 20MP and above, Model Year - 2023, Price Range - £50-£100

Given I launch the Amazon application
When I Navigate to Mobile Phones and Smartphones
And I apply filters         
Then I see the list of filter specifications
