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
        
     // Adicionar atributos na requisição
        request.setAttribute("jogo", jogo);

        // Encaminhar para o JSP
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
    }
}
