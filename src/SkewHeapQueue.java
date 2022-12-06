public class SkewHeapQueue<E extends Comparable<? super E>>{
    public int currentSize = 0;
    Node root = null;

    private class Node{
        Node left;
        Node right;
        E element;
        private Node(E element){
            this.element = element;
            this.left = null;
            this.right = null;
        }
    }

    public void insert(E element){
        Node newNode = new Node(element);
        root = merge(root, newNode);
        currentSize += 1;
    }

    public Node dequeue(){
        Node poppedNode = root;
        root = merge(root.left, root.right);
        currentSize -= 1;
        return poppedNode;
    }

    /**
     * Combine two subtrees
     * @param left root of the left subtree
     * @param right root of the right subtree
     * @return the new root/parent node
     */
    private Node merge(Node left, Node right){
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }

        if(right.element.compareTo(left.element) > 0){
//            left.right = merge(left.right, right);
//            Node temp = left.right;
//            left.right = left.left;
//            left.left = merge(temp, right);
//            return left;

            left.right = merge(left.right, right);
            Node temp = left.right;
            left.right = left.left;
            left.left = temp;
            return left;
        } else{
//            right.right = merge(left, right.right);
//            Node temp = right.left;
//            right.left = right.right;
//            right.right = merge(left, temp);
//            return right;

            right.right = merge(left, right.right);
            Node temp = right.right;
            right.right = right.left;
            right.left = temp;
            return right;
        }

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
}
