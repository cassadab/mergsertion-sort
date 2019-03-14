public class Main {

    public static void main(String[] args) {
        runTests(1000);
    }

    public static void printArray(int[] sequence) {
        System.out.print("{ ");
        for (int x : sequence) {
            System.out.print(x + ", ");
        }
        System.out.println("}");
    }


    /**
     * Little method that runs a bunch of trials for a variety of sizes
     *
     * @param trials
     */
    public static void runTests(int trials) {
        System.out.println("TOTAL TRIALS: " + trials);
        System.out.println("n\tminTime\taverageTime");
        for (int size = 1; size < 1000; size++) {
            runXTrials(size, 1000);
        }
        for (int size = 1000; size < 10001; size = size + 500) {
            runXTrials(size, 1000);
        }

        runXTrials(100000, 100);

    }

    /**
     * Prints out sorting times for an array of specified size over a specified number of trials
     *
     * @param size   How large the array should be
     * @param trials How many trials to run for each size
     */
    private static void runXTrials(int size, int trials) {
        double min = Double.MAX_VALUE;
        double totalTimeInSeconds = 0;
        double averageTimeInSeconds;
        ArrayGenerator arrayGenerator = new ArrayGenerator();
        Sorter sorter = new Sorter();
        for (int i = 0; i < trials; i++) {
//            int[] arr = arrayGenerator.worstCase(size);
//            int[] arr = arrayGenerator.randomArray(size);
            int[] arr = arrayGenerator.bestCase(size);
            long startTime = System.nanoTime();
//            sorter.insertionSort(arr);
//            sorter.mergeSort(arr, 0, arr.length - 1);
            sorter.mergeSertionSort(arr, 0, arr.length - 1);
            long endTime = System.nanoTime();
            double timeThisTrial = (endTime - startTime) / 1e9;
            if (timeThisTrial < min) {
                min = timeThisTrial;
            }
            totalTimeInSeconds += timeThisTrial;
        }
        averageTimeInSeconds = totalTimeInSeconds / trials;
        System.out.println(size + "\t" + min + "\t" + averageTimeInSeconds);
    }
}
