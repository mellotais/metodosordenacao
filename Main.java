package atividade;



public class Main {
    public static void main(String[] args) {
        int tamanho1 = 100000;
        int tamanho2 = 1000000;

        MetodosOrdenacao metodosOrdenacao = new MetodosOrdenacao();

        int[] vetorOrdenado1 = criarVetorOrdenado(tamanho1);
        int[] vetorOrdenado2 = criarVetorOrdenado(tamanho2);

        int[] vetorInvertido1 = criarVetorInvertido(tamanho1);
        int[] vetorInvertido2 = criarVetorInvertido(tamanho2);

        int[] vetorAleatorio1 = criarVetorAleatorio(tamanho1);
        int[] vetorAleatorio2 = criarVetorAleatorio(tamanho2);

        // Medição do Bubble Sort
        medirDesempenho(metodosOrdenacao, "Bubble Sort (Vetor Ordenado " + tamanho1 + ")", vetorOrdenado1);
        medirDesempenho(metodosOrdenacao, "Bubble Sort (Vetor Ordenado " + tamanho2 + ")", vetorOrdenado2);
        medirDesempenho(metodosOrdenacao, "Bubble Sort (Vetor Invertido " + tamanho1 + ")", vetorInvertido1);
        medirDesempenho(metodosOrdenacao, "Bubble Sort (Vetor Invertido " + tamanho2 + ")", vetorInvertido2);
        medirDesempenho(metodosOrdenacao, "Bubble Sort (Vetor Aleatório " + tamanho1 + ")", vetorAleatorio1);
        medirDesempenho(metodosOrdenacao, "Bubble Sort (Vetor Aleatório " + tamanho2 + ")", vetorAleatorio2);

        // Medição do Selection Sort
        medirDesempenho(metodosOrdenacao, "Selection Sort (Vetor Ordenado " + tamanho1 + ")", vetorOrdenado1);
        medirDesempenho(metodosOrdenacao, "Selection Sort (Vetor Ordenado " + tamanho2 + ")", vetorOrdenado2);
        medirDesempenho(metodosOrdenacao, "Selection Sort (Vetor Invertido " + tamanho1 + ")", vetorInvertido1);
        medirDesempenho(metodosOrdenacao, "Selection Sort (Vetor Invertido " + tamanho2 + ")", vetorInvertido2);
        medirDesempenho(metodosOrdenacao, "Selection Sort (Vetor Aleatório " + tamanho1 + ")", vetorAleatorio1);
        medirDesempenho(metodosOrdenacao, "Selection Sort (Vetor Aleatório " + tamanho2 + ")", vetorAleatorio2);

        // Medição do Insertion Sort
        medirDesempenho(metodosOrdenacao, "Insertion Sort (Vetor Ordenado " + tamanho1 + ")", vetorOrdenado1);
        medirDesempenho(metodosOrdenacao, "Insertion Sort (Vetor Ordenado " + tamanho2 + ")", vetorOrdenado2);
        medirDesempenho(metodosOrdenacao, "Insertion Sort (Vetor Invertido " + tamanho1 + ")", vetorInvertido1);
        medirDesempenho(metodosOrdenacao, "Insertion Sort (Vetor Invertido " + tamanho2 + ")", vetorInvertido2);
        medirDesempenho(metodosOrdenacao, "Insertion Sort (Vetor Aleatório " + tamanho1 + ")", vetorAleatorio1);
        medirDesempenho(metodosOrdenacao, "Insertion Sort (Vetor Aleatório " + tamanho2 + ")", vetorAleatorio2);

        // Medição do Merge Sort
        medirDesempenho(metodosOrdenacao, "Merge Sort (Vetor Ordenado " + tamanho1 + ")", vetorOrdenado1);
        medirDesempenho(metodosOrdenacao, "Merge Sort (Vetor Ordenado " + tamanho2 + ")", vetorOrdenado2);
        medirDesempenho(metodosOrdenacao, "Merge Sort (Vetor Invertido " + tamanho1 + ")", vetorInvertido1);
        medirDesempenho(metodosOrdenacao, "Merge Sort (Vetor Invertido " + tamanho2 + ")", vetorInvertido2);
        medirDesempenho(metodosOrdenacao, "Merge Sort (Vetor Aleatório " + tamanho1 + ")", vetorAleatorio1);
        medirDesempenho(metodosOrdenacao, "Merge Sort (Vetor Aleatório " + tamanho2 + ")", vetorAleatorio2);

        // Medição do Quick Sort
        medirDesempenho(metodosOrdenacao, "Quick Sort (Vetor Ordenado " + tamanho1 + ")", vetorOrdenado1);
        medirDesempenho(metodosOrdenacao, "Quick Sort (Vetor Ordenado " + tamanho2 + ")", vetorOrdenado2);
        medirDesempenho(metodosOrdenacao, "Quick Sort (Vetor Invertido " + tamanho1 + ")", vetorInvertido1);
        medirDesempenho(metodosOrdenacao, "Quick Sort (Vetor Invertido " + tamanho2 + ")", vetorInvertido2);
        medirDesempenho(metodosOrdenacao, "Quick Sort (Vetor Aleatório " + tamanho1 + ")", vetorAleatorio1);
        medirDesempenho(metodosOrdenacao, "Quick Sort (Vetor Aleatório " + tamanho2 + ")", vetorAleatorio2);

}

    private static void medirDesempenho(MetodosOrdenacao metodosOrdenacao, String algoritmo, int[] vetor) {
        long startTime = System.nanoTime();

        if (algoritmo.contains("Bubble Sort")) {
            metodosOrdenacao.bubbleSort(vetor);
        } else if (algoritmo.contains("Selection Sort")) {
            metodosOrdenacao.selectionSort(vetor);
        } else if (algoritmo.contains("Insertion Sort")) {
            metodosOrdenacao.insertionSort(vetor);
        } else if (algoritmo.contains("Merge Sort")) {
            metodosOrdenacao.mergeSort(vetor);
        } else if (algoritmo.contains("Quick Sort")) {
            metodosOrdenacao.quickSort(vetor);
        }

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        // Converter o tempo gasto em minutos
        double elapsedTimeMinutes = (double) elapsedTime / (60_000_000_000.0);

        // Imprima as informações relevantes ou armazene-as para posterior geração de gráficos
        System.out.println("Algoritmo: " + algoritmo);
        System.out.println("Tamanho do vetor: " + vetor.length);
        System.out.println("Tempo gasto (em minutos): " + elapsedTimeMinutes);
        System.out.println("Número de comparações: " + metodosOrdenacao.getComparacoes());
        System.out.println("Número de trocas: " + metodosOrdenacao.getTrocas());
        System.out.println();
    }
    private static int[] criarVetorOrdenado(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = i;
        }
        return vetor;
    }

    private static int[] criarVetorInvertido(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = tamanho - 1; i >= 0; i--) {
            vetor[tamanho - i - 1] = i;
        }
        return vetor;
    }

    private static int[] criarVetorAleatorio(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = (int) (Math.random() * tamanho);
        }
        return vetor;
    }
}
