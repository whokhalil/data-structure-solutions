public class Rod_Cutting {
    static int rod(int price[], int m){
        int dp[] = new int[m+1];
        for (int i=1;i<=m;i++){
            for (int j=0;j<i;j++){
                dp[i] = Math.max(dp[i],price[j]+dp[i-j-1]);
            }
        }
        return dp[m];
    }


    public static void main(String[] args) {
        int price[] = {1,5,6,9,11,12,14,16};
        int m = 6;
        int s = rod(price,m);
        System.out.println(s);
    }
}
