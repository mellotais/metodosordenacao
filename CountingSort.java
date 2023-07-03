package atividade;

import java.util.Random;

public class CountingSort {

    public static int[] countingSort(int[] A, int k) {
        int[] C = new int[k + 1];

        // frequência
        for (int i = 0; i < A.length; i++) {
            C[A[i]] += 1;
        }

        // cumulativa
        for (int i = 1; i < C.length; i++) {
            C[i] += C[i - 1];
        }

        int[] B = new int[A.length];
        int comparacoes = 0;
        int trocas = 0;

        for (int i = A.length - 1; i >= 0; i--) { // aqui são feitas as trocas e comparações 
            B[C[A[i]] - 1] = A[i];               // (entretanto esse algoritimo não possui trocas nem comparações, foi improvisado)
            C[A[i]] -= 1;
            comparacoes++;
            trocas++;
        }

        System.out.println("Número de comparações: " + comparacoes);
        System.out.println("Número de trocas: " + trocas);

        return B;
    }

    public static void main(String[] args) {
        int tamanho1 = 100000;
        int tamanho2 = 1000000;

        int[] vetorOrdenado1 = new int[tamanho1];
        int[] vetorOrdenado2 = new int[tamanho2];
        int[] vetorInvertido1 = new int[tamanho1];
        int[] vetorInvertido2 = new int[tamanho2];
        int[] vetorAleatorio1 = new int[tamanho1];
        int[] vetorAleatorio2 = new int[tamanho2];

        // Preencher os vetores com valores
        for (int i = 0; i < tamanho1; i++) {
            vetorOrdenado1[i] = i + 1;
            vetorInvertido1[i] = tamanho1 - i;
            vetorAleatorio1[i] = new Random().nextInt(tamanho1); // Vetor com valores aleatórios de 0 a tamanho1
        }

        for (int i = 0; i < tamanho2; i++) {
            vetorOrdenado2[i] = i + 1;
            vetorInvertido2[i] = tamanho2 - i;
            vetorAleatorio2[i] = new Random().nextInt(tamanho2); // Vetor com valores aleatórios de 0 a tamanho2
        }

        // Vetor Ordenado 1
        System.out.println("Algoritmo: Counting Sort (Vetor Ordenado 100000)");
        long startTime = System.nanoTime();
        countingSort(vetorOrdenado1, tamanho1);
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("Tamanho do vetor: " + tamanho1);
        System.out.println("Tempo gasto (em nanosegundos): " + elapsedTime);

        // Vetor Invertido 1
        System.out.println("Algoritmo: Counting Sort (Vetor Invertido 100000)");
        startTime = System.nanoTime();
        countingSort(vetorInvertido1, tamanho1);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Tamanho do vetor: " + tamanho1);
        System.out.println("Tempo gasto (em nanosegundos): " + elapsedTime);

        // Vetor Aleatório 1
        System.out.println("Algoritmo: Counting Sort (Vetor Aleatório 100000)");
        startTime = System.nanoTime();
        countingSort(vetorAleatorio1, tamanho1);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Tamanho do vetor: " + tamanho1);
        System.out.println("Tempo gasto (em nanosegundos): " + elapsedTime);

        // Vetor Ordenado 2
        System.out.println("Algoritmo: Counting Sort (Vetor Ordenado 1000000)");
        startTime = System.nanoTime();
        countingSort(vetorOrdenado2, tamanho2);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Tamanho do vetor: " + tamanho2);
        System.out.println("Tempo gasto (em nanosegundos): " + elapsedTime);

        // Vetor Invertido 2
        System.out.println("Algoritmo: Counting Sort (Vetor Invertido 1000000)");
        startTime = System.nanoTime();
        countingSort(vetorInvertido2, tamanho2);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Tamanho do vetor: " + tamanho2);
        System.out.println("Tempo gasto (em nanosegundos): " + elapsedTime);

        // Vetor Aleatório 2
        System.out.println("Algoritmo: Counting Sort (Vetor Aleatório 1000000)");
        startTime = System.nanoTime();
        countingSort(vetorAleatorio2, tamanho2);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Tamanho do vetor: " + tamanho2);
        System.out.println("Tempo gasto (em nanosegundos): " + elapsedTime);
    }
}
