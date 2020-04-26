package question127;

import java.util.*;

public class BFSSolution {
    //O(n^2)	层序遍历，每次弹出元素都要进行一次遍历list。
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) return 0;
        //记录已访问过的元素
        boolean[] isVisited = new boolean[wordList.size()];
        //广搜队列
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        //深度
        int depth = 0;
        //广搜/层序遍历模板
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    //已经访问过的元素跳过,树中不存在重复节点
                    if (isVisited[j]) {
                        continue;
                    }
                    //孩子节点只能改变一个字符转换为s,不满足则跳过
                    if (!canConvert(poll, wordList.get(j))) {
                        continue;
                    }
                    //如果节点s等于endWord,接龙完成
                    if (wordList.get(j).equals(endWord)) {
                        return depth + 1;
                    }
                    isVisited[j] = true;
                    queue.add(wordList.get(j));
                }
            }
        }
        return 0;
    }

    //poll是否只可以改变一个字符转换为s
    private boolean canConvert(String poll, String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (poll.charAt(i) != s.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }
}
