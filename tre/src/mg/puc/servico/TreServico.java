package mg.puc.servico;

import mg.puc.Eleitor;
import mg.puc.Main;
import mg.puc.modelos.Pilha;

import java.io.IOException;

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
}
