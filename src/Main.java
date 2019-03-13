public class Main {
    public static void main(String [] args) {
        int[] nums = {10, 2, 3, 3, 9, 11, 7};

        nums = Sorter.mergeSort(nums, 0,nums.length - 1 );

        for(int x: nums) {
            System.out.println(x);
        }
    }
}
