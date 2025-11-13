## porque usar mapeadores (mappers) em uma aplicação Java?

nessa aplicação a escolhar de mapeadores (mappers) se da por sua simplicidade e eficiência
outras propostas poderiam ser usadas, como o uso de alguns design patterns: 
- Factory: facilita a criação do objeto porém pode adicionar complexidade desnecessária se o mapeamento for simples.
- Builder: útil para criar objetos complexos passo a passo, mas pode ser excessivo para mapeamentos diretos.
e por ai vai...

os mapeadores (mappers) são uma solução direta e eficaz para converter entre diferentes representações de dados, como entidades de banco de dados e objetos de transferência de dados (DTOs). eles ajudam a manter o código limpo e organizado, facilitando a manutenção e a evolução da aplicação ao longo do tempo.