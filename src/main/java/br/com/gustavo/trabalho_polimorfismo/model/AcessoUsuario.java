package br.com.gustavo.trabalho_polimorfismo.model;

public class AcessoUsuario implements AcessoSistema{
    @Override
    public void acessarPainel(){
        System.out.println("Painel do usuário");
        System.out.println("Consultar perfil");
    }
}
