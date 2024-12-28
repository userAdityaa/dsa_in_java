public class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] windowSum = new int[n - k + 1];
        int sum = 0;
        
        // Calculate sums of all subarrays of length k
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (i >= k) sum -= nums[i - k];
            if (i >= k - 1) windowSum[i - k + 1] = sum;
        }

        // Arrays to store best left and right indices
        int[] left = new int[windowSum.length];
        int[] right = new int[windowSum.length];
        
        // Calculate left array
        int best = 0;
        for (int i = 0; i < windowSum.length; i++) {
            if (windowSum[i] > windowSum[best]) best = i;
            left[i] = best;
        }
        
        // Calculate right array
        best = windowSum.length - 1;
        for (int i = windowSum.length - 1; i >= 0; i--) {
            if (windowSum[i] >= windowSum[best]) best = i;
            right[i] = best;
        }
        
        // Find the best combination of three subarrays
        int[] result = new int[3];
        int maxSum = 0;
        for (int mid = k; mid < windowSum.length - k; mid++) {
            int l = left[mid - k];
            int r = right[mid + k];
            int total = windowSum[l] + windowSum[mid] + windowSum[r];
            if (total > maxSum) {
                maxSum = total;
                result[0] = l;
                result[1] = mid;
                result[2] = r;
            }
        }
        
        return result;
    }
}
