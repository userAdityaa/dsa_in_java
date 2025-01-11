//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String temp[] = sc.nextLine().trim().split(" ");
            int n = temp.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(temp[i]);
            Solution ob = new Solution();
            System.out.println(ob.maxSumIS(arr));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxSumIS(int nums[]) {
        // code here.
        if(nums == null || nums.length == 0) return 0; 
        int[] dp = new int[nums.length]; 
        for(int i = 0; i < nums.length; i++) dp[i] = nums[i]; 
        for(int i = 1; i < nums.length; i++) { 
            for(int j = 0; j < i; j++) { 
                if(nums[j] < nums[i]) { 
                    dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                }
            }
        }
        int maxSum = 0; 
        for(int sum: dp) maxSum = Math.max(maxSum, sum); 
        return maxSum;
    }
}