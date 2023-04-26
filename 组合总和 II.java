import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
// 先对数组进行排序，然后在同一层中相同数字不参与使用，但是下层中可能可以参与使用
// 比如1，1在第一层中第二个1不参与，但是在下一层中要参与
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Deque<Integer> path=new ArrayDeque<>();
        Arrays.sort(candidates);
        dfs(ans,candidates,target,path,0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans,int[] candidates, int target, Deque<Integer> path, int i) {
        if(target==0){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(target<0){
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            if(j>0&&candidates[j]==candidates[j-1]&&j!=i){
                continue;
            }
            path.addLast(candidates[j]);
            dfs(ans, candidates, target-candidates[j], path, j+1);
            path.removeLast();
        }
    }
}