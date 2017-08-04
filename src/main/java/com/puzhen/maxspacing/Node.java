package com.puzhen.maxspacing;

import java.util.HashSet;
import java.util.Set;

public class Node {

    public Node(String line, int bits) {
        origin = line;
        content = new byte[bits];
        String[] elements = line.split(" ");
        int i = 0;
        for (String bit : elements)
            content[i++] = Byte.valueOf(bit);

    }

    /**
     * @return the int value of this binary number
     */
    public int intValue() {
        int value = 0, length = content.length;
        for (int i = 0; i < length; i++) {
            value += content[i] * Math.pow(2, length - 1 - i);
        }
        return value;
    }

    /**
     * Get the Hamming distance between this node and the
     * input node.
     * @param node
     * @return Hamming distance between two nodes
     */
    public int distanceTo(Node node) {
        int distance = 0;
        byte[] content1 = node.getContent();
        for (int i = 0; i < content.length; i++)
            if (content[i] != content1[i])
                distance++;
        return distance;
    }

    @Override
    public boolean equals(Object obj) {
        Node newNode = (Node) obj;
        byte[] content1 = newNode.getContent();
        if (content.length != content1.length)
            return false;
        for (int i = 0; i < content.length; i++)
            if (content[i] != content1[i])
                return false;
        return true;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        StringBuffer sb = new StringBuffer();
        boolean first = true;
        for (byte bit : content) {
            if (first) {
                sb.append(bit);
                first = false;
            } else {
                sb.append(" " + bit);
            }
        }
        Node node = new Node(sb.toString(), content.length);
        return node;
    }

    @Override
    public String toString() {
        return origin;
    }

    @Override
    public int hashCode() {
        return intValue();
    }

    /**
     * This method finds all the nodes that has one or two
     * hamming distance with the given node.
     * @param node
     * @return a set of nodes.
     */
    public static Set<Node> generateNeighbors(Node node) {
        Set<Node> neighbors = new HashSet<Node>();
        byte[] content = node.getContent();
        int length = content.length;
        // find all 1-distance neighbors
        for (int i = 0; i < length; i++) {
            try {
                Node newNode = (Node) node.clone();
                byte[] newContent = newNode.getContent();
                newContent[i] = negate(newContent[i]);
                neighbors.add(newNode);
            } catch (CloneNotSupportedException e) {
                System.err.println("Cloning fails");
            }
        }

        // find all 2-distance neighbors
        for (int i = 0; i < length - 1; i++)
            for (int j = i + 1; j < length; j++) {
                try {
                    Node newNode = (Node) node.clone();
                    byte[] newContent = newNode.getContent();
                    newContent[i] = negate(newContent[i]);
                    newContent[j] = negate(newContent[j]);
                    neighbors.add(newNode);
                } catch (CloneNotSupportedException e) {
                    System.err.println("Cloning fails");
                }
            }
        return neighbors;
    }

    private static byte negate(byte bit) {
        if (bit == 0)
            return 1;
        else
            return 0;
    }

    public byte[] getContent() {
        return content;
    }


    private byte[] content;

    private String origin;
}
