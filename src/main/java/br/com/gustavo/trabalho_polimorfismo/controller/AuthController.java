package br.com.gustavo.trabalho_polimorfismo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/inicio")
    public String inicio(Authentication authentication){

        boolean ehAdmin = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(permissao -> permissao.equals("ROLE_ADMIN"));

        if(ehAdmin){
            return "redirect:/admin.html";
        }
        return "redirect:/usuario.html";
    }
    @GetMapping("/csrf")
    @ResponseBody
    public CsrfToken csrf(CsrfToken token) {
        return token;
    }
}
