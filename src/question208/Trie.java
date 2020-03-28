package question208;

public class Trie {
    //节点是否为单词串的结尾
    private boolean isEnd;
    //字符集是a-z
    private Trie[] next;
    private final int SIZE = 26;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.isEnd = false;
        this.next = new Trie[SIZE];
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        //拿到根节点
        Trie temp = this;
        //遍历word
        for (char c : word.toCharArray()) {
            //每个字符对应的next映射下没有子树
            if (temp.next[c - 'a'] == null) {
                //当前字符的映射下创建节点
                temp.next[c - 'a'] = new Trie();
            }
            //拿到下一个节点
            temp = temp.next[c - 'a'];
        }
        //最后将字符映射到的最后一个节点设置为单词串的结尾
        temp.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        //拿到根节点
        Trie temp = this;
        for (char c : word.toCharArray()) {
            //没有匹配的前缀链，false
            if (temp.next[c - 'a'] == null) {
                return false;
            }
            temp = temp.next[c - 'a'];
        }
        //返回成功匹配的前缀链是否为一个单词串的结尾
        return temp.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie temp = this;
        for (char c : prefix.toCharArray()) {
            if (temp.next[c - 'a'] == null) {
                return false;
            }
            temp = temp.next[c - 'a'];
        }
        return true;
    }
}
