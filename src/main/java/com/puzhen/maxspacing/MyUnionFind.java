package com.puzhen.maxspacing;

import org.jgrapht.alg.util.UnionFind;

import java.util.HashSet;
import java.util.Set;

public class MyUnionFind extends UnionFind<Node> {

    public MyUnionFind(Set<Node> set) {
        super(set);
        this.set = set;
    }

    /**
     * @return the number of components
     */
    public int count() {
        Set<Node> leaders = new MyHashSet();
        // count the components
        for (Node node : set) {
            Node leader = find(node);
            if (!leaders.contains(leader))
                leaders.add(leader);
        }
        return leaders.size();
    }

    private Set<Node> set;
}
