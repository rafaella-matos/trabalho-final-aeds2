package mg.puc;

/**
 * Representa um partido político.
 * 
 * @author
 *
 */
public class Partido {

	private String nome;
	private String sigla;

	public Partido(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Override
	public String toString() {
		return "mg.puc.Partido{" + "nome='" + nome + '\'' + ", sigla='" + sigla + '\'' + '}';
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		Partido temp = (Partido) obj;
		return this.nome.equalsIgnoreCase(temp.nome) && this.sigla.equalsIgnoreCase(temp.sigla);
	}
}
