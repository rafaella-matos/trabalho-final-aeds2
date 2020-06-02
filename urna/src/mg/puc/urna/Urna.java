package mg.puc.urna;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


/***
 * Representa uma urna eleitoral.
 * @author rafaella-matos
 */
public class Urna {
	
	private String municipio;
	private String zonaEleitoral;	
	private String secaoEleitoral;
	
	/***
	 * Obt�m o munic�pio associado � urna.
	 * @return O munic�pio associado � urna.
	 */
	public String getMunicipio() { return this.municipio; }
	
	/***
	 * Obt�m a zona eleitoral associada � urna.
	 * @return A zona eleitoral associada � urna.
	 */
	public String getZonaEleitoral() { return this.zonaEleitoral; }
	
	/***
	 * Obt�m a se��o eleitoral associada � urna.
	 * @return A se��o eleitoral associada � urna.
	 */
	public String getSecaoEleitoral() { return this.secaoEleitoral; }
	
	/***
	 * Inicializa uma inst�ncia de {@link Urna}
	 * @param municipio O munic�pio ao qual a urna est� associada.
	 * @param zonaEleitoral A zona eleitoral � qual a urna est� associada.
	 * @param secaoEleitoral A se��o eleitoral � qual a urna est� associada.
	 */
	public Urna(String municipio, String zonaEleitoral, String secaoEleitoral) 	{
		this.municipio = municipio;
		this.zonaEleitoral = zonaEleitoral;
		this.secaoEleitoral = secaoEleitoral;
	}
	
	/***
	 * L� as urnas a partir de um arquivo de texto.
	 * @param caminho O caminho (completo) para o arquivo texto de urnas.
	 * @return A cole��o de urnas.
	 * @throws IOException sempre que houver algum problema na leitura do arquivo de texto, ou quando n�o existir.
	 */
	public static ListaUrna fromArquivo(String caminho) throws IOException {
		File arquivoUrnas = new File(caminho);
		FileReader leitor = new FileReader(arquivoUrnas);
		BufferedReader leitorBuffer = new BufferedReader(leitor);
		ListaUrna urnas = new ListaUrna();
		
		try {
			String linha = null;
			
			while((linha = leitorBuffer.readLine()) != null) {
				Urna urna = Urna.fromLinha(linha);
				
				if (urna != null)
					urnas.adicionarUrna(urna);
			}
		} finally {
			leitorBuffer.close();
			leitor.close();
		}
		
		return urnas;
	}
	
	private static Urna fromLinha(String linha) {
		
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
			
			Urna retorno = new Urna(nomeMunicipio, zonaEleitoral, secaoEleitoral);
			if (!retorno.validar())
			{
				System.out.println("Os dados da urna n�o s�o v�lidos.");
				return null;
			}
			
			return retorno;
		} catch (Exception erro) {
			System.out.println("Falha durante o processamento da linha [" + linha + "]. O erro retornado foi: " + erro.getMessage());
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
}
