import java.util.Collections;
import java.util.PriorityQueue;

public class Priority_queue {
    public static void main(String[] args) {


        // Finding the Kth largest and smallest number in an array!!!


        int[] arr = new int[]{20,10,60,30,50,40};
        int k = 4;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i<k;i++){
            pq.add(arr[i]);
        }
        for (int i = k;i<arr.length;i++){
            if (pq.peek()> arr[i]){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        System.out.println(pq.peek());


        //Connect n ropes!!!


        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        int[] arr2 = new int[]{2,5,4,8,6,9};
        for (int i=0;i<arr2.length;i++){
            pq1.add(arr2[i]);
        }
        int ans = 0;
        while (pq1.size()>1){
            int first = pq1.poll();
            int second = pq1.poll();
            int sum = first+second;
            ans+= sum;
            pq1.add(sum);
        }
        System.out.println(ans);
    }
}
