//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
class Solution {

    int countPairs(int arr[], int target) {
        // Your code here
        HashMap<Integer, Integer> container = new HashMap<>();
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            int value = target - arr[i];  // The complement that would sum to target
            
            // If complement exists in the map, add its frequency to counter
            if (container.containsKey(value)) {
                counter += container.get(value);
            }
            
            // Add the current element to the map, increasing its frequency
            container.put(arr[i], container.getOrDefault(arr[i], 0) + 1);
        }
        
        return counter;
    }
}

//{ Driver Code Starts.

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine());

            Solution obj = new Solution();

            System.out.println(obj.countPairs(nums, target));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends