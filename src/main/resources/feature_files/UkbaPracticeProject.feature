
Feature:  confirm whether a visa is require for coming to the Uk
  @UK
  Scenario: Country and study

    Given That I am on  the Ukba website
    When I type enter nationality as France
    And I click on continue button
    And I select study as reason
    And I click one continue button
    And I select more than 6 months as reason for stay
    And I click on the continue button
    Then I should get a note "You will need a visa to study in France"
