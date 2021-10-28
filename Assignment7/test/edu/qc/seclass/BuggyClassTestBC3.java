package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuggyClassTestBC3 {

    BuggyClass myBuggyClass;

    @Before
    public void setUp() {
        myBuggyClass= new BuggyClass();
    }

    @After
    public void tearDown() {
        myBuggyClass = null;
    }

    //This test does 100% branch coverage and does not reveal fault
    @Test
    public void buggyMethod3() {
        assertEquals(-1, myBuggyClass.buggyMethod3(-2));
        assertEquals(0, myBuggyClass.buggyMethod3(2));
    }

}
