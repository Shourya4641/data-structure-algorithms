// Recursive DFS with String Building

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
    // create an empty list to store all the paths
    private List <String> treePaths = new ArrayList<>(); 

    // an empty list to store individual path
    private List <String> path = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root);

        return treePaths;
    }

    private void dfs (TreeNode root) {

        // base case when root is empty
        if (root == null) return;

        // add the node to the path
        path.add(root.val + "");

        // check if the node has child nodes
        // if no then add the path to the final tree path list
        // if yes then call the dfs() with both left and right node
        if (root.left == null && root.right == null) {
            treePaths.add(String.join("->",path));
        } else {
            dfs(root.left);

            dfs(root.right);
        }
        
        path.remove(path.size() - 1);
    }
}