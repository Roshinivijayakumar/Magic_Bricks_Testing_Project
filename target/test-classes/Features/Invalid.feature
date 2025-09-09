@InvalidLogin
Feature: Invalid Login Scenarios
  Scenario Outline: Login with invalid mobile number
    Given I am on the homepage of magicbricks
    When I click on the login button of home page
    And I click the inner login button
    And I am redirected to the login page 
    And I enter an invalid mobile number "<phone>" and captcha "<captcha>"
    Then I should see an error message for invalid mobile number

    Examples:
      | phone   | captcha |
      | 12345   | abcd    |
      | 987     | xyz     |

  Scenario Outline: Login with missing captcha
    Given I am on the homepage of magicbricks
    When I click on the login button of home page
    And I click the inner login button
    And I am redirected to the login page 
    And I enter a mobile number "<phone>" without captcha
    Then I should see an error message for captcha

    Examples:
      | phone      |
      | 9790875322 |

  Scenario Outline: Login with invalid OTP
    Given I am on the homepage of magicbricks
    When I click on the login button of home page
    And I click the inner login button
    And I am redirected to the login page 
    And I enter the otp "<otp>"
    Then I should see an error message for invalid OTP

    Examples:
      | otp   |
      | 9999  |

  Scenario: Login without entering any credentials
    Given I am on the homepage of magicbricks
    When I click on the login button of home page
    And I click the inner login button
    And I am redirected to the login page 
    And I try to proceed without entering details
    Then I should see an error message for mandatory fields

    
    
    
    
    
    
    
    
    
    
    