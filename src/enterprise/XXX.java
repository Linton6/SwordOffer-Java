package enterprise;

/**
 * @Date 2019/9/4 19:59
 * @携程表达式解析
 */


import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

public class XXX {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String expr) {
        int len  = expr.length();
        int left  = 0;
        int right = len - 1;
        int cl = 0;
        int rl = 0;
        while (right > left) {
            if (expr.charAt(left) == '(') {
                cl++;
                left++;
            }  else if (expr.charAt(left) == ')') {
                cl--;
                left++;
            } else {
                left++;
            }

            if (expr.charAt(right) == ')') {
                rl++;
                right--;
            } else if (expr.charAt(right) == '(') {
                rl--;
                right--;
            } else {
                right--;
            }
        }
        if (cl - rl != 0) {
            return "";
        }


        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < len; i++) {
            if (expr.charAt(i) == '(') {
                stack.push(expr.charAt(i));
                continue;
            }
            if (stack.contains('(')) {
                if (expr.charAt(i) != ')') {
                    stack.push(expr.charAt(i));
                } else {
                    while (!stack.isEmpty()){
                        if (stack.peek() != '('){
                            sb.append(stack.pop() );
                        } else {
                            stack.pop();
                            break;
                        }
                    }
                    if (stack.isEmpty()) {
                        res.append(sb);
                    }

                    // 清理sb
                    int size  = sb.length();
                    for (int j = 0; j < size ; j++) {
                        stack.push(sb.charAt(j));
                    }
                    sb.delete(0,size);
                }
            } else {
                res.append(expr.charAt(i));
            }

        }
        return res.toString();


    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}

