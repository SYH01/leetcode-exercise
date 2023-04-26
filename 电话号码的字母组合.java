import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

// 分层递归
// 1 abc
// 2 def
// 3 ghi
// 4


class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return Collections.emptyList();
        }
        int[] d=new int[digits.length()];
        for (int i = 0; i < d.length; i++) {
            d[i]=Integer.parseInt(String.valueOf(digits.charAt(i)));
        }
        List<String> ans=new ArrayList<>();
        List<String> numStr=new ArrayList<String>(){{
            add("abc");
            add("def");
            add("ghi");
            add("jkl");
            add("mno");
            add("pqrs");
            add("tuv");
            add("wxyz");
        }};
        Deque<String> path=new ArrayDeque<>();
        int count=0;
        dfs(d,ans,numStr,path,count);
        return ans;
    }

    private String listToStr(Deque<String> a){
        String s=new String();
        for(Object o:a){
            s=s+o;
        }
        return s;
    }

    private void dfs(int[] d,List<String> ans, List<String> numStr, Deque<String> path,int count) {
        if(count==d.length){
            ans.add(listToStr(path));
            return;
        }
        for (int i = 0; i < numStr.get(d[count]-2).length(); i++) {
            path.addLast(String.valueOf(numStr.get(d[count]-2).charAt(i)));
            dfs(d, ans, numStr, path, count+1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        String digits = "";
        Solution solution=new Solution();
        System.out.println(solution.letterCombinations(digits));
    }
}
