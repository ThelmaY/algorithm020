/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    
    ArrayList<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {

        //1. 迭代写法
        // Deque<Node> stack = new LinkedList();
        // ArrayList<Integer> res = new ArrayList();

        // if (root != null){
        //     stack.push(root);
        // }
        // while (!stack.isEmpty()){
        //     Node node = stack.pop();
        //     res.add(node.val);
        //     for (int i=node.children.size()-1;i>=0;i--){
        //         stack.push(node.children.get(i));
        //     }
        // }
        // return res;

        //2. 递归写法
        if (root == null) return res;
        res.add(root.val);
        for (int i = 0; i< root.children.size();i++){
            preorder(root.children.get(i));
        }
        return res;
    }
}