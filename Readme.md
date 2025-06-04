# EXEMPLO DE ANTI-PADRÕES DE PROJETO
## Este código demonstra vários problemas comuns de design

---

## ANTI-PADRÕES DEMONSTRADOS:

1. GOD CLASS: ECommerceSystem faz tudo (vendas, usuários, relatórios, BD)
2. LONG METHOD: processarPedido() muito longo e complexo
3. MAGIC NUMBERS/STRINGS: valores hardcoded (0.9, "PREMIUM", etc.)
4. ANEMIC DOMAIN MODEL: Classes de domínio sem comportamento
5. SINGLETON MAL FEITO: Não thread-safe
6. TIGHT COUPLING: Acesso direto ao banco de dados
7. MIXED CONCERNS: UI (System.out) misturado com lógica
8. POOR ERROR HANDLING: printStackTrace() inadequado
9. VIOLATION OF SRP: Uma classe com múltiplas responsabilidades
10. HARD TO TEST: Código acoplado e sem injeção de dependências

---

### Como Melhorar o Projeto:
- Separar responsabilidades em classes específicas
- Criar camadas (Controller, Service, Repository)  
- Implementar interfaces para abstrair dependências
- Usar padrões como Factory, Strategy, Observer
- Implementar tratamento de erros adequado
- Criar testes unitários
