public class Tester {
    public static void main(String[] args){
        //leftistHeapCheck();
        skewHeapCheck();
    }

    /**
     * Test functionality of the skew heap queue
     */
    private static void skewHeapCheck(){
        SkewHeapQueue<String> queue = new SkewHeapQueue<>();
        queue.insert("apps");
        queue.insert("bent");
        queue.insert("cess");
        queue.insert("fabo");
        queue.insert("zenn");
        queue.insert("maxy");
        queue.insert("ripd");
        queue.insert("turt");
        queue.insert("purp");
        queue.insert("sick");
        //System.out.println(queue.toString());
        System.out.println(queue.currentSize);
        queue.dequeue();
        //System.out.println(queue.toString());
        System.out.println(queue.currentSize);
        SkewHeapQueue<Integer> queue2 = new SkewHeapQueue<>();
        queue2.insert(5);
        queue2.insert(10);
        queue2.insert(12);
        queue2.insert(14);
        queue2.insert(16);
        queue2.insert(17);
        queue2.insert(13);
        queue2.insert(3);
        queue2.insert(7);
        queue2.insert(20);
        queue2.insert(30);
        queue2.insert(13);
        queue2.insert(15);
        queue2.insert(19);
        queue2.insert(35);
        queue2.insert(21);
        queue2.insert(22);
        //System.out.println(queue2.toString());
        System.out.println(queue2.currentSize);
        queue2.dequeue();
        //System.out.println(queue2.toString());
        System.out.println(queue2.currentSize);
    }

    /**
     * Test functionality of the leftist priority queue
     */
    private static void leftistHeapCheck(){
        LeftistPriorityQueue<String> queue = new LeftistPriorityQueue<>();
        queue.insert("apps");
        queue.insert("bent");
        queue.insert("cess");
        queue.insert("fabo");
        queue.insert("zenn");
        queue.insert("maxy");
        queue.insert("ripd");
        queue.insert("turt");
        queue.insert("purp");
        queue.insert("sick");
        System.out.println(queue.toString());
        queue.dequeue();
        System.out.println(queue.toString());
        LeftistPriorityQueue<Integer> queue2 = new LeftistPriorityQueue<>();
        queue2.insert(5);
        queue2.insert(10);
        queue2.insert(12);
        queue2.insert(14);
        queue2.insert(16);
        queue2.insert(17);
        queue2.insert(13);
        queue2.insert(3);
        queue2.insert(7);
        queue2.insert(20);
        queue2.insert(30);
        queue2.insert(13);
        queue2.insert(15);
        queue2.insert(19);
        queue2.insert(35);
        queue2.insert(21);
        queue2.insert(22);
        System.out.println(queue2.toString());
        queue2.dequeue();
        System.out.println(queue2.toString());
    }
}
