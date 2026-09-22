package week4.practiceproblems;
    public class ContainsDuplicateChecker {

        public static boolean containsDuplicate(int[] nums) {
            // Compare every pair of positions
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        return true; // duplicate found, exit early
                    }
                }
            }
            return false; // no duplicates found
        }

        public static void main(String[] args) {
            // Sample inputs
            int[] nums1 = {1, 2, 3, 1};
            System.out.println(containsDuplicate(nums1)); // true

            int[] nums2 = {1, 2, 3, 4};
            System.out.println(containsDuplicate(nums2)); // false
        }
    }

