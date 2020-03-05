package question1103;

public class BFSolution {
    //时间复杂度：O(Max(sqrt(candies),numpeople))
    public int[] distributeCandies(int candies, int num_people) {
        int[] res=new int[num_people];
        int curCandies=0;
        while (candies>0){
            res[curCandies%num_people]+=Math.min(curCandies+1,candies);
            candies-=curCandies+1;
            curCandies++;
        }
        return res;
    }
}
