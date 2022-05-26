package rmi;

import java.io.Serializable;

public class Indirizzo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String via;
	private int nciv;

	public Indirizzo(String via, int nciv) {
		this.via = via;
		this.nciv = nciv;
	}

	@Override
	public String toString() {
		return "Indirizzo [via=" + via + ", nciv=" + nciv + "]";
	}

}
