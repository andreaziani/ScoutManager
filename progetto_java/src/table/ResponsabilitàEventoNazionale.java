package table;

public class Responsabilit‡EventoNazionale {
	
	private String codiceEvento;
	private String codiceResponasbile;
	
	public Responsabilit‡EventoNazionale(String codiceEvento, String codiceResponasbile) {
		super();
		this.codiceEvento = codiceEvento;
		this.codiceResponasbile = codiceResponasbile;
	}

	public String getCodiceEvento() {
		return codiceEvento;
	}

	public String getCodiceResponasbile() {
		return codiceResponasbile;
	}

	public void setCodiceEvento(String codiceEvento) {
		this.codiceEvento = codiceEvento;
	}

	public void setCodiceResponasbile(String codiceResponasbile) {
		this.codiceResponasbile = codiceResponasbile;
	}
	
}
