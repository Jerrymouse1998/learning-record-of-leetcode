package question68;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //时间复杂度：O(n)    遍历
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int n = words.length;
        while (i < n) {
            // 找到一行可以容下单词
            int left = i;
            // 至少一行能放下一个单词
            int cur_row_len = words[i].length();
            i++;

            while (i < n) {
                if (cur_row_len + words[i].length() + 1 > maxWidth) break;
                ;
                cur_row_len += words[i].length() + 1;
                i++;
            }
            StringBuilder tmp = new StringBuilder();
            // 考虑最后一行
            if (i == n) {
                for (int j = left; j < i; j++) {
                    tmp.append(words[j] + " ");
                }
                tmp.deleteCharAt(tmp.length() - 1);
                for (int j = tmp.length(); j < maxWidth; j++)
                    tmp.append(" ");
                res.add(tmp.toString());
                break;
            }
            // 所有单词长度
            int all_word_len = 0;
            for (int j = left; j < i; j++) {
                all_word_len += words[j].length();
            }
            //System.out.println(all_word_len);
            // 至少空格个数
            int space_num = i - left - 1;
            // 可以为空格的位置个数
            int remain_space = maxWidth - all_word_len;
            int a = 0;
            int b = 0;
            if (space_num != 0) {
                a = remain_space / space_num;
                b = remain_space % space_num;
            }
            for (int j = left; j < i; j++) {
                if (tmp.length() > 0) {
                    for (int k = 0; k < a; k++) tmp.append(" ");
                    if (b != 0) {
                        tmp.append(" ");
                        b--;
                    }
                }
                tmp.append(words[j]);
            }
            for (int j = tmp.length(); j < maxWidth; j++) {
                tmp.append(" ");
            }
            res.add(tmp.toString());
        }
        return res;
    }

}
