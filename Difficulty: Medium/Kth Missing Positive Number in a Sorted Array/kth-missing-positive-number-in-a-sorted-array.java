//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.kthMissing(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    public int kthMissing(int[] arr, int k) {
        // code here
        Set<Integer> s = new HashSet<>();
        for(int i : arr){
            s.add(i);
        }
        
        int[] arr2 = new int[k];
        
        int temp = 1;
        int x = 0;
        
        while(x<k){
            if(s.contains(temp)){
                temp++;
            }
            else{
                arr2[x] = temp;
                x++;
                temp++;
            }
        }
        
        return arr2[arr2.length-1];
    }
}