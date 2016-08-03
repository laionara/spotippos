# Spotippos
Esse projeto consiste em uma API Rest para a identificação e inclusão de imóveis de acordo com determinada província.
Ele foi desenvolvimento em Java versão 8, utilizando:
- Framework Spring MVC versão 4.2.6
- Hibernate versão 5.1.0
- Mockito versão 1.10.19
- Tomcat versão 7.0.30
- Banco de dados Postgres versão 9.4
- Maven versão 4.0
- Gson versão 2.7

Cada imóvel está contido em uma ou mais provincia, definida de acordo com os valores de latitude e longitude do imóvel. 
A utilização da API é feita da seguinte maneira:
1- Para a inclusão de um novo ímovel, é preciso enviá-lo via body por request do tipo Post spotippos/properties
2- Um imóvel pode ser obtido via request Get spotippos/properties/{id}
3- Os imóveis contidos em determinada provícia podem ser obtidos via request spotippos/properties?{integer}&ay={integer}&bx={integer}&by={integer}




