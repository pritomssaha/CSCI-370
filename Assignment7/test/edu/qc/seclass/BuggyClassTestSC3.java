package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuggyClassTestSC3 {

    BuggyClass myBuggyClass;

    @Before
    public void setUp() {
        myBuggyClass= new BuggyClass();
    }

    @After
    public void tearDown() {
        myBuggyClass = null;
    }

    //This test does 100% statement coverage, less than 100% branch coverage and reveal fault
    @Test
    public void buggyMethod3() {
        assertEquals(0, myBuggyClass.buggyMethod3(-1));

    }

}
