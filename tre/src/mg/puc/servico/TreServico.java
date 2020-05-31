package mg.puc.servico;

import mg.puc.Partido
import mg.puc.Municipio
import mg.puc.Eleitor;
import mg.puc.Main;
import mg.puc.modelos.Pilha;

import java.io.BufferedReader;

import java.io.IOException;

import static mg.puc.Main.writeFile;
import static mg.puc.utils.Utils.trimAll;

public class TreServico {
  public Pilha <Partido> cadastrarPartido(String caminho) throws IOException {

    Pilha<Partido> partidos = new Pilha<>();
    String file = Main.readFile(caminho);
    String[] linhas = file.split("\n");
    for (String linha : linhas) {
      String[] tokens = linha.split(";");
      trimAll(tokens);
      partidos.empilhar(new Partido(tokens[0], tokens[1]);
    }
    return partidos;
  }

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

  public Pilha<Municipio> cadastraMunicipio(String caminho) throws IOException {
    Pilha<Municipio> municipios = new Pilha<>();
    String file = Main.readFile(caminho);
    String[] linhas = file.split("\n");
    for (String linha : linhas) {
      String[] tokens = linha.split(";");
      trimAll(tokens);
      municipios.empilhar(new Municipio(tokens[0],tokens[1],tokens[2],tokens[3]));
    }
  return municipios;
  }

  public void exportarEleitores(String caminho, Pilha<Eleitor> eleitores) {
    int index = 0;
    StringBuilder sb = new StringBuilder();
    while (!eleitores.pilhaVazia()) {
      sb.append(eleitores.desempilhar().toString())
          .append("\n");
      if (index % 1000 == 0) {
        String path = caminho + "/zona" + index + ".txt";
        try {
          writeFile(path, sb.toString());
        } catch (IOException e) {
          System.out.println("Não foi possível escrever no caminho " + path);
          e.printStackTrace();
        }
        sb.setLength(0);
      }
      index++;
    }

  public void exportarMunicipio(String caminho, Pilha<Municipio> municipios) {
    StringBuilder sb = new StringBuilder();
    while (!municipios.pilhaVazia()) {
      sb.append(municipios.desempilhar().toString())
              .append("\n");
      try {
        writeFile(caminho + "municipio.txt" sb.toString());
      } catch (IOException e) {
        System.out.println("Não foi possível escrever no caminho ");
        e.printStackTrace();
      }
    }
  }
    public void exportarPartido(String caminho, Pilha<Partido> partidos) {
      StringBuilder sb = new StringBuilder();
      while (!partidos.pilhaVazia()) {
        sb.append(partidos.desempilhar().toString())
                .append("\n");
        try {
          writeFile(caminho + "partido.txt", sb.toString());
        } catch (IOException e) {
          System.out.println("Não foi possível escrever no caminho ");
          e.printStackTrace();
        }
      }
    }
}
