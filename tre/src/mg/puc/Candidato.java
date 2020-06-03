package mg.puc;

/**
 * Representa um candidato
 * 
 * @author
 *
 */
public class Candidato {
	private String nome;
	private long numero;
	private String municipio;
	private String siglaPartido;
	private Cargo cargo;

	public Candidato(String nome, long numero, String municipio, String siglaPartido, Cargo cargo) {
		this.nome = nome;
		this.numero = numero;
		this.municipio = municipio;
		this.siglaPartido = siglaPartido;
		this.cargo = cargo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public String getSiglaPartido() {
		return siglaPartido;
	}

	public void setSiglaPartido(String siglaPartido) {
		this.siglaPartido = siglaPartido;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	@Override
	public String toString() {
		return nome + ';' + numero + ';' + municipio + ';' + siglaPartido + ';' + cargo;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		Candidato temp = (Candidato) obj;
		return this.numero == temp.numero && this.nome.equalsIgnoreCase(temp.nome)
				&& this.municipio.equalsIgnoreCase(temp.municipio) && this.cargo.equals(temp.cargo)
				&& this.siglaPartido.equalsIgnoreCase(temp.siglaPartido);
	}
}
