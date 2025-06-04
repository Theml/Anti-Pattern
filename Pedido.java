import java.util.List;

class Pedido {
    public int id;
    public Usuario usuario;
    public List<Produto> produtos;
    public double total;
    public String status;
    // Sem métodos para calcular total, validar, etc.
}
