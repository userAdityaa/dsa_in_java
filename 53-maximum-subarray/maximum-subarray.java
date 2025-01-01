class Solution {
    public int maxSubArray(int[] nums) {
        int maxNumber = Integer.MIN_VALUE; 
        int sum = 0; 
        for(int i = 0; i < nums.length; i++) { 
            sum += nums[i];
            maxNumber = Math.max(maxNumber, sum); 
            if(sum < 0) sum = 0; 
        }
        return maxNumber;
    }
}