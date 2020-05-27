import mg.puc.Eleitor;
import mg.puc.modelos.Pilha;
import mg.puc.servico.TreServico;

import java.io.IOException;

class Teste {

  public static void main(String[] args) {
    String caminhoAtual = System.getProperty("user.dir");
    TreServico treServico = new TreServico();
    Pilha<Eleitor> eleitores = null;
    try {
      eleitores = treServico.cadastrarEleitores(caminhoAtual + "/dados/eleitores.txt");
    } catch (IOException e) {
      System.out.println("Não foi possível ler o arquivo com eleitores");
      e.printStackTrace();
    }
    treServico.exportarEleitores(caminhoAtual, eleitores);
  }
}