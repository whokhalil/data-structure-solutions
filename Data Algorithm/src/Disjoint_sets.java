public class Disjoint_sets {
    int p[] = new int[8];
    public void initialize(){
        for (int i =0; i<8;i++){
            p[i] = i;
        }
    }

    int find(int x){
     if (p[x]!=x) return p[x] = find(p[x]);
     return p[x];
    }

    void union(int a, int b){
        int x = find(a);
        int y = find(b);
        if (x==y) return;
        if (p[a]<p[b]) p[y] = x;
        if (p[a]>p[b]) p[x] = y;
    }

    public static void main(String[] args) {
        Disjoint_sets k = new Disjoint_sets();
        k.initialize();
        k.union(0,2);
        k.union(3,4);
        k.union(2,4);
        System.out.println(k.find(2));
        k.union(5,4);
        System.out.println(k.find(6));
    }
}
