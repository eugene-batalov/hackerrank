package hackerrank.datastructures;

import java.util.Scanner;
import java.util.Stack;

public class JavaStack {
    private final static Character O1 = '{';
    private final static Character C1 = '}';
    private final static Character O2 = '(';
    private final static Character C2 = ')';
    private final static Character O3 = '[';
    private final static Character C3 = ']';

    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input=sc.next();
            System.out.println(isValid(input));
        }

    }

    private static boolean isValid(String input) {
        StringBuilder sb = new StringBuilder(input);
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            Character c = sb.charAt(i);
            if (c.equals(C1) || c.equals(C2) || c.equals(C3)) {
                if(stack.isEmpty()){
                    return false;
                }
                Character onTop = stack.pop();
                if(c.equals(C1) && !onTop.equals(O1) || c.equals(C2) && !onTop.equals(O2) || c.equals(C3) && !onTop.equals(O3) ){
                    return false;
                }
            }
            else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
