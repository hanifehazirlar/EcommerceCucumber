@GridTest
Feature: Grid Test
  Scenario: TC_001 Email cannot be left blank and must be a valid email
    Given Grid User goes to Hubcomfy
    Then  Grid User verifies that he or she went to the home page
    And   Grid User click the register button
    And   Grid User clicks on the Become a vendor link
    When  Grid User go to minutesEmail to receive a valid email
    And   Grid User receive the email from the page they go to
    And   Grid The user returns to the hub-comfy page and enters the email in the email box
    And   Grid User clicks the RE-SEND CODE button
    And   Grid The user goes back to minutesEmail to get the code sent to the email address
    And   Grid User receives the code and returns to Hubcomfy
    And   Grid The user enters the code that comes to the e-mail address entered in the Verification Code box
    And   Grid User enter a valid password
    And   Grid User enters valid confirm password
    And   Grid User clicks the register button
    Then  Grid The user verifies seeing the text Welcome to Hubcomfy!
    And   Grid User quits page


  Scenario: TC_001 Email cannot be left blank and must be a valid email
    Given GridEdge User goes to Hubcomfy
    Then  Grid User verifies that he or she went to the home page
    And   Grid User click the register button
    And   Grid User clicks on the Become a vendor link
    When  Grid User go to minutesEmail to receive a valid email
    And   Grid User receive the email from the page they go to
    And   Grid The user returns to the hub-comfy page and enters the email in the email box
    And   Grid User clicks the RE-SEND CODE button
    And   Grid The user goes back to minutesEmail to get the code sent to the email address
    And   Grid User receives the code and returns to Hubcomfy
    And   Grid The user enters the code that comes to the e-mail address entered in the Verification Code box
    And   Grid User enter a valid password
    And   Grid User enters valid confirm password
    And   Grid User clicks the register button
    Then  Grid The user verifies seeing the text Welcome to Hubcomfy!
    And   Grid User quits page

