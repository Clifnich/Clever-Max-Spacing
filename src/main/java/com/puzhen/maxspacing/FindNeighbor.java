package com.puzhen.maxspacing;

import java.io.IOException;
import java.util.Set;

public class FindNeighbor {

    public static void main(String[] args) throws IOException {
        Set<Node> set = Main.createSet("clustering_big.txt");
        for (Node n1 : set) {
            for (Node n2 : set) {
                if (n1.equals(n2)) continue;
                if (n1.distanceTo(n2) < 3) {
                    System.out.println("Find a match\r\n\t"
                            + n1.toString() + "\r\n\t" + n2.toString());
                }
            }
        }
    }
}
