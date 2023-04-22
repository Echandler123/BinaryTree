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
    // Returns if true or false if the val was in the tree and calls the recursive helper method
    public boolean search(int val) {
        // TODO: Complete the search function
        if(helperSearch(root,val) == false) {
            return false;
        }
        return true;
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    // Returns the arraylist and calls the recursive helper method
    public ArrayList<BSTNode> getInorder() {
        ArrayList<BSTNode> inorder = new ArrayList<BSTNode>();
        helperIn(root,inorder);
        // TODO: Complete inorder traversal
        return inorder;
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    // Returns the arraylist and calls the recursive helper method
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> preorder = new ArrayList<BSTNode>();
        helperPre(root,preorder);
        return preorder;
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    // Returns the arraylist and calls the recursive helper method
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> postorder = new ArrayList<BSTNode>();
        helperPost(root,postorder);
        return postorder;
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    // Calls the recursive helper method
    public void insert(int val) {
        // TODO: Complete insert
        if(search(val) == false) {
            BSTNode add = new BSTNode(val);
            helperInsert(add,root);
        }
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
    // Searches the tree for a node with the same value as the value inputted
    public boolean helperSearch(BSTNode current,int val) {
        if(current.getVal() == val) {
            return true;
        }
        else if(current.getLeft() == null && current.getRight() == null) {
            return false;
        }
        if(current.getVal() > val) {
            return helperSearch(current.getLeft(), val);
        }
        if(current.getVal() < val){
            return helperSearch(current.getRight(),val);
        }
        return false;
    }
    // Sorts the tree into an inorder arraylist
    public ArrayList<BSTNode> helperIn(BSTNode current, ArrayList<BSTNode> inorder) {
        if(current == null) {
            return null;
        }
        helperIn(current.getLeft(),inorder);
        inorder.add(current);
        helperIn(current.getRight(),inorder);
        return inorder;
    }
    // Sorts the tree into a preorder arraylist
    public ArrayList<BSTNode> helperPre(BSTNode current, ArrayList<BSTNode> preorder) {
        if(current == null) {
            return null;
        }
        preorder.add(current);
        helperPre(current.getLeft(),preorder);
        helperPre(current.getRight(),preorder);
        return preorder;
    }
    // Sorts the tree into a postorder arraylist
    public ArrayList<BSTNode> helperPost(BSTNode Current, ArrayList<BSTNode> postorder) {
        if(Current == null) {
            return null;
        }
        helperPost(Current.getLeft(),postorder);
        helperPost(Current.getRight(),postorder);
        postorder.add(Current);
        return postorder;
    }
    // Inserts a node at the correct position in the tree
    public void helperInsert(BSTNode add, BSTNode current) {
        if(add.getVal() < current.getVal() && current.getLeft() == null) {
            current.setLeft(add);
        }
        else if(add.getVal() > current.getVal() && current.getRight() == null ) {
            current.setRight(add);
        }
        if(add.getVal() < current.getVal()) {
            helperInsert(add,current.getLeft());
        }
        if(add.getVal() > current.getVal()) {
            helperInsert(add,current.getRight());
        }
    }
}
