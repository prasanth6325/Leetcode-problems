class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        int[] freq = new int[101]; // since 1 <= nums[i] <= 100

        for (int num : nums) {
            count += freq[num]; // each previous occurrence of num forms a good pair
            freq[num]++;
        }

        return count;
    }
}
