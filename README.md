# Projeto Backend Frutas #

O projeto foi desenvolvido usando o Spring Web, e busca os dados de uma API externa de frutas e permite armazenar localmente frutas enviadas via requisição POST.
Configurações Usadas: Maven, Java, Spring Boot 3.4.5, Packaging Jar, Java 17, API - https://www.fruityvice.com/#3, API DOC - https://www.fruityvice.com/doc/index.html.

# Pré-requisitos
- Java  instalado
- Maven instalado
- Ferramenta para testar APIs (Insomnia)

(Usamos IntelliJ IDEA, Insomnia)

# Execução do Projeto
Clone o repositório:

Open Git Bash here
git clone <url-do-repositorio>
Extrair o zip, abrir o IntelliJ IDEA e abrir o clone do projeto.
Clicar em Run BackendProjetoEuniceKatleenApplication
Após a execução, a API estará disponível em http://localhost:8000/frutas

# Modelos
Fruta
Atributos:
name, String, Nome da Fruta.
Id, Integer, Identificador único da fruta.
family, String, Familia da fruta.
order, String, Ordem da fruta.
genus, String, Genero da fruta.
nutritions, Nutrientes, Dados nutricionais da fruta. (Nutrientes, classe criada como objeto para encapsular os nutrientes)

Nutrientes
Atributos:
protein, Double, Proteína da Fruta (por 100g) em gramas.
carbohydrates Double, Carboidratos da Fruta (por 100g) em gramas.
fat, Double, Gordura da Fruta (por 100g) em gramas.
calories, Integer, Calorias da fruta (por 100g) em gramas.
sugar, Double, Açúcar da Fruta (por 100g) em gramas.

Sobre
Modelo simples para informações sobre o nome do projeto e nome  dos integrantes.


# Rotas
GET /frutas
•	Descrição: Retorna lista de frutas obtidas da API externa.
•	Exemplo de requisição:
GET http://localhost:8000/frutas
•	Exemplo de resposta:
[
	{
		"name": "Persimmon",
		"id": 52,
		"family": "Ebenaceae",
		"order": "Rosales",
		"genus": "Diospyros",
		"nutrientes": {
			"protein": 0,
			"carbohydrates": 18,
			"fat": 0,
			"calories": 81,
			"sugar": 18
		}
	},
	{
		"name": "Strawberry",
		"id": 3,
		"family": "Rosaceae",
		"order": "Rosales",
		"genus": "Fragaria",
		"nutrientes": {
			"protein": 0.8,
			"carbohydrates": 5.5,
			"fat": 0.4,
			"calories": 29,
			"sugar": 5.4
		}
	},
]

________________________________________
GET /frutas/{name}
•	Descrição: Busca na API externa uma fruta pelo nome (ignorando maiúsculas e minúsculas).
•	Exemplo de requisição:
GET http://localhost:8080/frutas/banana
•	Exemplo de resposta:

{
	"name": "Banana",
	"id": 1,
	"family": "Musaceae",
	"order": "Zingiberales",
	"genus": "Musa",
	"nutrientes": {
		"protein": 1,
		"carbohydrates": 22,
		"fat": 0.2,
		"calories": 96,
		"sugar": 17.2
	}
}
________________________________________

GET /frutas/armazenadas
•	Descrição: Retorna a lista de frutas armazenadas localmente.
•	Exemplo de requisição:
GET http://localhost:8000/frutas/armazenadas
•	Exemplo de resposta:
[
	{
		"name": "Orange",
		"id": 2,
		"family": "Rutaceae",
		"order": "Sapindales",
		"genus": "Citrus",
		"nutrientes": {
			"protein": 1,
			"carbohydrates": 8.3,
			"fat": 0.2,
			"calories": 43,
			"sugar": 8.2
		}
	}
]

________________________________________
GET /frutas/armazenadas/ordenadas
•	Descrição: Retorna frutas armazenadas localmente ordenadas por ID crescente.
•	Exemplo de requisição:
GET http://localhost:8000/frutas/armazenadas/ordenadas
•	Exemplo de resposta:

