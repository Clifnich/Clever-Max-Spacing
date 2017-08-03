package com.puzhen.maxspacing;

import junit.framework.Test;
import junit.framework.TestSuite;

public class RunAllTests {

    public static Test suite() {
        TestSuite suite = new TestSuite(RunAllTests.class.getName());

        suite.addTestSuite(NodeTest.class);
        suite.addTestSuite(UnionFindTest.class);
        suite.addTestSuite(MainTest.class);

        return suite;
    }
}
