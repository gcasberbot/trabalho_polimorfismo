package br.com.gustavo.trabalho_polimorfismo.service;

import br.com.gustavo.trabalho_polimorfismo.model.Usuario;
import br.com.gustavo.trabalho_polimorfismo.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository repository;

    public CustomUserDetailsService(UsuarioRepository repository){
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

            Usuario usuario = repository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));


        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getSenha())
                .roles(usuario.getPermissao().name())
                .build();
    }
}
