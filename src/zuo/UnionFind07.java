package zuo;

import java.util.HashMap;
import java.util.List;

/**
 * @Author Linton
 * @Date 2019/8/5 21:10
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description  并差集结构
 *
 */

public class UnionFind07 {
    public static class Node {
        // whatever you like String , Int ,char, F...
    }
    public static class UnionFindSet {
        public HashMap<Node, Node> fatherMap;
        public HashMap<Node, Integer> sizeMap;
        public  UnionFindSet () {
            fatherMap = new HashMap<Node, Node>();
            sizeMap = new HashMap<Node, Integer>();
        }

        public void makeSets(List<Node> nodes) {
            fatherMap.clear();
            sizeMap.clear();
            for (Node node : nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        private Node findHead(Node node) {
            Node father = fatherMap.get(node);
            if (father != node) {
                father = findHead(father);
            }
            fatherMap.put(node, father);
            return father;
         }

         public boolean isSameSet(Node a, Node b) {
            return findHead(a) == findHead(b); // 可以直接用==吗？
         }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aHead = findHead(a);
            Node bHead = findHead(b);
            if (aHead != bHead) {
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                if (aSetSize <= bSetSize) {
                    fatherMap.put(aHead, bHead);
                    sizeMap.put(bHead, aSetSize + bSetSize);
                } else {
                    fatherMap.put(bHead, aHead);
                    sizeMap.put(aHead, aSetSize + bSetSize);
                }
            }
        }
    }
}

