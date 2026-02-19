package br.com.solid.sistemahotel.service;

import br.com.solid.sistemahotel.domain.MetodoPagamento;
import br.com.solid.sistemahotel.domain.Pagamento;
import br.com.solid.sistemahotel.domain.Usuario;
import br.com.solid.sistemahotel.strategies.PagamentoBoleto;
import br.com.solid.sistemahotel.strategies.PagamentoCartao;
import br.com.solid.sistemahotel.strategies.PagamentoPaypal;
import br.com.solid.sistemahotel.strategies.PagamentoPix;
import br.com.solid.sistemahotel.view.AppSistemaHotel;

import java.util.Scanner;

public class HotelService {

    public Scanner scanner = new Scanner(System.in);
    AppSistemaHotel sistemaHotel = new AppSistemaHotel();

    public Usuario cadastroUsuario(){

        sistemaHotel.cadastroUsuarioNome();
        String nome = scanner.nextLine();

        sistemaHotel.cadastroUsuarioEmail();
        String email = scanner.nextLine();

        Usuario usuario = new Usuario(nome, email);

        System.out.println("Usuário Criado!");

        return usuario;
    }

    public double processarPagamento(Pagamento pagamento) {
        return pagamento.getMetodoPagamento().pagar(pagamento.getValor());
    }

    public String gerenciamentoHotel() {

        sistemaHotel.alertaCadastro();
        Usuario usuario = cadastroUsuario();

        System.out.println("Digite o valor da hospedagem: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        MetodoPagamento metodoPagamento = null;
        String escolhaPagamento = "";


        while (metodoPagamento == null) {

            sistemaHotel.metodoPagamento();
            escolhaPagamento = scanner.nextLine().toUpperCase();

            switch (escolhaPagamento) {

                case "CARTAO":
                    metodoPagamento = new PagamentoCartao();
                    break;
                case "PIX":
                    metodoPagamento = new PagamentoPix();
                    break;
                case "BOLETO":
                    metodoPagamento = new PagamentoBoleto();
                    break;
                case "PAYPAL":
                    metodoPagamento = new PagamentoPaypal();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        Pagamento pagamento = new Pagamento("1", valor, usuario, metodoPagamento);
        double valorFinal = processarPagamento(pagamento);

        return "O usuário " + usuario.getNome() +
                ", ID: " + usuario.getId() +
                " realizou o pagamento de R$" + valorFinal +
                " via " + escolhaPagamento;
    }
}
