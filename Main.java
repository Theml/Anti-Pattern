import java.util.Arrays;
import java.util.List;

// Classe para demonstrar uso do sistema problemático
class Main {
    public static void main(String[] args) {
        ECommerceSystem sistema = ECommerceSystem.getInstance();
        
        // Populando dados
        sistema.gerenciarSistema("ADD_PRODUTO", 1, "Notebook", 2500.0, "PREMIUM");
        sistema.gerenciarSistema("ADD_PRODUTO", 2, "Mouse", 50.0, "ACESSORIO");
        sistema.gerenciarSistema("ADD_USER", 1, "João Silva", "joao@email.com");
        
        // Processando pedido
        List<Integer> produtos = Arrays.asList(1, 2);
        sistema.processarPedido(1, produtos, "PIX");
        
        // Gerando relatório
        sistema.gerenciarSistema("RELATORIO");
    }
}
