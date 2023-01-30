class Node{
    int data,height;
    Node next,left,right;
    //Node random;
    Node(int data){
        this.data = data;
        this.height = 1;
    }

    // PRINTING A LINKEDLIST!!!


    void print(Node head){
        Node cur = head;
        while (cur!=null){
            System.out.println(cur.data);
            cur = cur.next;
        }

    }


    // INSERTION OF A ELEMENT IN A LINKED LIST!!!


    void insert(int data, Node head, int pos) {
        Node toAdd = new Node(data);
        if (pos == 0) {
            toAdd.next = head;
            head = toAdd;
            return;
        }
        Node prev = head;
        for (int i = 0;i<pos-1;i++){
            prev = prev.next;
        }
        toAdd.next = prev.next;
        prev.next = toAdd;

    }


    //DELETION OF A ELEMENT FROM A LINKEDLIST!!!


    void delete(Node head,int pos){

        if (pos == 0) {
            head = head.next;
            return;
        }

            Node prev = head;
            for (int i = 0; i<pos-1;i++){
                prev= prev.next;
            }
            prev.next = prev.next.next;
        }


        //REVERSE OF A LINKEDLIST!!!


        Node reverse(Node head){
        Node cur = head;
        Node prev = null;
        while(cur!=null){
            Node temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
        }


        //FINDING THE MIDDLE NODE OF THE LINEKEDLIST!!!

        Node middle(Node head){
        Node slow = head;
        Node fast = head;
        while (fast!=null && fast.next !=null){
            slow=slow.next;
            fast = fast.next.next;
        }
        return slow;
        }


        //CHECK OF A LINKEDLIST FOR A PALINDROMIC VALUES!!!

        boolean palindrome(Node head){
        if (head==null){
           // return true;
        }
        Node mid = middle(head);
        Node last = reverse(mid.next);
        Node cur = head;
        while(last!=null){
            if (cur.data != last.data){
                return false;
            }
            cur = cur.next;
            last = last.next;
        }
        return true;
        }


        //DUPLICATE OF A LINKEDLIST

        Node duplicate(Node head){
        Node cur = head;
        while(cur!=null){
            Node temp = cur.next;
            cur.next = new Node(cur.data);
            cur.next.next = temp;
            cur = temp;
        }
        cur = head;

        Node original = head;
        Node copy = head.next;
        Node temp =copy;
        while (original!=null){
            original.next = original.next.next;
            copy.next = copy.next.next;
            original= original.next;
            copy = copy.next;
        }
return temp;
        }


        // CHECKING OF A CYCLIC LINKEDLIST!!!

    boolean cyclic(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }

}

public class Custom_Linkedlist {
    public static void main(String[] args) {

        //MAKING OF A NEW NODE!!!
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(20);
        Node n5 = new Node(10);


        // LINKING THE NODES!!!

        Node head = n1;
        n1.next =n2;
        n2.next =n3;
        n3.next =n4;
        n4.next = n5;

        // INSERTION OF ELEMENTS IN LINKEDLIST!!!

        head.insert(30,n1,0);

        // DELETION OF ELEMENT FROM THE LILNKEDLIST!!!

        head.delete(head,0);

        // PRINTING THE LINKEDLIST!!!

        head.print(head);

        // CHECKING FOR PALINDROMIC VALUES IN LINKEDLIST!!!

        System.out.println(head.palindrome(n1));
        head.palindrome(head);

        // GETTING THE MIDDLE ELEMENT OF THE LINKEDLIST!!!

        head.middle(head);
        System.out.println(head.middle(head));

        // CHECKING FOR A CYCLIC LOOP IN THE  LINKEDLIST!!!

        head.cyclic(head);
        System.out.println(head.cyclic(head));


        // REVERSING THE LINKEDLIST!!!

        head.reverse(head);
        System.out.println(head.reverse(head));
    }
}
