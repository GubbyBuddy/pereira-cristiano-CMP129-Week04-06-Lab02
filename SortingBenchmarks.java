/*Cristiano Periera
  26FA15 Computer Science II (CMP-129-80231) 
  Weeks 4 and 6, Lab 2
  10/12/2026
*/
import java.util.Random;

public class SortingBenchmarks {
    public static void main(String[] args) {
        int[] array1 = new int[20];
        int[] array2 = new int[20];
        Random random = new Random();
        for (int j = 0; j < 20; j++) {
            array1[j] = random.nextInt(100);
            array2[j] = array1[j];
        }
        int bubbleExchanges = bubbleSort(array1);
        System.out.println("Bubble Sort Results");
        System.out.print("Sorted array: ");
        for (int v : array1) System.out.print(v + " ");
        System.out.println("\nNumber of exchanges: " + bubbleExchanges + "\n");

        int selectionExchanges = selectionSort(array2);
        System.out.println("selection Sort Results");
        System.out.print("Sorted array: ");
        for (int v : array2) System.out.print(v + " ");
        System.out.println("\nNumber of exhcanges: " + selectionExchanges + "\n");

        if (bubbleExchanges < selectionExchanges) {
            System.out.println("Bubble sort made less exchanges.");
        } else if (selectionExchanges < bubbleExchanges) {
            System.out.println("Selection sort made less exchanges.");
        } else {
            System.out.println("Both algorithms made the same amount of exchanges.");
        }
    }
    public static int bubbleSort(int[] array) {
        int exchanges = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    exchanges++;
                }
            }
        }
        return exchanges;
    }
    public static int selectionSort(int[] array) {
        int exchanges = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
                exchanges++;
            }
        }
        return exchanges;
    }
}
