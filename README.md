# Consultor-de-Cep 
API de Consulta de CEP
<img width="1920" height="1080" alt="Captura de tela 2026-10-01 220247" src="https://github.com/user-attachments/assets/6b775424-4241-440c-ac32-984b090416c9" />


API REST em Java e Spring Boot que recebe um CEP, consulta a API pública ViaCEP e devolve o endereço completo. O projeto inclui uma página HTML simples para testar a busca pelo navegador.

Mostrar Imagem

Funcionalidades
Consulta de endereço a partir de um CEP, com ou sem hífen (01001000 ou 01001-000)
Consumo de API externa (ViaCEP) com RestTemplate
Validação do CEP (precisa ter 8 dígitos)
Tratamento de erros com os status HTTP corretos (400 e 404)
Página web para testar a busca
Tecnologias
Java 17
Spring Boot 4.1.1 (Spring Web MVC)
Maven
API ViaCEP
HTML, CSS e JavaScript (página de teste)
Endpoint
GET /cep/{cep}

Exemplo de requisição

GET http://localhost:8080/cep/01001000

Resposta (200 OK)

json
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "complemento": "lado ímpar",
  "bairro": "Sé",
  "localidade": "São Paulo",
  "uf": "SP",
  "erro": null
}

Respostas de erro

Situação	Status	Mensagem
CEP com menos ou mais de 8 dígitos	400 Bad Request	CEP deve ter 8 dígitos
CEP que não existe	404 Not Found	CEP não encontrado
Como rodar
Pré-requisitos
JDK 17 instalado
Variável de ambiente JAVA_HOME apontando para o JDK
Passos
Clone o repositório:
bash
   git clone https://github.com/lucassilvasantos2207-svg/api-consulta-cep.git
   cd api-consulta-cep
Suba a API:
bash
   # Windows
   mvnw spring-boot:run

   # Linux / macOS
   ./mvnw spring-boot:run
Quando aparecer Started ApicepApplication no terminal, a API está no ar em http://localhost:8080.
Para testar pela página, abra http://localhost:8080 no navegador, digite um CEP e clique em Buscar.

A API precisa estar rodando para a página funcionar, porque é ela que faz a consulta à ViaCEP.

Estrutura do projeto
src/main/java/com/lucas/apicep/
├── ApicepApplication.java   # classe principal
├── CepController.java       # endpoint GET /cep/{cep}
├── CepService.java          # validação e chamada à ViaCEP
└── Endereco.java            # modelo da resposta

src/main/resources/static/
└── index.html               # página de teste
O que aprendi
Consumir uma API externa em uma aplicação Spring Boot
Separar as responsabilidades em controller, service e modelo
Validar a entrada e devolver os status HTTP adequados
Configurar o ambiente Java e o Maven para rodar o projeto
Próximos passos
Adicionar testes automatizados com JUnit e Mockito
Fazer o deploy da API
Criar um cache para CEPs já consultados
Autor

Lucas Silva Santos

GitHub: lucassilvasantos2207-svg
LinkedIn: lucas-silva-santos
