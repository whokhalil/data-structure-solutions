public class Sorting {
    public static void main(String[] args) {
        int[] arr = new int[7];
        arr[0] = 9;
        arr[1] = 1;
        arr[2] = 94;
        arr[3] = 16;
        arr[4] = 11;
        arr[5] = 5;
        arr[6] = -2;
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i]; // =16
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
        for (int element : arr) {
            if (element == 0) {
                continue;
            }
        }
    }
}
