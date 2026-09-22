package week4.practiceproblems;

public class RotateArray {

    public static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return nums;

        // Reduce k to avoid unnecessary rotations
        k = k % n;

        // Create new array
        int[] rotated = new int[n];

        // Place each element in its new position
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = nums[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        // Sample inputs
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        int[] result1 = rotateArray(nums1, k1);
        System.out.println(java.util.Arrays.toString(result1)); // [5, 6, 7, 1, 2, 3, 4]

        int[] nums2 = {1, 2};
        int k2 = 3;
        int[] result2 = rotateArray(nums2, k2);
        System.out.println(java.util.Arrays.toString(result2)); // [2, 1]
    }
}

