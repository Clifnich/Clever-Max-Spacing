package com.puzhen.maxspacing;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        Set<Node> set = createSet("clustering_big.txt");
        System.out.println("Finish reading and parsing the data file, now union-find processing them...");

        ExtendedUF uf = new ExtendedUF(set);

        int i = 0;
        for (Node node : set) {
            System.out.println("Examing neighbors of node " + ++i);
            Set<Node> neighbors = Node.generateNeighbors(node);
            for (Node neighbor : neighbors)
                if (set.contains(neighbor))
                    uf.union(node, neighbor);
        }

        System.out.println("Finish examing neighbors, now computing leaders");


        System.out.println("Final number of clusters is : " + uf.count());
    }

    public static Set<Node> createSet(String filename) throws IOException{
        BufferedReader rd = new BufferedReader(new FileReader(new File(filename)));
        String line = rd.readLine();
        String[] elements = line.split(" ");
        int length = Integer.valueOf(elements[1]);
        Set<Node> set = new HashSet();
        // read and parse the data file
        while ((line = rd.readLine()) != null)
            set.add(new Node(line, length));
        return set;
    }
}
