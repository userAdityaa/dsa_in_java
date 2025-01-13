class Solution {
    public int minimumLength(String s) {
        int[] charFreq = new int[26]; 
        int totalLength = 0; 
        for(char c: s.toCharArray()){
            charFreq[c - 'a']++;
        }
        for(int freq: charFreq) { 
            if(freq == 0) continue; 
            if(freq % 2== 0) { 
                totalLength += 2; 
            }
            else { 
                totalLength += 1; 
            }
        }
        return totalLength;
    }
}