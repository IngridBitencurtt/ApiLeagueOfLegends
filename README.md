# League of Legends HTTP Campeão Adapter
Este repositório foi criado com o intuito de testar meus conhecimentos obtidos na mentoria. 

## Pre-requisites
- Java 17 
- Spring Boot framework
- Maven

## Endpoints

### Consulta Geral de Campeões

- Method: GET
- Path: `/lol/v1/campeoes`
- Parameters:
  - `nome` (optional): Filter by name
  - `genero` (optional): Filter by gender
  - `posicao` (optional): Filter by position
  - `especie` (optional): Filter by species
  - `recurso` (optional): Filter by resource
  - `regiao` (optional): Filter by region
  - `tipoDeAlcance` (optional): Filter by range type
  - `anoDeLancamento` (optional): Filter by release year
- Response: List of CampeaoDto objects

### Criação de Campeão

- Method: POST
- Path: `/lol/v1/campeoes`
- Body: CampeaoDto object
- Response: HTTP 201 Created with the URI of the created resource

### Busca de Campeão por ID

- Method: GET
- Path: `/lol/v1/campeoes/{id}`
- Path Parameter: `id` - ID of the Campeão
- Response: CampeaoDto object

### Remoção de Campeão por ID

- Method: DELETE
- Path: `/lol/v1/campeoes/{id}`
- Path Parameter: `id` - ID of the Campeão
- Response: HTTP 204 No Content

### Busca de Campeões por Nome

- Method: GET
- Path: `/lol/v1/campeoes/nome/{nome}`
- Path Parameter: `nome` - Name of the Campeões
- Response: List of CampeaoDto objects

### Remoção de Campeões por Nome

- Method: DELETE
- Path: `/lol/v1/campeoes/nome/{nome}`
- Path Parameter: `nome` - Name of the Campeões
- Response: HTTP 204 No Content

### Atualização de Campeão por Nome

- Method: PUT
- Path: `/lol/v1/campeoes/nome/{nome}`
- Path Parameter: `nome` - Name of the Campeão
- Body: CampeaoDto object
- Response: HTTP 204 No Content

![image](https://github.com/IngridBitencurtt/ApiLeagueOfLegends/assets/84420903/9d6fce58-d816-4e70-b1ec-4f8f33bc9c37)

