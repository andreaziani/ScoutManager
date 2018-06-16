package table;

public class Parrocchia {
		
	private String codiceParrocchia;
	private String nome;
	private String indirizzo;
	private String numeroCivico;
	
	public Parrocchia(String codiceParrocchia, String nome, String indirizzo, String numeroCivico) {
		this.codiceParrocchia = codiceParrocchia;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.numeroCivico = numeroCivico;
	}

	public String getCodiceParrocchia() {
		return this.codiceParrocchia;
	}

	public String getNome() {
		return this.nome;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public String getNumeroCivico() {
		return this.numeroCivico;
	}
	
	public void setCodiceParrocchia(String codiceParrocchia) {
		this.codiceParrocchia = codiceParrocchia;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public void setNumeroCivico(String numeroCivico) {
		this.numeroCivico = numeroCivico;
	}
		
}
