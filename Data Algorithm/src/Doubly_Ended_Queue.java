import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;

public class Doubly_Ended_Queue {
    static void printMax(int a[], int n, int k){
        int j,max;
        for (int i=0;i<=n-k;i++){
            max= a[i];
            for (j=1; j<k;j++){
                if (a[i+j]> max){
                    max= a[i+j];
                }
            }
            System.out.print(max+ " ");
        }
        System.out.println();
    }
    static void print(int a[], int n, int k){
        Deque<Integer> s = new ArrayDeque<>();

        for (int i=0;i<k;i++){
            while (!s.isEmpty() && a[i]>=a[s.peekLast()]){
                s.removeLast();
            }
            s.addLast(i);
        }

        for (int i=k;i<n;i++){
            System.out.print(a[s.peek()] + " ");

            while (!s.isEmpty() && s.peek()<=i-k){
                s.removeFirst();
            }
            while (!s.isEmpty() && a[i]>=a[s.peekLast()]){
                s.removeLast();
            }
            s.addLast(i);

        }
        System.out.print(a[s.peek()] + " ");

    }
    public static void main(String[] args) {
        int[] a = new  int[]{4,1,3,5,1,2,3,2,1,1,5};
        int k = 3;
        int n = a.length;
       Doubly_Ended_Queue dd = new Doubly_Ended_Queue();
       dd.print(a,n,k);

//        Doubly_Ended_Queue max = new Doubly_Ended_Queue();
//        max.printMax(a,n,k);
//        ArrayDeque<Integer> s = new ArrayDeque<>();
//        s.add(10);
//        s.add(20);
//        s.add(30);
//        s.add(40);
//        s.add(50);
//        s.add(60);
//        s.add(70);
//        s.offer(5);
//        s.poll();
//        s.removeFirst();
//        System.out.println(s.getFirst());
//        System.out.println(s.getLast());
    }
}
