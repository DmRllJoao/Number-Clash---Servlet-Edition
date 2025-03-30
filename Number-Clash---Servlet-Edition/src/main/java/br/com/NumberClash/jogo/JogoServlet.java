package br.com.NumberClash.jogo;

import br.com.NumberClash.jogo.Jogo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/JogoServlet")
public class JogoServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8"); // Garante que os parâmetros recebidos estejam em UTF-8  
    	// Recuperar os valores do formulário
        int valor1 = Integer.parseInt(request.getParameter("valor1"));
        int valor2 = Integer.parseInt(request.getParameter("valor2"));
        String jogador1 = request.getParameter("jogador1");
        String jogador2 = request.getParameter("jogador2");
        
        // Criar um objeto do jogo e definir os valores
        Jogo jogo = new Jogo();
        jogo.setValor1(valor1);
        jogo.setValor2(valor2);
        jogo.setJogador1(jogador1);
        jogo.setJogador2(jogador2);
        
        // Verificar quem ganhou
        if (valor1 > valor2) {
            jogo.setResultado("Vencedor: " + jogador1);
        } else if (valor2 > valor1) {
            jogo.setResultado("Vencedor: " + jogador2);
        } else {
            jogo.setResultado("Empate");
        }
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Jogo</title>");
        out.println("<html><head>");
        out.println("<title>Jogo</title>");
        out.println("<link rel='stylesheet' type='text/css' href='styles/jogo.css'>"); 
        out.println("</head><body>");
        out.println("<h1>Jogo</h1>");
        out.println("<form action='JogoServlet' method='post'>");
        out.println("<label>Nome do Jogador 1:</label> <input type='text' name='jogador1'><br>");
        out.println("<label>Valor do Jogador 1:</label> <input type='number' name='valor1'><br>");
        out.println("<label>Nome do Jogador 2:</label> <input type='text' name='jogador2'><br>");
        out.println("<label>Valor do Jogador 2:</label> <input type='number' name='valor2'><br>");
        out.println("<button type='submit'>Jogar</button>");
        out.println("</form>");
        
        out.println("<h2>Resultado:</h2>");
        out.println("<ul>");
        out.println("<li>Jogador 1: " + jogo.getJogador1() + " (" + jogo.getValor1() + ")</li>");
        out.println("<li>Jogador 2: " + jogo.getJogador2() + " (" + jogo.getValor2() + ")</li>");
        out.println("<li>" + jogo.getResultado() + "</li>");
        out.println("</ul>");
        
        out.println("<a href='index.html'>Voltar</a>");
        out.println("</body></html>");
    }
}
