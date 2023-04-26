
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

// 同层剪枝(去重)，used[i-1]被使用时，使用nums[i]。
// 相反,used[i-1]没被使用时，也不使用nums[i]

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        int length=nums.length;
        if(length==0){
            return ans;
        }
        Arrays.sort(nums);
        boolean[] used=new boolean[length];
        Deque<Integer> path=new ArrayDeque<>(); 
        dfs(ans,nums,0,length,path,used);
        return ans;
    }

    private void dfs(List<List<Integer>> res,int[] nums, int depth, int length, Deque<Integer> path, boolean[] used) {
        if(depth==length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < length; i++) {
            if(used[i]||(i>0&&nums[i]==nums[i-1]&&!used[i-1])){
                continue;
            }
            path.addLast(nums[i]);
            used[i]=true;
            dfs(res, nums, depth+1, length, path, used);
            used[i]=false;
            path.removeLast();
        }
    
    }
}