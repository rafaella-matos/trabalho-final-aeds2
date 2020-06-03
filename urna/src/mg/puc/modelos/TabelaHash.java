package mg.puc.modelos;


public class TabelaHash {

    private int M;

    private ListaEleitores[] tabelaEleiores;

    public TabelaHash(int tamanho) {
        M = tamanho;
        tabelaEleiores = new ListaEleitores[M];
    }

    private int funcaoHash(int chave) {
        return chave % M;
    }

    public int inserir(Eleitor eleitorNovo) {
        int aux = -1;
        int hash = funcaoHash(eleitorNovo.getNumeroTitulo());
        if (tabelaEleiores[hash] != null) {
            Eleitor prod = tabelaEleiores[hash].localizar(eleitorNovo.getNumeroTitulo());
            if (prod == null) {
                tabelaEleiores[hash].inserirFinal(eleitorNovo);
                aux = hash;
            }
        } else {
            tabelaEleiores[hash] = new ListaEleitores();
            tabelaEleiores[hash].inserirFinal(eleitorNovo);
            aux = hash;
        }
        return aux;
    }

    public Eleitor pesquisar(int numero) {
        Eleitor prod = null;
        int hash = funcaoHash(numero);
        if (tabelaEleiores[hash] != null) {
            prod = tabelaEleiores[hash].localizar(numero);
        }
        return prod;
    }
}
