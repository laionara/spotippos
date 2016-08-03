# Spotippos
Esse projeto consiste em uma API Rest para o gerenciamento de imóveis de acordo com determinada província.
Ele foi desenvolvimento em Java, utilizando:
- Framework Spring MVC versão 4.2.6
- Hibernate versão 5.1.0
- Tomcat versão 7.0.30
- Banco de dados Postgres versão 9.4
- Maven versão 4.0
- Gson versão 2.7

Cada imóvel está contido em uma ou mais provincias, definida de acordo com os valores de latitude e longitude do imóvel. 
A utilização da API é feita da seguinte maneira:
- 1- Para a inclusão de um novo ímovel, é preciso enviá-lo via body por request do tipo Post /properties
- 2- Um imóvel pode ser obtido via request Get /properties/{id}
- 3- Os imóveis contidos em determinada provícia podem ser obtidos via request /properties?{integer}&ay={integer}&bx={integer}&by={integer}




