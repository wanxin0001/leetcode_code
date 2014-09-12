/*
LRU Cache Total Accepted: 17576 Total Submissions: 125046 My Submissions
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/

public class LRUCache {
    private class Node {
        Node prev;
        Node next;
        int key;
        int value;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            
            move_to_tail(node);
            
            return node.value;
        }
    }
    
    private void move_to_tail(Node node) {
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
        
    }
    
    public void set(int key, int value) {
        
        if ( get(key) != -1) {  //  Very important: cannot be map.containsKey(key) because the position fo the node should put to the end of the list
            map.get(key).value = value;
            return;
        }
        
        if (map.size() == capacity) {
            Node old = head.next;
            head.next = head.next.next;
            old.next.prev = head;
            map.remove(old.key);
            
        } 
        
        Node node = new Node(key, value);
        map.put(key, node);
        move_to_tail(node);
            
        
         
    
    }
}