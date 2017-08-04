package com.puzhen.maxspacing;

import junit.framework.TestCase;

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

        ExtendedUF uf = new ExtendedUF(set);
        uf.union(node1, node2);
        assertEquals(1, uf.count());
    }

    public void testFind() {
        Node node1 = new Node("1 0 0", 3);
        Set<Node> set = new HashSet<Node>();
        set.add(node1);

        ExtendedUF uf = new ExtendedUF(set);

        assertEquals(new Node("1 0 0", 3), uf.find(node1));
    }
}
