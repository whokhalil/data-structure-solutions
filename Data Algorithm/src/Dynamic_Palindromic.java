public class Dynamic_Palindromic {

    static boolean isPalindromic(String s , int i, int j){
        while(i<j){
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    static int palindrome(String s){
        int n =s.length();
        int dp[][] = new int[n][n];
        for (int gap = 1; gap<n; gap++){
            for (int row = 0, col = gap; row<n-gap; row++,col++){
                if (isPalindromic(s,row,col)){
                    dp[row][col] = 0;
                }
                else{
                    dp[row][col] = Integer.MAX_VALUE;
                    for (int i=row; i<col; i++){
                        dp[row][col] = Math.min(dp[row][col], 1 + dp[row][i] + dp[i+1][col]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        String s = "ababbbabbababa";
        System.out.println(palindrome(s));

    }
}
