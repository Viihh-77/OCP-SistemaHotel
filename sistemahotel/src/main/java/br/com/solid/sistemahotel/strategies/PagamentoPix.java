package br.com.solid.sistemahotel.strategies;

import br.com.solid.sistemahotel.domain.MetodoPagamento;

public class PagamentoPix implements MetodoPagamento {
    @Override
    public double pagar(double valor) {
        System.out.println("Pagamento via Pix processado.");
        return valor;
    }
}
