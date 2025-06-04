import java.util.*;
import java.sql.*;

// Anti-padrão: God Class (Classe Deus)
// Uma única classe fazendo muitas responsabilidades
public class ECommerceSystem {
    
    // Anti-padrão: Magic Numbers e Strings
    private static final int VALOR_SECRETO = 12345;
    private static final String CONEXAO_DB = "jdbc:mysql://localhost:3306/loja";
    
    // Anti-padrão: Variáveis públicas (quebra encapsulamento)
    public List<Produto> produtos;
    public List<Usuario> usuarios;
    public List<Pedido> pedidos;
    
    // Anti-padrão: Singleton mal implementado (não thread-safe)
    private static ECommerceSystem instance;
    
    public static ECommerceSystem getInstance() {
        if (instance == null) {
            instance = new ECommerceSystem();
        }
        return instance;
    }
    
    private ECommerceSystem() {
        produtos = new ArrayList<>();
        usuarios = new ArrayList<>();
        pedidos = new ArrayList<>();
    }
    
    // Anti-padrão: Método muito longo fazendo muitas coisas
    public void processarPedido(int userId, List<Integer> produtoIds, String pagamento) {
        
        // Validação inline sem método separado
        if (userId <= 0) {
            System.out.println("Erro: User ID inválido");
            return;
        }
        
        // Busca usuário - deveria estar em camada de repositório
        Usuario usuario = null;
        for (Usuario u : usuarios) {
            if (u.id == userId) {
                usuario = u;
                break;
            }
        }
        
        if (usuario == null) {
            System.out.println("Usuário não encontrado");
            return;
        }
        
        // Calcular total - lógica de negócio misturada
        double total = 0;
        List<Produto> produtosPedido = new ArrayList<>();
        
        for (Integer prodId : produtoIds) {
            for (Produto p : produtos) {
                if (p.id == prodId) {
                    produtosPedido.add(p);
                    total += p.preco;
                    
                    // Anti-padrão: Magic Numbers
                    if (p.categoria.equals("PREMIUM")) {
                        total = total * 0.9; // 10% desconto
                    }
                    break;
                }
            }
        }
        
        // Processar pagamento - responsabilidade misturada
        boolean pagamentoOk = false;
        if (pagamento.equals("CARTAO")) {
            // Simulação de processamento de cartão
            if (total < 1000) {
                pagamentoOk = true;
            }
        } else if (pagamento.equals("PIX")) {
            pagamentoOk = true;
        }
        
        if (!pagamentoOk) {
            System.out.println("Falha no pagamento");
            return;
        }
        
        // Anti-padrão: Acesso direto ao banco sem abstração
        try {
            Connection conn = DriverManager.getConnection(CONEXAO_DB, "user", "pass");
            String sql = "INSERT INTO pedidos (user_id, total, status) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            stmt.setDouble(2, total);
            stmt.setString(3, "PROCESSADO");
            stmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            // Anti-padrão: Tratamento de erro inadequado
            e.printStackTrace();
        }
        
        // Criar pedido em memória também
        Pedido pedido = new Pedido();
        pedido.id = pedidos.size() + 1;
        pedido.usuario = usuario;
        pedido.produtos = produtosPedido;
        pedido.total = total;
        pedido.status = "PROCESSADO";
        pedidos.add(pedido);
        
        // Anti-padrão: System.out em lógica de negócio
        System.out.println("Pedido processado com sucesso! Total: R$ " + total);
    }
    
    // Anti-padrão: Método fazendo muitas coisas diferentes
    public void gerenciarSistema(String acao, Object... params) {
        switch (acao) {
            case "ADD_PRODUTO":
                Produto p = new Produto();
                p.id = (Integer) params[0];
                p.nome = (String) params[1];
                p.preco = (Double) params[2];
                p.categoria = (String) params[3];
                produtos.add(p);
                break;
                
            case "ADD_USER":
                Usuario u = new Usuario();
                u.id = (Integer) params[0];
                u.nome = (String) params[1];
                u.email = (String) params[2];
                usuarios.add(u);
                break;
                
            case "RELATORIO":
                // Anti-padrão: Lógica de relatório na classe principal
                System.out.println("=== RELATÓRIO ===");
                System.out.println("Produtos: " + produtos.size());
                System.out.println("Usuários: " + usuarios.size());
                System.out.println("Pedidos: " + pedidos.size());
                
                double totalVendas = 0;
                for (Pedido pedido : pedidos) {
                    totalVendas += pedido.total;
                }
                System.out.println("Total vendas: R$ " + totalVendas);
                break;
        }
    }
}