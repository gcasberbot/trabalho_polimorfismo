const logoutButton = document.getElementById("logoutButton");

logoutButton.addEventListener("click", async function() {

    try {

        const respostaToken = await fetch("/csrf");

        const csrf = await respostaToken.json();

        const resposta = await fetch("/logout", {

            method: "POST",

            headers: {
                [csrf.headerName]: csrf.token
            }

        });

        if (resposta.ok) {
            window.location.href = "/login?logout";
        }

    } catch (erro) {

        console.error("Erro ao sair do sistema:", erro);

    }

});