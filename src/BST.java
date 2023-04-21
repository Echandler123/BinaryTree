import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Elijah Chandler
 * @version: 04/19/23
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        if(helpersearch(root,val) == false) {
            return false;
        }
        return true;
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        ArrayList<BSTNode> inorder = new ArrayList<BSTNode>();
        BSTNode current = root;
        helper(current,inorder);
        // TODO: Complete inorder traversal
        return inorder;
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> preorder = new ArrayList<BSTNode>();
        BSTNode current = root;
        helperpre(current,preorder);
        return preorder;
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> postorder = new ArrayList<BSTNode>();
        BSTNode current = root;
        helperpost(current,postorder);
        return postorder;
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
    public Boolean helpersearch(BSTNode Current,int val) {
        if(Current == null)
        {
            return null;
        }
        else if(Current.getVal() == val)
        {
            return true;
        }
        helpersearch(Current.getLeft(),val);
        helpersearch(Current.getRight(),val);
        return false;
    }
    public ArrayList<BSTNode> helper(BSTNode Current, ArrayList<BSTNode> inorder) {
        if(Current == null)
        {
            return null;
        }
        helper(Current.getLeft(),inorder);
        inorder.add(Current);
        helper(Current.getRight(),inorder);
        return inorder;
    }
    public ArrayList<BSTNode> helperpre(BSTNode Current, ArrayList<BSTNode> preorder) {
        if(Current == null)
        {
            return null;
        }
        preorder.add(Current);
        helper(Current.getLeft(),preorder);
        helper(Current.getRight(),preorder);
        return preorder;
    }
    public ArrayList<BSTNode> helperpost(BSTNode Current, ArrayList<BSTNode> postorder) {
        if(Current == null)
        {
            return null;
        }
        helper(Current.getLeft(),postorder);
        helper(Current.getRight(),postorder);
        postorder.add(Current);
        return postorder;
    }
}
