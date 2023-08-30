import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        MatrizComPilha matrizComPilha = new MatrizComPilha(10, 10); //instancia

        System.out.println("Matriz original:");
        matrizComPilha.imprimirMatriz();

        System.out.println("\nMatriz após preenchimento:");
        matrizComPilha.excluirEIncrementar(2);
        matrizComPilha.imprimirMatriz();
    }
}
