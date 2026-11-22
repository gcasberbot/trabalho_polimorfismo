package br.com.gustavo.trabalho_polimorfismo.model;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GerarSenha {

    public static void main(String[] args) {

        BCryptPasswordEncoder encoder =
                new BCryptPasswordEncoder();

        String senha = "1234567";

        String hash = encoder.encode(senha);

        System.out.println(hash);
    }
}
