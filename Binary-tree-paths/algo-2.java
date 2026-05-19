// Iterative DFS with StringBuilder

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

    public List<String> binaryTreePaths(TreeNode root) {

        // list to store all the paths
        List<String> paths = new ArrayList<>();

        // base case if root is null
        if (root == null) return paths;

        // 2 stacks to store the nodes and their paths
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<StringBuilder> pathStack = new Stack<>();

        // push the root and their path in the stack
        nodeStack.push(root);
        pathStack.push(new StringBuilder(Integer.toString(root.val)));

        // iterate through the node stack to reach the leaf nodes
        // iterate until the stack is empty
        while(!nodeStack.isEmpty()) {
            // pop the last node and the path
            TreeNode node = nodeStack.pop();
            StringBuilder path = pathStack.pop();

            // check if they are the leaf nodes
            if (node.left == null && node.right == null) {
                paths.add(path.toString());
                continue;
            }

            // check if the left node is not null
            // push the node to the stack
            // push the value to the path
            if (node.left != null) {
                nodeStack.push(node.left);
                StringBuilder leftPath = new StringBuilder(path);
                leftPath.append("->").append(node.left.val);
                pathStack.push(leftPath);
            }

            if (node.right != null) {
                nodeStack.push(node.right);
                StringBuilder rightPath = new StringBuilder(path);
                rightPath.append("->").append(node.right.val);
                pathStack.push(rightPath);
            }
        }

        return paths;
    }
}