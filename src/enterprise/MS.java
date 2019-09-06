package enterprise;

/**
 * @Date 2019/8/22 16:56
 * @
 */
import java.util.*;
public class MS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        String[] strs = string.split(" ");
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> hashMap = new HashMap<>();
        for (String str : strs) {
            for (char c : str.toCharArray()) {
                hashMap.put(c, 0);
            }
        }
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < strs.length - 1; i++) {
            String cur = strs[i];
            String next = strs[i + 1];
            int len = Math.min(cur.length(), next.length());
            for (int j = 0; j < len; j++) {
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {
                    Set<Character> set = new HashSet<>();
                    if (map.containsKey(c1)) set = map.get(c1);
                    if (!set.contains(c2)) {
                        set.add(c2);
                        map.put(c1, set);
                        hashMap.put(c2, hashMap.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        LinkedList<Character> linkedlist = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == 0) {
                linkedlist.add(entry.getKey());
            }
        }

        while (!linkedlist.isEmpty()) {
            char parent = linkedlist.poll();
            sb.append(parent);
            if (map.containsKey(parent)) {
                for (char child : map.get(parent)) {
                    hashMap.put(child, hashMap.get(child) - 1);
                    if (hashMap.get(child) == 0) linkedlist.offer(child);
                }
            }
        }
        System.out.println(sb.toString());
    }
}

