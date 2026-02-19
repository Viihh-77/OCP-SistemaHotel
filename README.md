# 🏨 Sistema Hotel - OCP (Open/Closed Principle)

<div align="center">

![SOLID](https://img.shields.io/badge/SOLID%20Principles-4A90E2?style=for-the-badge)

Um projeto educacional demonstrando a aplicação do princípio **Open/Closed (OCP)** e **Padrão Strategy** para criar um sistema de pagamento extensível e flexível.

<br>

📖 Aprendizagem Industrial em Desenvolvimento de Sistemas - WEG - AI MIDS 77

Unidade Curricular: Arquitetura de Sistemas  
Professor: Lucas Santos

</div>



---

## 🎯 Objetivo

Este projeto foi desenvolvido como uma **avaliação prática** dos princípios SOLID, com foco especial no **Open/Closed Principle (OCP)**. O objetivo é demonstrar como refatorar um sistema rígido baseado em `if/else` para um sistema extensível e flexível, utilizando o padrão **Strategy** e **Dependency Injection**.

### ✨ Principais Destaques

- ✅ Implementação prática do princípio **OCP**
- ✅ Padrão **Strategy** para cálculo de pagamentos
- ✅ Código extensível sem modificação das classes existentes
- ✅ Fácil adição de novos métodos de pagamento

---

## 🏗️ Arquitetura

### 📊 Diagrama de Classes

```
┌─────────────────────────────────────────────────┐
│              Interface (Abstração)              │
│                 MetodoPagamento                 │
├─────────────────────────────────────────────────┤
│ + pagar(double valor): double                   │
└─────────────────────────────────────────────────┘
       ▲           ▲           ▲           ▲
       │           │           │           │
   implements    implements   implements  implements
       │           │           │           │
  ┌────┴────┐  ┌───┴───┐    ┌──┴───┐  ┌────┴────┐
  │ Cartão  │  │  Pix  │    │Boleto│  │ PayPal  │
  └─────────┘  └───────┘    └──────┘  └─────────┘
```

### 🔄 Fluxo da Aplicação

```
┌──────────────────────────────────────────────────────┐
│          Usuario (Cadastro de Usuário)               │
└──────────────────────────────────┬───────────────────┘
                                   │
                                   ▼
                         ┌──────────────────┐
                         │ Seleção de Valor │
                         └─────────┬────────┘
                                   │
                                   ▼
                    ┌──────────────────────────────┐
                    │ Escolha Método de Pagamento  │
                    │   (Strategy Pattern)         │
                    └─────────────┬────────────────┘
                                  │
        ┌─────────────────────────┼─────────────────────────┐
        │                         │                         │
        ▼                         ▼                         ▼
    ┌────────┐             ┌──────────┐          ┌──────────────┐
    │ Cartão │             │   Pix    │          │ Boleto/PayPal│
    └────────┘             └──────────┘          └──────────────┘
        │                         │                         │
        └─────────────────────────┼─────────────────────────┘
                                  │
                                  ▼
                     ┌──────────────────────────┐
                     │ Processamento Pagamento  │
                     └──────────┬───────────────┘
                                │
                                ▼
                    ┌──────────────────────┐
                    │  Resultado Final     │
                    └──────────────────────┘
```

---

## 📦 Estrutura do Projeto

```
OCP-SistemaHotel/
│
├── 📁 sistemahotel/
│   ├── 📁 src/main/java/br/com/solid/sistemahotel/
│   │   │
│   │   ├── 📁 domain/
│   │   │   ├── 📄 Usuario.java           (Entidade de Usuário)
│   │   │   ├── Pagamento.java            (Entidade de Pagamento)
│   │   │   └── 📄 MetodoPagamento.java   (Interface - Abstração)
│   │   │
│   │   ├── 📁 strategies/
│   │   │   ├── 📄 PagamentoCartao.java      (Strategy: Cartão)
│   │   │   ├── 📄 PagamentoPix.java         (Strategy: Pix)
│   │   │   ├── 📄 PagamentoBoleto.java      (Strategy: Boleto)
│   │   │   └── 📄 PagamentoPaypal.java      (Strategy: PayPal)
│   │   │
│   │   ├── 📁 service/
│   │   │   └── 📄 HotelService.java         (Lógica de Negócio)
│   │   │
│   │   ├── 📁 view/
│   │   │   └── 📄 AppSistemaHotel.java      (Interface de Usuário)
│   │   │
│   │   └── 📄 SistemahotelApplication.java  (Classe Principal)
│   │
│   ├── 📁 src/test/java/
│   │   └── 📁 br/com/solid/sistemahotel/
│   │       └── 📄 SistemahotelApplicationTests.java
│   │
│   ├── 📄 pom.xml                           (Dependências Maven)
│   └── 📄 application.properties             (Configurações)
│
├── 📄 README.md                             (Este arquivo)
├── 📄 .gitignore
└── 📄 LICENSE
```

### 📄 Descrição dos Pacotes

| Pacote | Propósito | Responsabilidade |
|--------|-----------|-----------------|
| `domain` | Entidades e abstrações | Modelos de negócio |
| `strategies` | Implementações concretas | Diferentes métodos de pagamento |
| `service` | Lógica de negócio | Orquestração da aplicação |
| `view` | Interface com usuário | Apresentação e interação |

---

## 🔑 Conceitos SOLID Implementados

### 1️⃣ **Open/Closed Principle (OCP)** - ABERTO PARA EXTENSÃO, FECHADO PARA MODIFICAÇÃO

#### ❌ Antes (Violação do OCP):

**Problemas Identificados:**
- 🔴 Violação do OCP: Requer modificação para adicionar novos métodos
- 🔴 Princípio Aberto/Fechado quebrado: Fechado para extensão
- 🔴 Responsabilidade única violada: Classe conhece todos os métodos
- 🔴 Difícil manutenção e testabilidade
- 🔴 Acoplamento alto com implementações concretas

#### ✅ Depois (Aplicação do OCP com Strategy):

**Vantagens:**
- ✅ **Aberto para extensão**: Novos métodos = novas classes
- ✅ **Fechado para modificação**: Classes existentes não mudam
- ✅ **Fácil adicionar novo método de pagamento** (ex: ANIVERSARIO)
- ✅ **Código organizado e limpo**
- ✅ **Altamente testável**

---

### 2️⃣ **Dependency Inversion Principle (DIP)** - DEPENDA DE ABSTRAÇÕES

#### 🎯 Implementação no Projeto:

**Benefícios:**
- 🎁 Desacoplamento entre classes
- 🎁 Maior flexibilidade e testabilidade
- 🎁 Fácil substituição de implementações
- 🎁 Injeção de dependência automática

---

### 3️⃣ **Padrão Strategy** - ENCAPSULAR ALGORITMOS

O padrão Strategy permite definir uma família de algoritmos, encapsulá-los e torná-los intercambiáveis.

```
┌─────────────────────────────────┐
│      MetodoPagamento (Interface)│
│  Define contrato para estratégias│
└──────────────┬──────────────────┘
               │
       ┌───────┴────────┬────────────┬────────────┐
       │                │            │            │
    Strategy1        Strategy2    Strategy3    Strategy4
  Cartão             Pix          Boleto       PayPal
```

---

### 💻 Exemplo de Uso

```java
// 1. Criar um usuário
Usuario usuario = new Usuario("João Silva", "joao@email.com");

// 2. Escolher um método de pagamento (Strategy)
MetodoPagamento metodoPagamento = new PagamentoCartao();

// 3. Criar o pagamento com injeção de dependência
Pagamento pagamento = new Pagamento("PAG001", 500.00, usuario, metodoPagamento);

// 4. Processar o pagamento
double valorFinal = pagamento.getMetodoPagamento()
                             .pagar(pagamento.getValor());

// Resultado: Pagamento via Cartão processado. → 500.00
```

### 🎮 Interação com a Aplicação

```
| Cadastro Usuário |
--------------------
--> Nome: João Silva

--------------------
--> Email: joao@email.com

Usuário Criado!

Digite o valor da hospedagem: 
500.00

| Escolha o metódo de pagamento |
|-------------------------------|
| CARTÃO - PIX - BOLETO - PAYPAL|

CARTAO

Pagamento via Cartão processado.

O usuário João Silva, ID: 1 realizou o pagamento de R$500.0 via CARTAO
```

---

### 🎓 1. Problema Original (Código Rígido)

#### Estrutura Antiga (Antes do Refatoramento):

**Problemas:**
| Problema | Impacto |
|----------|--------|
| 📌 Modificação constante | Risco de bugs |
| 📌 Acoplamento alto | Difícil de testar |
| 📌 Difícil extensão | Novos requisitos = refatoração |
| 📌 Responsabilidade única violada | Classe faz muita coisa |
| 📌 Sem abstrações | Código não reutilizável |

---

### 🎯 2. Solução: Padrão Strategy + OCP

#### Estrutura Nova (Depois do Refatoramento):

```
┌──────────────────────────┐
│  MetodoPagamento         │  ← Interface (Abstração)
│  + pagar(double): double │
└─────────┬────────────────┘
          │
          │ implements
          │
    ┌─────┴──────┬──────────┬──────────┐─────────────┐
    │            │          │          │             │
    │ PagCartao  │  PagPix  │ PagBoleto│   PagPayPal │
    │            │          │          │             │
    └─────┬──────┴──────┬───┴──────┬───┘──────┬──────┘
          │             │          │          │
          └─────────────┼──────────┘──────────┘
                        │
                ┌───────▼────────┐
                │  Pagamento     │  ← Usa abstração
                │  (DIP aplicado)│
                └────────────────┘
```

## 📊 Comparação: Antes vs Depois

| Aspecto | ❌ Antes | ✅ Depois |
|---------|---------|----------|
| **Extensibilidade** | Requer modificação | Nova classe apenas |
| **Manutenção** | Difícil (if/else crescendo) | Fácil (cada Strategy separada) |
| **Testabilidade** | Baixa (tudo acoplado) | Alta (cada Strategy independente) |
| **Violação OCP** | Sim (fechado para extensão) | Não (aberto para extensão) |
| **Acoplamento** | Alto (conhece todas as impls) | Baixo (depende de abstração) |
| **Princípio SOLID** | Violado | Respeitado |
| **Linhas de Código** | Cresce com cada método | Estável |
| **Riscos de Bugs** | Alto | Baixo |

---

## 🎓 Lições Aprendidas

### 1️⃣ **Open/Closed Principle em Ação**
- ✨ Classes **abertas para extensão** (novos métodos de pagamento)
- 🔒 Classes **fechadas para modificação** (existentes não mudam)

### 2️⃣ **Estratégia vs Código Rígido**
- 📌 Padrão Strategy permite **comportamentos diferentes** sem modificar a classe principal
- 📌 Cada estratégia é **independente** e **reutilizável**

### 3️⃣ **Injeção de Dependência**
- 🔗 A classe **não cria** suas dependências
- 🔗 As dependências são **injetadas** no construtor
- 🔗 Facilita **testes** com mocks

### 4️⃣ **Benefícios para o Negócio**
- 💰 **Novo requisito** = apenas uma nova classe
- 💰 **Sem riscos** de quebrar código existente
- 💰 **Desenvolvimento mais rápido** após implementação inicial
- 💰 **Código mais profissional** e alinhado com boas práticas

---

## 🤝 Padrões de Design Utilizados

```
┌─────────────────────────────────────────┐
│       Design Patterns Implementados      │
├─────────────────────────────────────────┤
│                                         │
│  1. Strategy Pattern                    │
│     └─ Encapsular algoritmos variáveis  │
│                                         │
│  2. Dependency Injection                │
│     └─ Injetar dependências             │
│                                         │
│  3. Interface Segregation               │
│     └─ MetodoPagamento (responsável)    │
│                                         │
│  4. Single Responsibility               │
│     └─ Cada classe = uma responsabilidade
│                                         │
└─────────────────────────────────────────┘
```

---

## 📝 Documentação das Classes

### 🔷 MetodoPagamento (Interface)

```java
/**
 * Interface que define o contrato para diferentes métodos de pagamento.
 * Implementa o Strategy Pattern e permite extensibilidade sem modificar
 * código existente (OCP).
 */

```

### 🔷 Pagamento (Classe)

```java
/**
 * Entidade que representa um pagamento.
 * Utiliza Dependency Injection para receber a estratégia de pagamento.
 * Segue o Dependency Inversion Principle (depende de abstração).
 */

```

### 🔷 HotelService (Serviço)

```java
/**
 * Serviço que gerencia as operações do hotel.
 * Processa pagamentos utilizando a abstração MetodoPagamento.
 * Demonstra como usar Strategy Pattern sem acoplamento.
 */

```

---


## 📌 Checklist de Validação do OCP

- [x] **Problema Identificado**: Código rígido com if/else violava OCP
- [x] **Solução Implementada**: Strategy Pattern com interface
- [x] **Extensibilidade Comprovada**: Novo desconto (ANIVERSARIO) sem modificações
- [x] **Dependency Injection**: Abstrações injetadas, não hardcoded
- [x] **Princípio SOLID**: OCP e DIP aplicados corretamente
- [x] **Código Testável**: Cada estratégia independente
- [x] **Documentação Completa**: Explicação do "porquê"

---

## 🎯 Conclusão

Este projeto demonstra, na prática, como o **Open/Closed Principle** e o **Padrão Strategy** transformam código rígido e acoplado em um sistema **flexível, extensível e fácil de manter**.

### 💡 Pontos-Chave:

1. **OCP em Ação**: Adicionar novos métodos de pagamento sem modificar código existente
2. **Strategy Pattern**: Encapsula comportamentos e os torna intercambiáveis
3. **DIP Aplicado**: Dependências em abstrações, não em implementações
4. **Benefícios Reais**: Código mais limpo, testável e mantível
5. **Boas Práticas**: Demonstra profissionalismo e conhecimento de SOLID

---


<div align="center">

**Desenvolvido como uma demonstração de conhecimento em SOLID Principles**

</div>

