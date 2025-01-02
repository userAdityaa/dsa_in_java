//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            int res = new Solution().countSubarrays(arr, k);

            System.out.print(res);
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public int countSubarrays(int nums[], int k) {
        // code here
        int count = 0;
        int n = nums.length; 
        for(int i = 1; i < n; i++) nums[i] += nums[i - 1]; 
        HashMap<Integer, Integer> container = new HashMap<>(); 
        for(int i = 0; i < n; i++) { 
            if(nums[i] == k) count++; 
            int rem = nums[i] - k; 
            if(container.containsKey(rem)) count += container.get(rem); 
            if(container.containsKey(nums[i])) { 
                int freq = container.get(nums[i]); 
                container.put(nums[i], freq + 1); 
            }
            else { 
                container.put(nums[i], 1); 
            }
        }
        return count;
    }
}