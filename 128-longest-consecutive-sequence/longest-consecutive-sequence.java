class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0; 
        Arrays.sort(nums); 
        int size = nums.length; 

        int first = nums[0]; 
        int length = 1; 
        int maxLen = 1; 

        for(int i = 1; i < size; i++) { 
            if(nums[i] == nums[i - 1]) continue; 
            if(nums[i] == first + 1) length++; 
            else { 
                maxLen = Math.max(maxLen, length); 
                length = 1; 
            }
            first = nums[i];
        }

        maxLen = Math.max(maxLen, length); 
        return maxLen;
    }
}