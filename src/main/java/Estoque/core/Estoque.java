package Estoque.core;

public class Estoque {

    private long id;

    private String codBarra;

    private String nomeProduto;

    private String descricao;

    private int quantidade;

    private String categoria;

    public Estoque() {
    }

    public Estoque(long id, String codBarra, String nomeProduto, String descricao, int quantidade, String categoria) {
        this.id = id;
        this.codBarra = codBarra;
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
