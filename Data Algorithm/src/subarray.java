import java.util.HashMap;

public class subarray {
    public static void main(String[] args) {
        int[] a = new int[6];
        a = new int[]{10, 15,-5,15,-10,15};
        int sum = 5;
//        for (int i=0; i<a.length-1;i++){
//            if (a[i] +a[i+1] == sum){
//                System.out.println("Indexes are : " + i + " , " + (i+1));
//                System.out.println("Values on these indexes are : " + a[i] + " and " + a[i+1]);
//            }

        int cursum = 0;
        int start = 0;
        int end = -1;
        HashMap<Integer,Integer> k = new HashMap<>();
        for (int i=0;i<a.length;i++){
            cursum += a[i];
            if (cursum==sum){
                start =0; end =i;
            }
            if (k.containsKey(cursum-sum)){
                start = k.get(cursum-sum) +1;
                end = i;
                break;
            }
            k.put(cursum,i);
        }
        if (end== -1){
            System.out.println("Not found");
        }
        else {
            System.out.println(start + " " + end);
        }
    }
}
