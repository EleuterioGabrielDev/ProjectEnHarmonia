# 🎶 Project EnHarmonia 🎶 

Sistema de gestão para empresa de casamentos e música: cadastro de clientes, produtos contratados (instrumentos e cantores) e geração automática de orçamento.

Projeto desenvolvido com o método Agile Scrum, em Java, com foco em resolver problemas reais da empresa.

## 📌 Sumário
1. Contexto e problema
2. Objetivos
3. Tecnologias
4. Processo Scrum
5. Product Backlog
6. Status das Sprints
7. Como executar
8. Estrutura do projeto
9. Padrões do projeto
---
## 🏢 Contexto e problema

Hoje a empresa trabalha de forma manual:

| Processo                             | 	Situação atual                                                      |
|--------------------------------------|---------------------------------------------------------------------|
| Atendimento                          | 	Feito via WhatsApp                                                  |
| Cadastro de clientes                 | 	Manual                                                              |
| Gerenciamento de dados               | 	Manual                                                              |
| Cálculo do orçamento                 | 	Word / Excel                                                        |
| Apresentação do orçamento ao cliente | 	Montado no Canva, com edição manual e trabalhosa de nomes e valores |


## 🎯 Objetivos

* Cadastrar novos clientes com os dados do evento: nome do(a) noivo(a), data, horário e local.
* Gerenciar o produto contratado: instrumentos e cantores.
* Calcular o orçamento automaticamente (preços fixos, preços variáveis e descontos).
* Gerar o orçamento com valores, produtos contratados e confirmação do pedido, pronto para apresentar ao cliente (substituindo Word/Excel/Canva).
* Suportar 2 usuários simultâneos.

## 🛠 Tecnologias

| Camada         | Tecnologia                                                  |
|----------------|-------------------------------------------------------------|
| Linguagem      | 	Java 21                                                     |
| Backend        | 	Spring Boot 4.1.2 (Maven)                                   |
| Persistência   | 	Hibernate / Spring Data JPA                                 |
| Banco de dados | 	PostgreSQL                                                  |
| Migrations     | 	Flyway                                                      |
| Interface      | gráfica	JavaFX                                               |
| IDE            | 	IntelliJ IDEA (backend) / VS Code (frontend, se necessário) |
| Versionamento  | 	Git + GitHub                                                |
| Ambiente       | 	Linux Ubuntu                                                |
---
## 🔄 Processo Scrum

Papéis

| Papel                 | 	Quem                      |
|-----------------------|---------------------------|
| Product Owner         | 	Gerentes da empresa       |
| Scrum Master/Dev Team | 	Equipe de desenvolvimento |

### Cerimônias

* Sprint Planning – define o que entra na sprint a partir do Product Backlog.
* Daily – acompanhamento rápido do que foi feito, o que será feito e impedimentos.
* Sprint Review – demonstração do incremento aos gerentes (PO) e coleta de feedback.
* Sprint Retrospective – o que funcionou, o que melhorar.

### Artefatos
* Product Backlog – lista priorizada de funcionalidades (abaixo).
* Sprint Backlog – itens escolhidos para a sprint atual.
* Incremento – versão funcional entregue ao final de cada sprint.

## Definition of Done (DoD)

Um item só é considerado pronto quando:

1. [ ] O código está na branch main (via commit/PR) e compila sem erros
2. [ ] Há migration Flyway quando houver mudança no banco
3. [ ] Foi testado manualmente (e com testes automatizados quando aplicável)
4. [ ] Foi demonstrado ao Product Owner na Review
5. [ ] Atende ao critério de aceite da user story

## 📋 Product Backlog

Backlog inicial, sujeito a refinamento conforme as respostas dos gerentes.

