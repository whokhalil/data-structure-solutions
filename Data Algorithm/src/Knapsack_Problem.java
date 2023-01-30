import java.util.Arrays;

public class Knapsack_Problem {
    public static void main(String[] args) {
        int w = 10;
        int n = 4;
        int val[] = {20,30,10,50};
        int wt[] = {1,3,4,6};

        int mat[][] = new int[n+1][w+1];
//        Arrays.fill(mat,-1);
        for (int i=0;i<=n;i++){
            mat[i][0] = 0;
        }
        for (int j=0;j<=w;j++){
            mat[0][j]=0;
        }


        //MAin Logic!!!

        for (int item=1;item<=n;item++){
            for (int capacity=1;capacity<=w;capacity++){
                int maxValueWithoutcur = mat[item-1][capacity];
                int maxValueWithCur = 0;

                int weightofCur = wt[item-1];
                if (capacity >= weightofCur){
                    maxValueWithCur=val[item-1];
                    int remainingCapacity = capacity - weightofCur;
                    maxValueWithCur += mat[item-1][remainingCapacity];
                }
                mat[item][capacity] = Math.max(maxValueWithoutcur,maxValueWithCur);
            }
        }

        System.out.println(mat[n][w]);

        for (int i=1;i<=n;i++){
            for (int j=1;j<=w;j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

        //System.out.println(Arrays.deepToString(mat));
    }
}
