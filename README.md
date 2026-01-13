# PROJETO SISTEMA DE GESTÃO ESCOLAR

Um sistema de gerenciamento escolar desenvolvido como projeto da disciplinaEntity Arquitetura de Software, **BASEADO** em Clean Architecture como um norte para separação de responsabilidades e manutenção facilitada.

##  Documentações do Projeto

[**Documentação do Projeto**](https://github.com/Framks/gestao_escolar_api/blob/master/docs/README.md)

## Calendário de entregas: 

### **01/12 e 02/12**

 - [X] Equipe alinhada e definição do aplicativo que será desenvolvido dentro do domínio sorteado para a equipe.
 - [X] Modelo de documentação que será usado e estilos arquiteturais selecionados.
 - [X] Repositório do aplicativo criado no Github e equipe adicionada.
 - [X] Ferramentas que serão usadas durante o processo de desenvolvimento do aplicativo e criação dos diagramas.

### **08/12 e 09/12**

 - [X] Modelo C4 → Diagramas de Contexto e Container

### **15/12 e 16/12**

 - [ ] Modelo C4 → Diagramas de Componentes e Código

### **05/01 e 06/01**

 - [ ] Código rodando e conformidade do que foi desenvolvido com os diagramas criados (parcial).


## Como "Rodar":

para rodar toda a parte de 

## Fluxo de criação de usuario usando o Clean Architecture:

```
Controller
    ↓
Facade
    ↓
UseCase
    ↓
Domain (UserRepository interface)
    ↓
Infra (UserRepositoryImpl)
    ↓
Infra (SpringDataUserRepository JPA)
    ↓
Banco
```