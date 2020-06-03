package mg.puc;

/**
 * Define registros de votos.
 * 
 * @author rafaella-matos
 */
public class Voto {

	private long numeroCandidato;
	private long contagem;

	/**
	 * Inicializa um registro de voto para um determinado candidato.
	 * 
	 * @param numeroCandidato O n�mero do candidato.
	 */
	public Voto(long numeroCandidato) {
		this.numeroCandidato = numeroCandidato;
		this.contagem = 0;
	}

	/**
	 * Incrementa em um o voto para um determinado candidato.
	 */
	public void incrementar() {
		this.incrementar(1);
	}

	/**
	 * Incrementa em um o voto para um determinado candidato.
	 * 
	 * @param quantidade A quantidade de votos a serem incrementados.
	 */
	public void incrementar(long quantidade) {
		this.contagem += quantidade;
	}

	/**
	 * Obt�m a contagem de votos para um candidato;
	 * 
	 * @return A contagem de votos para um candidato.
	 */
	public long getContagem() {
		return this.contagem;
	}

	/**
	 * Obt�m o n�mero do candidato associado a essa contagem de votos.
	 * 
	 * @return O n�mero do candidato associado.
	 */
	public long getNumeroCandidato() {
		return this.numeroCandidato;
	}

}
