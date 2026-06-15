const API = "http://localhost:8080";

async function api(path, options) {
    const resposta = await fetch(API + path, options);
    const texto = await resposta.text();
    if (!resposta.ok) {
        throw new Error(texto || ("Erro " + resposta.status));
    }
    return texto ? JSON.parse(texto) : null;
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
    return dados ? JSON.parse(dados) : null;
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
    return "R$ " + Number(valor || 0).toFixed(2).replace(".", ",");
}

function sim(valor) {
    return valor ? "Sim" : "Não";
}

function formatarData(texto) {
    if (!texto) return "";
    const data = new Date(texto);
    return data.toLocaleDateString("pt-br") + " " + data.toLocaleTimeString("pt-br", { hour: "2-digit", minute: "2-digit" });
}
