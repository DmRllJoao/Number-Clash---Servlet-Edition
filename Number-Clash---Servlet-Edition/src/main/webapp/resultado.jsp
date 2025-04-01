<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="br.com.NumberClash.jogo.Jogo" %>
<%
    Jogo jogo = (Jogo) request.getAttribute("jogo");
%>
<html>
<head>
    <title>Resultado do Jogo</title>
    <link rel="stylesheet" type="text/css" href="styles/resultado.css">
</head>
<body>
    <h1>Resultado do Jogo</h1>
    <ul>
        <li>Jogador 1: <%= jogo.getJogador1() %> (<%= jogo.getValor1() %>)</li>
        <li>Jogador 2: <%= jogo.getJogador2() %> (<%= jogo.getValor2() %>)</li>
        <li><strong><%= jogo.getResultado() %></strong></li>
    </ul>
    <a href="index.html">Voltar</a>
</body>
</html>
