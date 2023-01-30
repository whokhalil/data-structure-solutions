import java.sql.Array;
import java.util.*;
public class Hashset {
    public static void main(String[] args) {
        HashSet<Integer> k = new HashSet<>();
        k.add(5);
        k.add(10);
        k.add(1);
        k.add(8);
        System.out.println(k);

        //Count of distinctive elements!!!

        int[] a = new int[]{5,10,15,5,4,5};
        HashSet<Integer> set = new HashSet<>();
        for (int element:a) {
            set.add(element);
        }
        System.out.println(set.size());

        //Union of two arrays!!!
        int[] b = new int[]{5,10,15,5};
        int[] c = new int[]{10,15,4,5};
        HashSet<Integer> f = new HashSet<>();
        for (int e: b) {
            f.add(e);
        }
        for (int e: c) {
            f.add(e);
        }
        System.out.println(f);

        //Intersection of two arrays!!!
        int[] arr1= new int[]{5,10,15,5,10};
        int[] arr2= new int[]{15,5,5,10,4};
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        for (int e: arr1) {
            set2.add(e);
        }
        int count=0;
        for (int e: arr2){
            if (set2.contains(e)){
                count++;
                set3.add(e);
                set2.remove(e);
            }
        }
        System.out.println(count);
        System.out.println(set3);
    }
}
