package enterprise;

/**
 * @Author Linton
 * @Date 2019/7/28 14:55
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.*;
import java.util.Scanner;
public class C1 {
    public static void main1(String[] args) {
        Scanner in = new Scanner(System. in);
        String list1 = in.nextLine();
        String list2 = in.nextLine();
        String[] list3 = list1.split(" ");
        String[] list4 = list2.split(" ");
        int a1 = list3.length;
        float[] A = new float[a1];
        for(int i = 0; i < a1; i++){
            A[i] = Float.valueOf(list3[i]);
        }
        int a2 = list4.length;
        float[] B = new float[a2];
        for(int i = 0; i < a2; i++){
            B[i] = Float.valueOf(list4[i]);
        }
        float[] C = sort(A ,B);
        if (C == null) {
            System.out.println("NO");
        } else {
            System.out.println(Arrays.toString(C));
        }

//        System.out.println(list1);
//        System.out.println(list2);


    }

    public static float[] sort(float[] A, float[] B){
        if(A == null || A.length < 2 || B == null || B.length == 0 ) return null;
        int a = A.length;
        int b = B.length;
        int indexA = -1;
        for(int i = 0; i < a - 1; i++){
            if(A[i] >= A[i + 1]) {
                if (A[i] > A[i + 2]){
                    indexA = i;
                } else {
                    indexA = i + 1;
                }

            }
        }
        int leftA = indexA - 1;
        int rightA = indexA + 1;
        // 在B中取出范围的值
        float max = A[indexA];
        for(int i = 0; i < b; i++) {
            if(B[i] > A[leftA] && B[i] < A[rightA]){
                if(B[i] > max){
                    max = B[i];
                }
            }
        }
        if(A[indexA] == max) {
            return null;
        } else {
            A[indexA] = max;
            return A;
        }
    }

   static class TreeNode{
       public int val;
        public   TreeNode left;
       public  TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

    }
    /**
     * 判断完全二叉树
     */
    private static boolean judge(TreeNode node){
        if (node == null) {
            return false;
        }
//        while ()
            return true;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(8);
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(10);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(9);
        TreeNode g = new TreeNode(11);
        a.left = b; a.right = c; b.left = d; b.right = e;c.left = f; c.right = g;
        depth(a);
    }

    /**
     * 深度优先搜索树结构
     */
    private static void depth(TreeNode node) {
        if (node == null) {
            System.out.println("");
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.print(node.val + " ");

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 层次打印二叉树  <>广度优先搜索树结构</>
     */
    private static void print(TreeNode node) {
        if (node == null) {
            System.out.println("");
            return;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        ArrayList<TreeNode> l = new ArrayList<>();
        list.add(node);
        boolean flag = true;
        boolean leftNode = false;
        while (!list.isEmpty()) {
            node = list.pollFirst();
            if (node.right != null && node.left == null) {
                flag = false;
                break;
            }else  if (node.left != null && node.right != null){
                if (leftNode == true){
                    flag = false;
                    break;
                }
                    list.add(node.left);
                    list.add(node.right);
            } else if(node.right == null && node.left != null) {
                if (leftNode == false){
                    leftNode = true;
                } else {
                    flag = false;
                    break;
                }
            }

        }
        System.out.println(flag);
    }

}

