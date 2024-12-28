class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long maxSum = 0;
        long currentSum = 0;
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0, start = 0; i < n; i++) {
            // Add the current element to the window
            while (set.contains(nums[i])) {
                // Remove the leftmost element until the duplicate is removed
                set.remove(nums[start]);
                currentSum -= nums[start];
                start++;
            }
            
            // Add the current element
            set.add(nums[i]);
            currentSum += nums[i];
            
            // Check if the window size is exactly k
            if (set.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
                
                // Slide the window forward by removing the leftmost element
                set.remove(nums[start]);
                currentSum -= nums[start];
                start++;
            }
        }
        
        return maxSum;
    }
}
