import java.util.*;

class Pair{
    int hd;
    Node root;

    public Pair(int hd, Node root){
        this.hd = hd;
        this.root=root;
    }

}

  class Depth{
    int d;

      public Depth(int i) {
          this.d = i;
      }


  }

public class Bt_Lateral_Order {
    static Scanner sc = new Scanner(System.in);
    static Node createTree1(){

        Node root = null;
        System.out.println("Enter the node :");
        int data = sc.nextInt();
        if (data==-1) return null;
        root = new Node(data);

        System.out.println("Enter the left of node :" + data);
        root.left = createTree1();
        System.out.println("Enter the right of node :" + data);
        root.right = createTree1();
        return root;
    }


    // PRINT A BINARY SEARCH TREE LEVEL-WISE!!!!


    static void printLevelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (! q.isEmpty()){
                Node cur = q.poll();
                if (cur==null){
                    if (q.isEmpty()){
                        return;
                    }
                    q.add(null);
                    System.out.println();
                    continue;
                }
                System.out.print(cur.data+ " ");
                if (cur.left!= null){
                    q.add(cur.left);
                }
                if (cur.right!=null){
                    q.add(cur.right);
                }

        }
    }


    // LEFTSIDE VIEW OF A BINARY SEARCH TREE!!!!

    static void leftView(Node root, ArrayList list, int level){
        if (root == null) return;
        if (level==list.size()){
            list.add(root);
        }

        leftView(root.left,list,level+1);
        leftView(root.right,list,level+1);
    }


    static void printLeftView(Node root){
        ArrayList<Node> list = new ArrayList<>(20);
        leftView(root,list,0);
        for (Node cur: list){
            System.out.println(cur.data + " ");
        }
    }


// RIGHTSIDE VIEW OF A BINARY SEARCH TREE!!!!!

    static void rightView(Node root, ArrayList list, int level){
        if (root == null) return;
        list.set(level,root);
        rightView(root.left,list,level+1);
        rightView(root.right,list,level+1);
    }


    static void printRightView(Node root){
        ArrayList<Node> list = new ArrayList<>(20);
        rightView(root,list,0);
        for (Node cur: list){
            System.out.println(cur.data + " ");
        }
    }


// TOP VIEW OF A BINARY SEARCH TREE!!!!

    static ArrayList<Integer> topView(Node root){
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer,Integer> map = new TreeMap<>();
        q.add(new Pair(0,root));
        while (!q.isEmpty()){
            Pair cur = q.poll();
            if (!map.containsKey(cur.hd)){
                map.put(cur.hd,cur.root.data);
            }
            if (cur.root.left != null){
                q.add(new Pair(cur.hd-1,cur.root.left));
            }
            if (cur.root.right != null){
                q.add(new Pair(cur.hd+1,cur.root.right));
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry: map.entrySet()){
            ans.add(entry.getValue());
        }

        return ans;
    }

// BOTTOM VIEW OF A BINARY SEARCH TREE!!!!

    static ArrayList<Integer> bottomView(Node root){
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer,Integer> map = new TreeMap<>();
        q.add(new Pair(0,root));
        while (!q.isEmpty()){
            Pair cur = q.poll();
                map.put(cur.hd,cur.root.data);
            if (cur.root.left != null){
                q.add(new Pair(cur.hd-1,cur.root.left));
            }
            if (cur.root.right != null){
                q.add(new Pair(cur.hd+1,cur.root.right));
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry: map.entrySet()){
            ans.add(entry.getValue());
        }

        return ans;
    }



    static Node prev = null;
     static Node head = null;
      static void convertToDLL(Node root){
        if (root == null) return  ;
        convertToDLL(root.left);
        if (prev == null) head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convertToDLL(root.right);

    }

// DIAMETER OF A BINARY TREE!!!
    static int diameter = 0;
      static int height(Node root){
          if (root == null) return 0;
          int lh = height(root.left);
          int rh = height(root.right);
          diameter = Math.max(diameter,(1+lh+rh));
          return 1 + Math.max(lh,rh);
      }

// LOWEST COMMON ANCESTOR!!!

    static int papa = 0;
      static Node lca(Node root, int n1, int n2){
          if (root==null) return null;
          if (root.data==n1 || root.data == n2) return root;

          Node left = lca(root.left,n1,n2);
          Node right = lca(root.right,n1,n2);
          if (left == null){  return right;}
          if (right == null){  return left;}

          return root;
      }
      public static int parent(Node root, int n1, int n2){
          lca(root,n1,n2);
          return papa;
      }


      // BURNING TIME OF A TREE!!!

    static int ans = -1;
    public static int burn(Node root, int target, Depth depth){
          if (root == null) return 0;
          if (root.data == target) {
              depth.d = 1;
              return 1;
          }
          Depth ld = new Depth(-1);
          Depth rd = new Depth(-1);

          int lh = burn(root.left, target, ld);
          int rh = burn(root.right,target,rd);

          if (ld.d != -1){
              ans = Math.max(ans, (ld.d + 1 + rh));
              depth.d = ld.d +1;
          }
          if (rd.d != -1){
              ans = Math.max(ans,(rd.d+1+lh));
              depth.d = rd.d+1;
          }
          return Math.max(lh,rh)+1;
    }

    public static int minTime(Node root,int target){
        Depth depth = new Depth(-1);
        burn(root,target,depth);
        return ans;
    }

    public static void main(String[] args) {
       Node b= createTree1();

        System.out.println(topView(b) + "/n");

        System.out.println(bottomView(b) + "/n");

       // convertToDLL(b);

        System.out.println(height(b)  + "/n");

        System.out.println(diameter + "/n");

        System.out.println(parent(b,3,2) + "/n");

        System.out.println(minTime(b,1) + "/n");



    }
}
