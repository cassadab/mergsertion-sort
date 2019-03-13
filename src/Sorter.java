import java.sql.SQLOutput;

public class Sorter {
    public static int[] insertionSort(int[] sequence) {
        for(int i = 1; i < sequence.length; i++) {
            int key = sequence[i];
            int j = i - 1;
            while(j >= 0 && sequence[j] > key) {
                sequence[j + 1] = sequence[j];
                j--;
            }
            sequence[j + 1] = key;
        }
        return sequence;
    }

    public static int[] mergeSort(int[] sequence, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;

            mergeSort(sequence, p, q);
            mergeSort(sequence, q + 1, r);

            merge(sequence, p, q, r);

        }
        return sequence;
    }

    private static void merge(int[] sequence, int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;

        int P[] = new int[n1];

        int R[] = new int[n2];

        for(int i = 0; i < n1; i++) {
            P[i] = sequence[p + i];
        }
        for(int i = 0; i < n2; i++) {
            R[i] = sequence[q + i];
        }
        printArray(R);

        int i = 0, j = 0; // sub array "pointers"

        int k = 1; // merged array pointer

        while(i < n1 && j < n2) {
            if (P[i] <= R[j]) {
                sequence[k] = P[i];
                i++;
            } else {
                sequence[k] = R[j];
                j++;
            }
            k++;
        }
    }


    public static void printArray(int[] sequence) {
        System.out.print("{ ");
        for(int x: sequence) {
            System.out.print(x + ", ");
        }
        System.out.println("}");
    }
}
