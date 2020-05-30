package mg.puc.servico;

import mg.puc.Candidato;
import mg.puc.Cargo;
import mg.puc.Eleitor;
import mg.puc.Main;
import mg.puc.modelos.Pilha;

import java.io.IOException;

import static mg.puc.Main.writeFile;
import static mg.puc.utils.Utils.trimAll;

public class TreServico {
  public Pilha<Eleitor> cadastrarEleitores(String caminho) throws IOException {
    Pilha<Eleitor> eleitores = new Pilha<>();
    String file = Main.readFile(caminho);
    String[] linhas = file.split("\n");
    for (String linha : linhas) {
      String[] tokens = linha.split(";");
      trimAll(tokens);
      eleitores.empilhar(new Eleitor(tokens[0], Long.parseLong(tokens[1]),
          tokens[2], tokens[3], tokens[4]));
    }
    return eleitores;
  }

  public void exportarEleitores(String caminho, Pilha<Eleitor> eleitores) {
    int index = 0;
    StringBuilder sb = new StringBuilder();
    String path = caminho + "/eleitoresCadastrados.txt";

    while (!eleitores.pilhaVazia()) {
      sb.append(eleitores.desempilhar().toString())
          .append("\n");
      index++;
    }

    try {
      writeFile(path, sb.toString());
    } catch (IOException e) {
      System.out.println("Não foi possível escrever no caminho " + path);
      e.printStackTrace();
    }
  }

  public Pilha<Candidato> cadastrarCandidatos(String caminho) throws IOException {
    Pilha<Candidato> candidatos = new Pilha<>();
    String file = Main.readFile(caminho);
    String[] linhas = file.split("\n");
    for (String linha : linhas) {
      String[] params = linha.split(";");
      trimAll(params);
      candidatos.empilhar(new Candidato(params[0], Long.parseLong(params[1]),
              params[2], params[3], Cargo.valueOf(params[4])));
    }
    return candidatos;
  }

  public void exportarCandidatos(String caminho, Pilha<Candidato> candidatos) {
    int index = 0;
    StringBuilder sb = new StringBuilder();
    String path = caminho + "/candidatosCadastrados.txt";

    while (!candidatos.pilhaVazia()) {
      sb.append(candidatos.desempilhar().toString())
              .append("\n");
      index++;
    }

    try {
      writeFile(path, sb.toString());
    } catch (IOException e) {
      System.out.println("Não foi possível escrever no caminho " + path);
      e.printStackTrace();
    }
  }
}
