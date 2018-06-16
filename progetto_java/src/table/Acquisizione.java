package table;

public class Acquisizione {
	
	private String nome;
	private String areaCompetenza;
	private String codiceIscritto;
	
	public Acquisizione(String nome, String areaCompetenza, String codiceIscritto) {
		super();
		this.nome = nome;
		this.areaCompetenza = areaCompetenza;
		this.codiceIscritto = codiceIscritto;
	}

	public String getNome() {
		return nome;
	}

	public String getAreaCompetenza() {
		return areaCompetenza;
	}

	public String getCodiceIscritto() {
		return codiceIscritto;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setAreaCompetenza(String areaCompetenza) {
		this.areaCompetenza = areaCompetenza;
	}

	public void setCodiceIscritto(String codiceIscritto) {
		this.codiceIscritto = codiceIscritto;
	}	

}
