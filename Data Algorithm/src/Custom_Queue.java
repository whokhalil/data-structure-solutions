import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class que1{
    Node front;
    Node rear;
    void enque(int data){
        Node newnode = new Node(data);
        if (front == null){
            front = rear = newnode;
        }
        else{
            rear.next = newnode;
            rear = newnode;
        }
    }
    int deque(){
        if (front == null){
            throw new RuntimeException("Empty queue");
        }

        int temp = front.data;
        front = front.next;
        return temp;
    }
}

class Myque{
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    void push(int data){
        s1.push(data);
    }
    int pop(){
        if(s1.isEmpty()){
            System.out.println("Queue is empty");
            return 0;
        }
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int temp = s2.pop();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return temp;
    }
    int peek(){
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int res = s2.peek();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return res;
    }
}

public class Custom_Queue {
    public static void main(String[] args) {
//        que1 khalil = new que1();
//        khalil.enque(5);
//        khalil.enque(1);
//        khalil.enque(2);
//        khalil.enque(8);
//        khalil.enque(6);
//        System.out.println(khalil.deque());
//        System.out.println(khalil.deque());
//        System.out.println(khalil.deque());
//        System.out.println(khalil.deque());
//        System.out.println(khalil.deque());

//        Queue<Integer> q = new LinkedList<>();
//        q.offer(10);
//        q.offer(20);
//        q.offer(30);
//        //System.out.println(q.poll());
//        System.out.println(q.peek());
//        System.out.println(q.size());
//        System.out.println(q.isEmpty());



        Myque que = new Myque();
        que.push(10);
        que.push(20);
        que.push(30);
        System.out.println(que.pop());
        System.out.println(que.peek());
//        System.out.println(que.pop());
//        System.out.println(que.pop());
//        System.out.println(que.pop());

    }
}
