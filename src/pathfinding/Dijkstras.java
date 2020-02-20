package pathfinding;

import java.util.*;

public class Dijkstras {

    public static void main(String[] args) {
//        建图
        Graph g = new Graph();
        g.addVertex('A', Arrays.asList(new Vertex('B', 7), new Vertex('C', 8)));
        g.addVertex('B', Arrays.asList(new Vertex('A', 7), new Vertex('F', 2)));
        g.addVertex('C', Arrays.asList(new Vertex('A', 8), new Vertex('F', 6), new Vertex('G', 4)));
        g.addVertex('D', Arrays.asList(new Vertex('F', 8)));
        g.addVertex('E', Arrays.asList(new Vertex('H', 1)));
        g.addVertex('F', Arrays.asList(new Vertex('B', 2), new Vertex('C', 6), new Vertex('D', 8), new Vertex('G', 9), new Vertex('H', 3)));
        g.addVertex('G', Arrays.asList(new Vertex('C', 4), new Vertex('F', 9)));
        g.addVertex('H', Arrays.asList(new Vertex('E', 1), new Vertex('F', 3)));
//        最短路径
        System.out.println(g.getShortestPath('A', 'W'));
    }
}

//定义 顶点类
class Vertex implements Comparable<Vertex> {

    private Character id;
    private Integer distance;

    public Vertex(Character id, Integer distance) {
        super();
        this.id = id;
        this.distance = distance;
    }

    public Character getId() {
        return id;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setId(Character id) {
        this.id = id;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((distance == null) ? 0 : distance.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (distance == null) {
            if (other.distance != null)
                return false;
        } else if (!distance.equals(other.distance))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "pathfinding.Vertex [id=" + id + ", distance=" + distance + "]";
    }

    @Override
    public int compareTo(Vertex o) {
        if (this.distance < o.distance)
            return -1;
        else if (this.distance > o.distance)
            return 1;
        else
            return this.getId().compareTo(o.getId());
    }

}

// 定义图类，图的存储结构是邻接表
class Graph {

    private final Map<Character, List<Vertex>> vertices;

    public Graph() {
        this.vertices = new HashMap<Character, List<Vertex>>();
    }

//    增加邻接表的链接点
    public void addVertex(Character character, List<Vertex> vertex) {
        this.vertices.put(character, vertex);
    }

    /** 核心方法 */
    /**
     * 重点理解
     * distance：不断更新各个顶点与起始点的最短距离
     * previous：存储规划出的路径
     * nodes：一开始和distance一样，随着程序的进行，最短路径的顶点都被依次抛出
     * @param start
     * @param finish
     * @return
     */
    public List<Character> getShortestPath(Character start, Character finish) {
//        创建两个集合，一个集合distance记录已求出最短路径的顶点以及相应的最短路径长度；另一个集合distance记录还未求出最短路径的顶点以及该顶点到起点s的距离
        final Map<Character, Integer> distances = new HashMap<Character, Integer>();
        final Map<Character, Vertex> previous = new HashMap<Character, Vertex>();


        PriorityQueue<Vertex> nodes = new PriorityQueue<Vertex>();// 关于顶点集合的优先级队列，最小的优先

        // 执行完后，distance集合内除start顶点对应为0，其余顶点都为Integer.MAX_VALUE,previous集合所有顶点对饮null值
        // nodes集合内包含所有顶点，start顶点的distance为0，其余顶点都为Integer.MAX_VALUE，与distance集合相同。
        for(Character vertex : vertices.keySet()) {
            if (vertex == start) {
                distances.put(vertex, 0);// put vertex in map
                nodes.add(new Vertex(vertex, 0));
            } else {
                distances.put(vertex, Integer.MAX_VALUE);
                nodes.add(new Vertex(vertex, Integer.MAX_VALUE));
            }
            previous.put(vertex, null);
        }

        while (!nodes.isEmpty()) {

            Vertex smallest = nodes.poll();// 从nodes中找出路径最短的顶点
            if (smallest.getId() == finish) {// 若找到的顶点为finish顶点，路径查找结束，程序结束
                final List<Character> path = new ArrayList<Character>();
                while (previous.get(smallest.getId()) != null) { // previous集合中对应的finish顶点的value值不为null，则顶点加入path集合，输出路径；否者直接输出路径path
                    path.add(smallest.getId());
                    smallest = previous.get(smallest.getId());
                }
                return path;
            }

            if (distances.get(smallest.getId()) == Integer.MAX_VALUE) {//若找出的这个最短路径的顶点，在distance集合中的距离为Integer.MAX_VALUE，跳出本方法
                break;
            }

            // 更新nodes集合
            for (Vertex neighbor : vertices.get(smallest.getId())) { // 获取移出来最短路径顶点的相邻节点
                Integer alt = distances.get(smallest.getId()) + neighbor.getDistance();
                if (alt < distances.get(neighbor.getId())) {//与distance原先的value值做对比，小的话，就更新
                    distances.put(neighbor.getId(), alt);
                    previous.put(neighbor.getId(), smallest);//？？？？previous = new HashMap<Character, Vertex>()

                    forloop:
                    for(Vertex n : nodes) {//对nodes集合里的顶点进行更新
                        if (n.getId() == neighbor.getId()) {
                            nodes.remove(n);
                            n.setDistance(alt);
                            nodes.add(n);
                            break forloop;
                        }
                    }
                }
            }

        }

        // distance集合是最短距离的
        return new ArrayList<Character>(distances.keySet());
    }

}