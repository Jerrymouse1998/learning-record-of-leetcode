package question60;

public class CantorSolution {
    //时间复杂度：O(n^2)
    public String getPermutation(int n, int k) {
        StringBuilder ans=new StringBuilder();
        //所有可用数字
        StringBuilder map=new StringBuilder();
        for (int i = 1; i <= n ; i++)map.append(i);
        int groupId,index=n;
        //逐位确定
        for (int i = 1; i <= n; i++) {
            index--;
            //确定在当前分组的第几组
            groupId=(k-1)/foc(index);
            //得到分组的数字，移除使用过的数字
            ans.append(map.charAt(groupId));
            map.deleteCharAt(groupId);
            //更新k
            k-=groupId*foc(index);
        }
        return ans.toString();
    }
    // 求 i!
    private int foc(int i) {
        int x=1;
        while (i>=1){
            x*=i--;
        }
        return x;
    }
}
