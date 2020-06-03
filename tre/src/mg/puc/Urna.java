package mg.puc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.naming.OperationNotSupportedException;

import mg.puc.modelos.Lista;
import mg.puc.modelos.ListaCandidatos;
import mg.puc.modelos.ListaVotos;

/***
 * Representa uma urna eleitoral.
 * 
 * @author rafaella-matos
 */
public class Urna {

	private String municipio;
	private String zonaEleitoral;
	private String secaoEleitoral;
	private Lista<Eleitor> eleitoresDisponiveis;
	private Lista<Eleitor> eleitoresQueJustificaram;
	private Lista<Eleitor> eleitoresQueVotaram;
	private ListaCandidatos prefeitos;
	private ListaCandidatos vereadores;
	private ListaVotos votosPrefeitos;
	private ListaVotos votosVereadores;

	/**
	 * Obt�m a lista de votos para vereadores.
	 * 
	 * @return A lista de votos para vereadores.
	 */
	public ListaVotos getVotosVereadores() {
		return this.votosVereadores;
	}

	/**
	 * Obt�m a lista de votos para prefeito.
	 * 
	 * @return A lista de votos para prefeito.
	 */
	public ListaVotos getVotosPrefeitos() {
		return this.votosPrefeitos;
	}

	/**
	 * Obt�m a lista de eleitos que justificaram.
	 * 
	 * @return A lista de eleitos que justificaram.
	 */
	public Lista<Eleitor> getEleitoresQueJustificativa() {
		return this.eleitoresQueJustificaram;
	}

	/**
	 * Obt�m a lista de eleitores que votaram.
	 * 
	 * @return A lista de eleitores que votaram.
	 */
	public Lista<Eleitor> getEleitoresQueVotaram() {
		return this.eleitoresQueVotaram;
	}

	/***
	 * Obt�m o munic�pio associado � urna.
	 * 
	 * @return O munic�pio associado � urna.
	 */
	public String getMunicipio() {
		return this.municipio;
	}

	/***
	 * Obt�m a zona eleitoral associada � urna.
	 * 
	 * @return A zona eleitoral associada � urna.
	 */
	public String getZonaEleitoral() {
		return this.zonaEleitoral;
	}

	/***
	 * Obt�m a se��o eleitoral associada � urna.
	 * 
	 * @return A se��o eleitoral associada � urna.
	 */
	public String getSecaoEleitoral() {
		return this.secaoEleitoral;
	}

	/***
	 * Inicializa uma inst�ncia de {@link Urna}
	 * 
	 * @param municipio      O munic�pio ao qual a urna est� associada.
	 * @param zonaEleitoral  A zona eleitoral � qual a urna est� associada.
	 * @param secaoEleitoral A se��o eleitoral � qual a urna est� associada.
	 * @param eleitores 	 Os eleitores vinculados � urna.
	 */
	public Urna(String municipio, String zonaEleitoral, String secaoEleitoral, Lista<Eleitor> eleitores, ListaCandidatos candidatosPrefeito, ListaCandidatos candidatosVereador) {
		this.municipio = municipio;
		this.zonaEleitoral = zonaEleitoral;
		this.secaoEleitoral = secaoEleitoral;
		this.eleitoresDisponiveis = eleitores;
		this.eleitoresQueJustificaram = new Lista<Eleitor>();
		this.eleitoresQueVotaram = new Lista<Eleitor>();
		this.prefeitos = candidatosPrefeito;
		this.vereadores = candidatosVereador;
		this.votosPrefeitos = new ListaVotos(this.prefeitos);
		this.votosVereadores = new ListaVotos(this.vereadores);
	}

	/**
	 * Realiza a vota��o para um eleitor.
	 * 
	 * @param eleitor O eleitor.
	 * @return True caso a vota��o seja realizada com sucesso, False caso contr�rio.
	 * @throws IOException                    Erros de leitura dos dados informados
	 *                                        na vota��o.
	 * @throws NumberFormatException          Erros de formata��o no n�mero dos
	 *                                        candidatos.
	 * @throws OperationNotSupportedException Falha no processamento do voto.
	 */
	public Boolean votar(Eleitor eleitor) throws IOException, NumberFormatException, OperationNotSupportedException {
		Eleitor elemento = this.eleitoresDisponiveis.localizar(eleitor);

		if (elemento == null) {
			// Eleitor j� votou ou justificou.
			return false;
		} else {
			// Eleitor ainda dispon�vel - votar.
			registrarVoto();
			this.eleitoresDisponiveis.retirar(eleitor);
			this.eleitoresQueVotaram.inserir(eleitor);
			return true;
		}
	}

	/**
	 * Realiza a justificativa eleitoral para um eleitor.
	 * 
	 * @param eleitor O eleitor.
	 * @return True caso a justificativa seja realizada com sucesso, False caso
	 *         contr�rio.
	 */
	public Boolean justificar(Eleitor eleitor) {
		Eleitor elemento = this.eleitoresDisponiveis.localizar(eleitor);

		if (elemento == null) {
			// Eleitor j� votou ou justificou.
			return false;
		} else {
			// Eleitor ainda dispon�vel - votar.
			registrarJustificativa();
			this.eleitoresDisponiveis.retirar(eleitor);
			this.eleitoresQueJustificaram.inserir(eleitor);
			return true;
		}
	}

