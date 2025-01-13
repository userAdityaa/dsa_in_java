//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends

 
// User function Template for Java

class Solution {
    static boolean isPalindrome(String s,int i,int j){
        int l=i;
        int h=j;
        while(l<h){
            if(s.charAt(l)!=s.charAt(h)){
                return false;
            }
            l++;
            h--;
        }
        return true;
    }
    static int solve(String s, int i, int j, Integer dp[][]) { 
        if(i > j || isPalindrome(s, i, j)) return 0; 
        if(dp[i][j] != null) return dp[i][j]; 
        int min = Integer.MAX_VALUE; 
        for(int k = i; k < j; k++) {
            if(isPalindrome(s, i, k)) { 
                int temp = 1 + solve(s, k + 1, j, dp); 
                min = Math.min(min, temp);
            }
        }
        return dp[i][j] = min;
    }
    static int palindromicPartition(String s) {
        // code here: 
        int i = 0; 
        int j = s.length(); 
        Integer[][] dp = new Integer[j][j]; 
        return solve(s, i, j - 1, dp);
    }
}