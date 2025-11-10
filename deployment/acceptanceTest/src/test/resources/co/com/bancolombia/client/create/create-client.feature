Feature: Crear un cliente

  Background:
    * def baseUrl = 'http://localhost:8080'

  Scenario: Crear un cliente exitosamente
    Given url baseUrl + '/api/client'
    And request read('create-client-request.json')
    When method post
    Then status 201
    And match response == read('create-client-response-ok.json')