	/***
	 * L� as urnas a partir de um arquivo de texto.
	 * 
	 * @param caminho O caminho (completo) para o arquivo texto de urnas.
	 * @param prefeitos A lista de prefeitos para a vota��o
	 * @param vereadores A lista de vereadores para a vota��o
	 * @param eleitores A lista de eleitores da urna
	 * @return A cole��o de urnas.
	 * @throws IOException sempre que houver algum problema na leitura do arquivo de
	 *                     texto, ou quando n�o existir.
	 */
	public static Lista<Urna> fromArquivo(String caminho, ListaCandidatos prefeitos, ListaCandidatos vereadores, Lista<Eleitor> eleitores) throws IOException {
		File arquivoUrnas = new File(caminho);
		FileReader leitor = new FileReader(arquivoUrnas);
		BufferedReader leitorBuffer = new BufferedReader(leitor);
		Lista<Urna> urnas = new Lista<Urna>();

		try {
			String linha = null;

			while ((linha = leitorBuffer.readLine()) != null) {
				Urna urna = Urna.fromLinha(linha, prefeitos, vereadores, eleitores);

				if (urna != null)
					urnas.inserir(urna);
			}
		} finally {
			leitorBuffer.close();
			leitor.close();
		}

		return urnas;
	}

	private static Urna fromLinha(String linha, ListaCandidatos prefeitos, ListaCandidatos vereadores, Lista<Eleitor> eleitores) {

		if (linha.chars().filter(c -> c == ';').count() != 2) {
			System.out.println("A linha [" + linha + "] n�o estava em um formato v�lido e n�o ser� lida.");
			return null;
		}

		Scanner leitorFormatado = new Scanner(linha);
		try {
			leitorFormatado.useDelimiter(";");

			String nomeMunicipio = leitorFormatado.next().trim();
			String zonaEleitoral = leitorFormatado.next().trim();
			String secaoEleitoral = leitorFormatado.next().trim();

			Urna retorno = new Urna(nomeMunicipio, zonaEleitoral, secaoEleitoral, eleitores, prefeitos, vereadores);
			if (!retorno.validar()) {
				System.out.println("Os dados da urna n�o s�o v�lidos.");
				return null;
			}

			return retorno;
		} catch (Exception erro) {
			System.out.println("Falha durante o processamento da linha [" + linha + "]. O erro retornado foi: "
					+ erro.getMessage());
			return null;
		} finally {
			leitorFormatado.close();
		}

	}

	private Boolean validar() {
		if (this.municipio == null || this.municipio.isEmpty() || this.municipio.isBlank()) {
			System.out.println("O munic�pio n�o pode ser nulo ou branco.");
			return false;
		}

		if (this.zonaEleitoral == null || this.zonaEleitoral.isEmpty() || this.zonaEleitoral.isBlank()) {
			System.out.println("A zona eleitoral n�o pode ser nula ou branco.");
			return false;
		}

		if (this.secaoEleitoral == null || this.secaoEleitoral.isEmpty() || this.secaoEleitoral.isBlank()) {
			System.out.println("A se��o eleitoral n�o pode ser nula ou branco.");
			return false;
		}

		return true;
	}

	private void registrarVotoPrefeito() throws IOException, NumberFormatException, OperationNotSupportedException {
		System.out.println();
		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Por favor, informe o n�mero do candidato a prefeito: ");
		String numeroPrefeitoInformado = leitor.readLine();

		long numeroPrefeito = Long.parseLong(numeroPrefeitoInformado);

		Candidato prefeito = this.prefeitos.localizar(numeroPrefeito);
		if (prefeito != null) {
			this.votosPrefeitos.registrar(numeroPrefeito);
		}

		leitor.close();
	}

	private void registrarVotoVereador() throws IOException, NumberFormatException, OperationNotSupportedException {
		System.out.println();
		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Informe o n�mero do candidato a vereador: ");
		String numeroVereadorInformado = leitor.readLine();

		long numeroVereador = Long.parseLong(numeroVereadorInformado);

		Candidato vereador = this.vereadores.localizar(numeroVereador);
		if (vereador != null) {
			this.votosVereadores.registrar(numeroVereador);
		}

		leitor.close();
	}

	private void registrarVoto() throws IOException, NumberFormatException, OperationNotSupportedException {
		registrarVotoPrefeito();
		registrarVotoVereador();
		System.out.println("Voto registrado");
	}

	private void registrarJustificativa() {
		System.out.println("Justificativa registrada");
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		Urna temp = (Urna) obj;
		return this.municipio.equalsIgnoreCase(temp.municipio)
				&& this.zonaEleitoral.equalsIgnoreCase(temp.zonaEleitoral)
				&& this.secaoEleitoral.equalsIgnoreCase(temp.secaoEleitoral);
	}
}
