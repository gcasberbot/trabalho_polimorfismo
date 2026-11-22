package br.com.gustavo.trabalho_polimorfismo.model;

public class Main {

    public static void main(String[] args) {

        AcessoService service = new AcessoService();

        AcessoSistema acesso1 =
                service.definirAcesso(Permissao.ADMIN);

        AcessoSistema acesso2 =
                service.definirAcesso(Permissao.USER);

        acesso1.acessarPainel();

        acesso2.acessarPainel();

    }

}
