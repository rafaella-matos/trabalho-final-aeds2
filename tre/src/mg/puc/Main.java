package mg.puc;

import mg.puc.modelos.Pilha;
import mg.puc.servico.TreServico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

  public static void main(String[] args) {
    String caminhoAtual = System.getProperty("user.dir") + "/";
    TreServico treServico = new TreServico();
    Pilha<Eleitor> eleitores = null;
    Pilha<Municipio> municipios = null;
    Pilha<Partido> partidos = null;
    try {
      partidos = treServico.cadastrarPartido(caminhoAtual + "partido.txt");
    } catch (IOException e) {
      System.out.println("Não foi possível ler o arquivo com os partidos");
      e.printStackTrace();
    }
    try {
      eleitores = treServico.cadastrarEleitores(caminhoAtual + "eleitores.txt");
    } catch (IOException e) {
      System.out.println("Não foi possível ler o arquivo com eleitores");
      e.printStackTrace();
    }
    try {
      municipios = treServico.cadastraMunicipio(caminhoAtual + "municipio.txt");
    } catch (IOException e) {
      System.out.println("Não foi possível ler o arquivo com os municípios");
      e.printStackTrace();
    }
    treServico.exportarEleitores(caminhoAtual, eleitores);
    treServico.exportarMunicipio(caminhoAtual, municipios);
  }

  public static String readFile(String path) throws IOException {
    return Files.readString(Paths.get(path));
  }

  public static void writeFile(String path, String conteudo) throws IOException {
    Files.writeString(Paths.get(path), conteudo);
  }
}
