//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.rotateby90(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to rotate matrix anticlockwise by 90 degrees.
    static void rotateby90(int mat[][]) {
        // code here
        int container[][] = new int[mat.length][mat.length]; 
        for(int i = 0; i < mat.length; i++) { 
            int rowCount = mat.length - (i + 1); 
            for(int j = 0; j < mat[i].length; j++) { 
                container[i][j] = mat[j][rowCount];
            }
        }
        for(int i = 0; i < container.length; i++) { 
            for(int j = 0; j < container[i].length; j++) { 
                mat[i][j] = container[i][j]; 
            }
        }
        return;
    }
}