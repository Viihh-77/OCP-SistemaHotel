package br.com.solid.sistemahotel.view;

import java.util.Scanner;

public class AppSistemaHotel {

    public void alertaCadastro(){

        System.out.println("""
                |Você precisa estar Cadastrado!|
                |Realize o Cadastro ---------- |
                """);
    }

    public void metodoPagamento(){
        System.out.println("""
                | Escolha o metódo de pagamento |
                |-------------------------------|
                | CARTÃO - PIX - BOLETO - PAYPAL|
               
                """);
    }

    public void cadastroUsuarioNome(){

        System.out.println("""
                | Cadastro Usuário |
                --------------------
                --> Nome:
                
                """);
    }

    public void cadastroUsuarioEmail(){

        System.out.println("""
                --------------------
                --> Email:
                
                """);
    }
}
