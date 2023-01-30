import java.util.Collections;
import java.util.PriorityQueue;

class median1{
    PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minheap = new PriorityQueue<>();
    void insertnum(int num){
        if (maxheap.isEmpty() || maxheap.peek()>num){
            maxheap.add(num);
        }
        else {
            minheap.add(num);
        }

        if (maxheap.size()> minheap.size()+1){
            minheap.add(maxheap.poll());
        } else if (maxheap.size()<minheap.size()) {
            maxheap.add(minheap.poll());
        }
    }
    public double findmedian(){
        if (maxheap.size() == minheap.size()){
            double median4 = (maxheap.peek() + minheap.peek()) / 2.0;
            return median4;
        }
            return maxheap.peek();

    }
}

public class Median_Priority_queue {
    public static void main(String[] args) {
        median1 m = new median1();
        m.insertnum(1);
        m.insertnum(2);
//        m.insertnum(3);
//        m.insertnum(4);
//        m.insertnum(5);
//        m.insertnum(6);
        System.out.println(m.findmedian());


    }
}
