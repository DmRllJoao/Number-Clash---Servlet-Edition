package br.com.NumberClash.jogo;

public class Jogo {
	
	private String jogador1;
	private String jogador2;
	
	private int valor1;
	private int valor2;
	
	private String resultado;

	public String getJogador1() {
		return jogador1;
	}

	public void setJogador1(String jogador1) {
		this.jogador1 = jogador1;
	}
	
	public String getJogador2() {
		return jogador2;
	}
	
	public void setJogador2(String jogador2) {
		this.jogador2 = jogador2;
	}

	public int getValor1() {
		return valor1;
	}

	public void setValor1(int valor1) {
		this.valor1 = valor1;
	}

	public int getValor2() {
		return valor2;
	}

	public void setValor2(int valor2) {
		this.valor2 = valor2;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
}
