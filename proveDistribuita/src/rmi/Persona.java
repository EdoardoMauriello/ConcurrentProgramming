package rmi;

import java.io.Serializable;

public class Persona implements Serializable {

	private String nome;
	private Indirizzo addr;

	private static final long serialVersionUID = 1L;

	public Persona(String nome, String via, int nciv) {
		this.nome = nome;
		this.addr = new Indirizzo(via, nciv);
	}

	public String getNome() {
		return nome;
	}

	public String getAddr() {
		return addr.toString();
	}

}
