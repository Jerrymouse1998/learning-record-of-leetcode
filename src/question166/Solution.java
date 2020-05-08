package question166;

import java.util.HashMap;

public class Solution {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        long num = numerator;
        long den = denominator;
        //取符号
        String sign = "";
        if ((num ^ den) < 0) {
            sign = "-";
        }
        //都转为正数
        if (num < 0) num = -num;
        if (den < 0) den = -den;
        //计算整数部分
        long integer = num / den;
        long remain = num - integer * den;
        //记录当前值的索引,发生重复的索引位置
        int idx = 0, repeatIdx = -1;
        //小数部分,每个值及其对应的索引
        HashMap<Long, Integer> map = new HashMap<>();
        //小数部分
        String decimal = "";
        while (remain != 0) {
            //发生重复
            if (map.containsKey(remain)) {
                repeatIdx = map.get(remain);
                break;
            }
            map.put(remain, idx);
            remain *= 10;
            //计算商和余数
            long temp = remain / den;
            remain = remain - temp * den;
            //商接入小数部分
            decimal += temp;
            idx++;
        }
        //根据情况,拼接返回
        if (repeatIdx == -1) {
            if (decimal == "") {
                return sign + integer;
            } else {
                return sign + integer + "." + decimal;
            }
        } else {
            return sign + integer + "." +
                    decimal.substring(0, repeatIdx) +
                    "(" + decimal.substring(repeatIdx) + ")";
        }
    }

}
