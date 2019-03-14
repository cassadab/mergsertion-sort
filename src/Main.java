public class Main {

    public static void main(String [] args) {
        int[] nums = {10, 9, 2, 3, 1, 1, 4, 5};

        Sorter sorter = new Sorter();
        sorter.mergeSort(nums, 0,nums.length - 1 );

        System.out.print("{ ");
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i != nums.length - 1) {
                System.out.print(", ");
            }
            else {
                System.out.print(" ");
            }
        }
        System.out.println("}");
    }
}
