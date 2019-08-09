package 基础.进阶;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Comparator;

/**
 * @Author Linton
 * @Date 2019/8/8 16:16
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description  轮廓问题
 */
import java.util.*;
public class BuildingOutline04 {
    public static class Node {
        public boolean isUp;
        public int posi;
        public int h;


    public Node(boolean bORe, int position, int height) {
        isUp = bORe;
        posi = position;
        h = height;
    }
    }
    public static class NodeComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            if (o1.posi != o2.posi) {
                return o1.posi - o2.posi;
            }
            if (o1.isUp != o2.isUp) {   // 一个位置可能有两个信息
                return o1.isUp ? -1 : 1;
            }
            return 0;
        }
    }

    public static List<List<Integer>> buildingOutLine(int[][] buildings) {  // 一座大楼拆成2个信息
        Node[] nodes = new Node[buildings.length * 2];
        for (int i = 0; i < buildings.length; i++) {
            nodes[i * 2] = new Node(true, buildings[i][0], buildings[i][2]);
            nodes[i * 2 + 1] = new Node(false, buildings[i][1], buildings[i][2]);
        }

        Arrays.sort(nodes, new NodeComparator()); // 按位置排序
        TreeMap<Integer, Integer> htMap = new TreeMap<>(); // 红黑树
        TreeMap<Integer, Integer> pmMap = new TreeMap<>();  // 记录每个点的最大高度
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].isUp) {
                if (!htMap.containsKey(nodes[i].h)) {
                    htMap.put(nodes[i].h, 1);   // 第一次出现
                } else {
                    htMap.put(nodes[i].h, htMap.get(nodes[i].h) + 1);  // 上一次出现的次数 再加1
                }
            } else {
                if (htMap.containsKey(nodes[i].h)) {
                    if (htMap.get(nodes[i].h) == 1) {
                        htMap.remove(nodes[i].h);
                        } else {
                        htMap.put(nodes[i].h, htMap.get(nodes[i].h) - 1);
                    }
                }

            }
            // 收集每个点最大高度
            if (htMap.isEmpty()){
                pmMap.put(nodes[i].posi, 0);
            } else {
                pmMap.put(nodes[i].posi, htMap.lastKey());
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        int height = 0;
        for (Map.Entry<Integer, Integer> entry : pmMap.entrySet()) { // 不断跟踪最大高度
            int curPosition = entry.getKey();      // 这一段不清楚？？？？？   2:00左右
            int curMaxHeight = entry.getValue();
            if (height != curMaxHeight) {
                if (height != 0) {
                    List<Integer> newRecord = new ArrayList<>();
                    newRecord.add(start);
                    newRecord.add(curPosition);
                    newRecord.add(height);
                    res.add(newRecord);
                }
                start = curPosition;
                height = curMaxHeight;
            }
        }
        return res;
    }

}

