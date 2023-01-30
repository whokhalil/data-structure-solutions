import java.util.Stack;

public class Leetcode {

    int[] prevSmaller(int a[]){
        int ps[] = new int[a.length];
        Stack<Integer> s = new Stack<>();
        for (int i= 0;i<a.length;i++){
            while(!s.isEmpty() && a[s.peek()]>=a[i]){
                s.pop();
            }
            if (s.isEmpty()){
                ps[i] =-1;
            }
            else {
                ps[i] = s.peek();
            }
            s.push(i);
        }
        return ps;
    }

    int[] nextSmaller(int a[]){
        int ns[] = new int[a.length];
        Stack<Integer> s = new Stack<>();
        for (int i= a.length-1;i>=0;i--){
            while(!s.isEmpty() && a[s.peek()]>=a[i]){
                s.pop();
            }
            if (s.isEmpty()){
                ns[i] =a.length;
            }
            else {
                ns[i] = s.peek();
            }
            s.push(i);
        }
        return ns;
    }

    int maxArea(int a[]){
        int maxAns = 0;
        int ps[] = prevSmaller(a);
        int ns[] = nextSmaller(a);
        for (int i = 0;i<a.length;i++){
            int cur = (ns[i] -ps[i]-1) *a[i];
            maxAns = Math.max(maxAns,cur);
        }
        return maxAns;
    }
    public static void main(String[] args) {
        //Rain water trapping:
//        int[] a = new int[]{4,2,0,3,2,5};
//        int[] b = new int[6];
//        int[] c = new int[6];
//        b[0] = a[0];
//        c[5] = a[5];
//        int temp = a[0];
//        int temp2 = a[5];
//        for (int i= 1; i<a.length;i++){
//             b[i] = Math.max(temp,a[i]);
//             temp = b[i];
//        }
//        for (int i = a.length-2; i>=0;i--){
//            c[i] = Math.max(a[i] , temp2);
//            temp2= c[i];
//        }
//        int counter=0;
//        for (int i=0 ;i<a.length;i++){
//            counter += ((Math.min(b[i], c[i])) - a[i]);
//
//        }
//        System.out.println(counter);
//        for (int element1:b) {
//            System.out.print(element1 + " ");
//        }
//        System.out.println();
//        for (int element2:c) {
//            System.out.print(element2 + " ");
//        }
//        System.out.println();
//        for (int f:a) {
//            System.out.print(f + " ");
//        }

        //find the previous smallest number!!!

//        int[] a = new int[]{4,2,0,3,2,5};
//        Stack<Integer> s = new Stack<>();
//        for (int i= 0; i<a.length;i++){
//            while(!s.isEmpty() && s.peek()>=a[i]){
//                s.pop();
//            }
//            if (s.isEmpty()){
//                System.out.println("-1");
//            }
//            else{
//                System.out.println(s.peek());
//            }
//            s.push(a[i]);
//        }

        //find the previous largest number!!!

//        int[] a = new int[]{4,2,0,3,2,5};
//        Stack<Integer> s1 = new Stack<>();
//        for (int i = 0; i< a.length;i++){
//            while (!s1.isEmpty() && s1.peek()<=a[i]){
//                s1.pop();
//            }
//            if (s1.isEmpty()){
//                System.out.println("-1");
//            }
//            else {
//                System.out.println(s1.peek());
//            }
//            s1.push(a[i]);
//        }

//        find the next smallest number!!!

//        int[] a = new int[]{4,2,0,3,2,5};
//        Stack<Integer> s2 = new Stack<>();
//        for (int i = a.length-1; i>=0; i--){
//            while (!s2.isEmpty() && s2.peek()>=a[i]){
//                s2.pop();
//            }
//            if (s2.isEmpty()){
//                System.out.println("-1");
//            }
//            else {
//                System.out.println(s2.peek());
//            }
//            s2.push(a[i]);
//        }

//        find the next largest number!!!

//        int[] a = new int[]{4,2,0,3,2,5};
//        Stack<Integer> s2 = new Stack<>();
//        for (int i = a.length-1; i>=0; i--){
//            while (!s2.isEmpty() && s2.peek()<=a[i]){
//                s2.pop();
//            }
//            if (s2.isEmpty()){
//                System.out.println("-1");
//            }
//            else {
//                System.out.println(s2.peek());
//            }
//            s2.push(a[i]);
//        }


        //Find the maximum area in a histogram!!!

        int[] a = {4,2,1,5,6,3,2,4,2};
       Leetcode l =new Leetcode();
        System.out.println(l.maxArea(a));

    }
}
