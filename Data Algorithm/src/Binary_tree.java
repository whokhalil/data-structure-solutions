import java.util.Scanner;

class Node1{
    Node1 left,right;
    int data;
    public Node1(int data){
        this.data = data;
    }
}

public class Binary_tree {

    static void inOrder(Node1 root){
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data+ " ");
        inOrder(root.right);
    }
    static void preOrder(Node1 root){
        if (root == null) return;
        System.out.print(root.data+ " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    static void postOrder(Node1 root){
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+ " ");
    }


    static Scanner sc = new Scanner(System.in);
    static Node1 createTree(){
        Node1  root= null;
        System.out.println("Enter node" );
        int data = sc.nextInt();
        if (data == -1) return null;
        root = new Node1(data);

        System.out.println("Enter left child for:" + data);
        root.left = createTree();
        System.out.println("Enter right child for:" + data);
        root.right = createTree();
        return root;
    }

    static void hasChild(Node1 root){
        if (root.data == root.left.data + root.right.data){
            System.out.println();
            System.out.println("It has equal child");
        }
    }

    static int height(Node1 root){
        if (root==null) return 0;
        return Math.max(height(root.left),height(root.right)) +1;
    }

    static int max(Node1 root){
        if (root==null) return Integer.MIN_VALUE;
        return Math.max(root.data, Math.max(max(root.left),max(root.right)));
    }

    static int min(Node1 root){
        if (root==null) return Integer.MAX_VALUE;
        return Math.min(root.data, Math.min(min(root.left),min(root.right)));
    }


    static int size(Node1 root){
        if (root == null) return 0;
        return size(root.left)+ size(root.right)+1;
    }

    public static void main(String[] args) {
        Node1 b = createTree();
        inOrder(b);
        System.out.println();
        preOrder(b);
        System.out.println();
        postOrder(b);
        hasChild(b);
        System.out.println(height(b));
        System.out.println(size(b));
        System.out.println(max(b));
        System.out.println(min(b));



    }
}
