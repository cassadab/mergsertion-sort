public class Sorter {

    /**
     * Sorts an array using the insertion sort algorithm
     * @param sequence Array to be sorted
     * @return A sorted array
     */
    public int[] insertionSort(int[] sequence) {
        for (int i = 1; i < sequence.length; i++) {
            int key = sequence[i];
            int j = i - 1;
            while (j >= 0 && sequence[j] > key) {
                sequence[j + 1] = sequence[j];
                j--;
            }
            sequence[j + 1] = key;
        }
        return sequence;
    }

    /**
     * Method that actually carries out the merging process
     * @param sequence Array to be merged
     * @param start Starting index of array
     * @param middle Middle index of array
     * @param end Ending index of array
     */
    private void merge(int sequence[], int start, int middle, int end) {
        int n1 = middle - start + 1;
        int n2 = end - middle;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++) {
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

    /**
     * Recursive merge sort function
     * @param sequence Array to be sorted
     * @param start Starting index of array
     * @param end Ending index of array
     */
    public void mergeSort(int sequence[], int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;

            mergeSort(sequence, start, mid);
            mergeSort(sequence, mid + 1, end);

            merge(sequence, start, mid, end);
        }
    }

    /**
     * Combines merge and insertion sort, where appropriate
     *
     * @param sequence Array to be storted
     * @param start Starting index of array
     * @param end Ending index of array
     */
    public void mergeSertionSort(int sequence[], int start, int end) {

        if (sequence.length < 600) {
            insertionSort(sequence);
        } else {
            if (start < end) {
                int mid = (start + end) / 2;
                mergeSertionSort(sequence, start, mid);
                mergeSertionSort(sequence, mid + 1, end);
                merge(sequence, start, mid, end);
            }
        }
    }

}


