import java.util.Arrays;

public class ss {
    public static void main(String[] args) {
        String a = "9";
        String b = "10";
        //String x ;

        String[] ab = {"9","10"};

        for(int j = 0;j<ab.length-1;j++){
            String temp = "0";
            for(int i=1;i<ab.length;i++){
                if(ab[j].charAt(0)>ab[i].charAt(0)){
                    temp = ab[j];
                    ab[j] = ab[i];
                    ab[i] = temp;
                }
            }
        }
        String x = ab[0];
        for (int i=1;i<ab.length;i++){
           x += ab[i];
        }


        System.out.println(x);
    }
}
