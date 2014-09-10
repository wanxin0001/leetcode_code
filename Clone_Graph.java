/*
Clone Graph Total Accepted: 16582 Total Submissions: 72710 My Submissions
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        queue.offer(node);
        map.put(node, head);
        set.add(node);
        while (!set.isEmpty()) {
            
            UndirectedGraphNode cur = queue.poll();
            if (!set.contains(cur)) {
                continue;
            }
            set.remove(cur);
            for (int i = 0; i < cur.neighbors.size(); i++) {
                if (map.containsKey(cur.neighbors.get(i))) {
                    map.get(cur).neighbors.add(map.get(cur.neighbors.get(i)));
                    
                } else {
                    UndirectedGraphNode newNode = new UndirectedGraphNode(cur.neighbors.get(i).label);
                    map.put(cur.neighbors.get(i), newNode);
                    set.add(cur.neighbors.get(i));
                    map.get(cur).neighbors.add(newNode);
                }
                queue.offer(cur.neighbors.get(i));
                
            }
            
            
        }
        return head;
    }
}