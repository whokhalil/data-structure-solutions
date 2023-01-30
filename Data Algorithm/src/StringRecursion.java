public class StringRecursion {
    static String powerset(String s, int i, String cur){
        if (i== s.length()){
            System.out.println(cur);
            return s;
        }
        powerset(s,i+1,cur +s.charAt(i));
        powerset(s,i+1,cur);
        return s;
    }
    public static void main(String[] args) {
       // String s = "abc";
        String k = powerset("abc",0,"");
        System.out.println(k);


    }
}
