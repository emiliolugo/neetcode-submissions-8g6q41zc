class LRUCache {
    Map<Integer,Node> cache;
    Node head, tail;
    int cap;

    public LRUCache(int capacity) {
        cap = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();

    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Node retNode = cache.get(key);
        remove(retNode);
        add(retNode);
        return retNode.val;
    }
    
    public void put(int key, int value) {
         Node newNode = new Node(key,value);

        if(cache.containsKey(key)){
            Node remNode = cache.get(key);
            remove(remNode);
        }
        
        add(newNode);
        cache.put(newNode.key,newNode);
        if(cache.size() > cap){
            Node toBeRemoved = head.next;
            cache.remove(toBeRemoved.key);
            remove(toBeRemoved);
        }

    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void add(Node node){
        Node prevEnd = tail.prev;
        prevEnd.next = node;
        tail.prev = node;
        node.next = tail;
        node.prev = prevEnd;
    }

    class Node{
        int val,key;
        Node next;
        Node prev;

        public Node(int key, int val){
            this.val = val;
            this.key = key;
        }

    }
}
