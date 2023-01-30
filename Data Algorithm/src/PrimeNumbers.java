import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
//        boolean isPrime[] = prime(100);
//        for (int i = 0;i<=100;i++){
//        System.out.println(isPrime[i]);
//        }
//
        for (int i = 1; i <130;i++) {
            if (i % 2 == 0 || i % 3 ==0 || i% 5 == 0 || i% 7 ==0 ){
//                System.out.println(i + "  is not a prime number");
            }
            else {
                System.out.println(i);
            }

        }

    }
    static boolean[] prime(int n) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the prime numbers limit!!!");
//         n = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i <n;i++){
//            arr[i] = i;
//            //Array.getBoolean(arr, i);
//
//        }
//        for (int elements : arr){
//            System.out.print(elements + " ");
//        }

        boolean isPrime[] = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i*i<=n;i++){
            for (int j= 2*i;j<=n;j+=i){
                isPrime[j] = false;

            }

        }
        return isPrime;
    }
}
