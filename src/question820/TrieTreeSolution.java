package question820;

import java.util.Arrays;

public class TrieTreeSolution {
    //时间复杂度：O(∑words[i].length) 所有单词的字符数量和
    public int minimumLengthEncoding(String[] words) {
        int len=0;
        Trie trie=new Trie();
        //按照单词从长到短排序
        Arrays.sort(words,(e1,e2)->e2.length()-e1.length());
        //单词依次向字典树进行插入，记录新增单词的长度
        for (String word : words) {
            len+=trie.insertWord(word);
        }
        return len;
    }

    //定义一个TrieTree
    class Trie{
        private Trie[] next;
        private final int SIZE=26;

        Trie(){
            this.next=new Trie[SIZE];
        }

        public int insertWord(String word){
            boolean isNew=false;//是否为新单词
            Trie curr = this;
            for (int i = word.length()-1; i >= 0; i--) {
                char c = word.charAt(i);
                if (curr.next[c - 'a'] == null) {
                    isNew=true;
                    curr.next[c - 'a']=new Trie();
                }
                curr=curr.next[c - 'a'];
            }
            //如果是新单词就返回单词长度+'#'，否则是旧单词的前缀返回0
            return isNew?word.length()+1:0;
        }
    }
}
