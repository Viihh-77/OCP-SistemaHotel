package br.com.solid.sistemahotel.domain;

public class Pagamento {
    private String id;
    private double valor;
    private Usuario usuario;
    private MetodoPagamento metodoPagamento;

    public Pagamento(String id, double valor, Usuario usuario, MetodoPagamento metodoPagamento) {
        this.id = id;
        this.valor = valor;
        this.usuario = usuario;
        this.metodoPagamento = metodoPagamento;
    }

    public String getId() {
        return id;
    }
    public double getValor() {
        return valor;
    }
    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
