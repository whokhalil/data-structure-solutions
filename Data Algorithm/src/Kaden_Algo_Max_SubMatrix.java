import java.util.Arrays;

public class Kaden_Algo_Max_SubMatrix {
    static int kaden(int a[]){
        int maxSum = 0;
        int cursum = 0;
        for (int i=0;i<a.length;i++){
            cursum = cursum + a[i];
            if (cursum > maxSum){
                maxSum = cursum;
            }
            if (cursum < 0){
                cursum = 0;
            }
        }
        return maxSum;
    }

    static int SubMatrix(int a[][], int r, int c){
        int sum[] = new int[r];
        int maxSum = Integer.MIN_VALUE;
        for (int cstart = 0;cstart<c;cstart++){
            Arrays.fill(sum,0);
            for (int cend = cstart;cend<c;cend++){
                for (int row = 0;row<r;row++){
                    sum[row] += a[row][cend];
                }
                int cursum = kaden(sum);
                maxSum = Math.max(cursum,maxSum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int a[][] = new int[][]{
                { 1, 2,-1, -4,-20},
                {-8,-3, 4, -2,  1},
                { 3, 8, 9,  1,  3},
                {-4,-1, 1,  7, -6},
                {-2,-3, 8,  1, -1}
        };
        int c = 5;
        int r = 5;
        System.out.println(SubMatrix(a,r,c));
        }
    }

