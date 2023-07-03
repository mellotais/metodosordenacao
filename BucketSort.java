package atividade;

import java.util.Random;

public class BucketSort {
    private static int comparacoes;
    private static int trocas;

    private static void resetContadores() {
        comparacoes = 0;
        trocas = 0;
    }

    private static void incrementarComparacoes() {
        comparacoes++;
    }

    private static void incrementarTrocas() {
        trocas++;
    }

    public static void bucketSort(int[] array) {
        if (array.length <= 1) {
            return;
        }

        resetContadores();

        ListaEncadeada[] buckets = new ListaEncadeada[array.length];

        int maiorValor = array[0];
        for (int i : array) {
            if (i > maiorValor)
                maiorValor = i;
        }

        for (int i = 0; i < array.length; i++) {   // aqui são realizadas as comparações
            int indiceBucket = array[i] * buckets.length / (maiorValor + 1);
            if (indiceBucket < 0) {
                indiceBucket = 0;
            } else if (indiceBucket >= buckets.length) {
                indiceBucket = buckets.length - 1;
            }

            if (buckets[indiceBucket] == null) {
                buckets[indiceBucket] = new ListaEncadeada();
            }
            buckets[indiceBucket].inserirOrdenado(array[i]);
            incrementarComparacoes();
        }

        int index = 0;
        for (int i = 0; i < buckets.length; i++) { // aqui as trocas são incrementadas
            if (buckets[i] != null) {
                Nodo aux = buckets[i].getInicio();
                while (aux != null) {
                    array[index++] = aux.getDado();
                    aux = aux.getProx();
                    incrementarTrocas();
                }
            }
        }
    }

    public static void testBucketSort(int[] array, String algorithm, String arrayType) {
        System.out.println("Algoritmo: " + algorithm);
        System.out.println("Tipo de vetor: " + arrayType);
        
        long startTime = System.currentTimeMillis();
        bucketSort(array);
        long endTime = System.currentTimeMillis();

       System.out.println("Tempo de execução: " + (endTime - startTime) + "ms");
        System.out.println("Número de comparações: " + comparacoes);
        System.out.println("Número de trocas: " + trocas);
        System.out.println("------------------------------------");
    }

    public static void main(String[] args) {
        int[] array1 = generateRandomArray(10000);
        int[] array2 = generateRandomArray(1000000);
        int[] array3 = generateSortedArray(10000);
        int[] array4 = generateSortedArray(1000000);
        int[] array5 = generateReversedArray(10000);
        int[] array6 = generateReversedArray(1000000);

        testBucketSort(array1, "BucketSort", "Vetor Aleatório (10.000)");
        testBucketSort(array2, "BucketSort", "Vetor Aleatório (1.000.000)");
        testBucketSort(array3, "BucketSort", "Vetor Crescente (10.000)");
        testBucketSort(array4, "BucketSort", "Vetor Crescente (1.000.000)");
        testBucketSort(array5, "BucketSort", "Vetor Decrescente (10.000)");
        testBucketSort(array6, "BucketSort", "Vetor Decrescente (1.000.000)");
    }

    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }

    public static int[] generateSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    public static int[] generateReversedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }
        return array;
    }
}
