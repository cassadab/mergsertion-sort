public class ArrayGenerator {

    /**
     * Generates a best case array (already in order
     * @param size How large the array should be
     * @return A sorted array of specified size
     */
    public int[] bestCase(int size) {
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * Generates a worst case array (descending order)
     * @param size How large the array should be
     * @return An array of specified size in descending order
     */
    public int[] worstCase(int size) {
        int arr[] = new int[size];
        int num = size;
        for (int i = 0; i < size; i++) {
            arr[i] = num - i;
        }
        return arr;
    }

    /**
     * Generates an array with random numbers and a specified size
     * @param size How large the array should be
     * @return An array with random integers
     */
    public int[] randomArray(int size) {
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        return arr;
    }
}
