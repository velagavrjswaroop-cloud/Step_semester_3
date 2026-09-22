package week4.practiceproblems;
public class MergeSortedArrays {

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int[] result = new int[arr1.length + arr2.length];

        // Compare elements from both arrays
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // Copy remaining elements from arr1
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }

        // Copy remaining elements from arr2
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        // Sample inputs
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        int[] merged1 = mergeSortedArrays(arr1, arr2);
        System.out.println(java.util.Arrays.toString(merged1)); // [1, 2, 3, 4, 5, 6]

        int[] arr3 = {};
        int[] arr4 = {1, 2, 3};
        int[] merged2 = mergeSortedArrays(arr3, arr4);
        System.out.println(java.util.Arrays.toString(merged2)); // [1, 2, 3]
    }
}
