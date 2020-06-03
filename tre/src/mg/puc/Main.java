package mg.puc;

import mg.puc.modelos.Pilha;
import mg.puc.servico.TreServico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

  public static void main(String[] args) {
    String caminhoAtual = System.getProperty("user.dir") + "/dados/";
    TreServico treServico = new TreServico(caminhoAtual);
    Pilha<Eleitor> eleitores = new Pilha<>();
    Pilha<Municipio> municipios = new Pilha<>();
    Pilha<Partido> partidos = new Pilha<>();
    Pilha<Candidato> candidatos = new Pilha<>();
    try {
      partidos = treServico.cadastrarPartido("partido.txt");
    } catch (IOException e) {
      System.out.println("Não foi possível ler o arquivo com os partidos");
      e.printStackTrace();
    }
    try {
      eleitores = treServico.cadastrarEleitores("eleitores.txt");
    } catch (IOException e) {
      System.out.println("Não foi possível ler o arquivo com eleitores");
      e.printStackTrace();
    }
    try {
      municipios = treServico.cadastraMunicipio("municipio.txt");
    } catch (IOException e) {
      System.out.println("Não foi possível ler o arquivo com os municípios");
      e.printStackTrace();
    }
    try {
      candidatos = treServico.cadastrarCandidatos("candidatos.txt");
    } catch (IOException e) {
      System.out.println("Não foi possível ler o arquivo com os candidatos");
      e.printStackTrace();
    }

    treServico.exportarEleitores("eleitoresCadastrados.txt", eleitores);
    treServico.exportarMunicipio("municipiosCadastrados.txt", municipios);
    treServico.exportarPartido("partidosCadastrados.txt", partidos);
    treServico.exportarCandidatos("candidatosCadastrados.txt", candidatos);
  }

  public static String readFile(String path) throws IOException {
    return Files.readString(Paths.get(path));
  }

  public static void writeFile(String path, String conteudo) throws IOException {
    Files.writeString(Paths.get(path), conteudo);
  }
}
