package edu.qc.seclass;

import org.junit.*;

import static org.junit.Assert.*;

public class BuggyClassTestSC2 {

    BuggyClass myBuggyClass;

    @Before
    public void setUp() {
        myBuggyClass= new BuggyClass();
    }

    @After
    public void tearDown() {
        myBuggyClass = null;
    }

    //This test does 100% statement coverage and does not reveal fault
    @Test
    public void buggyMethod2() {
        assertEquals(1, myBuggyClass.buggyMethod2(1, 2,true));
        assertEquals(5, myBuggyClass.buggyMethod2(0, 5,true));
    }
}