//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
class Solution {
    static ArrayList<Integer> search(String pat, String txt) {
        // Code here
        String lowerTxt = txt.toLowerCase();
        String lowerPat = pat.toLowerCase();

        ArrayList<Integer> container = new ArrayList<>();

        int txtLength = lowerTxt.length();
        int patLength = lowerPat.length();

        // Sliding window approach
        for (int i = 0; i <= txtLength - patLength; i++) {
            if (lowerTxt.substring(i, i + patLength).equals(lowerPat)) {
                container.add(i);
            }
        }

        return container;
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.search(patt, s);
            System.out.print("[");
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i));
                if (i != res.size() - 1) System.out.print(",");
            }
            System.out.println("]");
            System.out.println("~");
        }
    }
}
// } Driver Code Ends