package question12;

public class GreedSolution {
    public static void main(String[] args) {
        System.out.println(new GreedSolution().intToRoman(2978));
    }
    public String intToRoman(int num) {
//        列出所有罗马数字和阿拉伯数字的特殊点
        String[] roman={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] arab={1000,900,500,400,100,90,50,40,10,9,5,4,1};
//        贪心算法
        String result="";
        int index=0;
        while (num>0){
            int count=num/arab[index];
            while (count-->0){
                result+=roman[index];
            }
            num%=arab[index];
            index++;
        }
        return result;
    }
}
