class Solution {
    public int secondHighest(String s) {
        TreeSet<Integer> digits = new TreeSet<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) { 
                digits.add(c - '0');  
            }
        }
        if (digits.size() < 2) {
            return -1;
        }

        digits.pollLast();  
        return digits.last();
    }
}