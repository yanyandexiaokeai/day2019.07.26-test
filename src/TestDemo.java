public class TestDemo {
    public static void main(String[] args) {
        TestBinaryTree testBinaryTree = new TestBinaryTree();
        String str = "ABC##DE#G##F###";
        TestBinaryTree.TreeNode root =
                testBinaryTree.createTestTree(str);
        testBinaryTree.binaryTreePrevOrder(root);
        System.out.println("===============");
        testBinaryTree.binaryTreePrevOrderNonR(root);
        System.out.println("===============");
        testBinaryTree.binaryTreeInOrder(root);
        System.out.println("===============");
        testBinaryTree.binaryTreeInOrderNonR(root);
        System.out.println("===============");
        testBinaryTree.binaryTreePostOrder(root);
        System.out.println("===============");
        testBinaryTree.binaryTreePostOrderNonR(root);
        System.out.println("=========层序遍历=====");
        testBinaryTree.binaryTreeLevelOrder(root);
        System.out.println();
        int n = testBinaryTree.binaryTreeComplete(root);
        System.out.println(n);
        /*System.out.println();
        int ret = testBinaryTree.getSize(root);
        System.out.println(ret);//7
        ret = testBinaryTree.getLeafSize(root);
        System.out.println(ret);//3
        ret = testBinaryTree.getKLevelSize(root,3);
        System.out.println(ret);
        ret = testBinaryTree.height(root);
        System.out.println(ret);
        TestBinaryTree.TreeNode treeNode =
                testBinaryTree.find(root,'E');
        System.out.println(treeNode.val);*/
    }
}
