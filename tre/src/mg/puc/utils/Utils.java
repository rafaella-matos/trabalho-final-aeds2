package mg.puc.utils;

import mg.puc.Urna;
import mg.puc.Voto;
import mg.puc.modelos.Lista;
import mg.puc.modelos.Lista.Celula;
import mg.puc.modelos.ListaCandidatos;
import mg.puc.modelos.ListaVotos;

/**
 * Define elementos de apoio.
 * @author 
 *
 */
public class Utils {
	
	public static void trimAll(String[] strings) {
		for (int i = 0; i < strings.length; i++) {
			strings[i] = strings[i].trim();
		}
	}

	/**
	 * Realiza a contagem total de votos de vereadores.
	 * 
	 * @param candidatos Os candidatos cadastrados para vereador.
	 * @param urnas      As urnas de votação.
	 * @return A listagem final de votos para vereadores.
	 */
	public static ListaVotos contarVotosVereadores(ListaCandidatos candidatos, Lista<Urna> urnas) {

		ListaVotos resultado = new ListaVotos(candidatos);

		Celula<Urna> aux = urnas.getPrimeiro();
		while (aux != null) {
			ListaVotos votosVereadores = aux.getItem().getVotosVereadores();

			Celula<Voto> aux2 = votosVereadores.getPrimeiro();
			while (aux2 != null) {

				// Localiza a contagem de votos correspondente na urna.
				Voto votoRegistratoNaUrna = aux2.getItem();

				// Localiza a contagem total de votos correspondente.
				Voto votoFinal = resultado.localizar(votoRegistratoNaUrna.getNumeroCandidato());

				// Incrementa a contagem total.
				votoFinal.incrementar(votoRegistratoNaUrna.getContagem());
			}
		}

		return resultado;

	}

	/**
	 * Realiza a contagem total de votos de vereadores.
	 * 
	 * @param candidatos Os candidatos cadastrados para vereador.
	 * @param urnas      As urnas de votação.
	 * @return A listagem final de votos para vereadores.
	 */
	public static ListaVotos contarVotosPrefeitos(ListaCandidatos candidatos, Lista<Urna> urnas) {

		ListaVotos resultado = new ListaVotos(candidatos);

		Celula<Urna> aux = urnas.getPrimeiro();
		while (aux != null) {
			ListaVotos votosVereadores = aux.getItem().getVotosPrefeitos();

			Celula<Voto> aux2 = votosVereadores.getPrimeiro();
			while (aux2 != null) {

				// Localiza a contagem de votos correspondente na urna.
				Voto votoRegistratoNaUrna = aux2.getItem();

				// Localiza a contagem total de votos correspondente.
				Voto votoFinal = resultado.localizar(votoRegistratoNaUrna.getNumeroCandidato());

				// Incrementa a contagem total.
				votoFinal.incrementar(votoRegistratoNaUrna.getContagem());
			}
		}

		return resultado;

	}
}
