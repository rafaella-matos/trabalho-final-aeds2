package mg.puc.modelos;

import mg.puc.Candidato;

/**
 * Representa uma lista específica para candidatos.
 * 
 * @author rafalla-matos
 */
public class ListaCandidatos extends Lista<Candidato> {

	/**
	 * Adiciona a busca pelo número do candidato.
	 * 
	 * @param numero O número do candidato.
	 * @return O candidato localizado, ou nulo.
	 */
	public Candidato localizar(long numero) {
		Celula<Candidato> aux;

		aux = primeiro;

		while (aux != null) {
			if (aux.getItem().getNumero() == numero) {
				return aux.getItem();
			} else {
				aux = aux.proximo;
			}
		}

		return null;
	}

}
