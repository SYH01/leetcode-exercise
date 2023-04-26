import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(ans, candidates, path, target, 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, int[] candidates, Deque<Integer> path, int target, int num) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = num; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            dfs(ans, candidates, path, target - candidates[i], i);
            path.removeLast();
        }
    }
}