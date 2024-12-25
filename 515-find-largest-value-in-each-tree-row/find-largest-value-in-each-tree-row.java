/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> container = new ArrayList<>();
        if (root == null) return container;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int len = q.size(); // Number of nodes at the current level
            int maxElement = Integer.MIN_VALUE;

            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll(); // Remove the front element in the queue
                maxElement = Math.max(maxElement, node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            container.add(maxElement);
        }

        return container;
    }
}