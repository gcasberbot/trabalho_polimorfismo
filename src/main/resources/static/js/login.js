const formulario = document.getElementById("loginForm");

formulario.addEventListener("submit", async function(event) {

    // Impede o envio tradicional do formulário
    event.preventDefault();

    const mensagem = document.getElementById("mensagem");

    // Captura os dados digitados
    const email = document.getElementById("email").value;
    const senha = document.getElementById("senha").value;

    // Organiza os dados para envio
    const dados = new URLSearchParams();

    dados.append("email", email);
    dados.append("senha", senha);

    // Recupera o token CSRF gerado pelo Thymeleaf
    const tokenCSRF = formulario.querySelector(
        'input[name="_csrf"]'
    ).value;

    try {

        // Envia os dados para o Spring Boot
        const resposta = await fetch("/login", {

            method: "POST",

            headers: {
                "Content-Type": "application/x-www-form-urlencoded",
                "X-CSRF-TOKEN": tokenCSRF
            },

            body: dados

        });

        // Verifica se a autenticação falhou
        if (!resposta.ok) {

            mensagem.textContent = "E-mail ou senha incorretos.";

            return;
        }

        // Redireciona para a página definida pelo backend
        window.location.href = resposta.url;

    } catch (erro) {

        mensagem.textContent = "Erro ao conectar com o servidor.";

        console.error(erro);
    }

});