| ID    | 	User Story                                                                                                                         | 	Prioridade |
|-------|------------------------------------------------------------------------------------------------------------------------------------|------------|
| US-01 | 	Como gerente, quero cadastrar clientes (noivo(a), data, horário, local) para não depender de planilhas e WhatsApp.                 | 	Alta       |
| US-02 | 	Como gerente, quero editar, buscar e listar clientes para consultar eventos rapidamente.                                           | 	Alta       |
| US-03 | 	Como gerente, quero cadastrar instrumentos e cantores (com preços) para montar o produto contratado.                               | 	Alta       |
| US-04 | 	Como gerente, quero vincular produtos a um cliente/evento para registrar o que foi contratado.                                     | 	Alta       |
| US-05 | 	Como gerente, quero que o sistema calcule o orçamento (preços fixos, variáveis e descontos) para eliminar o cálculo em Word/Excel. | 	Alta       |
| US-06 | 	Como gerente, quero gerar o orçamento em formato apresentável (nome, valores, produtos) para substituir a edição manual no Canva.  | 	Alta       |
| US-07 | 	Como gerente, quero confirmar o pedido ao final do cadastro.                                                                       | 	Média      |
| US-08 | 	Como gerente, quero que 2 pessoas usem o sistema ao mesmo tempo sem conflito de dados.                                             | 	Média      |
| US-09 | 	Como gerente, quero acompanhar proposta e pagamento do cliente.                                                                    | 	A definir  |
---
## 🏃 Status das Sprints

| Sprint   | 	Objetivo                                                          | 	Status                    |
|----------|-------------------------------------------------------------------|---------------------------|
| Sprint 0 | 	Preparação do ambiente e arquitetura base                         | 	✅ Concluída (10/11/2026) |
| Sprint 1 | 	Integrar JavaFX ao Spring e criar a 1ª tela (cadastro de cliente) | 	✅ Concluída (11/10/2026  |
| Sprint 2 | 	Instrumentos e cantores (cadastro e gestão)                       | 	🔜 Próxima                |
| Sprint 3 | 	Contratação de produtos e cálculo de orçamento                    | 	⏳ Planejada              |
| Sprint 4 | 	Geração/apresentação do orçamento e confirmação do pedido         | 	⏳ Planejada              |
| Sprint 5 | 	Ajustes, testes finais, multiusuário e entrega                    | 	⏳ Planejada              |


### 🏃 Sprint 0 – Finalizado
✅ Java 21 e Spring Boot 4.1.2 (Maven) configurados

✅ Repositório criado no GitHub (branch main)

✅ PostgreSQL com banco enh_musical e usuário dedicado

✅ Flyway configurado (db/migration)

✅ Migration V1 – tabela client aplicada com sucesso

✅ Entidade Client, repositório e serviço funcionando (testado com gravação no banco)

### 🏃 Sprint 1 – Finalizado
✅ Integrar JavaFX ao contexto do Spring

✅ Criar a primeira tela: cadastro de cliente

✅ Listagem de clientes

✅ Sprint Review com os gerentes

---
## ▶️ Como executar

Pré-requisitos

* Java 21

* Maven

* PostgreSQL

## | Passos |

```bash
### 1. Clonar o repositório
git clone https://github.com/EleuterioGabrielDev/ProjectEnHarmonia.git
cd ProjectEnHarmonia

### 2. Criar o banco de dados (PostgreSQL)
sudo -u postgres psql -c "CREATE DATABASE enh_musical;"
sudo -u postgres psql -c "CREATE USER enh_user WITH PASSWORD '<sua-senha>';"
sudo -u postgres psql -c "GRANT ALL PRIVILEGES ON DATABASE enh_musical TO enh_user;"

### 3. Configurar src/main/resources/application.properties com a sua senha

### 4. Executar (o Flyway aplica as migrations automaticamente)
./mvnw spring-boot:run
```

>⚠️ Nunca suba senhas reais para o GitHub. Use variáveis de ambiente ou um arquivo local ignorado pelo .gitignore.



# 📁 Estrutura do projeto

```
src/main/java/br/com/enhmusical/
├── client/          # Entidade, repositório e serviço de clientes
└── ...              # Novos módulos (instrumentos, cantores, orçamento)

src/main/resources/
├── application.properties
└── db/migration/    # Migrations Flyway (V1__..., V2__...)
```

## 📐 Padrões do projeto

* Código e banco de dados em inglês (ex.: entidade Client, tabela client).
* Pacote base: br.com.enhmusical.
* Toda alteração no banco é feita por migration Flyway (nunca manualmente).
* Commits pequenos e descritivos, preferencialmente no padrão: feat:, fix:, docs:, refactor:.


> _**📅 README atualizado a cada Sprint Review.**_
