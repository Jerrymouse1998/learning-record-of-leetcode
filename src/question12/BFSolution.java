package question12;

public class BFSolution {
    public String intToRoman(int num) {
        String[][] roman=new String[][]{
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM","","","","","",""}
        };
        StringBuilder result=new StringBuilder();
        result.append(roman[3][num/1000%10]);//最高位，千位
        result.append(roman[2][num/100%10]);//百位
        result.append(roman[1][num/10%10]);//十位
        result.append(roman[0][num%10]);//个位
        return result.toString();
    }
}
