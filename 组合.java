import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        Deque<Integer> path=new ArrayDeque<>();
        dfs(ans,path,n,k,1,0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, Deque<Integer> path, int n, int k, int start, int count) {
        if(count==k){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < n+1; i++) {
            path.addLast(i);
            dfs(ans, path, n, k, i+1, count+1);
            path.removeLast();
        }
    }
}