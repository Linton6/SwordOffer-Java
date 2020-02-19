package pathfinding;
/**
 * Java: Dijkstra�㷨��ȡ���·��(�ڽӾ���)
 *
 * @author skywang
 * @date 2014/04/24
 */

import java.io.IOException;
import java.util.Scanner;

public class MatrixUDG {

    private int mEdgNum;        // �ߵ�����
    private char[] mVexs;       // ���㼯��
    private int[][] mMatrix;    // �ڽӾ���
    private static final int INF = Integer.MAX_VALUE;   // ���ֵ

    /*
     * ����ͼ(�Լ���������)
     */
    public MatrixUDG() {

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
        mVexs = new char[vlen];
        for (int i = 0; i < mVexs.length; i++) {
            System.out.printf("vertex(%d): ", i);
            mVexs[i] = readChar();
        }

        // 1. ��ʼ��"��"��Ȩֵ
        mEdgNum = elen;
        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                if (i==j)
                    mMatrix[i][j] = 0;
                else
                    mMatrix[i][j] = INF;
            }
        }
        // 2. ��ʼ��"��"��Ȩֵ: �����û���������г�ʼ��
        for (int i = 0; i < elen; i++) {
            // ��ȡ�ߵ���ʼ����,��������,Ȩֵ
            System.out.printf("edge(%d):", i);
            char c1 = readChar();       // ��ȡ"��ʼ����"
            char c2 = readChar();       // ��ȡ"��������"
            int weight = readInt();     // ��ȡ"Ȩֵ"

            int p1 = getPosition(c1);
            int p2 = getPosition(c2);
            if (p1==-1 || p2==-1) {
                System.out.printf("input error: invalid edge!\n");
                return ;
            }

            mMatrix[p1][p2] = weight;
            mMatrix[p2][p1] = weight;
        }
    }

    /*
     * ����ͼ(�����ṩ�ľ���)
     *
     * ����˵����
     *     vexs  -- ��������
     *     matrix-- ����(����)
     */
    public MatrixUDG(char[] vexs, int[][] matrix) {

        // ��ʼ��"������"��"����"
        int vlen = vexs.length;

        // ��ʼ��"����"
        mVexs = new char[vlen];
        for (int i = 0; i < mVexs.length; i++)
            mVexs[i] = vexs[i];

        // ��ʼ��"��"
        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++)
            for (int j = 0; j < vlen; j++)
                mMatrix[i][j] = matrix[i][j];

        // ͳ��"��"
        mEdgNum = 0;
        for (int i = 0; i < vlen; i++)
            for (int j = i+1; j < vlen; j++)
                if (mMatrix[i][j]!=INF)
                    mEdgNum++;
    }

    /*
     * ����chλ��
     */
    private int getPosition(char ch) {
        for(int i=0; i<mVexs.length; i++)
            if(mVexs[i]==ch)
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
     * ���ض���v�ĵ�һ���ڽӶ����������ʧ���򷵻�-1
     */
    private int firstVertex(int v) {

        if (v<0 || v>(mVexs.length-1))
            return -1;

        for (int i = 0; i < mVexs.length; i++)
            if (mMatrix[v][i]!=0 && mMatrix[v][i]!=INF)
                return i;

        return -1;
    }

    /*
     * ���ض���v�����w����һ���ڽӶ����������ʧ���򷵻�-1
     */
    private int nextVertex(int v, int w) {

        if (v<0 || v>(mVexs.length-1) || w<0 || w>(mVexs.length-1))
            return -1;

        for (int i = w + 1; i < mVexs.length; i++)
            if (mMatrix[v][i]!=0 && mMatrix[v][i]!=INF)
                return i;

        return -1;
    }

    /*
     * ���������������ͼ�ĵݹ�ʵ��
     */
    private void DFS(int i, boolean[] visited) {

        visited[i] = true;
        System.out.printf("%c ", mVexs[i]);
        // �����ö���������ڽӶ��㡣����û�з��ʹ�����ô����������
        for (int w = firstVertex(i); w >= 0; w = nextVertex(i, w)) {
            if (!visited[w])
                DFS(w, visited);
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
                System.out.printf("%c ", mVexs[i]);
                queue[rear++] = i;  // �����
            }

            while (head != rear) {
                int j = queue[head++];  // ������
                for (int k = firstVertex(j); k >= 0; k = nextVertex(j, k)) { //k��Ϊ���ʵ��ڽӶ���
                    if (!visited[k]) {
                        visited[k] = true;
                        System.out.printf("%c ", mVexs[k]);
                        queue[rear++] = k;
                    }
                }
            }
        }
        System.out.printf("\n");
    }

    /*
     * ��ӡ�������ͼ
     */
    public void print() {
        System.out.printf("Martix Graph:\n");
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = 0; j < mVexs.length; j++)
                System.out.printf("%10d ", mMatrix[i][j]);
            System.out.printf("\n");
        }
    }

    /*
     * prim��С������
     *
     * ����˵����
     *   start -- ��ͼ�еĵ�start��Ԫ�ؿ�ʼ��������С��
     */
    public void prim(int start) {
        int num = mVexs.length;         // �������
        int index=0;                    // prim��С������������prims���������
        char[] prims  = new char[num];  // prim��С���Ľ������
        int[] weights = new int[num];   // �����ߵ�Ȩֵ

        // prim��С�������е�һ������"ͼ�е�start������"����Ϊ�Ǵ�start��ʼ�ġ�
        prims[index++] = mVexs[start];

        // ��ʼ��"�����Ȩֵ����"��
        // ��ÿ�������Ȩֵ��ʼ��Ϊ"��start������"��"�ö���"��Ȩֵ��
        for (int i = 0; i < num; i++ )
            weights[i] = mMatrix[start][i];
        // ����start�������Ȩֵ��ʼ��Ϊ0��
        // �������Ϊ"��start�����㵽������ľ���Ϊ0"��
        weights[start] = 0;

        for (int i = 0; i < num; i++) {
            // ���ڴ�start��ʼ�ģ���˲���Ҫ�ٶԵ�start��������д���
            if(start == i)
                continue;

            int j = 0;
            int k = 0;
            int min = INF;
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
            prims[index++] = mVexs[k];
            // ��"��k�������Ȩֵ"���Ϊ0����ζ�ŵ�k�������Ѿ��������(����˵�Ѿ���������С�������)��
            weights[k] = 0;
            // ����k�����㱻���뵽��С�������Ľ��������֮�󣬸������������Ȩֵ��
            for (j = 0 ; j < num; j++) {
                // ����j���ڵ�û�б�����������Ҫ����ʱ�ű����¡�
                if (weights[j] != 0 && mMatrix[k][j] < weights[j])
                    weights[j] = mMatrix[k][j];
            }
        }

        // ������С��������Ȩֵ
        int sum = 0;
        for (int i = 1; i < index; i++) {
            int min = INF;
            // ��ȡprims[i]��mMatrix�е�λ��
            int n = getPosition(prims[i]);
            // ��vexs[0...i]�У��ҳ���j��Ȩֵ��С�Ķ��㡣
            for (int j = 0; j < i; j++) {
                int m = getPosition(prims[j]);
                if (mMatrix[m][n]<min)
                    min = mMatrix[m][n];
            }
            sum += min;
        }
        // ��ӡ��С������
        System.out.printf("PRIM(%c)=%d: ", mVexs[start], sum);
        for (int i = 0; i < index; i++)
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
            for (int j=i+1; j < mVexs.length; j++) {
                if (mMatrix[i][j]!=INF) {
                    edges[index++] = new EData(mVexs[i], mVexs[j], mMatrix[i][j]);
                }
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
        // flag[i]=true��ʾ"����vs"��"����i"�����·���ѳɹ���ȡ
        boolean[] flag = new boolean[mVexs.length];

        // ��ʼ��
        for (int i = 0; i < mVexs.length; i++) {
            flag[i] = false;          // ����i�����·����û��ȡ����
            prev[i] = 0;              // ����i��ǰ������Ϊ0��
            dist[i] = mMatrix[vs][i];  // ����i�����·��Ϊ"����vs"��"����i"��Ȩ��
        }

        // ��"����vs"������г�ʼ��
        flag[vs] = true;
        dist[vs] = 0;

        // ����mVexs.length-1�Σ�ÿ���ҳ�һ����������·����
        int k=0;
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
                int tmp = (mMatrix[k][j]==INF ? INF : (min + mMatrix[k][j]));
                if (flag[j]==false && (tmp<dist[j]) ) {
                    dist[j] = tmp;
                    prev[j] = k;
                }
            }
        }

        // ��ӡdijkstra���·���Ľ��
        System.out.printf("dijkstra(%c): \n", mVexs[vs]);
        for (int i=0; i < mVexs.length; i++)
            System.out.printf("  shortest(%c, %c)=%d\n", mVexs[vs], mVexs[i], dist[i]);
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
        int matrix[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {   0,  12, INF, INF, INF,  16,  14},
                /*B*/ {  12,   0,  10, INF, INF,   7, INF},
                /*C*/ { INF,  10,   0,   3,   5,   6, INF},
                /*D*/ { INF, INF,   3,   0,   4, INF, INF},
                /*E*/ { INF, INF,   5,   4,   0,   2,   8},
                /*F*/ {  16,   7,   6, INF,   2,   0,   9},
                /*G*/ {  14, INF, INF, INF,   8,   9,   0}};
        MatrixUDG pG;

        // �Զ���"ͼ"(����������)
        //pG = new MatrixUDG();
        // �������е�"ͼ"
        pG = new MatrixUDG(vexs, matrix);

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
