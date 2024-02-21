/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.matchers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockitoutil.TestBase;

public class ArrayEqualsTest extends TestBase {
    @Test
    public void shouldArraysMatchTypesWhenEqual() throws Exception {
        assertTrue(new ArrayEquals(new boolean[] {true, false}).matches(new boolean[] {true, false}));
        assertTrue(new ArrayEquals(new byte[] {1, 2}).matches(new byte[] {1, 2}));
        assertTrue(new ArrayEquals(new char[] {'a', 'b'}).matches(new char[] {'a', 'b'}));
        assertTrue(new ArrayEquals(new double[] {1.3, 2.1}).matches(new double[] {1.3, 2.1}));
        assertTrue(new ArrayEquals(new float[] {1f, 2f}).matches(new float[] {1f, 2f}));
        assertTrue(new ArrayEquals(new int[] {1, 2}).matches(new int[] {1, 2}));
        assertTrue(new ArrayEquals(new long[] {1, 2}).matches(new long[] {1, 2}));
        assertTrue(new ArrayEquals(new short[] {1, 2}).matches(new short[] {1, 2}));
        assertTrue(new ArrayEquals(new Integer[] {1, 2}).matches(new Integer[] {1, 2}));
        assertTrue(new ArrayEquals(new Object[] {"1"}).matches(new Object[] {"1"}));
    }

    @Test
    public void shouldArraysMatchTypesWhenNotEqual() throws Exception {
        assertFalse(new ArrayEquals(new boolean[] {true, false}).matches(new boolean[] {false, false}));
        assertFalse(new ArrayEquals(new byte[] {1, 2}).matches(new byte[] {1, 3}));
        assertFalse(new ArrayEquals(new char[] {'a', 'b'}).matches(new char[] {'x', 'b'}));
        assertFalse(new ArrayEquals(new double[] {1.3, 2.1}).matches(new double[] {20.1, 2.1}));
        assertFalse(new ArrayEquals(new float[] {1f, 2f}).matches(new float[] {1f, 3f}));
        assertFalse(new ArrayEquals(new int[] {1, 2}).matches(new int[] {3, 2}));
        assertFalse(new ArrayEquals(new long[] {1, 2}).matches(new long[] {3, 2}));
        assertFalse(new ArrayEquals(new short[] {1, 2}).matches(new short[] {3, 2}));
        assertFalse(new ArrayEquals(new Integer[] {1, 2}).matches(new Integer[] {3, 2}));
        assertFalse(new ArrayEquals(new Object[] {"1"}).matches(new Object[] {"2"}));
    }

    @Test
    public void shouldArraysMatchWhenDifferentTypes() throws Exception {
        assertFalse(new ArrayEquals(new boolean[] {true, false}).matches(new int[] {0, 1}));
        assertFalse(new ArrayEquals(new byte[] {1, 2}).matches(new int[] {0, 1}));
        assertFalse(new ArrayEquals(new char[] {'a', 'b'}).matches(new int[] {0, 1}));
        assertFalse(new ArrayEquals(new double[] {1.3, 2.1}).matches(new int[] {0, 1}));
        assertFalse(new ArrayEquals(new float[] {1f, 2f}).matches(new int[] {0, 1}));
        assertFalse(new ArrayEquals(new int[] {1, 2}).matches(new boolean[] {true, false}));
        assertFalse(new ArrayEquals(new long[] {1, 2}).matches(new int[] {0, 1}));
        assertFalse(new ArrayEquals(new short[] {1, 2}).matches(new int[] {0, 1}));
        assertFalse(new ArrayEquals(new Object[] {"1"}).matches(new int[] {0, 1}));
    }

    @Test
    public void shouldArrayMatchWhenNotArray() throws Exception {
        assertFalse(new ArrayEquals(new int[] {1, 2}).matches(100));
        assertFalse(new ArrayEquals(100).matches(100));
        assertFalse(new ArrayEquals(100).matches(103));
    }

    @Test
    public void shouldArraysMatchSafelyWhenGivenIsNull() throws Exception {
        assertTrue(new ArrayEquals(null).matches(null));
        assertFalse(new ArrayEquals(null).matches(new int[] {0, 1}));
        assertFalse(new ArrayEquals(new int[] {0, 1}).matches(null));
    }

    @Test
    public void shouldDescribeUsingToString() {
        assertEquals("[1, 2]", new ArrayEquals(new int[] {1, 2}).toString());
    }

    @Test
    public void shouldDescribeNullUsingToString() {
        assertEquals("null", new ArrayEquals(null).toString());
    }

    @Test
    public void shouldDescribeWhenNotGivenArrayUsingToString() {
        assertEquals("100", new ArrayEquals(100).toString());
    }
}
