import java.util.HashSet;

public class Arry {
    public static void main(String[] args) {
        int[] arr = new int[6];
        int[] arr1 = new int[6];
        arr[0] = 9;
        arr[1] = 1;
        arr[2] = 94;
        arr[3] = 16;
        arr[4] = 11;
        arr[5] = 5;

        arr1[0] = 25;
        arr1[1] = 1;
        arr1[2] = 64;
        arr1[3] = 16;
        arr1[4] = 71;
        arr1[5] = 55;

        for (int i = 1; i< arr.length;i++ ){
            int temp = arr[i];
            int j = i - 1;
            while (j>=0 && arr[j]>temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
        for (int i = 1; i< arr1.length;i++ ){
            int temp = arr1[i];
            int j = i - 1;
            while (j>=0 && arr1[j]>temp){
                arr1[j+1] = arr1[j];
                j--;
            }
            arr1[j+1] = temp;
        }
        int[] arr2 = new int[12];
        for (int i = 0; i<arr.length;i++){
            arr2[i] = arr[i];
        }
        for (int i = 6; i<arr2.length;i++){
            arr2[i] = arr1[i-6];
        }
        for (int i = 1; i<arr2.length;i++){
            int temp = arr2[i];
            int j = i-1;
            while (j>=0 && arr2[j]>temp){
                arr2[j+1] = arr2[j];
                j--;
            }arr2[j+1] = temp;
        }
//        for (int element5: arr2) {
//            System.out.println(element5);
//        }

        HashSet<Integer> k = new HashSet<>();

        for (int element: arr2 ) {
           k.add(element);
        }
        for (int element:k) {
            System.out.println(element);
        }
//        System.out.print("[");
//
//        for (int i = 0; i<arr.length;i++){
//            if (arr[i] != arr1[i]) {
//                System.out.print(" " +arr[i] +" " + arr1[i]);
//            }
//                    if (arr[i]==arr1[i]){
//                        System.out.print(" " +arr[i] );
//                    }
//            }
//        System.out.print("]");

//        for (int i=0; i<=5;i++) {
//            for (int j = 0; j <= 5-i ; j++) {
//                if (j-i >1){
//                    System.out.print("*"+ " ");
//                }
//                else{
//                    System.out.print(" ");
//                }
//            }
//            System.out.println();
//        }


       // int[] k = java.util.Arrays.stream(arr).sorted().toArray();
//        for (int element: k) {
//            System.out.println(element);
//        }


    }
}
