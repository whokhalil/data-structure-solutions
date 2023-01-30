class binary {
    static int binaryS(int arr[] , int key) {

        int low = 0;
        int high = arr.length - 1;

        while(low<=high){
        int mid = (low + high) / 2;
        if (arr[mid] == key) {
            return mid;
        }
        else if (arr[mid] > key) {
            high = mid-1;
        }
        else{
            low = mid+1;
        }
        }
        return -1;
        }

        static int recurBinary(int a[], int key, int low, int high){
        if (low>high) {
            return -1;
        }
        int mid = low +high/2;
        if (a[mid]==key){
            return mid;
        }
        if (key> a[mid]){
            return recurBinary(a, key, mid+1, high);
        }
        if (key< a[mid]){
            return recurBinary(a,key, low, mid-1);
        }
            return mid;
        }
    }

public class Binarysearch {

    public static void main(String[] args) {
        binary k = new binary();
        int[] arr = new int[6];
        arr[0] = 9; // 1
        arr[1] = 1; // 5
        arr[2] = 94; // 9
        arr[3] = 16; // 11
        arr[4] = 11; // 16
        arr[5] = 5; // 94
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i]; // =16
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }

//        System.out.println(binary.binaryS(arr, 11));
        System.out.println(binary.recurBinary(arr, 5, 0, arr.length));

        //  int k = binary();
      //  System.out.println(k);
    }
}
