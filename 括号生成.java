import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        StringBuilder path=new StringBuilder();
        dfs(ans,path,0,0,n);
        return ans;
    }

    private void dfs(List<String> ans, StringBuilder path, int left, int right, int n) {
        if(right==n){
            ans.add(path.toString());
            return;
        }
        if(left<n){
            path.append("(");
            dfs(ans, path, left+1, right, n);
            path.deleteCharAt(path.length()-1);
        }
        if(right<left){
            path.append(")");
            dfs(ans, path, left, right+1, n);
            path.deleteCharAt(path.length()-1);
        }
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.generateParenthesis(3));
    }
}