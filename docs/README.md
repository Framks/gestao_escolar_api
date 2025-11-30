# Visão Geral da Arquitetura

## 1. Princípios adotados

- **Clean Architecture**
   - Separação clara entre domínio, aplicação e infraestrutura.
   - Dependências apontando para dentro: as regras de negócio não dependem de frameworks.

- **Infraestrutura**
   - Uso de **Spring Boot** para facilitar a construção de APIs REST.
   - **JPA / Hibernate** para persistência de entidades.
   - Configuração via Docker para facilitar deploy e desenvolvimento local.

- **Segurança / Autenticação**
   - Se houver login/autenticação, pode usar **Spring Security**.
   - Fluxo de autenticação deve estar isolado da lógica de negócio nos casos de uso.

- **Escalabilidade**
   - A arquitetura limpa facilita a manutenção e evolução (separar regras, trocar repositório, adicionar cache, etc).
   - Possível adição de contêineres futuros, como fila, micro-serviços ou cache distribuído.

## 2. Fluxos principais documentados

1. **Criação de Aluno**
   - O front faz requisição para `AlunoController` → `CriarAlunoUseCase` → valida domínio → usa `AlunoRepository` → persistência via `AlunoRepositoryJpa` → retorna para controller → resposta para o front.

2. **Autenticação (se existir)**
   - Front envia credenciais → Controller de autenticação → UseCase de login → repositório de usuário → geração de token / sessão → retorno para front.

## 3. Benefícios dessa arquitetura

- **Testabilidade**: os casos de uso e domínio podem ser testados isoladamente sem dependência de DB ou Spring.
- **Flexibilidade**: se quiser trocar JPA por outro mecanismo, basta implementar a interface de repositório.
- **Manutenibilidade**: código organizado, responsabilidades bem separadas → mais fácil de entender e evoluir.

## 4. Possíveis riscos / trade-offs

- **Complexidade inicial**: mais camadas significa mais classes, o que pode ser “overkill” para projetos muito simples.
- **Performance**: abstrações têm custo (mas geralmente pequeno para casos CRUD típicos).
- **Sobrecarga operacional**: manter a documentação atualizada conforme o código evolui exige disciplina.

## 5. Documentação C4

1. [**Diagramas**](https://github.com/Framks/gestao_escolar_api/blob/master/docs/diagramas/README.md): 
   - Visão geral da arquitetura do sistema, incluindo componentes principais, suas interações e fluxos de dados.

## 6. Requests para a API

na pasta `docs/postman` você encontrará uma coleção de requests para a API, que podem ser importadas diretamente no Postman para facilitar os testes e a exploração dos endpoints disponíveis.