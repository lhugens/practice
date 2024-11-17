import java.util.Stack;

public class Solution {
    public static boolean isValid(String s){

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char current = s.charAt(i);

            if(current == '(' || current == '[' || current == '{'){
                stack.push(current);
            } else {
                switch (current) {
                    case ')':
                        if(!stack.isEmpty() && stack.peek() == '('){
                            stack.pop();
                            break;
                        }
                        return false;
                    case ']':
                        if(!stack.isEmpty() && stack.peek() == '['){
                            stack.pop();
                            break;
                        }
                        return false;
                    case '}':
                        if(!stack.isEmpty() && stack.peek() == '{'){
                            stack.pop();
                            break;
                        }
                        return false;
                }
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        String s;

        s = "()";
        System.out.println(isValid(s));

        s = "()[]{}";
        System.out.println(isValid(s));

        s = "(]";
        System.out.println(isValid(s));

        s = "([])";
        System.out.println(isValid(s));

        s = "]";
        System.out.println(isValid(s));
    }


}
