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
        }
        if (actual == null) {
            coverage.branchUsed(1);
            return super.matches(actual);
        }
        else if (wanted instanceof boolean[]){
            coverage.branchUsed(2);
            if (actual instanceof boolean[]) {
                coverage.branchUsed(3);
                if (Arrays.equals((boolean[]) wanted, (boolean[]) actual)) {
                    coverage.branchUsed(4);
                    return true;
                }
                else {
                    coverage.branchUsed(5);
                    return false;
                }
            }
        } else if (wanted instanceof byte[]){
            coverage.branchUsed(6);
           if (actual instanceof byte[]) {
                coverage.branchUsed(7);
                if(Arrays.equals((byte[]) wanted, (byte[]) actual)){
                    coverage.branchUsed(8);
                    return  true;
                } else {
                    coverage.branchUsed(9);
                    return false;
                }
           }
        } else if (wanted instanceof char[]){
            coverage.branchUsed(10);
            if (actual instanceof char[]) {
                coverage.branchUsed(11);
                if (Arrays.equals((char[]) wanted, (char[]) actual)){
                    coverage.branchUsed(12);
                    return true;
                } else {
                    coverage.branchUsed(13);
                    return false;
                }
            }
        } else if (wanted instanceof double[]){
            coverage.branchUsed(14);
            if (actual instanceof double[]) {
                coverage.branchUsed(15);
                if (Arrays.equals((double[]) wanted, (double[]) actual)){
                    coverage.branchUsed(16);
                    return true;
                } else {
                    coverage.branchUsed(17);
                    return false;
                }
            }
        } else if (wanted instanceof float[]) {
            coverage.branchUsed(18);
            if (actual instanceof float[]) {
                coverage.branchUsed(19);
                if (Arrays.equals((float[]) wanted, (float[]) actual)){
                    coverage.branchUsed(20);
                    return true;
                } else {
                    coverage.branchUsed(21);
                    return false;
                }
            }
        } else if (wanted instanceof int[]) {
            coverage.branchUsed(22);
            if (actual instanceof int[]) {
                coverage.branchUsed(23);
                if (Arrays.equals((int[]) wanted, (int[]) actual)) {
                    coverage.branchUsed(24);
                    return true;
                }
                else {
                    coverage.branchUsed(25);
                    return false;
                }
            }
        } else if (wanted instanceof long[]) {
            coverage.branchUsed(26);
            if (actual instanceof long[]) {
                coverage.branchUsed(27);
                if (Arrays.equals((long[]) wanted, (long[]) actual)) {
                    coverage.branchUsed(28);
                    return true;
                }
                else {
                    coverage.branchUsed(29);
                    return false;
                }
            }
        } else if (wanted instanceof short[]) {
            coverage.branchUsed(30);
            if (actual instanceof short[]) {
                coverage.branchUsed(31);
                if (Arrays.equals((short[]) wanted, (short[]) actual)) {
                    coverage.branchUsed(32);
                    return true;
                }
                else {
                    coverage.branchUsed(33);
                    return false;
                }
            }
        } else if (wanted instanceof Object[]) {
            coverage.branchUsed(34);
            if (actual instanceof Object[]) {
                coverage.branchUsed(35);
                if (Arrays.equals((Object[]) wanted, (Object[]) actual)) {
                    coverage.branchUsed(36);
                    return true;
                }
                else {
                    coverage.branchUsed(37);
                    return false;
                }
            }
        }
        coverage.branchUsed(38);
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
