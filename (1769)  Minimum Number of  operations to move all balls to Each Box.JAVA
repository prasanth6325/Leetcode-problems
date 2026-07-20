class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length(), ans[] = new int[n], balls = 0, ops = 0;
        for (int i = 0; i < n; i++) { // L→R
            ans[i] += ops;
            ops += balls += boxes.charAt(i) - '0';
        }
        balls = ops = 0;
        for (int i = n - 1; i >= 0; i--) { // R→L
            ans[i] += ops;
            ops += balls += boxes.charAt(i) - '0';
        }
        return ans;
    }
}
