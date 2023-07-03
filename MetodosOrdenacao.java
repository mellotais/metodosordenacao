package atividade;

import java.util.Arrays;

public class MetodosOrdenacao {
    private long comparacoes;
    private long trocas;

   public boolean bubbleSort(int vetor[]) {
        comparacoes = 0;
        trocas = 0;

        int temp = 0;
        boolean ordenado = false;
        for (int i = 0; i < vetor.length; i++) { //nesse for são feitas as comparações e trocas.
            for (int j = 0; j < vetor.length - i - 1; j++) {
                comparacoes++;
                if (vetor[j] > vetor[j + 1]) {
                    temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                    trocas++;
                }
            }
            ordenado = true;
            for (int k = 0; k < vetor.length - 1; k++) {
                comparacoes++;
                if (vetor[k] > vetor[k + 1]) {
                    ordenado = false;
                    break;
                }
            }
            if (ordenado) {
                break;
            }
        }
        return ordenado;
    }

    public int[] selectionSort(int vetor[]) {
        comparacoes = 0;
        trocas = 0;

        int min, temp;
        for (int i = 0; i < vetor.length - 1; i++) { 
            min = i;
            for (int j = i + 1; j < vetor.length; j++) { //nesse for são feitas as comparações e trocas.
                comparacoes++;
                if (vetor[j] < vetor[min]) {
                    min = j;
                }
            }
            temp = vetor[i];
            vetor[i] = vetor[min];
            vetor[min] = temp;
            trocas++;
        }
        return vetor;
    }

    public int[] insertionSort(int vetor[]) {
        comparacoes = 0;
        trocas = 0;

        int pivo, j;
        for (int i = 0; i < vetor.length; i++) { //nesse for são feitas as comparações e trocas.
            pivo = vetor[i];
            j = i - 1;
            while (j >= 0 && vetor[j] > pivo) {
                comparacoes++;
                vetor[j + 1] = vetor[j];
                j = j - 1;
                trocas++;
            }
            vetor[j + 1] = pivo;
            trocas++;
        }
        return vetor;
    }
    

        private int particionar(int[] vetor, int inicio, int fim) { // aqui são feitas as trocas e comparações
            int pivo = vetor[fim];
            int i = inicio - 1;
            for (int j = inicio; j < fim; j++) {
                comparacoes++;
                if (vetor[j] <= pivo) {
                    i++;
                    trocar(vetor, i, j);
                }
            }
            trocar(vetor, i + 1, fim);
            return i + 1;
        }

        public void quickSort(int[] vetor) {
            comparacoes = 0;
            trocas = 0;
            quickSort(vetor, 0, vetor.length - 1);
        }

        private void quickSort(int[] vetor, int inicio, int fim) {
            if (inicio < fim) {
                int posicaoPivo = particionar(vetor, inicio, fim);
                quickSort(vetor, inicio, posicaoPivo - 1);
                quickSort(vetor, posicaoPivo + 1, fim);
            }
        }

        private void trocar(int[] vetor, int i, int j) {
            int temp = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = temp;
            trocas++;
        }

    public void mergeSort(int vetor[]) {
        comparacoes = 0;
        trocas = 0;
        mergeSortRecursivo(vetor, 0, vetor.length - 1);
    }

    private void mergeSortRecursivo(int vetor[], int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSortRecursivo(vetor, inicio, meio);
            mergeSortRecursivo(vetor, meio + 1, fim);
            mesclar(vetor, inicio, meio, fim);
        }
    }

    private void mesclar(int vetor[], int inicio, int meio, int fim) {
        int[] vetorTemporario = Arrays.copyOf(vetor, vetor.length);

        int i = inicio;
        int j = meio + 1;
        int k = inicio;

        while (i <= meio && j <= fim) { //nesse while são feitas as comparações e trocas.
            comparacoes++;
            if (vetorTemporario[i] <= vetorTemporario[j]) {
                vetor[k] = vetorTemporario[i];
                i++;
            } else {
                vetor[k] = vetorTemporario[j];
                j++;
            }
            k++;
            trocas++;
        }

        while (i <= meio) {
            vetor[k] = vetorTemporario[i];
            i++;
            k++;
            trocas++;
        }
    }
    


    public long getComparacoes() {
        return comparacoes;
    }

    public long getTrocas() {
        return trocas;
    }
}
