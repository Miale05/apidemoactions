@test-lista-clientes
Feature: Get Lista Clientes Request

    Background:
        Given url karate.get('baseApiUrl')
        * path 'lista'
        * def response_cliente = read('classpath:com/mikidev/apidemoactions/resources/response/response_cliente.json')

    Scenario: Validar status 200
        When method GET
        Then status 200
        
    Scenario: Validar status 500
        * path '6'
        When method GET
        Then status 500

    Scenario: Validar que se obtenga un cliente por index exitosamente
        * path '0'
        When method GET
        Then status 200
        And match response == 
        """
        {
            nombre: "Miguel Duenas",
            correoElectronico: "miguel@mail.com",
            telefono: 987654321
        }
        """

    Scenario: Validar que la lista de clientes no este vacia
        When method GET
        Then match response != null

    Scenario: Validar que la lista de clientes sea un array
        When method GET
        Then match response == "#array"

    Scenario: Validar tipo de dato de un cliente de la lista
        When method GET
        Then match response[0] == response_cliente
        * print response_cliente
    