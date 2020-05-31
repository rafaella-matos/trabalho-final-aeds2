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
	 * Obtém o município associado à urna.
	 * @return O município associado à urna.
	 */
	public String getMunicipio() { return this.municipio; }
	
	/***
	 * Obtém a zona eleitoral associada à urna.
	 * @return A zona eleitoral associada à urna.
	 */
	public String getZonaEleitoral() { return this.zonaEleitoral; }
	
	/***
	 * Obtém a seção eleitoral associada à urna.
	 * @return A seção eleitoral associada à urna.
	 */
	public String getSecaoEleitoral() { return this.secaoEleitoral; }
	
	/***
	 * Inicializa uma instância de {@link Urna}
	 * @param municipio O município ao qual a urna está associada.
	 * @param zonaEleitoral A zona eleitoral à qual a urna está associada.
	 * @param secaoEleitoral A seção eleitoral à qual a urna está associada.
	 */
	public Urna(String municipio, String zonaEleitoral, String secaoEleitoral) 	{
		this.municipio = municipio;
		this.zonaEleitoral = zonaEleitoral;
		this.secaoEleitoral = secaoEleitoral;
	}
	
	/***
	 * Lê as urnas a partir de um arquivo de texto.
	 * @param caminho O caminho (completo) para o arquivo texto de urnas.
	 * @return A coleção de urnas.
	 * @throws IOException sempre que houver algum problema na leitura do arquivo de texto, ou quando não existir.
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
			System.out.println("A linha [" + linha + "] não estava em um formato válido e não será lida.");
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
				System.out.println("Os dados da urna não são válidos.");
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
			System.out.println("O município não pode ser nulo ou branco.");
			return false;
		}
		
		if (this.zonaEleitoral == null || this.zonaEleitoral.isEmpty() || this.zonaEleitoral.isBlank()) {
			System.out.println("A zona eleitoral não pode ser nula ou branco.");
			return false;
		}
		
		if (this.secaoEleitoral == null || this.secaoEleitoral.isEmpty() || this.secaoEleitoral.isBlank()) {
			System.out.println("A seção eleitoral não pode ser nula ou branco.");
			return false;
		}
		
		return true;
	}
}
