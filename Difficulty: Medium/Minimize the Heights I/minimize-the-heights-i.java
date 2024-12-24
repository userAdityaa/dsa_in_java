//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String input = br.readLine().trim();
            int k = Integer.parseInt(br.readLine().trim());

            // Split the input line into integers and store them in the array
            String[] tokens = input.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the getMinDiff method
            int res = ob.getMinDiff(arr, k);

            // Print the result
            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int getMinDiff(int[] arr, int k) {
        // code here
        int n = arr.length;
        if (n == 1) return 0;
    
        // Step 1: Sort the array
        Arrays.sort(arr);
    
        // Initialize the maximum difference
        int result = arr[n - 1] - arr[0];
    
        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;
    
        for (int i = 0; i < n - 1; i++) {
            int minHeight = Math.min(smallest, arr[i + 1] - k);
            int maxHeight = Math.max(largest, arr[i] + k);
            result = Math.min(result, maxHeight - minHeight);
        }
    
        return result;
    }
}