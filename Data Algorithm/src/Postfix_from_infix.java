import java.util.Stack;

public class Postfix_from_infix {
    boolean operand(char a){
        if (a== 'a' || a=='b'|| a=='c'|| a=='d'|| a=='e'|| a=='f'|| a=='g'|| a=='h'|| a=='i'|| a=='j'|| a=='k'|| a=='l'|| a=='m'
                || a=='n'|| a=='o'|| a=='p'|| a=='q'|| a=='r'|| a=='s'|| a=='t'|| a=='u'|| a=='v'|| a=='w'|| a=='x'|| a=='y'|| a=='z'){
            return true;
        }
        return false;
    }

    boolean operator(char a){
        if (a =='+' || a=='-'|| a=='*'|| a=='/'|| a=='('|| a==')'){
            return true;
        }
        return false;
    }

    void postfix(String s){
        Stack<Character> stk = new Stack<>();
        for (int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            if (cur == '('){
                stk.push(cur);
            }
            if (operand(cur)){
                System.out.println(cur);
            }
            if (cur == ')'){
                while(stk.pop()=='('){
                   char b= stk.pop();
                    System.out.println(b);
//                    if (stk.peek()=='('){
//                        stk.pop();
//                    }
                }
            }
            else if (operator(cur) == true){
                if (stk.isEmpty()){
                    stk.push(cur);
                }
                else {
                    if (stk.peek()<cur){
                        stk.push(cur);
                    }
                    else{
                        while(stk.peek()>cur){
                            char j = stk.pop();
                            System.out.println(j);
                        }
                    }
                }
            }
        }
        while(stk.isEmpty()){
            char m = stk.pop();
            System.out.println(m);
        }

    }

    public static void main(String[] args) {
        Postfix_from_infix pp = new Postfix_from_infix();
        String k ="a+b*(d+e)";
        pp.postfix(k);

    }
}
