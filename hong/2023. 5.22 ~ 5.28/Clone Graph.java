/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    HashMap<Integer, Node> map;
    
    public Node cloneGraph(Node node) {
        System.out.println(node.val);
        map = new HashMap<>();
        
        Node newNode = new Node(node.val, new ArrayList<Node>(node.neighbors));
        dfs(newNode);
        return newNode;
    }
    
    private Node dfs(Node node) {
        // 현재 노드 복사
        Node copy = new Node(node.val, new ArrayList<Node>(node.neighbors));
        map.put(copy.val, copy);
        
        // 이웃에 대하여 DFS ㄱㄱ
        for (Node neighbor : copy.neighbors) {
            // 이미 복사한 애면 안함
            if (map.containsKey(neighbor.val))
                continue;
            
            dfs(neighbor);
        }
        
        return copy;
    }
}