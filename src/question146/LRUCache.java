package question146;

import java.util.HashMap;

public class LRUCache {
    //key 和 Node 映射
    HashMap<Integer, Node> map;
    //双向链表
    DoubleLinkedList cache;
    //缓存容量
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cache = new DoubleLinkedList();
        this.capacity = capacity;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        //如果key存在,则更新
        if (map.containsKey(key)) {
            //删除旧节点,不需要手动更新map,后面会进行覆盖
            cache.remove(map.get(key));
        } else if (cache.size == capacity) {
            //key不存在,且缓存已满
            //删除表尾节点
            Node last = cache.removeLast();
            //更新map
            map.remove(last.key);
        }
        //新节点添加到表头
        cache.addFirst(node);
        //更新map
        map.put(key, node);
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        int value = map.get(key).value;
        //使用put方法,将访问过的键值对节点放到
        put(key, value);
        return value;
    }

}
