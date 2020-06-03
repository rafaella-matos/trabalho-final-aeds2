package mg.puc;

public class Municipio {

	private String nome;
	private String estado;
	private long habitantes;
	private int vagas;

	public Municipio(String nome, String estado, long habitantes, int vagas) {
		this.nome = nome;
		this.estado = estado;
		this.habitantes = habitantes;
		this.vagas = vagas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public long getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(long habitantes) {
		this.habitantes = habitantes;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	@Override
	public String toString() {
		return nome + ';' + estado + ";" + habitantes + ";" + vagas;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		Municipio temp = (Municipio) obj;
		return this.nome.equalsIgnoreCase(temp.nome) && this.estado.equalsIgnoreCase(temp.estado)
				&& this.habitantes == temp.habitantes && this.vagas == temp.vagas;
	}

}
