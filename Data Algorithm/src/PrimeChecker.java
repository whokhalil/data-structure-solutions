
     import java.util.ArrayList;
 import java.util.List;
 import java.util.Scanner;


     class PrimeChecker {


         public void permute(String s,int l,int r, ArrayList<Integer> ans){
             if(l == r){
                 ans.add(Integer.parseInt(s));
             }
             else{
                 for(int i = l;i<=r;i++){
                     s = swap(s,l,i);
                     permute(s,l+1,r,ans);
                     s = swap(s,l,i);
                 }
             }
         }
         public String swap(String s , int l,int r){
             char temp;
             char[] charArray = s.toCharArray();
             temp = charArray[l];
             charArray[l] = charArray[r];
             charArray[r] = temp;
             return String.valueOf(charArray);
         }

        int PrimeChecker(int num) {
            String s = Integer.toString(num);
            int n = s.length();
            ArrayList<Integer> ans = new ArrayList<>();
            permute(s,0,n-1,ans);
            for (int perm : ans) {
                if (isPrime(perm)) {
                    return 1;
                }
            }

            return 0;

        }

        boolean isPrime(int num) {
            if (num %2 == 0) return false;

            for (int i = 3; i * i <= num; i += 2) {
                if (num % i == 0)
                    return false;
            }
            return true;
        }


        public static void main (String[] args) {
            // keep this function call here
//            Scanner s = new Scanner(System.in);
//            PrimeChecker c = new PrimeChecker();
//            System.out.print(c.PrimeChecker(89));
            String x = "abcd";
            String y = x;
            System.out.println(y);
            if(x==y){
                System.out.println("1");
            }
            else{
                System.out.println("0");
            }
        }
    }

