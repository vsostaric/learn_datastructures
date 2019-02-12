package collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyMap<K, V> implements Map<K, V> {

    private int size;

    private Node<K, V> mapNodes;

    public MyMap() {
        this.size = 0;
    }

    private class Node<K, V> {

        Node<K, V> first;
        K key;
        V value;
        Node<K, V> next;
        Node<K, V> nextHash;

        final int hash;

        public Node(K key, V value, Node<K, V> first) {
            this.key = key;
            this.value = value;
            this.hash = this.key.hashCode();
            this.first = first;
        }

        public Node(K key, V value, Node<K, V> next, Node<K, V> first) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = this.key.hashCode();
            this.first = first;
        }

        public Node(K key, V value, Node<K, V> next, int hashCode) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = hashCode;
            this.first = this;
        }

        public Node(K key, V value, Node<K, V> next, int hashCode, Node<K, V> first) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = hashCode;
            this.first = first;
        }

        public boolean hasNext() {
            return next != null;
        }

        public boolean hasNextHash() {
            return nextHash != null;
        }

        public int getHash() {
            return hash;
        }
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {

        if (mapNodes == null) {
            return null;
        }

        int hash = key.hashCode();
        Node<K, V> node = mapNodes.first;

        boolean foundHash = false;
        do {
            if (node.hash == hash) {
                foundHash = true;
                break;
            }
            if(node.hasNextHash()) {
                node = node.nextHash;
            } else {
                break;
            }
        } while (true);

        if (!foundHash) {
            return null;
        }
        boolean foundNode = false;
        do {
            if (node.key.equals(key)) {
                foundNode = true;
                break;
            }
            if(node.hasNext()) {
                node = node.next;
            } else {
                break;
            }
        } while (true);

        if (!foundNode) {
            return null;
        }

        return node.value;
    }

    @Override
    public V put(K key, V value) {

        int hash = key.hashCode();

        if (mapNodes == null) {
            mapNodes = new Node<>(key, value, null, hash);
            size++;
            return value;
        }

        Node<K, V> node = mapNodes.first;
        boolean foundHash = false;
        while (!foundHash && node.hasNextHash()) {
            node = node.nextHash;
            if (node.hash == hash) {
                foundHash = true;
            }
        }

        if (foundHash) {
            boolean foundNode = false;
            while (!foundNode && node.hasNext()) {
                if (node.value == value) {
                    foundNode = true;
                    node.value = value;
                } else {
                    node = node.next;
                }
            }

            if (!foundNode) {
                node.next = new Node<>(key, value, null, node.hash, node.first);
                size++;
            }

        } else {
            node.nextHash = new Node<>(key, value, null, hash, node.first);
            size++;
        }

        return value;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
