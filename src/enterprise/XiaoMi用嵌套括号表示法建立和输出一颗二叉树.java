package enterprise;

/**
 * @Date 2019/9/6 20:20
 * @用嵌套括号表示法建立和输出一颗二叉树
 * （1）从左到右扫描树的括号表示；
 *
 * （2）每当遇到左括号时，其前一个结点进栈，并读入下一个符号；
 *
 * （3）每当遇到右括号时，栈顶元素出栈。说明以栈顶元素为根的树（子树）构造完毕，此时若栈为空，算法结束，否则读入下一个符号
 *
 * （4）每当遇到结点时，则它一定为栈顶元素的子女，将其挂到栈顶元素的某子女位置上，并读入下一个符号；
 *
 * （5）每当遇到“，”，则略过该符号，并读入下一个符号。
 *
 * http://www.yanglajiao.com/article/y_16041527/79772627
 */
import java.util.*;
public class XiaoMi用嵌套括号表示法建立和输出一颗二叉树 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append("1").append("3").toString());
        System.out.println(Integer.valueOf('1' - '0'));
        String str = "1(2(3),4(5(,6),7)";
//        String str = "1(2(3,4(,5)),6(7))";

        TreeNode res = convert(str);
        System.out.println();

    }

    private static TreeNode convert(String str) {
        int len = str.length();
        char[] chs = str.toCharArray();
        TreeNode res = new TreeNode(1);
        TreeNode tmp = new TreeNode(1);
        TreeNode tmp2 = new TreeNode(1);
        boolean isLeft = true;

        Stack<TreeNode> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < len; i++) {

            if (chs[i] == '(') {
//                TreeNode p = new TreeNode(chs[i - 1] - '0');
                stack.push(new TreeNode(chs[i - 1] - '0'));
                index = i - 1;
            } else if (chs[i] == ')') {
                if (stack.isEmpty()) {
                    return res;
                } else {
                    tmp = stack.pop();
                    TreeNode q = new TreeNode(chs[i - 1] - '0');
                    if (chs[i - 2] == '(') {//左子树
                        tmp.left = q;
                    } else if (chs[i - 2] == ',') { // 右子树
                        tmp.right = q;
//                        if (chs[i - 3] != '(' || chs[i - 3] != ')' || chs[i - 3] != ','){
//                            tmp.left = new TreeNode(chs[i - 3] - '0');
//                        }
                    }
                    if (stack.isEmpty()) {
                        res = tmp;
                        return res; // 正确的返回
                    } else {
                        tmp2 = stack.peek();
//                        if(tmp2.left == null) {  // 这块处理的有问题（如果你还经常被那些不怎么出众和重要的事物吸引，那么说明你经历的还不够多，内心不够丰富，才需要关注大量外界的事物）
//                            tmp2.left = tmp;
//                        } else {
//                            tmp2.right = tmp;
//                        }
                        if (chs[index -  1] == '(') {
                            tmp2.left = tmp;
                        } else {
                            tmp2.right = tmp;
                        }
                    }


                }
            }
        }
        res = stack.pop();

//        System.out.println("输出格式不正确！！");

        return res;// 正确输入是不会执行到这一步的
    }
}


    class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int x) {
            val = x;
        }
}

