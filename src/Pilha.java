public class Pilha {
    private int maxSize;
    private int[] stackArray;// Array que representa a pilha
    private int top;

    public Pilha(int size) {
        maxSize = size;
        stackArray = new int[maxSize]; // Cria um array com o tamanho máximo especificado
        top = -1;// Inicializa o índice do topo como -1 (pilha vazia)
    }

    public void push(int value) {
        if (top < maxSize - 1) {
            stackArray[++top] = value; // Adiciona um valor ao topo da pilha
        }
    }

    public int pop() {
        if (top >= 0) {
            return stackArray[top--]; // Remove e retorna o valor do topo da pilha
        } else {
            return -1; // Valor para indicar pilha vazia
        }
    }

    public boolean isEmpty() {
        return top == -1; // Retorna verdadeiro se o topo for -1 (pilha vazia), caso contrário, retorna falso
    }
}
