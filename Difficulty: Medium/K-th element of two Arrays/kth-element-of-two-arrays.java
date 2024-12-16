//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] a = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                a[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] b = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                b[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(a, b, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int indexA = 0;
        int indexB = 0;

        // Iterate k times to find the kth smallest element
        while (k > 0) {
            // Edge case: If one of the arrays is exhausted
            if (indexA >= a.length) {
                return b[indexB + k - 1];
            }
            if (indexB >= b.length) {
                return a[indexA + k - 1];
            }

            // Compare elements from both arrays and decide
            if (a[indexA] < b[indexB]) {
                if (k == 1) return a[indexA];
                indexA++;
            } else {
                if (k == 1) return b[indexB];
                indexB++;
            }
            k--; // Reduce k after considering an element
        }
        return -1;
    }
}