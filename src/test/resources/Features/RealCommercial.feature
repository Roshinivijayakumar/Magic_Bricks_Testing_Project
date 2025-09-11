Feature: Commercial Property Search

  Scenario: Search for office space on lease in Chennai
    Given the user is on the MagicBricks homepage
    When the user navigates to the Commercial tab
    And the user selects "Lease" option
    And the user enters location as "<location>" in the Search bar 
    And the user selects the Property Type from drop down
    And the user selects budget range from drop down
    And the user clicks on Search
        