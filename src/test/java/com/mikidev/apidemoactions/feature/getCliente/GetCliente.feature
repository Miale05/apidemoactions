@test-cliente
Feature: Get Cliente Request

    Background:
        Given url karate.get('baseApiUrl')
        * path 'cliente'
        * def response_cliente = read('classpath:com/mikidev/apidemoactions/resources/response/response_cliente.json')

    Scenario: Validar status 200
        When method GET
        Then status 200

    Scenario: Validar status 404
        * path '1'
        When method GET
        Then status 404

    Scenario: Validar que el cliente no este vacio
        When method GET
        Then match response != null

    Scenario: Validar tipos de datos de cliente
        When method GET
        Then match response == response_cliente
        * print response_cliente

    Scenario Outline: Validar <atributo> especifico de cliente 
        When method GET
        Then match response.<atributo> == <valor>

        Examples:
            | atributo          | valor             |
            | nombre            | "Miguel Duenas"   |
            | correoElectronico | "miguel@mail.com" |
            | telefono          | 987654321         |