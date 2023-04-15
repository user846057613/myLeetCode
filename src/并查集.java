public class 并查集 {
    private int[] parent;      //记录节点的父结点
    private int[] rank;     //记录树的深度
    private int x;

    public void init(int capacity) {
        this.x = capacity;
        parent = new int[x];
        rank = new int[x];
        for (int i = 0; i < x; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int m) {
        if(parent[m] == m) {
            return m;
        }
        return find(parent[m]);
    }

    public int find1(int m) {
        if(parent[m] == m) {
            return m;
        }else {
            parent[m] = find(parent[m]);
            return parent[m];
        }

//        parent[m] == m ? m : (parent[m] = find(parent[m]));
    }

    public void union(int i, int j) {
        parent[find(i)] = find(j);
    }
    public void union1(int i, int j) {
        int x = find1(i), y = find1(j);
        if(rank[x] <= rank[y]) {
            parent[x] = y;
        }else {
            parent[y] = x;
        }
        if(rank[x] == rank[y] && x != y) {
            rank[y]++;
        }
    }
}
