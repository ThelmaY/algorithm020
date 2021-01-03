class Solution {
    public void solve(char[][] board) {
        int nrow = board.length;
        if (nrow == 0) return;
        int ncol = board[0].length;

        UnionFind uf = new UnionFind(nrow*ncol+1);
        int edge = ncol*nrow;

        for (int i = 0;i<nrow;i++){
            for (int j = 0;j<ncol;j++){
                if (board[i][j] == 'O'){
                    if (i == 0 || i == nrow-1 || j == 0 || j == ncol-1 ){
                        uf.union(edge, i*ncol+j);
                    }else{
                        if (board[i-1][j] == 'O'){
                            uf.union(i*ncol+j, (i-1)*ncol+j);
                        }
                        if (board[i+1][j] == 'O'){
                            uf.union(i*ncol+j, (i+1)*ncol+j);
                        }
                        if (board[i][j-1] == 'O'){
                            uf.union(i*ncol+j, i*ncol+j-1);
                        }
                        if (board[i][j+1] == 'O'){
                            uf.union(i*ncol+j, i*ncol+j+1);
                        }
                    }
                }
            }
        }

        for (int i = 0;i<nrow;i++){
            for (int j = 0;j<ncol;j++){
                 if (board[i][j] == 'O'){
                    if (uf.find(i*ncol+j) != uf.find(edge)){
                        board[i][j] = 'X';
                    }
                 }
            }
        }
    }
}

class UnionFind {
    public int count = 0;
    private int[] parent;
    
    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ;
        count--;
    }
}