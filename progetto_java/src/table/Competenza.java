package table;

public class Competenza {

	private String nome;
	private String areaCompetenza;
	
	public Competenza(String nome, String areaCompetenza) {
		super();
		this.nome = nome;
		this.areaCompetenza = areaCompetenza;
	}

	public String getNome() {
		return nome;
	}

	public String getAreaCompetenza() {
		return areaCompetenza;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setAreaCompetenza(String areaCompetenza) {
		this.areaCompetenza = areaCompetenza;
	}	
	
}
