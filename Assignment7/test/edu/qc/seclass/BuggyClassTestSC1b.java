package edu.qc.seclass;

import org.junit.*;

import static org.junit.Assert.*;

public class BuggyClassTestSC1b {

    BuggyClass myBuggyClass;

    @Before
    public void setUp() {
        myBuggyClass= new BuggyClass();
    }

    @After        
    public void tearDown() {
        myBuggyClass = null;
    }

    //This test does less than 50% statement coverage and shows fault
    @Test
    public void buggyMethod1() {
        assertEquals(2, myBuggyClass.buggyMethod1(4, 2,false));
        assertEquals(2, myBuggyClass.buggyMethod1(2, 2,false));
    }
}