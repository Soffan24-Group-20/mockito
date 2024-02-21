/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.matchers;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayEquals extends Equals {

    public ArrayEquals(Object wanted) {
        super(wanted);
    }

    @Override
    public boolean matches(Object actual) {
        ArrayEqualsCoverage coverage = new ArrayEqualsCoverage();
        Object wanted = getWanted();
        if (wanted == null) {
            coverage.branchUsed(0);
            return super.matches(actual);

        } else if (wanted.getClass() == actual.getClass()) {
            return Arrays.equals(createObjectArray(wanted), createObjectArray(actual));
        }
        return false;
    }

    @Override
    public String toString() {
        if (getWanted() != null && getWanted().getClass().isArray()) {
            return appendArray(createObjectArray(getWanted()));
        } else {
            return super.toString();
        }
    }

    private String appendArray(Object[] array) {
        // TODO SF overlap with ValuePrinter
        StringBuilder out = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            out.append(new Equals(array[i]));
            if (i != array.length - 1) {
                out.append(", ");
            }
        }
        out.append("]");
        return out.toString();
    }

    public static Object[] createObjectArray(Object array) {
        if (array instanceof Object[]) {
            return (Object[]) array;
        }
        Object[] result = new Object[Array.getLength(array)];
        for (int i = 0; i < Array.getLength(array); i++) {
            result[i] = Array.get(array, i);
        }
        return result;
    }
}
