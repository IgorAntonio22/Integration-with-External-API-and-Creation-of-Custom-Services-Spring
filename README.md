[README EM PT-BR](https://github.com/IgorAntonio22/Integration-with-External-API-and-Creation-of-Custom-Services-Spring/blob/master/README-PTBR.md)

## Consumed School API: [https://simcaq.c3sl.ufpr.br/doc/#obter-todas-as-escolas](https://simcaq.c3sl.ufpr.br/doc/#obter-todas-as-escolas)

### Project Update with a Restful WEB API

Update the project by building a Restful WEB API that implements CRUD (Create, Read, Update, Delete) operations for a management system. Additionally, it will be necessary to guide the consumption of a public API to be used in the same project. As an example, the project of a school that can have multiple teachers will be considered.

#### API Requirements:

#### Implementation of Resources:

- Two main resources: Schools and Teachers.
- The relationship between Schools and Teachers must be one-to-many, meaning a school can have multiple teachers, but a teacher belongs to only one school.
- Utilization of HTTP methods GET, POST, and DELETE to perform CRUD operations on both classes.

#### For the Schools resource:
- The GET method should return the list of all registered schools.
- The POST method should allow the creation of a new school.
- The DELETE method should allow the deletion of a school based on its ID.

#### For the Teachers resource:
- The GET method should return the list of all teachers of a specific school based on the school's ID.
- The POST method should allow the creation of a new teacher in a specific school.
- The DELETE method should allow the deletion of a teacher based on its ID within a specific school.

Additionally, the API should guide the consumption of an external public API, which will be used in the same project. This public API should be used to obtain additional relevant information for the management system.

You should implement the API following Restful standards, ensuring the correct use of HTTP methods, proper resource modeling, and adequate data handling. Additionally, you should implement integration with the external API in an appropriate and efficient manner.
