package enterprise;

import java.util.Scanner;

/**
 * @Author Linton
 * @Date 2019/8/5 19:02
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class LostCattle {
    public static void main(String[] args) {
        TurnNode N = new TurnNode('N');
        TurnNode S = new TurnNode('S');
        TurnNode E = new TurnNode('E');
        TurnNode W = new TurnNode('W');
        N.left = E; N.right = W;
        E.left = S; E.right = N;
        S.left = W; S.right = E;
        W.left = N; W.right = S;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String str = in.nextLine();
        System.out.println(turn(S, str));
    }

    private static char turn(TurnNode node, String str) {
        if (str == null || str.length() == 0) {
            return  'S';
        }
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c == 'L') {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node.value;

    }

   private static class TurnNode {
        private char value;
        private  TurnNode left;
        private  TurnNode right;

        private TurnNode(char c){
            this.value = c;
            this.left = null;
            this.right = null;
        }
    }
}

