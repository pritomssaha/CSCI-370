package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {

        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {

        mycustomstring = null;
    }

    //tests for the testCountNumber() method
    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }
    //tests for nullPointerException
    @Test (expected = NullPointerException.class )
    public void testCountNumbers2() {
        mycustomstring.setString(null);
        mycustomstring.countNumbers();
    }

    @Test
    public void testCountNumbers3() {
        mycustomstring.setString("");
        assertEquals(0, mycustomstring.countNumbers());
    }

    //test for two number seperated by space
    @Test
    public void testCountNumbers4() {
        mycustomstring.setString("2 5two different number");
        assertEquals(2, mycustomstring.countNumbers());
    }

    //tests for four different number seperated by space
    @Test
    public void testCountNumbers5() {
        mycustomstring.setString("checking 256 365 1 12 ");
        assertEquals(4, mycustomstring.countNumbers());
    }

    //test if the current string contains no number
    @Test
    public void testCountNumbers6() {
        mycustomstring.setString("checking with n0 number");
        assertEquals(1, mycustomstring.countNumbers());
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("'bt t0 6snh r6rh", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }
    //tests for IllegalArgumentException
    @Test (expected = IllegalArgumentException.class )
    public void testGetEveryNthCharacterFromBeginningOrEnd3() {
        mycustomstring.setString("check test this exception");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, false);
    }
    //tests the NullPointerException
    @Test (expected = NullPointerException.class )
    public void testGetEveryNthCharacterFromBeginningOrEnd4() {
        mycustomstring.setString(null);
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, false);
    }

    //simple test to compare the results of this test to the next one
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd5() {
        mycustomstring.setString("hello world");
        assertEquals("el ol", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));
    }
    //simple test that starting from end usually nets the same result as starting from beginning but isn't always true
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd6() {
        mycustomstring.setString("hello world");
        assertEquals("el ol", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));
    }
    //test that proves starting from end and beginning of the string can net two different outcomes
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd7() {
        mycustomstring.setString("Rand0m Le113r are  v3ry rand0m");
        assertEquals("nme3a 3 nm", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd8() {
        mycustomstring.setString("Rand0m Le113r are  v3ry rand0m");
        assertEquals("Rd 1rr rrd", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    //test to print out the entire string by itteration
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd9() {
        mycustomstring.setString("Print me out");
        assertEquals("Print me out", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, false));
    }

    //test to print out the itteration by starting from the end and reordering
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd10() {
        mycustomstring.setString("Print me out completley");
        assertEquals("Print me out completley", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, true));
    }

    //tests the exception once more where n = -1
    @Test (expected = IllegalArgumentException.class )
    public void testGetEveryNthCharacterFromBeginningOrEnd11() {
        mycustomstring.setString("Testing illegalArgumentException exception");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(-1, false);
    }

    //to make sure that the outcome is empty if n is greater than the string length
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd12() {
        mycustomstring.setString("n is greater than string");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(27, true));
    }

    //prints out only spaces
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd13() {
        mycustomstring.setString("1 2 3 4 5 6 7 8 9 ");
        assertEquals("         ", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));
    }

    //prints out only the numbers
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd14() {
        mycustomstring.setString("1 2 3 4 5 6 7 8 9 ");
        assertEquals("123456789", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));
    }

    //test case for converting digits to string
    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }
    //tests the illegalArgumentException by making startingpoint > endingpoint
    @Test (expected = IllegalArgumentException.class)
    public void testConvertDigitsToNamesInSubstring2() {
        mycustomstring.setString("junit test ");
        mycustomstring.convertDigitsToNamesInSubstring(12,9);
    }
    //tests if index out of bounds exception for starting point
    @Test (expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring3() {
        mycustomstring.setString("junit test ");
        mycustomstring.convertDigitsToNamesInSubstring(0,11);
    }

    //tests if index out of bounds exception for Ending point
    @Test (expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring4() {
        mycustomstring.setString("junit test ");
        mycustomstring.convertDigitsToNamesInSubstring(1,mycustomstring.getString().length() + 1);
    }

    //tests NullPointer exception by making both starting and endpoints 0
    @Test (expected = NullPointerException.class)
    public void testConvertDigitsToNamesInSubstring5() {
        mycustomstring.setString(null);
        mycustomstring.convertDigitsToNamesInSubstring(1,2);
    }
    //Tests to make sure a space would work
    @Test
    public void testConvertDigitsToNamesInSubstring6() {
        mycustomstring.setString(" ");
        mycustomstring.convertDigitsToNamesInSubstring(1,1);
    }
    //Random rigorous test to see if the method fails
    @Test
    public void testConvertDigitsToNamesInSubstring7() {
        mycustomstring.setString("JuN1i1 135t");
        mycustomstring.convertDigitsToNamesInSubstring(2,7);
        assertEquals("JuNOneiOne 135t", mycustomstring.getString());
    }

    //tests the method with special keys
    @Test
    public void testConvertDigitsToNamesInSubstring8() {
        mycustomstring.setString("JuN1i1 135t");
        mycustomstring.convertDigitsToNamesInSubstring(1,10);
        assertEquals("JuNOneiOne OneThreeFivet", mycustomstring.getString());
    }
}
