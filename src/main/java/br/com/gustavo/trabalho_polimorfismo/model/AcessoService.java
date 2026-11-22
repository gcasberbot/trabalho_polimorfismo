package br.com.gustavo.trabalho_polimorfismo.model;

public class AcessoService {
    public AcessoSistema definirAcesso(Permissao permissao){

        if(permissao == Permissao.ADMIN){
            return new AcessoAdministrador();
        }
        else {
            return new AcessoUsuario();
        }

    }
}
