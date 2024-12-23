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
    private int solve(List<Integer> list) { 
        int count = 0; 
        List<Integer> listSort = new ArrayList(); 
        Map<Integer, Integer> map = new HashMap(); 
        for(int i = 0; i < list.size(); i++) { 
            map.put(list.get(i), i);
        }
        listSort.addAll(list); 
        Collections.sort(listSort);
        for(int i= 0; i < list.size(); i++) { 
            if(list.get(i) != listSort.get(i)) { 
                int ids = i; 
                int idx = map.get(listSort.get(i)); 
                Collections.swap(list, ids, idx); 
                map.put(list.get(ids), ids); 
                map.put(list.get(idx), idx); 
                count++;
            }
        }

        return count;
    }
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> container = new LinkedList<>(); 
        boolean[] visit = new boolean[100001]; 
        List<Integer> list; 
        int count = 0; 
        
        visit[root.val] = true; 
        container.add(root); 
        
        while(!container.isEmpty()) { 
            Queue<TreeNode> front = new LinkedList<>(); 
            front.addAll(container); 
            container.clear(); 

            list = new ArrayList(); 
            while(!front.isEmpty()) { 
                TreeNode node = front.poll(); 
                if(node.left != null && !visit[node.left.val]) { 
                    visit[node.left.val] = true; 
                    container.add(node.left); 
                    list.add(node.left.val);
                }
                if(node.right != null && !visit[node.right.val]) { 
                    visit[node.right.val] = true; 
                    container.add(node.right); 
                    list.add(node.right.val);
                }
            }
            count += solve(list); 
        }
        return count;
    }
}