import java.util.*;

public class Parenthesis {
   boolean isMatching(char a,char b) {
       if (a=='(' && b==')') {
           return true;
       }
       else if (a=='[' && b==']'){
           return true;
       }
       else if (a=='{' && b=='}'){
           return true;
       }
       return false;
   }
    boolean isParenthesis(String str){
        Stack<Character> s = new Stack<>();
        for (int i = 0; i<str.length();i++){
            char cur = str.charAt(i);
            if (cur == '(' || cur =='{' || cur=='['){
                s.push(cur);
            } else {
                if (s.isEmpty()){
                    return false;
                } else if (!isMatching(s.peek(),cur)) {
                    return false;
                }
                else{
                    s.pop();
                }
            }
        }
        return s.isEmpty();
    }
    public static void main(String[] args) {
        String s = "((([})";
        Parenthesis s2 = new Parenthesis();
        System.out.println(s2.isParenthesis(s));
    }
}
