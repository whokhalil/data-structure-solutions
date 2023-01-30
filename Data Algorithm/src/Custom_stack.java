class Mystack{
    Node head;
    int size;

    public Mystack(){
        head = null;
        size=0;
    }
    void push(int data){
        Node temp = new Node(data);
        temp.next= head;
        size++;
        head = temp;
    }
    int pop(){
        if (head==null){
            throw new RuntimeException("Stack is empty");
        }
        int res = head.data;
        head = head.next;
        size--;
        return res;
    }
    int peek(){
        if (head == null){
            throw new RuntimeException("Stack is empty");
        }
        return head.data;
    }
    int size(){
        return size;
    }

    void print(){
//
        while(size!=0){
            System.out.println(peek());
            pop();
        }
    }
}

public class Custom_stack {
    public static void main(String[] args) {
        Mystack stack = new Mystack();
        stack.push(1);
        stack.push(10);
        stack.push(6);
        stack.push(8);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.size());
        stack.print();
    }
}
