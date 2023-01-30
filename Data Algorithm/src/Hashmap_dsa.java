import java.util.HashMap;

public class Hashmap_dsa {
    public static void main(String[] args) {


        //Find the sum in subarray!!!


        HashMap<Integer,Integer> map = new HashMap<>();
        int[] a = new int[]{10,15,-5,15,-10,5};
        int cursum = 0;
        int sum = 5;
        int start = 0;
        int end = -1;
        for (int i=0;i<a.length;i++){
            cursum += a[i];
            if (cursum==sum){
                start= 0; end=i;
                break;
            }if (map.containsKey(cursum-sum)){
                start= map.get(cursum-sum)+1;
                end = i;
                break;
            }
            map.put(cursum,i);
        }
        if (end==-1){
            System.out.println("Not Found");
        }
        else{
            System.out.println(start + " , " + end);
        }
    }
}
