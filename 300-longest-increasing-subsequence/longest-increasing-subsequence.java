class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0; 
        int[] dp = new int[nums.length]; 
        Arrays.fill(dp, 1); 
        for(int i = 1; i < nums.length; i++) { 
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) { 
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int maxLTS = 0; 
        for(int len: dp) { 
            maxLTS = Math.max(maxLTS, len);
        }
        return maxLTS;
    }
}