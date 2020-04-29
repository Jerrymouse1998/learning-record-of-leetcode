package question133;

import DataStruction.graph.Node;

import java.util.*;

public class BFSSolution {
    //时间复杂度：O(n)	空间复杂度：O(n)  保存克隆图O(n)，队列O(w)，w是图的宽。
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node clone = new Node(node.val, new ArrayList<>());
        map.put(node, clone);
        Deque<Node> queue = new LinkedList<>();
        queue.offer(node);
        //广搜
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            //遍历节点的邻接点
            for (Node n : poll.neighbors) {
                //如果邻接点没有被访问过(未克隆),则进行克隆并入队
                if (!map.containsKey(n)) {
                    map.put(n, new Node(n.val, new ArrayList<>()));
                    queue.offer(n);
                }
                //将克隆的邻接点,添加到对应的克隆节点的邻接表中
                map.get(poll).neighbors.add(map.get(n));
            }
        }
        return clone;
    }

}
