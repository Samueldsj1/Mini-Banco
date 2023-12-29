# Mini Banco
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/Samueldsj1/Mini-Banco/blob/master/LICENSE) 

## Sobre o projeto
O "Mini-Banco" é uma aplicação desenvolvida em Java, criada com o intuito de simular um ambiente bancário simplificado. Este projeto oferece uma visão prática e desafiadora de conceitos fundamentais de programação, especialmente no contexto de sistemas financeiros.

Temos 2 tipos de usuários, os comuns e lojistas, ambos têm carteira com dinheiro e realizam transferências entre eles. Vamos nos atentar somente ao fluxo de transferência entre dois usuários.

## Regras de negócio.
- Para ambos tipos de usuário, precisamos do Nome Completo, CPF, e-mail e Senha. CPF/CNPJ e e-mails devem ser únicos no sistema. Sendo assim, seu sistema deve permitir apenas um cadastro com o mesmo CPF ou endereço de e-mail.

- Usuários podem enviar dinheiro (efetuar transferência) para lojistas e entre usuários.

- Lojistas só recebem transferências, não enviam dinheiro para ninguém.

- Validar se o usuário tem saldo antes da transferência.


  ### Dependências
  - Spring Boot
  - Spring Web
  - H2 Database
  - JPA
  - Lombok
  

