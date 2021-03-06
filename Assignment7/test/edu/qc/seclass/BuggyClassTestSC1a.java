package edu.qc.seclass;

import org.junit.*;

import static org.junit.Assert.*;

public class BuggyClassTestSC1a {

    BuggyClass myBuggyClass;

    @Before
    public void setUp() {
        myBuggyClass= new BuggyClass();
    }

    @After
    public void tearDown() {
        myBuggyClass = null;
    }

    //This test does 100% statement coverage but not 100% branch coverage and does not show the fault
    @Test
    public void buggyMethod1() {
        assertEquals(1, myBuggyClass.buggyMethod1(1, 1,true));
        assertEquals(2, myBuggyClass.buggyMethod1(4, 2,true));
    }
}