/*
 * BinaryDigitTest.java
 */

package org.simonpeter.examples.binarydigit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.simonpeter.examples.binarydigit.BinaryDigit.TRUE;
import static org.simonpeter.examples.binarydigit.BinaryDigit.FALSE;


/**
 * JUnit tests for {@link BinaryDigit}.
 *
 * @author  Simon Peter Chappell
 * @version 20100721
 * @see     org.simonpeter.examples.BinaryDigit
 */
public class BinaryDigitTest {

    BinaryDigit t1, t2, t3, f1, f2;

    /**
     * This method runs before each test and allows us to
     * create a couple of standard objects for the test.
     */
    @Before
    public void before() {
        t1 = TRUE;
        t2 = TRUE;
        t3 = TRUE;
        f1 = FALSE;
        f2 = FALSE;
    }


    /**
     * This method runs after each test and allows us to
     * clear out the test environment and dispose of our
     * standard test objects.
     */
    @After
    public void after() {
        t1 = null;
        t2 = null;
        f1 = null;
        f2 = null;
    }


    @Test public void testNullBehaviorOfEquals() {
    	// An object is never equal to null.
    	assertFalse(t1.equals(null));
    }

    @Test public void testReflexiveBehaviorOfEquals() {
    	// An object is always equal to itself.
    	assertEquals(t1, t1);
    	assertTrue(t1.equals(t1));
    }

    @Test public void testUnequalValuesOfEqual() {
    	// If o1 does not equal o2, then o2 must not equal o1.
    	assertFalse(t1.equals(f1));
    	assertFalse(f1.equals(t1));
    }

    @Test public void testSymmetricalBehaviorOfEquals() {
    	// If o1 is equal to o2, then o2 must be equal to o1.
    	assertTrue(t1.equals(t2));
    	assertTrue(t2.equals(t1));
    }

    @Test public void testTransitiveBehaviorOfEquals() {
    	// If o1 is equal to o2 and o2 is equal to o3,
    	// then o3 must be equal to o1.
    	assertTrue(t1.equals(t2));
    	assertTrue(t2.equals(t3));
    	assertTrue(t3.equals(t1));
    }

    @Test public void testEqualObjectsHaveEqualHashCodes() {
    	// Objects that are equal, must have equal hashcodes.
    	assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test public void testSameObjectAlwaysSameHashCode() {
    	// An unchanged object should always have the same hashcode.
    	int h1 = t1.hashCode();
    	int h2 = t1.hashCode();
    	assertEquals(h1, h2);
    }

    @Test public void testToString() {
        assertEquals("True",  t1.toString());
        assertEquals("False", f1.toString());
    }

    @Test public void testToBoolean() {
    	assertTrue(TRUE.toBoolean());
    	assertFalse(FALSE.toBoolean());
    }

    @Test
    public void testNot() {
        assertTrue(f1.not().toBoolean());
        assertFalse(t1.not().toBoolean());
    }

    @Test
    public void testAnd() {
        assertTrue(t1.and(t2).toBoolean());
        assertFalse(f1.and(f2).toBoolean());
        assertFalse(t1.and(f1).toBoolean());
        assertFalse(f1.and(t1).toBoolean());
    }

    @Test
    public void testNand() {
        assertFalse(t1.nand(t2).toBoolean());
        assertTrue(f1.nand(f2).toBoolean());
        assertTrue(t1.nand(f1).toBoolean());
        assertTrue(f1.nand(t1).toBoolean());
    }

    @Test
    public void testOr() {
        assertTrue(t1.or(t2).toBoolean());
        assertFalse(f1.or(f2).toBoolean());
        assertTrue(t1.or(f1).toBoolean());
        assertTrue(f1.or(t1).toBoolean());
    }

    @Test
    public void testNor() {
        assertFalse(t1.nor(t2).toBoolean());
        assertTrue(f1.nor(f2).toBoolean());
        assertFalse(t1.nor(f1).toBoolean());
        assertFalse(f1.nor(t1).toBoolean());
    }

    @Test
    public void testXor() {
        assertFalse(t1.xor(t2).toBoolean());
        assertFalse(f1.xor(f2).toBoolean());
        assertTrue(t1.xor(f1).toBoolean());
        assertTrue(f1.xor(t1).toBoolean());
    }

    @Test
    public void testXnor() {
        assertTrue(t1.xnor(t2).toBoolean());
        assertTrue(f1.xnor(f2).toBoolean());
        assertFalse(t1.xnor(f1).toBoolean());
        assertFalse(f1.xnor(t1).toBoolean());
    }
}
