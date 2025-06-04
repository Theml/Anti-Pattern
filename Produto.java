// Anti-padrão: Anemic Domain Model (classes sem comportamento)
class Produto {
    public int id;
    public String nome;
    public double preco;
    public String categoria;
    // Apenas getters/setters ou campos públicos, sem lógica
}