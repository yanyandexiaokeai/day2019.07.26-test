class Node{
    char val;
    Node left;
    Node right;
    public Node(char val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class FindVal {
    Node find(Node root, char value) {
        if (root == null) {
            return null;
        }
        if (root.val == value) {
            return root;
        }
        Node r = find(root.left, value);
        if (r != null) {
            return r;
        }
        r = find(root.right, value);
        if (r != null) {
            return r;
        }
        return null;
    }
    boolean find(Node root,int val){
        if (root == null){
            return false;
        }
        if (root.val == val){
            return true;
        }
        if (find(root.left,val)){
            return true;
        }
        if (find(root.right,val)){
            return true;
        }
        return false;

    }
}