class Solution {
    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0){
            return res;
        }
        dfs(n,1,k,new ArrayList<Integer>());
        return res;
    }

    public void dfs(int n, int begin, int k, List<Integer> comb){
        if (k == 0){
            res.add(new ArrayList<Integer>(comb));
            return;
        }

        for (int i = begin;i<=n-k+1;i++){
            comb.add(i);
            dfs(n,i+1, k-1, comb);
            comb.remove(comb.size()-1);
        }
        return;
    }
}