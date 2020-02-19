package pathfinding;

/**
 * Java: Dijkstra�㷨��ȡ���·��(�ڽӱ�)
 *
 * @author skywang
 * @date 2014/04/24
 */

import java.io.IOException;
import java.util.Scanner;

public class ListUDG {
    private static int INF = Integer.MAX_VALUE;

    // �ڽӱ��б��Ӧ������Ķ���
    private class ENode {
        int ivex;       // �ñ���ָ��Ķ����λ��
        int weight;     // �ñߵ�Ȩ
        ENode nextEdge; // ָ����һ������ָ��
    }

    // �ڽӱ��б�Ķ���
    private class VNode {
        char data;          // ������Ϣ
        ENode firstEdge;    // ָ���һ�������ö���Ļ�
    };

    private int mEdgNum;    // �ߵ�����
    private VNode[] mVexs;  // ��������


    /*
     * ����ͼ(�Լ���������)
     */
    public ListUDG() {

        // ����"������"��"����"
        System.out.printf("input vertex number: ");
        int vlen = readInt();
        System.out.printf("input edge number: ");
        int elen = readInt();
        if ( vlen < 1 || elen < 1 || (elen > (vlen*(vlen - 1)))) {
            System.out.printf("input error: invalid parameters!\n");
            return ;
        }

        // ��ʼ��"����"
        mVexs = new VNode[vlen];
        for (int i = 0; i < mVexs.length; i++) {
            System.out.printf("vertex(%d): ", i);
            mVexs[i] = new VNode();
            mVexs[i].data = readChar();
            mVexs[i].firstEdge = null;
        }

        // ��ʼ��"��"
        mEdgNum = elen;
        for (int i = 0; i < elen; i++) {
            // ��ȡ�ߵ���ʼ����ͽ�������
            System.out.printf("edge(%d):", i);
            char c1 = readChar();
            char c2 = readChar();
            int weight = readInt();

            int p1 = getPosition(c1);
            int p2 = getPosition(c2);
            // ��ʼ��node1
            ENode node1 = new ENode();
            node1.ivex = p2;
            node1.weight = weight;
            // ��node1���ӵ�"p1���������ĩβ"
            if(mVexs[p1].firstEdge == null)
                mVexs[p1].firstEdge = node1;
            else
                linkLast(mVexs[p1].firstEdge, node1);
            // ��ʼ��node2
            ENode node2 = new ENode();
            node2.ivex = p1;
            node2.weight = weight;
            // ��node2���ӵ�"p2���������ĩβ"
            if(mVexs[p2].firstEdge == null)
                mVexs[p2].firstEdge = node2;
            else
                linkLast(mVexs[p2].firstEdge, node2);
        }
    }

    /*
     * ����ͼ(�����ṩ�ľ���)
     *
     * ����˵����
     *     vexs  -- ��������
     *     edges -- ��
     */
    public ListUDG(char[] vexs, EData[] edges) {

        // ��ʼ��"������"��"����"
        int vlen = vexs.length;
        int elen = edges.length;

        // ��ʼ��"����"
        mVexs = new VNode[vlen];
        for (int i = 0; i < mVexs.length; i++) {
            mVexs[i] = new VNode();
            mVexs[i].data = vexs[i];
            mVexs[i].firstEdge = null;
        }

        // ��ʼ��"��"
        mEdgNum = elen;
        for (int i = 0; i < elen; i++) {
            // ��ȡ�ߵ���ʼ����ͽ�������
            char c1 = edges[i].start;
            char c2 = edges[i].end;
            int weight = edges[i].weight;

            // ��ȡ�ߵ���ʼ����ͽ�������
            int p1 = getPosition(c1);
            int p2 = getPosition(c2);
            // ��ʼ��node1
            ENode node1 = new ENode();
            node1.ivex = p2;
            node1.weight = weight;
            // ��node1���ӵ�"p1���������ĩβ"
            if(mVexs[p1].firstEdge == null)
                mVexs[p1].firstEdge = node1;
            else
                linkLast(mVexs[p1].firstEdge, node1);
            // ��ʼ��node2
            ENode node2 = new ENode();
            node2.ivex = p1;
            node2.weight = weight;
            // ��node2���ӵ�"p2���������ĩβ"
            if(mVexs[p2].firstEdge == null)
                mVexs[p2].firstEdge = node2;
            else
                linkLast(mVexs[p2].firstEdge, node2);
        }
    }

