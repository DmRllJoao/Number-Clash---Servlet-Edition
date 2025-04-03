package br.com.NumberClash.jogo;

import br.com.NumberClash.jogo.Jogo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/JogoServlet")
public class JogoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        int valor1 = Integer.parseInt(request.getParameter("valor1"));
        int valor2 = Integer.parseInt(request.getParameter("valor2"));
        String jogador1 = request.getParameter("jogador1");
        String jogador2 = request.getParameter("jogador2");
        
        Jogo jogo = new Jogo();
        jogo.setValor1(valor1);
        jogo.setValor2(valor2);
        jogo.setJogador1(jogador1);
        jogo.setJogador2(jogador2);
        
        if (valor1 > valor2) {
            jogo.setResultado("Vencedor: " + jogador1);
        } else if (valor2 > valor1) {
            jogo.setResultado("Vencedor: " + jogador2);
        } else {
            jogo.setResultado("Empate");
        }
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Jogo</title>");
        out.println("<link rel='stylesheet' type='text/css' href='styles/style.css'>");
        out.println("</head><body>");
        out.println("<h2>Resultado:</h2>");
        out.println("<table>");
        out.println("<tr><th>Jogador</th><th>Valor</th></tr>");
        out.println("<tr><td>" + jogo.getJogador1() + "</td><td>" + jogo.getValor1() + "</td></tr>");
        out.println("<tr><td>" + jogo.getJogador2() + "</td><td>" + jogo.getValor2() + "</td></tr>");
        out.println("<tr><td colspan='2'>" + jogo.getResultado() + "</td></tr>");
        out.println("</table>");
        out.println("<br><a href='index.html'>Voltar</a>");
        out.println("</body></html>");
    }
}
