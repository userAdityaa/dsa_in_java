class Solution {
    public int solve(int[] nums, int target, int index, int[][] dp) { 
        if(index == nums.length) return target == 0 ? 1 : 0; 
        if(target < -1000 || target > 1000) return 0; 
        if(dp[index][target + 1000] != -1) return dp[index][target + 1000]; 
        int plus = solve(nums, target - nums[index], index + 1, dp); 
        int sub = solve(nums, target + nums[index], index + 1, dp); 
        dp[index][target + 1000] = plus + sub; 
        return dp[index][target + 1000];
    }
    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[nums.length][2001];
        for(int i = 0; i < nums.length; i++) Arrays.fill(dp[i], -1);
        return solve(nums, target, 0, dp);
    }
}