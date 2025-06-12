# 💳 Projeto de Análise de Fraudes Bancárias com Estruturas de Dados e Looker Studio

Este projeto tem como objetivo aplicar os conceitos de **estrutura de dados** no tratamento de uma base real sobre **fraudes bancárias**, utilizando Java, banco de dados MySQL e integração com o **Looker Studio** para visualização e análise de dados.

---

## 🎯 Objetivo

- Armazenar e manipular dados de fraudes bancárias em estruturas de dados personalizadas.
- Persistir esses dados em um banco de dados MySQL.
- Criar uma **interface gráfica simples (Swing)** com um botão para abrir o painel analítico.
- Direcionar o usuário para o **Looker Studio**, onde é feita a análise com filtros e gráficos interativos.

---

## 🗃️ Base de Dados

A base de dados contém registros reais ou simulados de **fraudes bancárias**, com informações como:

- Banco da conta envolvida
- Ramo de atividade
- Valor da transação
- Tipo de fraude
- Data e localização

---

## 🏗️ Estruturas de Dados Utilizadas

Os dados são armazenados em **estruturas de dados implementadas manualmente** em Java, sem uso de bibliotecas prontas, permitindo o controle sobre o armazenamento e o fluxo das informações.

### ✅ Lista

- `Lista.java`: lista sequencial
- `ListaEncadeada.java`: lista encadeada

### ✅ Fila

- `Fila.java`: fila sequencial
- `FilaEncadeada.java`: fila dinamica

Essas estruturas foram utilizadas para ler, armazenar e preparar os dados antes da persistência no banco.

---

## 🖥️ Interface Gráfica (Swing)

Criada com Java Swing, a interface tem o objetivo de:

- Exibir uma tela inicial simples
- Conter um botão que redireciona o usuário diretamente para o painel do **Looker Studio**

> **Obs.:** A interface **não possui filtros** nem gráficos. Toda a análise é feita no Looker Studio.

---

## 📊 Integração com Looker Studio

Após o carregamento e envio dos dados ao banco de dados, é possível acessar o **Looker Studio**, onde foi criado um dashboard completo com:

- Filtros dinâmicos por:
  - Banco
  - Ramo
  - Tipo de fraude
  - Intervalos de valores e datas
- Gráficos de barras, pizza e séries temporais
- Resumo estatístico e insights sobre fraudes

---

## ⚙️ Tecnologias Utilizadas

- Java (Swing, JDBC)
- Banco de Dados MySQL
- Google Looker Studio (dashboard conectado ao banco)
- NetBeans (IDE recomendada)
- Estruturas de Dados personalizadas (sem bibliotecas externas)

---

## ▶️ Como Executar

### Requisitos

- Java JDK 8 ou superior
- NetBeans instalado
- MySQL workbench configurado
- Driver JDBC do MySQL
- Conta Google com acesso ao Looker Studio

### Passos

1. Clone ou extraia o projeto.
2. Abra no NetBeans.
3. Configure a conexão com seu banco de dados nas classes `ConexaoForLooker.java` e `ConexaoForWorkBench.java`.
4. Execute a classe `Main.java` ou `TelaInicio.java`.
5. Clique no botão da interface para abrir o painel no Looker Studio.

---

## 👨‍🏫 Propósito Educacional

Este projeto foi desenvolvido com fins didáticos, permitindo aplicar conteúdos de:

- **Estruturas de Dados**
- **Persistência com banco de dados**
- **Integração com BI (Business Intelligence)**
- **Desenvolvimento de interface com Java Swing**

---

## 👥 Equipe

> Gabriel Rodrigues da Silva
>
> João Pedro Caianeli Cabral
>
> Miguel Mirales Fighera
>
> Thales Marques Oliveira 

---

## 📄 Licença

Projeto livre para uso educacional. Modificações são bem-vindas para fins de estudo!
