package com.puzhen.maxspacing;

import java.util.*;

public class MyHashSet implements Set<Node> {

    private Map<Integer, Node> map;

    public MyHashSet() {
        map = new HashMap<Integer, Node>();
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.size() == 0;
    }

    public boolean contains(Object o) {
        Node node = (Node) o;
        return map.containsKey(new Integer(node.intValue()));
    }

    public Iterator<Node> iterator() {
        Set<Node> set = new HashSet<Node>();
        for (Integer key : map.keySet())
            set.add(map.get(key));
        return set.iterator();
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }

    public boolean add(Node node) {
        int key = node.intValue();
        Integer integerKey = new Integer(key);
        if (map.containsKey(integerKey))
            return false;
        else
            map.put(integerKey, node);
        return true;
    }

    public boolean remove(Object o) {
        Node node = (Node) o;
        Integer integerKey = new Integer(node.intValue());
        if (!map.containsKey(node.intValue()))
            return false;
        else
            map.remove(integerKey);
        return true;
    }

    public boolean containsAll(Collection<?> c) {
        for (Object obj : c) {
            Node node = (Node) obj;
            Integer integerKey = new Integer(node.intValue());
            if (!map.containsKey(integerKey))
                return false;
        }
        return true;
    }

    public boolean addAll(Collection<? extends Node> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public void clear() {

    }
}
