package com.puzhen.maxspacing;

import org.jgrapht.alg.util.UnionFind;
import java.util.Set;

/**
 * This class extends the UnionFind from jGraphT library
 */
public class ExtendedUF extends UnionFind<Node> {

    public ExtendedUF(Set<Node> set) {
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
