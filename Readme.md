# Demonstração de Anti-Padrões em Java
> Projeto acadêmico para demonstrar problemas comuns de design de software

## 📋 Sobre o Projeto
Este projeto implementa um sistema de e-commerce simples para demonstrar diversos anti-padrões de programação - práticas que devem ser evitadas no desenvolvimento de software.

## 🚫 Anti-Padrões Demonstrados

### 1. God Class (Classe Deus)
- **Onde**: Classe `ECommerceSystem`
- **Problema**: Uma única classe controlando todas as operações do sistema
- **Impacto**: Baixa coesão, alta complexidade, difícil manutenção

### 2. Long Method (Método Longo)
- **Onde**: Método `processarPedido()`
- **Problema**: Método realizando muitas operações distintas
- **Impacto**: Código difícil de entender e modificar

### 3. Magic Numbers/Strings
- **Onde**: Todo o código
- **Problema**: Uso de valores literais sem explicação
- **Exemplo**: `0.9` para desconto, `"PREMIUM"` para categoria

### 4. Anemic Domain Model
- **Onde**: Classes `Produto`, `Usuario`, `Pedido`
- **Problema**: Classes de domínio sem comportamento, apenas dados
- **Impacto**: Regras de negócio espalhadas pelo sistema

### 5. Singleton Mal Implementado
- **Onde**: `ECommerceSystem`
- **Problema**: Implementação não thread-safe
- **Impacto**: Possíveis problemas em ambiente multi-thread

## 🎯 Objetivos de Aprendizado
- Identificar anti-padrões comuns
- Entender seus impactos negativos
- Aprender melhores práticas de design

## ✅ Como Melhorar o Código

### 1. Separação de Responsabilidades
```java
// Exemplo de estrutura melhorada
└── src/
    ├── controller/
    ├── service/
    ├── repository/
    └── model/
```

### 2. Boas Práticas
- Implementar princípios SOLID
- Usar injeção de dependências
- Criar testes unitários
- Aplicar padrões de projeto adequados:
  - Factory para criação de objetos
  - Strategy para diferentes formas de pagamento
  - Repository para acesso a dados
  - Observer para notificações

## 🛠️ Como Executar
```bash
javac *.java
java Main
```
