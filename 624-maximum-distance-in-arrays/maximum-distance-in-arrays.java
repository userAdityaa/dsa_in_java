class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int minElement = arrays.get(0).get(0);
        int maxElement = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDistance = 0;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> container = arrays.get(i);

            // Update maxDistance using current list's elements
            maxDistance = Math.max(maxDistance, Math.abs(maxElement - container.get(0)));
            maxDistance = Math.max(maxDistance, Math.abs(container.get(container.size() - 1) - minElement));

            // Update minElement and maxElement
            minElement = Math.min(minElement, container.get(0));
            maxElement = Math.max(maxElement, container.get(container.size() - 1));
        }

        return maxDistance;
    }
}
