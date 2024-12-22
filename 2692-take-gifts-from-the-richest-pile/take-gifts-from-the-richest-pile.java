class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : gifts) { 
            maxHeap.add(i); 
        }
        while(k != 0) { 
            int value = maxHeap.poll(); 
            value = (int) Math.sqrt(value); 
            maxHeap.add(value); 
            k--; 
        }
        long value = 0; 
        while(!maxHeap.isEmpty()) { 
            value += maxHeap.poll(); 
        }
        return value;
    }
}