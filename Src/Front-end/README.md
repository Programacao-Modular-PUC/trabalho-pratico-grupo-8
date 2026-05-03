# Front-end · Pousadas de Maraú

Front-end do sistema de hospedagem feito em HTML e CSS puros (com pequenos
trechos de JavaScript para validações simples).

## Estrutura

```
Front-end/
├── css/
│   └── estilo.css        → folha de estilo global
├── js/                   → scripts (vazia por enquanto)
├── imagens/              → fotos do site (vazia por enquanto)
├── index.html            → redireciona para login
│
├── login.html            → entrar no sistema
├── cadastro.html         → criar conta de cliente
│
├── residencias.html      → buscar residências (cliente)
├── quartos.html          → ver quartos de uma residência
├── reserva.html          → escolher datas no calendário
├── aluguel.html          → revisar e confirmar o aluguel
├── pagamento.html        → forma de pagamento
├── recibo.html           → recibo final
│
├── minhas-reservas.html  → reservas ativas + histórico recente
├── historico.html        → histórico completo de hospedagens
│
├── proprietario.html     → painel do proprietário (suas residências)
├── alugueis.html         → aluguéis das residências do proprietário
├── nova-residencia.html  → cadastrar/editar residência
└── novo-quarto.html      → cadastrar quarto numa residência
```

## Como abrir

Abrir o `index.html` (ou `login.html`) direto no navegador.

## Fluxo principal (cliente)

login → residências → quartos → reserva → aluguel → pagamento → recibo

## Fluxo do proprietário

login → proprietário → nova-residência / novo-quarto / aluguéis
