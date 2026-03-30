class LRUCache {
    int cap;
    Map<Integer,Integer> cache;
    LinkedHashSet<Integer> keys;

    public LRUCache(int capacity) {
        cap = capacity;
        cache = new LinkedHashMap<>();
        keys = new LinkedHashSet<>();
    }
    
    public int get(int key) {
        int ret = cache.getOrDefault(key,-1);
        if(ret == -1) return ret;

        keys.remove(key);
        keys.add(key);

        return ret; 
    }
    
    public void put(int key, int value) {
        if(keys.contains(key)){
            keys.remove(key);
        }
        keys.add(key);

        cache.put(key,value);

        if(keys.size() > cap){
            cache.remove(keys.removeFirst());
        }
        
    }
}
