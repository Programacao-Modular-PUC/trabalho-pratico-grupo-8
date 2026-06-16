const API = "http://localhost:8080";

async function api(path, options) {
    const resposta = await fetch(API + path, options);
    const texto = await resposta.text();
    if (!resposta.ok) {
        let mensagem = texto;
        if (!mensagem) {
            mensagem = "Erro " + resposta.status;
        }
        throw new Error(mensagem);
    }
    if (texto) {
        return JSON.parse(texto);
    }
    return null;
}

function getJSON(path) {
    return api(path);
}

function postJSON(path, body) {
    return api(path, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(body)
    });
}

function putJSON(path) {
    return api(path, { method: "PUT" });
}

function salvarUsuario(cliente) {
    localStorage.setItem("usuario", JSON.stringify({ id: cliente.id, nome: cliente.nome }));
}

function usuarioLogado() {
    const dados = localStorage.getItem("usuario");
    if (dados) {
        return JSON.parse(dados);
    }
    return null;
}

function exigirLogin() {
    const usuario = usuarioLogado();
    if (!usuario) {
        window.location.href = "../acesso/login.html";
    }
    return usuario;
}

function logout() {
    localStorage.removeItem("usuario");
}

function mostrarUsuario() {
    const usuario = usuarioLogado();
    const elemento = document.querySelector(".usuario");
    if (usuario && elemento) {
        elemento.textContent = usuario.nome;
    }
}

function parametro(nome) {
    return new URLSearchParams(window.location.search).get(nome);
}

function moeda(valor) {
    if (!valor) {
        valor = 0;
    }
    return "R$ " + Number(valor).toFixed(2).replace(".", ",");
}

function sim(valor) {
    if (valor) {
        return "Sim";
    }
    return "Não";
}

function formatarData(texto) {
    if (!texto) {
        return "";
    }
    const data = new Date(texto);
    return data.toLocaleDateString("pt-br") + " " + data.toLocaleTimeString("pt-br", { hour: "2-digit", minute: "2-digit" });
}
