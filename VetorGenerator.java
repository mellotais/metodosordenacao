package atividade;

import java.util.Arrays;
import java.util.Random;

public class VetorGenerator {

    public static int[] generateSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
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

    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] sortedArray = generateSortedArray(10);
        int[] reversedArray = generateReversedArray(10);
        int[] randomArray = generateRandomArray(10);

        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
        System.out.println("Reversed Array: " + Arrays.toString(reversedArray));
        System.out.println("Random Array: " + Arrays.toString(randomArray));
    }
}
