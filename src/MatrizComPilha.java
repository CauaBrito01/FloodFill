public class MatrizComPilha {
    public static int[][] matriz; // Matriz bidimensional de enteros.
    public static Pilha pilha;    // Instancia de la clase Pilha (estructura de datos de pila).

    // Constructor que recibe el número de filas y columnas.
    public MatrizComPilha(int linhas, int colunas) {
        matriz = new int[linhas][colunas]; // Crea una matriz de tamaño linhas x colunas.
        pilha = new Pilha(linhas);         // Crea una instancia de la clase Pilha con un tamaño igual al número de filas.
        preencherMatriz();                 // Llama al método preencherMatriz para inicializar la matriz con unos.
        marcarLinhaDivisoria();            // Llama al método marcarLinhaDivisoria para establecer una línea diagonal de ceros.
    }

    // Llena la matriz con unos.
    public void preencherMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = 1;
            }
        }
    }

    // Establece una línea diagonal de ceros en la matriz y guarda las posiciones en la pila.
    public void marcarLinhaDivisoria() {
        for (int i = 0; i < matriz.length; i++) {
            int j = i;
            matriz[i][j] = 0;     // Establece un cero en la posición (i, i).
            pilha.push(i);        // Guarda la posición (i, i) en la pila.
        }
    }

    // Imprime la matriz en la consola.
    public void imprimirMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Imprime la matriz en un paso específico.
    public void imprimirPassoMatriz(int passo) {
        System.out.println("Passo " + passo + ":");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println();
    }

    // Realiza un relleno en la matriz a partir de una posición específica usando una pila.
    public void fillFunction(int linha, int coluna) {
        int passo = 1;

        if (matriz[linha][coluna] != 0) {
            matriz[linha][coluna] = 2; // Marca la posición inicial como 2.

            imprimirPassoMatriz(passo++);

            Pilha positionsToCheck = new Pilha(matriz.length * matriz[0].length);
            positionsToCheck.push(linha * matriz[0].length + coluna);

            while (!positionsToCheck.isEmpty()) {
                int position = positionsToCheck.pop();
                int row = position / matriz[0].length;
                int col = position % matriz[0].length;

                int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow >= 0 && newRow < matriz.length &&
                            newCol >= 0 && newCol < matriz[0].length &&
                            matriz[newRow][newCol] == 1) {
                        matriz[newRow][newCol] = 2;
                        positionsToCheck.push(newRow * matriz[0].length + newCol);
                        imprimirPassoMatriz(passo++);
                    }
                }
            }
        }
    }

    // Realiza un relleno en la matriz a partir de una posición específica usando una fila.
    public void fillFunctionFila(int linha, int coluna) {
        int passo = 1;

        if (matriz[linha][coluna] != 0) {
            matriz[linha][coluna] = 2;

            imprimirPassoMatriz(passo++);

            Fila positionsToCheck = new Fila(matriz.length * matriz[0].length);
            positionsToCheck.insert(linha * matriz[0].length + coluna);

            while (!positionsToCheck.isEmpty()) {
                int position = positionsToCheck.remove();
                int row = position / matriz[0].length;
                int col = position % matriz[0].length;

                int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow >= 0 && newRow < matriz.length &&
                            newCol >= 0 && newCol < matriz[0].length &&
                            matriz[newRow][newCol] == 1) {
                        matriz[newRow][newCol] = 2;
                        positionsToCheck.insert(newRow * matriz[0].length + newCol);
                        imprimirPassoMatriz(passo++);
                    }
                }
            }
        }
    }
}
