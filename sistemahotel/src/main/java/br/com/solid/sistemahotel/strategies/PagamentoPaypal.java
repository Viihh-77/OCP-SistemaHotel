package br.com.solid.sistemahotel.strategies;

import br.com.solid.sistemahotel.domain.MetodoPagamento;

public class PagamentoPaypal implements MetodoPagamento {
    @Override
    public double pagar(double valor) {
        System.out.println("Pagamento via PayPal processado.");
        return valor;
    }
}
