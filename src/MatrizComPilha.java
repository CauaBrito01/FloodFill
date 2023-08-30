public class MatrizComPilha {
    public static int[][] matriz; // Declara a matriz
    public static Pilha pilha; //Declara a pilha


    public MatrizComPilha(int linhas, int colunas) {
        matriz = new int[linhas][colunas]; // inicia a matriz com o número de linhas e colunas fornecido
        pilha = new Pilha(linhas);
        preencherMatriz();
        marcarLinhaDivisoria();
    }

    // preencher tudo com valores 1
    public void preencherMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = 1; // Atribuição do valor 1 à posição i, j da matriz
            }
        }
    }

    // metodo pra fazer a divisoria
    public void marcarLinhaDivisoria() {
        for (int i = 0; i < matriz.length; i++) {
            int j = i;// A coluna acompanha a linha para estar na diagonal quando for igual ele pega
            matriz[i][j] = 0;// Marca a posição da linha divisória com zero
            pilha.push(i);// Empilha o valor da linha
        }
    }

    // Método para excluir valores da matriz à direita da linha divisória e substituí-los por novoValor
    public void excluirEIncrementar(int novoValor) {
        while (!pilha.isEmpty()) {
            int linhaExcluida = pilha.pop(); // Desempilha o valor da linha
            for (int j = linhaExcluida + 1; j < matriz[0].length; j++) {
                matriz[linhaExcluida][j] = novoValor; // Substitui valores do lado direito da linha
            }
        }
    }

    // Método para imprimir a matriz
    public void imprimirMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "\t"); // Imprime o valor da posição i, j da matriz
            }
            System.out.println(); // Pula para a próxima linha após cada linha da matriz
        }
    }
}
