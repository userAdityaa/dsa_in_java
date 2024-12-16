class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0; 
        int right = 0; 
        int maxLen = 0; // Initialize maxLen to 0
        HashSet<Character> container = new HashSet<>(); 
        
        while (right < s.length()) { 
            if (!container.contains(s.charAt(right))) { 
                container.add(s.charAt(right)); 
                right++; 
                maxLen = Math.max(maxLen, right - left); // Update maxLen
            } else { 
                container.remove(s.charAt(left)); 
                left++; // Move the left pointer to shrink the window
            }
        }
        
        return maxLen; // No need for special cases
    }
}
