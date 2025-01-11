//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        HashSet<Character> container = new HashSet<>(); 
        int left = 0, maxLen = 0; 
        for(int right = 0; right < s.length(); right++) { 
            while(container.contains(s.charAt(right))) { 
                container.remove(s.charAt(left)); 
                left++; 
            }
            container.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1); 
        }
        return maxLen;
    }
}