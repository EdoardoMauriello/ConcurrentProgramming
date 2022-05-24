package serialization;

import java.io.Serializable;

public class Persona implements Serializable {

	private static final long serialVersionUID = 1;

	String name;

	public Persona(String name) {
		this.name = name;
	}

}
