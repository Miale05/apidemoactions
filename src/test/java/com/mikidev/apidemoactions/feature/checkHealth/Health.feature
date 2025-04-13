@health
Feature: Check API health

    Scenario: Validar API Health
        Given url karate.get('baseApiUrl')
        * path 'health'
        When method GET
        Then status 200
        And match response == "OK"