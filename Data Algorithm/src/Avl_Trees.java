import java.sql.SQLOutput;

public class Avl_Trees {

    int height(Node root){
        if (root==null) return 0;
        return root.height;
    }

    int max(int a,int b){
        return (a>b) ? a : b;
    }

    Node leftRotate(Node x){
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right));
        y.height = max(height(y.left), height(y.right));

        return y;
    }

    Node rightRotate(Node x){
        Node y = x.left;
        Node T1 = y.right;

        y.right = x;
        x.left = T1;

        x.height = max(height(x.left), height(x.right));
        y.height = max(height(y.left), height(y.right));
        return y;
    }

    int getBalance(Node root){
        if (root == null) return 0;
        return height(root.left) - height(root.right);
    }


    Node insert(Node root, int key){
        if (root == null){
            return (new Node(key));
        }

        if (key< root.data){
            root.left = insert(root.left,key);
        } else if (key> root.data) {
            root.right = insert(root.right,key);
        }
        else{
            return root;
        }

        root.height = 1 + max(height(root.left), height(root.right));

        int balance = getBalance(root);

        if (balance > 1 && key < root.left.data){
            return rightRotate(root);
        }
        if (balance < -1 && key > root.right.data){
            return leftRotate(root);
        }
        if (balance > 1 && key > root.left.data){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balance < -1 && key < root.right.data){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    void preOrder(Node root){
        if (root != null){
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    private void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
    public static void main(String[] args) {
        Node n = new Node(50);

        Avl_Trees t = new Avl_Trees();
        t.insert(n,70);
        t.insert(n,100);
        t.insert(n,90);
        t.insert(n,80);
        t.insert(n,800);
        t.insert(n,700);
        t.insert(n,79);
        t.insert(n,75);

        t.preOrder(n);

    }
}
