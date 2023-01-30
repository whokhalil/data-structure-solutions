class heapify{
    void heapify(int a[],int n, int i){
        int largest = i;
        int l = 2*i;
        int r = 2*i+1;
        if (l<=n && a[l]>a[largest]){
            largest = l;
        }
        if (r<=n && a[r]>a[largest]){
            largest = r;
        }
        if (largest!= i){
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            heapify(a,n,largest);

        }
    }
    void buildheap(int a[], int n){
        for (int i= n/2;i>0;i--){
            heapify(a,n,i);
        }
    }
    void heapsort(int a[], int n){
        for (int i=n;i>1;i-- ){
            int temp2 = a[1];
            a[1] = a[i];
            a[i] = temp2;
            temp2 = 0;
            heapify(a,i-1,1);
        }
    }
}
public class Heap_sort {
    public static void main(String[] args) {
        int[] arr = new int[]{0,10,30,50,20,35,15};
        heapify h = new heapify();
        h.buildheap(arr,6);
        h.heapsort(arr,6);
        for (int element:arr) {
            if (element == 0){
                continue;
            }
            System.out.print(element + " ");
        }

    }
}
