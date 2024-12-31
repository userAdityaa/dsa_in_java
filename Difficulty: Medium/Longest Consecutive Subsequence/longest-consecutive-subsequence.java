//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        Arrays.sort(arr); 
        int start = arr[0]; 
        int len = 1; 
        int maxLen = 1; 
        for(int i = 1; i < arr.length; i++) {
            if(start == arr[i]) continue; 
            if(start + 1 == arr[i]) { 
                len++; 
                start = arr[i];
                continue;
            }
            else { 
                maxLen = Math.max(maxLen, len);
                len = 1;
                start = arr[i]; 
            }
        }
        maxLen = Math.max(maxLen, len);
        return maxLen;
    }
}