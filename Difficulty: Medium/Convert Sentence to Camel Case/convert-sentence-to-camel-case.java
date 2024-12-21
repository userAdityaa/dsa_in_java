//{ Driver Code Starts
// Initial Template for Java
import java.util.Scanner; // Import should be at the top of the file

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // Read the number of test cases
        sc.nextLine();        // Consume the newline character after reading the integer

        while (t-- > 0) {
            String s = sc.nextLine(); // Read the input string

            // Remove surrounding quotes from the string
            String str = s.substring(1, s.length() - 1);

            Solution obj = new Solution(); // Create an object of the Solution class
            String ans =
                obj.convertToCamelCase(str); // Convert the sentence to Camel Case

            // Print the result with surrounding quotes
            System.out.println("\"" + ans + "\"");
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to convert the given string to Camel Case
    public String convertToCamelCase(String sentence) {
        // code here
        String[] words = sentence.split(" ");
        
        // Initialize a StringBuilder to construct the Camel Case string
        StringBuilder camelCase = new StringBuilder();

        // Flag to track the first word
        boolean isFirstWord = true;

        // Loop through the words and process non-empty strings
        for (String word : words) {
            if (!word.isEmpty()) { // Skip empty strings
                if (isFirstWord) {
                    // Add the first word as is
                    camelCase.append(word);
                    isFirstWord = false;
                } else {
                    // Capitalize the first letter and append the rest of the word
                    camelCase.append(word.substring(0, 1).toUpperCase())
                             .append(word.substring(1));
                }
            }
        }

        // Return the Camel Case string
        return camelCase.toString();
        
    }
}