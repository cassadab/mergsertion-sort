public class Sorter {
    public int[] insertionSort(int[] sequence) {
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

    private void merge(int sequence[], int start, int middle, int end) {
        int n1 = middle - start + 1;
        int n2 = end - middle;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i<n1; i++) {
            L[i] = sequence[start + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = sequence[middle + 1 + j];
        }

        int i = 0;
        int j = 0;

        int k = start;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                sequence[k] = L[i];
                i++;
            } else {
                sequence[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            sequence[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            sequence[k] = R[j];
            j++;
            k++;
        }
    }

    public void mergeSort(int arr[], int l, int r) {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
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
