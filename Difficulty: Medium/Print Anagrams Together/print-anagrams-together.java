//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<>(); 
        for(String i: arr) { 
            ArrayList<Character> temp = new ArrayList<>(); 
            for(char c: i.toCharArray()) temp.add(c); 
            Collections.sort(temp); 
            String s = ""; 
            for(char p: temp) s += p; 
            if(map.containsKey(s)) { 
                map.get(s).add(i);
            }
            else { 
                map.put(s, new ArrayList<>()); 
                map.get(s).add(i);
            }
        }
        ArrayList<ArrayList<String>> result = new ArrayList<>(); 
        for(String s: map.keySet()) { 
            result.add(map.get(s));
        }
        return result;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends