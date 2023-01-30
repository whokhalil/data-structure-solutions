import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Interval_Problem {

    public static ArrayList<Integer>  maxmeetings(int N, int[] S, int[] F){
        ArrayList<Integer> ans = new ArrayList<>();
        int a[][] = new int[N][3];
        for (int i = 0;i<N;i++){
            a[i][0] = i+1;
            a[i][1] = S[i];
            a[i][2] = F[i];
        }
        Arrays.sort(a, Comparator.comparingInt(o -> o[2]));
        int r = a[0][2];
        ans.add(a[0][0]);
        for (int i = 1;i<a.length;i++){
            if (a[i][1]>r){
                ans.add(a[i][0]);
                r = a[i][2];
            }
        }
        Collections.sort(ans);
        return ans;
    }
    public static void main(String[] args) {
        int s[] = {1,4,12,15,7};
        int f[] = {13,6,14,19,13};
        int s1[] = {1,3,0,5,8,5};
        int f1[] = {2,4,6,7,9,9};
        int n = s.length;
        System.out.println(maxmeetings(n,s1,f1));



    }
}
