package com.puzhen.maxspacing;

import junit.framework.TestCase;
import org.jgrapht.alg.util.UnionFind;

import java.util.HashSet;
import java.util.Set;

public class UnionFindTest extends TestCase {

    public UnionFindTest(String name) {
        super(name);
    }

    public void testUnion() {
        Node node1 = new Node("1 0 0", 3);
        Node node2 = new Node("1 0 1", 3);
        Set<Node> set = new HashSet<Node>();
        set.add(node1); set.add(node2);

        MyUnionFind uf = new MyUnionFind(set);
        uf.union(node1, node2);
        assertEquals(1, uf.count());
    }

    public void testFind() {
        Node node1 = new Node("1 0 0", 3);
        Set<Node> set = new HashSet<Node>();
        set.add(node1);

        MyUnionFind uf = new MyUnionFind(set);

        assertEquals(new Node("1 0 0", 3), uf.find(node1));
    }
}
