package question133;

import DataStruction.graph.Node;

import java.util.ArrayList;
import java.util.HashMap;

public class DFSSolution {
    //时间复杂度：O(n)	空间复杂度：O(n)  保存克隆图O(n)，递归栈O(h)，h是图的深度。
    HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        //如果node节点已经访问过(已克隆),则返回其克隆节点
        if (map.containsKey(node)) return map.get(node);
        //生成克隆节点
        Node clone = new Node(node.val, new ArrayList<>());
        //记录已访问的节点
        map.put(node, clone);
        //遍历源节点的邻接点
        for (Node n : node.neighbors) {
            //克隆每个邻接点,并添加到对应克隆节点的邻接表中
            clone.neighbors.add(cloneGraph(n));
        }
        return clone;
    }


}
