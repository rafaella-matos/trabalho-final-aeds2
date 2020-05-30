package mg.puc;

import mg.puc.modelos.Pilha;
import mg.puc.servico.TreServico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
  static String caminhoParaOsDados = System.getProperty("user.dir") + "/tre/dados/";
  static TreServico treServico = new TreServico();

  public static void main(String[] args) {
    cadastrarEleitores("eleitores.txt");
    cadastrarCandidatos("candidatos.txt");
  }

  public static void cadastrarEleitores(String arquivoParaCadastro){
    Pilha<Eleitor> eleitores = null;

    try {
      eleitores = treServico.cadastrarEleitores(caminhoParaOsDados + arquivoParaCadastro);
    } catch (IOException e) {
      System.out.println("Não foi possível ler o arquivo com eleitores");
      e.printStackTrace();
    }
    treServico.exportarEleitores(caminhoParaOsDados, eleitores);
  }

  public static void cadastrarCandidatos(String arquivoParaCadastro){
    Pilha<Candidato> candidatos = null;

    try {
      candidatos = treServico.cadastrarCandidatos(caminhoParaOsDados + arquivoParaCadastro);
    } catch (IOException e) {
      System.out.println("Não foi possível ler o arquivo com candidatos");
      e.printStackTrace();
    }
    treServico.exportarCandidatos(caminhoParaOsDados, candidatos);
  }

  public static String readFile(String path) throws IOException {
    return Files.readString(Paths.get(path));
  }

  public static void writeFile(String path, String conteudo) throws IOException {
    Files.writeString(Paths.get(path), conteudo);
  }
}
