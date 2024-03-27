Feature: Registeration on Ecommerce WebSite
  I want to use this template for my feature file

  @tag1
  Scenario: positive test user register for the first time on the website
    Given user on laningPage
    Given user on register page
    When user entre credintel on respictive filed
    And user click on the submit button
    Then "Your registration completed" message is desplayed on confirmation test
