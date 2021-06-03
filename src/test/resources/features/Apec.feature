Feature: Apec Bugs

Background: go to apec home page
  Given User is on Apec home page

  Scenario: Bug 621 Contactez-nous link redirectionerror
    And User clicked on site corporate link
    When user clicked on contactez-nous link
    Then User should be on contact page

    Scenario Outline:Bug 604 button overlapping
      When User set windows size with <width> and <height>
      Then Elements are overlapping
      Examples:
        | width | height |
      |   768    |  1024      |
      |    1620     |      2160     |

Scenario Outline: Bug 620 Appointment center not stored in memory
  And login to Apec with <email> and <password>
  And User clicked on mon centre
  And User entered <postalcode>
  When User click on Centre apec grenoble in results
  And User clicked on Prenez rendez-vous
 Then Appointment center should be stored in memory
#  And User logout from Apec
  Examples:
    | email                |      password |postalcode|
    |yoanntagne45@gmail.com|1995P@oyonyoann|     38000     |