class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101]; // since 0 <= nums[i] <= 100
        int[] result = new int[nums.length];

        // Count frequency of each number
        for (int num : nums) {
            count[num]++;
        }

        // Build prefix sum to know how many numbers are smaller
        for (int i = 1; i < 101; i++) {
            count[i] += count[i - 1];
        }

        // For each number, result is count[num - 1]
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] == 0 ? 0 : count[nums[i] - 1];
        }

        return result;
    }
}
