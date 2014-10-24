package code;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created: 9/3/14 4:54 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * <p/>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */
public class LRUCache {

    private Map<Integer, Integer> dataStore;
    private int cacheSize;

    public LRUCache(int capacity) {
        dataStore = new LinkedHashMap<Integer, Integer>();
        this.cacheSize = capacity;

    }

    public int get(int key) {
        if (dataStore.containsKey(key)) {
            int value = dataStore.get(key);
            dataStore.remove(key);
            dataStore.put(key,value);
            return value;
        }  else {
            return -1;
        }

    }

    public void set(int key, int value) {
        if (dataStore.containsKey(key)){
            dataStore.remove(key);
            dataStore.put(key,value);
            return;
        }
        if (dataStore.size()>=cacheSize){
            dataStore.remove(dataStore.keySet().iterator().next());
        }
        dataStore.put(key,value);
    }

    public static void main (String[] args) {

        LRUCache lruCache = new LRUCache(2);
        lruCache.set(2,1);
        lruCache.set(1,1);
        lruCache.get(2);
        lruCache.set(4,1);
    }
}
