import java.util.Arrays;

public class Minimum_Train_Platform {
    static int MinimumPlatform(int a[], int b[], int n){
        Arrays.sort(a);
        Arrays.sort(b);
        int count = 0;
        int max = 0;
        int i = 0; int j=0;
        while (i<n && j<n){
            if (a[i]<=b[j]){
                count++;
                max = Math.max(max,count);
                i++;
            } else if (a[i]>=b[j]) {
                count--;
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        int a[] = {900,940,950,1100,1500,1800};
//        int b[] = {910,1200,1120,1130,1900,2000};
//        int n = a.length;
//        System.out.println(MinimumPlatform(a,b,n));

        int a = 9;
        char x = (char)(a + '0');
        System.out.println(x);
    }
}
