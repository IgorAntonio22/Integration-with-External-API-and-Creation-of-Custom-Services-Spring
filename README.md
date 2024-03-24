API DE ESCOLAS CONSUMIDA: https://simcaq.c3sl.ufpr.br/doc/#obter-todas-as-escolas

Atualize o projeto com a construção de uma API WEB Restful que implemente operações CRUD (Create, Read, Update, Delete) para um sistema de gerenciamento. Além disso, será necessário orientar o consumo de uma API pública para ser utilizada no mesmo projeto. Como exemplo, será considerado o projeto de uma escola que pode ter vários professores.

A API deverá ter os seguintes requisitos:

Implementar dois recursos principais: Escolas e Professores.
A relação entre Escolas e Professores deve ser de um-para-muitos, ou seja, uma escola pode ter vários professores, mas um professor pertence apenas a uma escola.
Utilizar os métodos HTTP GET, POST e DELETE para realizar as operações CRUD em ambas as classes.
Para o recurso Escolas:

O método GET deve retornar a lista de todas as escolas cadastradas.
O método POST deve permitir a criação de uma nova escola.
O método DELETE deve permitir a exclusão de uma escola com base em seu ID.
Para o recurso Professores:

O método GET deve retornar a lista de todos os professores de uma determinada escola com base no ID da escola.
O método POST deve permitir a criação de um novo professor em uma escola específica.
O método DELETE deve permitir a exclusão de um professor com base em seu ID, dentro de uma escola específica.
Além disso, a API deverá orientar o consumo de uma API pública externa, que será utilizada no mesmo projeto. Esta API pública deve ser utilizada para obter informações adicionais relevantes para o sistema de gerenciamento.

Você deve implementar a API seguindo os padrões Restful, garantindo a correta utilização dos métodos HTTP, a correta modelagem dos recursos e a manipulação adequada dos dados. Além disso, deverá implementar a integração com a API externa de forma apropriada e eficiente.
