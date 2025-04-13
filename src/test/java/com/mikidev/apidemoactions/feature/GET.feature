Feature: GET request feature

    Scenario: Obtener respuesta 200 de un cliente
        Given url karate.get('baseApiUrl')
        * path 'cliente'
        When method GET
        Then status 200

    Scenario: Obtener respuesta 200 de una lista de clientes
        Given url karate.get('baseApiUrl')
        * path 'listaclientes'
        When method GET
        Then status 200