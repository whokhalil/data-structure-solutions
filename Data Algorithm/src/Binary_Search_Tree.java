import java.util.*;

 class Pair1 {
    int hd;
    Node root;

     public Pair1(int hd,Node root) {
         this.hd = hd;
         this.root = root;
     }
 }

public class Binary_Search_Tree {
    Node insert(Node root, int key) {
        if (root == null) return new Node(key);
        if (root.data > key) root.left = insert(root.left, key);
        if (root.data < key) root.right = insert(root.right, key);
        return root;
    }


    static int minValue(Node root) {
        int min = root.data;
        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    public static Node delete(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (root.data > key) {
            root.left = delete(root.left, key);
        } else if (root.data < key) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = minValue(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    private void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    boolean search(Node root, int x) {
        if (root == null) return false;
        if (root.data == x) return true;
        if (root.data > x) return search(root.left, x);
        return search(root.right, x);
    }

    boolean isBstUTIL(Node root, int min, int max) {
        if (root == null) return true;
        if (root.data < min || root.data > max) return false;
        return (isBstUTIL(root.left, min, root.data - 1) &&
                isBstUTIL(root.right, root.data + 1, max));

    }

    boolean isBst(Node root) {
        return isBstUTIL(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int floor(Node root, int key) {
        int ans = Integer.MAX_VALUE;
        while (root != null) {
            if (root.data == key) {
                return root.data;
            } else if (root.data > key) {
                root = root.left;
            } else {ans = root.data; root = root.right;}
        }
        return ans;
    }

    int cieling(Node root, int key) {
        int ans = Integer.MIN_VALUE;
        while (root != null) {
            if (root.data == key) {
                return ans;
            } else if (root.data < key) {
                root = root.right;
            } else {ans = root.data; root = root.left;}
        }
        return ans;
    }

    public boolean sumutil(Node root, int sum, Set<Integer> set){
        if (root== null) return false;

        if (sumutil(root.left,sum,set)== true){return true;}

        if (set.contains(sum-root.data)){
            return true;
        }
        set.add(root.data);
        return sumutil(root.right,sum,set);
    }
    public int isSumPresent(Node root, int target){
        Set<Integer> set = new HashSet<>();
        boolean ans = sumutil(root,target,set);
        return ans ? 1 : 0;
    }


    static ArrayList<Integer> verticalOrderTraversal(Node root){
        Queue<Pair1> q =new ArrayDeque<>();
        Map<Integer,ArrayList<Integer>> map = new TreeMap<>();
        q.add(new Pair1(0,root));
        while(!q.isEmpty()){
            Pair1 cur= q.poll();
            if (map.containsKey(cur.hd)){
                map.get(cur.hd).add(cur.root.data);
            }
            else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(cur.root.data);
                map.put(cur.hd,temp);
            }

            if (cur.root.left!= null){
                q.add(new Pair1(cur.hd-1,cur.root.left));
            }
            if (cur.root.right!=null){
                q.add(new Pair1(cur.hd+1,cur.root.right));
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer,ArrayList<Integer>> elements: map.entrySet()){
            ans.addAll(elements.getValue());
        }
        return ans;
    }


    public static void main(String[] args) {
        Node n = new Node(50);
        n.left = new Node(20);
        n.left.left = new Node(10);
        n.left.right = new Node(25);
        n.right = new Node(70);
        Binary_Search_Tree b = new Binary_Search_Tree();
//        b.insert(n,15);
//        b.insert(n,150);
//        b.insert(n,25);
//        b.insert(n,55);
//        b.insert(n,11);
//        b.insert(n,10);

        System.out.println(b.verticalOrderTraversal(n));

        System.out.println(b.isSumPresent(n,25));

        int k = 10;

        System.out.println("Floor of "+ k + " is : " + b.floor(n,k));
        System.out.println();
        System.out.println("Cieling of "+ k + " is : " + b.cieling(n,k));

       // System.out.println(b.isBst(n));

       // b.isBst(n);

        //b.delete(n,55);
        b.inOrder(n);
        //System.out.println(b.search(n,555));
    }
}
