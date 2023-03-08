@Register
Feature: Register olma

  Background: Joint Steps
    When User goes to Hubcomfy
    And User verifies that he or she went to the home page
    And User click the register button
    And User clicks on the Become a vendor link

  Scenario: TC_01 To register as a vendor, please navigate with the 'Become a vendor' button
    Then User verifies that Vendor Registration is visible
    And User quits page

  Scenario: TC_02 The registration page must have three features; email, password, and confirm password
    Then User verifies that there is an email box on the Vendor Registration page
    Then User verifies that there is a password box on the Vendor Registration page
    Then User verifies that there is a confirm password box on the Vendor Registration page
    And User quits page

  Scenario: TC_003 Email cannot be left blank and must be a valid email(negative test)
    And   User click the REGISTER button
    Then  User verifies that they have received the warning Email This field is required.
    And User quits page

  @TC4
  Scenario: TC_004 Email cannot be left blank and must be a valid email
    When User go to "minuteEmail" to receive a valid email
    And User receive the email from the page they go to
    And The user returns to the hub-comfy page and enters the email in the email box
    And User clicks the RE-SEND CODE button
    And The user goes back to "minuteEmail" to get the code sent to the email address
    And User receives the code and returns to hubcomfy
    And The user enters the code that comes to the e-mail address entered in the Verification Code box
    And User enter a valid password
    And User enters valid confirm password
    And User clicks the register button
    Then The user verifies seeing the text Welcome to Hubcomfy!
    And User quits page

  @TC5
  Scenario Outline: TC_005,006, 007, 008, 009 Email cannot be left blank and must be a valid email(negative test)
    And User enters an "<invalid email>"
    Then User verifies that Please provide a valid email address. appears
    And User quits page
    Examples:
      | invalid email |
      | 16project     |
      #| 16projectqa@lkh |
     # | 16projectqa.com |
     #| 16projectqa@.com|
     #|  @qa.com|

  @TC10
  Scenario: TC_010 Email must be unique
    When User go to "minuteEmail" to receive a valid email
    And User receive the email from the page they go to
    And The user returns to the hub-comfy page and enters the email in the email box
    And User clicks the RE-SEND CODE button
    And The user goes back to "minuteEmail" to get the code sent to the email address
    And User receives the code and returns to hubcomfy
    And The user enters the code that comes to the e-mail address entered in the Verification Code box
    And User enter a valid password
    And User enters valid confirm password
    And User clicks the register button
    Then The user verifies seeing the text Welcome to Hubcomfy!
    And User quits page

  @TC11
  Scenario: TC_011 Email must be unique(negative test)
    When User enters a non-unique email in the email box
    And User enters a postal code in the Verification Code box
    And User enter a valid password
    And User enters valid confirm password
    And User clicks the register button
    And User confirms that This Email already exists. Please login to the site and apply as a vendor.
    And User quits page

  @TC12
  Scenario Outline: TC_12 Create a strong password: use lowercase, uppercase, numbers and special characters
    When User go to "minuteEmail" to receive a valid email
    And User receive the email from the page they go to
    And The user returns to the hub-comfy page and enters the email in the email box
    And User clicks the RE-SEND CODE button
    And The user goes back to "minuteEmail" to get the code sent to the email address
    And User receives the code and returns to hubcomfy
    And The user enters the code that comes to the e-mail address entered in the Verification Code box
    And The user enters a "<password>" of at least six characters including lowercase, uppercase, numbers and special characters
    Then The user verifies seeing the text Strong
    And User quits page
    Examples:
      | password |
      | Aa!123   |
      #| 123Aa*   |
      #| %09Ehk   |

  @TC13
  Scenario Outline: TC_13 Create a strong password: use lowercase, uppercase, numbers and special characters(negative test)
    When User go to "minuteEmail" to receive a valid email
    And User receive the email from the page they go to
    And The user returns to the hub-comfy page and enters the email in the email box
    And User clicks the RE-SEND CODE button
    And The user goes back to "minuteEmail" to get the code sent to the email address
    And User receives the code and returns to hubcomfy
    And The user enters the code that comes to the e-mail address entered in the Verification Code box
    And User enters "<invalid password>" use cases(PageThree)
    Then User verifies that he or she cannot see the strong text
    And User quits page
    Examples:
      | invalid password |
      #|  aB1yyy*|
      | aB1yy            |
      #|  aByyy**|
     #|  aAasAA |
     #|  a33*** |
     #|  a111aaa |
     #|  aaaa***|
     #|  aaaaaaa |
     #|  AA55** |
     #|  AAA333 |
     #|  AAA*** |
     #|  AAAAAA |
     #|  3333**** |
     #|  333333 |
     #|         |
  @TC14
  Scenario: TC_014 Password must be reused in the same way
    When User go to "minuteEmail" to receive a valid email
    And User receive the email from the page they go to
    And The user returns to the hub-comfy page and enters the email in the email box
    And User clicks the RE-SEND CODE button
    And The user goes back to "minuteEmail" to get the code sent to the email address
    And User receives the code and returns to hubcomfy
    And The user enters the code that comes to the e-mail address entered in the Verification Code box
    And User enter a valid password
    And The user enters the same valid password in the confirm password as they enter in the password
    And User clicks the register button
    Then The user verifies seeing the text Welcome to Hubcomfy!
    And User quits page

  @TC15
  Scenario: TC_015 Password must be reused in the same way(negative test)
    When User go to "minuteEmail" to receive a valid email
    And User receive the email from the page they go to
    And The user returns to the hub-comfy page and enters the email in the email box
    And User clicks the RE-SEND CODE button
    And The user goes back to "minuteEmail" to get the code sent to the email address
    And User receives the code and returns to hubcomfy
    And The user enters the code that comes to the e-mail address entered in the Verification Code box
    And User enter a valid password
    And To confirm the password, the user enters a different password than the current password entered in the password
    And User clicks the register button
    Then The user confirms that they are unable to log in by seeing the text "Password and Confirm-password are not same."
    And User quits page
  @TC16
  Scenario: TC_016 Account must be confirmed via email
    When User go to "minuteEmail" to receive a valid email
    And User receive the email from the page they go to
    And The user returns to the hub-comfy page and enters the email in the email box
    And User clicks the RE-SEND CODE button
    And The user goes back to "minuteEmail" to get the code sent to the email address
    And User receives the code and returns to hubcomfy
    And The user enters the code that comes to the e-mail address entered in the Verification Code box
    And User enter a valid password
    And The user enters the same valid password in the confirm password as they enter in the password
    And User clicks the register button
    Then The user verifies seeing the text Welcome to Hubcomfy!
    And The user goes to minuteEmail to verify incoming email
    And The user clicks on the Hubcomfy email
    Then The user confirms that their My Account is visible by clicking on the Visit now... link in the email
    And User quits page





