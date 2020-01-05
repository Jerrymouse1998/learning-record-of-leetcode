package question9;

public class ConvertSolution {
    public boolean isPalindrome(int x) {
        String rs = new StringBuilder(x + "").reverse().toString();
        return (x+"").equals(rs);
    }
}
