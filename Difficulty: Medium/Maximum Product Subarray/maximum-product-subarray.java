//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        // code here
        long maxProd = arr[0]; 
        long minProd = arr[0]; 
        long result = arr[0]; 
        for(int i = 1; i < arr.length; i++) { 
            if(arr[i] < 0) { 
                long temp = maxProd; 
                maxProd = minProd; 
                minProd = temp;
            }
            maxProd = Math.max(arr[i], maxProd * arr[i]); 
            minProd = Math.min(arr[i], minProd * arr[i]); 
            result = Math.max(result, maxProd);
        }
        return (int)result;
    }
}