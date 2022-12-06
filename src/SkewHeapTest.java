import java.util.ArrayList;

public class SkewHeapTest {
    public static void main(String[] args){
        ArrayList<Integer> skewData = new ArrayList<>();
        SkewHeapQueue<Integer> skew = new SkewHeapQueue<>();

        for(int i = 0; i < 1000; i++){
            int randomPick = (int) (Math.random() * 100);
            skew.insert(randomPick);
        }
        System.out.println(skew.currentSize);
    }
}
