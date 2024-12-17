//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the newline
        while (t-- > 0) {
            int k = sc.nextInt();
            sc.nextLine(); // consume the newline
            String input = sc.nextLine();
            String[] strNumbers = input.split(" ");
            int[] arr = new int[strNumbers.length];
            for (int i = 0; i < strNumbers.length; i++) {
                arr[i] = Integer.parseInt(strNumbers[i]);
            }
            Solution ob = new Solution();
            int res = ob.binarysearch(arr, k);
            System.out.println(res);

            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int binarySearch(int[] arr, int k) { 
        int start = 0; 
        int end = arr.length - 1; 
        int result = -1; 
        while(start <= end) { 
            int mid = start + (end - start) / 2; 
            if(arr[mid] == k) { 
                result =  mid; 
                end = mid - 1;
            }
            else if(arr[mid] > k) { 
                end = mid - 1; 
            }
            else { 
                start = mid + 1; 
            }
        }
        return result;
    }

    public int binarysearch(int[] arr, int k) {
        // Code Here
        return binarySearch(arr, k);
    }
}