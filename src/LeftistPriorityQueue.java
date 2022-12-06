public class LeftistPriorityQueue<E extends Comparable<? super E>>{
    Node root = null;

    private class Node{
        E element;
        int npl;  // null path length
        Node right;
        Node left;

        private Node(E element){
            this.element = element;
            this.npl = 0;
            this.right = null;
            this.left = null;
        }
    }

    /**
     * Add a new node to the heap
     * @param newElement the value of the new node
     */
    public void insert(E newElement){
        Node newNode = new Node(newElement);
        if(root == null){
            root = newNode;
        }
        // if the new node is smaller than root, it becomes new root
        else if(root.element.compareTo(newElement) > 0){
            newNode.left = root;
            root = newNode;
        }
        // if not, recurse
        else{
            insert(newElement, root);
        }
    }

    /**
     * Private insertion that allows for recursion
     * @param element value of the new node
     * @param parent node we will be adding children to
     */
    private void insert(E element, Node parent){
        Node newNode = new Node(element);

        // adding a larger new node to one with no children yet
        if(parent.right == null && parent.left == null){
            parent.left = newNode;
        }
        // adding a larger new node and fixing up the npl's
        else if(parent.right == null){
            parent.right = newNode;
            parent.npl = Math.min(parent.right.npl, parent.left.npl) + 1;
            root.npl = restructure(root);
        }
        // fitting in the smaller new node into the tree
        else if(parent.right.element.compareTo(element) > 0){
            newNode.left = parent.right;
            parent.right = newNode;
        }
        // if none of these, recurse
        else{
            insert(element, parent.right);
        }
    }

    /**
     * Redo null path lengths and switch branches if needed
     * @param node which npl you want
     * @return the null path length of the node parameter
     */
    private int restructure(Node node){
        if(node == null){
            return -1;
        }
        if(node.right != null && node.left != null){
            if(node.right.npl > node.left.npl){
                Node temp = node.right;
                node.right = node.left;
                node.left = temp;
            }
        } else if(node.right != null){
            node.left = node.right;
            node.right = null;
        }

        node.npl = Math.min(restructure(node.right), restructure(node.left)) + 1;
        return node.npl;
    }

    /**
     * Print the heap in the formation it is stored
     * @return a string to print
     */
    public String toString(){
        if(root != null){
            return toString(root, "");
        } else{
            return "";
        }
    }

    /**
     * Private version of toString that allows for recursion
     * @param t the current node
     * @param indent marks the depth level of the node
     * @return the string to print
     */
    private String toString(Node t, String indent) {
        StringBuilder sb = new StringBuilder();
        if(t.right != null){
            sb.append(toString(t.right, indent + "  "));
        }
        sb.append(indent);
        sb.append(t.element);
        //sb.append("," + t.npl);  // uncomment this to add null path length to the printed heap
        sb.append("\n");
        if (t.left != null){
            sb.append(toString(t.left, indent + "  "));
        }
        return sb.toString();
    }

    /**
     * Remove the minimum value off the heap
     * @return the value it holds
     */
    public E dequeue(){
        Node poppedNode = root;
        if(root == null){
            return root.element;
        }
        if(root.left == null){
            root = null;
            return poppedNode.element;
        }
        if(root.right == null){
            root = root.left;
            return poppedNode.element;
        }

        if(root.left.element.compareTo(root.right.element) > 0){
            merge(root.right, root.left, root.right.right);
            root = root.right;
        } else{
            merge(root.left, root.left.right, root.right);
            root = root.left;
        }
        restructure(root);

        return poppedNode.element;
    }

    /**
     * After the minimum gets removed, we are left with two subtrees to combine
     * @param mergedTree the new root or main parent node we build onto
     * @param leftTree minimum of the left subtree
     * @param rightTree minimum of the right subtree
     */
    private void merge(Node mergedTree, Node leftTree, Node rightTree){
        // right child of the merged tree is the next smallest node
        if(leftTree == null){
            mergedTree.right = rightTree;
            return;
        } else if(rightTree == null){
            mergedTree.right = leftTree;
            return;
        }

        if(leftTree.element.compareTo(rightTree.element) > 0){
            mergedTree.right = rightTree;
            rightTree = rightTree.right;
        } else{
            mergedTree.right = leftTree;
            leftTree = leftTree.right;
        }
        merge(mergedTree.right, leftTree, rightTree);
    }

    /**
     * If the heap is empty, all the tasks have been run
     * @return yes or no
     */
    public boolean isEmpty(){
        if(root == null){
            return true;
        }
        return false;
    }
}
