package question127;

import java.util.*;

public class DoubleBFSSolution {
    //时间复杂度：O(n*len)    n单词个数，len单词长度
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) return 0;
        //将beginWord加入list
        wordList.add(beginWord);
        //begin找end
        Queue<String> queue1 = new LinkedList<>();
        Set<String> visited1 = new HashSet<>();
        queue1.add(beginWord);
        visited1.add(beginWord);
        //end找begin
        Queue<String> queue2 = new LinkedList<>();
        Set<String> visited2 = new HashSet<>();
        queue2.add(endWord);
        visited2.add(endWord);
        int depth = 0;
        Set<String> allWord = new HashSet<>(wordList);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            //将节点更少的作为 1
            if (queue1.size() > queue2.size()) {
                Queue<String> temp = queue1;
                queue1 = queue2;
                queue2 = temp;
                Set<String> set = visited1;
                visited1 = visited2;
                visited2 = set;
            }
            //开始遍历
            depth++;
            int size = queue1.size();
            while (size-- > 0) {
                String poll = queue1.poll();
                char[] chars = poll.toCharArray();
                //遍历poll的每个字符
                for (int i = 0; i < chars.length; i++) {
                    //保存第i个字符,判断结束后需要还原
                    char temp = chars[i];
                    //将poll的每个字符逐个替换为其他字符
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        //判断替换后的单词
                        String newString = new String(chars);
                        if (visited1.contains(newString)) {
                            continue;
                        }
                        if (visited2.contains(newString)) {
                            return depth + 1;
                        }
                        //如果替换后的单词,存在字典中，则入队并标记访问
                        if (allWord.contains(newString)) {
                            queue1.add(newString);
                            visited1.add(newString);
                        }
                    }
                    //还原第i个字符
                    chars[i] = temp;
                }
            }
        }
        return 0;
    }

}