[
	{
		"name": "Orange",
		"id": 2,
		"family": "Rutaceae",
		"order": "Sapindales",
		"genus": "Citrus",
		"nutrientes": {
			"protein": 1,
			"carbohydrates": 8.3,
			"fat": 0.2,
			"calories": 43,
			"sugar": 8.2
		}
	},
	{
		"name": "Raspberry",
		"id": 23,
		"family": "Rosaceae",
		"order": "Rosales",
		"genus": "Rubus",
		"nutrientes": {
			"protein": 1.2,
			"carbohydrates": 12,
			"fat": 0.7,
			"calories": 53,
			"sugar": 4.4
		}
	},
	{
		"name": "Watermelon",
		"id": 25,
		"family": "Cucurbitaceae",
		"order": "Cucurbitales",
		"genus": "Citrullus",
		"nutrientes": {
			"protein": 0.6,
			"carbohydrates": 8,
			"fat": 0.2,
			"calories": 30,
			"sugar": 6
		}
	},
	{
		"name": "Lemon",
		"id": 26,
		"family": "Rutaceae",
		"order": "Sapindales",
		"genus": "Citrus",
		"nutrientes": {
			"protein": 1.1,
			"carbohydrates": 9,
			"fat": 0.3,
			"calories": 29,
			"sugar": 2.5
		}
	},
	{
		"name": "Mango",
		"id": 27,
		"family": "Anacardiaceae",
		"order": "Sapindales",
		"genus": "Mangifera",
		"nutrientes": {
			"protein": 0.82,
			"carbohydrates": 15,
			"fat": 0.38,
			"calories": 60,
			"sugar": 13.7
		}
	},
]
________________________________________
GET /frutas/armazenadas/menoscaloricas
•	Descrição: Retorna frutas armazenadas localmente ordenadas pelas menos calóricas.
•	Exemplo de requisição:
GET http://localhost:8000/frutas/armazenadas/menoscaloricas
•	Exemplo de resposta:
[
	{
		"name": "GreenApple",
		"id": 72,
		"family": "Rosaceae",
		"order": "Rosales",
		"genus": "Malus",
		"nutrientes": {
			"protein": 0.4,
			"carbohydrates": 3.1,
			"fat": 0.1,
			"calories": 21,
			"sugar": 6.4
		}
	},
	{
		"name": "Lemon",
		"id": 26,
		"family": "Rutaceae",
		"order": "Sapindales",
		"genus": "Citrus",
		"nutrientes": {
			"protein": 1.1,
			"carbohydrates": 9,
			"fat": 0.3,
			"calories": 29,
			"sugar": 2.5
		}
	},
	{
		"name": "Watermelon",
		"id": 25,
		"family": "Cucurbitaceae",
		"order": "Cucurbitales",
		"genus": "Citrullus",
		"nutrientes": {
			"protein": 0.6,
			"carbohydrates": 8,
			"fat": 0.2,
			"calories": 30,
			"sugar": 6
		}
	},
	{
		"name": "Orange",
		"id": 2,
		"family": "Rutaceae",
		"order": "Sapindales",
		"genus": "Citrus",
		"nutrientes": {
			"protein": 1,
			"carbohydrates": 8.3,
			"fat": 0.2,
			"calories": 43,
			"sugar": 8.2
		}
	},
	{
		"name": "Raspberry",
		"id": 23,
		"family": "Rosaceae",
		"order": "Rosales",
		"genus": "Rubus",
		"nutrientes": {
			"protein": 1.2,
			"carbohydrates": 12,
			"fat": 0.7,
			"calories": 53,
			"sugar": 4.4
		}
	},
]
________________________________________
GET /frutas/sobre
•	Descrição: Retorna informações gerais informadas no atributo Sobre.
•	Exemplo de requisição:
GET http://localhost:8000/frutas/sobre
•	Exemplo de resposta:

{
	"integrantes": [
		"Eunice",
		"Katleen"
	],
	"nome_projeto": "Trabalho Frutas"
}
________________________________________
POST /frutas
•	Descrição: Armazena localmente uma nova fruta recebida no corpo da requisição.
•	Requisição:
POST http://localhost:8000/frutas
•	Exemplo de resposta:
Content-Type: application/json

  {
    "name": "Cherry",
    "id": 9,
    "family": "Rosaceae",
    "order": "Rosales",
    "genus": "Prunus",
    "nutrientes": {
      "protein": 1,
      "carbohydrates": 12,
      "fat": 0.3,
      "calories": 50,
      "sugar": 8
    }
	}

 Status: 201 Created

  {
    "name": "Cherry",
    "id": 9,
    "family": "Rosaceae",
    "order": "Rosales",
    "genus": "Prunus",
    "nutrientes": {
      "protein": 1,
      "carbohydrates": 12,
      "fat": 0.3,
      "calories": 50,
      "sugar": 8
    }
	}
 

# Teste da API
Usar o Insomnia.
Criar uma nova Requisição Get.
No campo de URL, insira o endereço da sua API.
Por exemplo: http://localhost:8000/frutas

Criar uma Requisição POST:
Criar uma nova requisição, e escolher a opção POST.
No campo de URL, insira o o endereço da sua API. 
Por exemplo: http://localhost:8000/frutas
Abrir a aba “ Body”, selecione o formato de corpo que você deseja usar (no caso, JSON) e adicionar no corpo da requisição os dados da fruta que você deseja enviar.
