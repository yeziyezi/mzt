package one.yezii.mzt.common;

import java.util.HashMap;

public class ChainedMap<K, V> extends HashMap<K, V> {
    public ChainedMap<K, V> set(K key, V value) {
        put(key, value);
        return this;
    }
}
