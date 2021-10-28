package edu.qc.seclass;

import org.junit.*;

import static org.junit.Assert.*;

public class BuggyClassTestBC2 {

    BuggyClass myBuggyClass;

    @Before
    public void setUp() {
        myBuggyClass= new BuggyClass();
    }

    @After
    public void tearDown() {
        myBuggyClass = null;
    }

    //This test does more than 50% branch coverage and reveal fault
    @Test
    public void buggyMethod2() {
        assertEquals(5, myBuggyClass.buggyMethod2(2, 6,false));
        assertEquals(5, myBuggyClass.buggyMethod2(2, 6,false));
    }
}