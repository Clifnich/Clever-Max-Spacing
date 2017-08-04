package com.puzhen.maxspacing;

import junit.framework.TestCase;

import java.util.Set;

public class NodeTest extends TestCase {

    public NodeTest(String name) {
        super(name);
    }

    public void testConstructor() {
        Node node = new Node("1 0 1", 3);
        assertEquals(5, node.intValue());
    }

    public void testConstructor1() {
        Node node = new Node("1 0 1 0", 4);
        assertEquals(10, node.intValue());
    }

    public void testEquals() {
        Node node0 = new Node("1 0 1", 3);
        assertTrue(node0.equals(new Node("1 0 1", 3)));
    }

    public void testEquals1() {
        Node node = new Node("1 0 1 0", 4);
        assertTrue(node.equals(new Node("1 0 1 0", 4)));
    }

    public void testDistanceTo() {
        Node node = new Node("1 0 0", 3);
        assertEquals(1, node.distanceTo(new Node("1 0 1", 3)));
    }

    public void testDistanceTo1() {
        Node node = new Node("1 0 0", 3);
        assertEquals(0, node.distanceTo(new Node("1 0 0", 3)));
    }

    public void testClone() {
        Node node = new Node("1 0 0", 3);
        Node cloned = null;
        try {
            cloned = (Node) node.clone();
        } catch (CloneNotSupportedException e) {
            fail("Cloning fails");
        }
        assertEquals(4, cloned.intValue());
    }

    public void testClone1() {
        Node node = new Node("1 0 1 0", 4);
        Node cloned = null;
        try {
            cloned = (Node) node.clone();
        } catch (CloneNotSupportedException e) {
            fail("Cloning fails");
        }
        assertEquals(4, cloned.getContent().length);
    }

    public void testGenerateNeightbor() {
        Set<Node> set = Node.generateNeighbors(new Node("1", 1));
        assertEquals(1, set.size());
    }

    public void testGenerateNeightbor1() {
        Set<Node> set = Node.generateNeighbors(new Node("1 0", 2));
        assertEquals(3, set.size());
    }

    public void testGenerateNeightbor2() {
        Set<Node> set = Node.generateNeighbors(new Node("1 0 0", 3));
        assertEquals(6, set.size());
    }

    public void testHashCode() {
        Node node = new Node("1 0", 2);
        assertEquals(2, node.hashCode());
    }

    public void testHashCode1() {
        Node node = new Node("1 1", 2);
        assertEquals(3, node.hashCode());
    }
}