    /*
     * ��node�ڵ����ӵ�list�����
     */
    private void linkLast(ENode list, ENode node) {
        ENode p = list;

        while(p.nextEdge!=null)
            p = p.nextEdge;
        p.nextEdge = node;
    }

    /*
     * ����chλ��
     */
    private int getPosition(char ch) {
        for(int i=0; i<mVexs.length; i++)
            if(mVexs[i].data==ch)
                return i;
        return -1;
    }

    /*
     * ��ȡһ�������ַ�
     */
    private char readChar() {
        char ch='0';

        do {
            try {
                ch = (char)System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while(!((ch>='a'&&ch<='z') || (ch>='A'&&ch<='Z')));

        return ch;
    }

    /*
     * ��ȡһ�������ַ�
     */
    private int readInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /*
     * ���������������ͼ�ĵݹ�ʵ��
     */
    private void DFS(int i, boolean[] visited) {
        ENode node;

        visited[i] = true;
        System.out.printf("%c ", mVexs[i].data);
        node = mVexs[i].firstEdge;
        while (node != null) {
            if (!visited[node.ivex])
                DFS(node.ivex, visited);
            node = node.nextEdge;
        }
    }

    /*
     * ���������������ͼ
     */
    public void DFS() {
        boolean[] visited = new boolean[mVexs.length];       // ������ʱ��

        // ��ʼ�����ж��㶼û�б�����
        for (int i = 0; i < mVexs.length; i++)
            visited[i] = false;

        System.out.printf("DFS: ");
        for (int i = 0; i < mVexs.length; i++) {
            if (!visited[i])
                DFS(i, visited);
        }
        System.out.printf("\n");
    }

    /*
     * ����������������������Ĳ�α�����
     */
    public void BFS() {
        int head = 0;
        int rear = 0;
        int[] queue = new int[mVexs.length];            // �������
        boolean[] visited = new boolean[mVexs.length];  // ������ʱ��

        for (int i = 0; i < mVexs.length; i++)
            visited[i] = false;

        System.out.printf("BFS: ");
        for (int i = 0; i < mVexs.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                System.out.printf("%c ", mVexs[i].data);
                queue[rear++] = i;  // �����
            }

            while (head != rear) {
                int j = queue[head++];  // ������
                ENode node = mVexs[j].firstEdge;
                while (node != null) {
                    int k = node.ivex;
                    if (!visited[k])
                    {
                        visited[k] = true;
                        System.out.printf("%c ", mVexs[k].data);
                        queue[rear++] = k;
                    }
                    node = node.nextEdge;
                }
            }
        }
        System.out.printf("\n");
    }

    /*
     * ��ӡ�������ͼ
     */
    public void print() {
        System.out.printf("List Graph:\n");
        for (int i = 0; i < mVexs.length; i++) {
            System.out.printf("%d(%c): ", i, mVexs[i].data);
            ENode node = mVexs[i].firstEdge;
            while (node != null) {
                System.out.printf("%d(%c) ", node.ivex, mVexs[node.ivex].data);
                node = node.nextEdge;
            }
            System.out.printf("\n");
        }
    }

    /*
     * ��ȡ��<start, end>��Ȩֵ����start��end������ͨ�ģ��򷵻������
     */
    private int getWeight(int start, int end) {

        if (start==end)
            return 0;

        ENode node = mVexs[start].firstEdge;
        while (node!=null) {
            if (end==node.ivex)
                return node.weight;
            node = node.nextEdge;
        }

        return INF;
    }

    /*
     * prim��С������
     *
     * ����˵����
     *   start -- ��ͼ�еĵ�start��Ԫ�ؿ�ʼ��������С��
     */
    public void prim(int start) {
        int min,i,j,k,m,n,tmp,sum;
        int num = mVexs.length;
        int index=0;                   // prim��С������������prims���������
        char[] prims = new char[num];  // prim��С���Ľ������
        int[] weights = new int[num];  // �����ߵ�Ȩֵ

        // prim��С�������е�һ������"ͼ�е�start������"����Ϊ�Ǵ�start��ʼ�ġ�
        prims[index++] = mVexs[start].data;

        // ��ʼ��"�����Ȩֵ����"��
        // ��ÿ�������Ȩֵ��ʼ��Ϊ"��start������"��"�ö���"��Ȩֵ��
        for (i = 0; i < num; i++ )
            weights[i] = getWeight(start, i);

        for (i = 0; i < num; i++) {
            // ���ڴ�start��ʼ�ģ���˲���Ҫ�ٶԵ�start��������д���
            if(start == i)
                continue;

            j = 0;
            k = 0;
            min = INF;
            // ��δ�����뵽��С�������Ķ����У��ҳ�Ȩֵ��С�Ķ��㡣
            while (j < num) {
                // ��weights[j]=0����ζ��"��j���ڵ��Ѿ��������"(����˵�Ѿ���������С��������)��
                if (weights[j] != 0 && weights[j] < min) {
                    min = weights[j];
                    k = j;
                }
                j++;
            }

            // ��������Ĵ������δ�����뵽��С�������Ķ����У�Ȩֵ��С�Ķ����ǵ�k�����㡣
            // ����k��������뵽��С�������Ľ��������
            prims[index++] = mVexs[k].data;
            // ��"��k�������Ȩֵ"���Ϊ0����ζ�ŵ�k�������Ѿ��������(����˵�Ѿ���������С�������)��
            weights[k] = 0;
            // ����k�����㱻���뵽��С�������Ľ��������֮�󣬸������������Ȩֵ��
            for (j = 0 ; j < num; j++) {
                // ��ȡ��k�����㵽��j�������Ȩֵ
                tmp = getWeight(k, j);
                // ����j���ڵ�û�б�����������Ҫ����ʱ�ű����¡�
                if (weights[j] != 0 && tmp < weights[j])
                    weights[j] = tmp;
            }
        }

        // ������С��������Ȩֵ
        sum = 0;
        for (i = 1; i < index; i++) {
            min = INF;
            // ��ȡprims[i]�ھ�����е�λ��
            n = getPosition(prims[i]);
            // ��vexs[0...i]�У��ҳ���j��Ȩֵ��С�Ķ��㡣
            for (j = 0; j < i; j++) {
                m = getPosition(prims[j]);
                tmp = getWeight(m, n);
                if (tmp < min)
                    min = tmp;
            }
            sum += min;
        }
        // ��ӡ��С������
        System.out.printf("PRIM(%c)=%d: ", mVexs[start].data, sum);
        for (i = 0; i < index; i++)
            System.out.printf("%c ", prims[i]);
        System.out.printf("\n");
    }

    /*
     * ��³˹������Kruskal)��С������
     */
    public void kruskal() {
        int index = 0;                      // rets���������
        int[] vends = new int[mEdgNum];     // ���ڱ���"������С������"��ÿ�������ڸ���С���е��յ㡣
        EData[] rets = new EData[mEdgNum];  // ������飬����kruskal��С�������ı�
        EData[] edges;                      // ͼ��Ӧ�����б�

        // ��ȡ"ͼ�����еı�"
        edges = getEdges();
        // ���߰���"Ȩ"�Ĵ�С��������(��С����)
        sortEdges(edges, mEdgNum);

        for (int i=0; i<mEdgNum; i++) {
            int p1 = getPosition(edges[i].start);      // ��ȡ��i���ߵ�"���"�����
            int p2 = getPosition(edges[i].end);        // ��ȡ��i���ߵ�"�յ�"�����

            int m = getEnd(vends, p1);                 // ��ȡp1��"���е���С������"�е��յ�
            int n = getEnd(vends, p2);                 // ��ȡp2��"���е���С������"�е��յ�
            // ���m!=n����ζ��"��i"��"�Ѿ���ӵ���С�������еĶ���"û���γɻ�·
            if (m != n) {
                vends[m] = n;                       // ����m��"���е���С������"�е��յ�Ϊn
                rets[index++] = edges[i];           // ������
            }
        }

        // ͳ�Ʋ���ӡ"kruskal��С������"����Ϣ
        int length = 0;
        for (int i = 0; i < index; i++)
            length += rets[i].weight;
        System.out.printf("Kruskal=%d: ", length);
        for (int i = 0; i < index; i++)
            System.out.printf("(%c,%c) ", rets[i].start, rets[i].end);
        System.out.printf("\n");
    }

    /*
     * ��ȡͼ�еı�
     */
    private EData[] getEdges() {
        int index=0;
        EData[] edges;

        edges = new EData[mEdgNum];
        for (int i=0; i < mVexs.length; i++) {

            ENode node = mVexs[i].firstEdge;
            while (node != null) {
                if (node.ivex > i) {
                    edges[index++] = new EData(mVexs[i].data, mVexs[node.ivex].data, node.weight);
                }
                node = node.nextEdge;
            }
        }

        return edges;
    }

    /*
     * �Ա߰���Ȩֵ��С��������(��С����)
     */
    private void sortEdges(EData[] edges, int elen) {

        for (int i=0; i<elen; i++) {
            for (int j=i+1; j<elen; j++) {

                if (edges[i].weight > edges[j].weight) {
                    // ����"��i"��"��j"
                    EData tmp = edges[i];
                    edges[i] = edges[j];
                    edges[j] = tmp;
                }
            }
        }
    }

    /*
     * ��ȡi���յ�
     */
    private int getEnd(int[] vends, int i) {
        while (vends[i] != 0)
            i = vends[i];
        return i;
    }

    /*
     * Dijkstra���·����
     * ����ͳ��ͼ��"����vs"������������������·����
     *
     * ����˵����
     *       vs -- ��ʼ����(start vertex)��������"����vs"��������������·����
     *     prev -- ǰ���������顣����prev[i]��ֵ��"����vs"��"����i"�����·����������ȫ�������У�λ��"����i"֮ǰ���Ǹ����㡣
     *     dist -- �������顣����dist[i]��"����vs"��"����i"�����·���ĳ��ȡ�
     */
    public void dijkstra(int vs, int[] prev, int[] dist) {
        // flag[i]=true��ʾ"����vs"��"����i"�����·���ѳɹ���ȡ��
        boolean[] flag = new boolean[mVexs.length];

        // ��ʼ��
        for (int i = 0; i < mVexs.length; i++) {
            flag[i] = false;            // ����i�����·����û��ȡ����
            prev[i] = 0;                // ����i��ǰ������Ϊ0��
            dist[i] = getWeight(vs, i); // ����i�����·��Ϊ"����vs"��"����i"��Ȩ��
        }

        // ��"����vs"������г�ʼ��
        flag[vs] = true;
        dist[vs] = 0;

        // ����mVexs.length-1�Σ�ÿ���ҳ�һ����������·����
        int k = 0;
        for (int i = 1; i < mVexs.length; i++) {
            // Ѱ�ҵ�ǰ��С��·����
            // ������δ��ȡ���·���Ķ����У��ҵ���vs����Ķ���(k)��
            int min = INF;
            for (int j = 0; j < mVexs.length; j++) {
                if (flag[j]==false && dist[j]<min) {
                    min = dist[j];
                    k = j;
                }
            }
            // ���"����k"Ϊ�Ѿ���ȡ�����·��
            flag[k] = true;

            // ������ǰ���·����ǰ������
            // �������Ѿ�"����k�����·��"֮�󣬸���"δ��ȡ���·���Ķ�������·����ǰ������"��
            for (int j = 0; j < mVexs.length; j++) {
                int tmp = getWeight(k, j);
                tmp = (tmp==INF ? INF : (min + tmp)); // ��ֹ���
                if (flag[j]==false && (tmp<dist[j]) )
                {
                    dist[j] = tmp;
                    prev[j] = k;
                }
            }
        }

        // ��ӡdijkstra���·���Ľ��
        System.out.printf("dijkstra(%c): \n", mVexs[vs].data);
        for (int i = 0; i < mVexs.length; i++)
            System.out.printf("  shortest(%c, %c)=%d\n", mVexs[vs].data, mVexs[i].data, dist[i]);
    }


    // �ߵĽṹ��
    private static class EData {
        char start; // �ߵ����
        char end;   // �ߵ��յ�
        int weight; // �ߵ�Ȩ��

        public EData(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    };

    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        EData[] edges = {
                // ��� �յ� Ȩ
                new EData('A', 'B', 12),
                new EData('A', 'F', 16),
                new EData('A', 'G', 14),
                new EData('B', 'C', 10),
                new EData('B', 'F',  7),
                new EData('C', 'D',  3),
                new EData('C', 'E',  5),
                new EData('C', 'F',  6),
                new EData('D', 'E',  4),
                new EData('E', 'F',  2),
                new EData('E', 'G',  8),
                new EData('F', 'G',  9),
        };
        ListUDG pG;

        // �Զ���"ͼ"(����������)
        //pG = new ListUDG();
        // �������е�"ͼ"
        pG = new ListUDG(vexs, edges);

        //pG.print();   // ��ӡͼ
        //pG.DFS();     // ������ȱ���
        //pG.BFS();     // ������ȱ���
        //pG.prim(0);   // prim�㷨������С������
        //pG.kruskal(); // Kruskal�㷨������С������

        int[] prev = new int[pG.mVexs.length];
        int[] dist = new int[pG.mVexs.length];
        // dijkstra�㷨��ȡ"��4������"�����������������̾���
        pG.dijkstra(3, prev, dist);
    }
}

