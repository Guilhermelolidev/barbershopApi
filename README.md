Estrutura do Projeto
Aqui está a estrutura geral do projeto:

Entidades: (Cliente, Agendamento, Serviço).
- Repositórios
- Serviços
- Controladores
- DTOs
- Configuracoes

Dependências:
- Spring Web
- Spring Data JPA
- PostgreSQL Driver
- Spring Boot DevTools 

Funcionalidades existentes
- cadastro de cliente
- cadastro de serviço
- listagem de agendamentos
- Agendamento de serviços com disponibilidade
- Filtro de agendamentos por cliente e intervalo de data inicial e data final
- Validação de dados (com @Valid e validações customizadas).
- Paginação e ordenação (para listar clientes, agendamentos, de forma paginada).

