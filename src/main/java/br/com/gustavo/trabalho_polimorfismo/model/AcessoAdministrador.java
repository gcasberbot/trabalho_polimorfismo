package br.com.gustavo.trabalho_polimorfismo.model;

public class AcessoAdministrador implements AcessoSistema{

    @Override
    public void acessarPainel() {
        System.out.println("Painel administrativo");
        System.out.println("Gerenciar usuarios");
        System.out.println("Consultar relatorios");

    }
}
