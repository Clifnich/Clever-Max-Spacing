package com.puzhen.maxspacing;

import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

public class MainTest extends TestCase {

    public MainTest(String name) {
        super(name);
    }

    public void testSet() {
        Set<Node> set = new MyHashSet();
        set.add(new Node("1 0", 2));
        assertTrue(set.contains(new Node("1 0", 2)));
    }

    public void testStandardHashSet() {
        Set<Node> set = new HashSet();
        set.add(new Node("1 0", 2));
        assertTrue(set.contains(new Node("1 0", 2)));
    }
}
