/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.matchers;

import java.util.Arrays;
import java.util.Collection;
import org.mockito.ArgumentMatcher;

public class ListAnyOrder<T> implements ArgumentMatcher<Collection<T>>{
    private final Collection<T> expected;

    public ListAnyOrder(Collection<T> expected) {
        this.expected = expected;
    }

    @Override
    public boolean matches(Collection<T> actual) {
        if (actual == null || expected == null) {
            return false;
        }

        if (actual.size() != expected.size()) {
            return false;
        }
        Object[] expectedArray = expected.toArray();
        Arrays.sort(expectedArray);
        Object[] actualArray = actual.toArray();
        Arrays.sort(actualArray);
        
        for (int i = 0; i < expectedArray.length; i++) {
            if (!expectedArray[i].equals(actualArray[i])) {
                return false;
            }
        }
        return true;
    }

    public <E> boolean deepMatches(Collection<E> actual) {
        if (actual == null || expected == null) {
            return false;
        }

        if (actual.size() != expected.size()) {
            return false;
        }
        Object[] expectedArray = expected.toArray();
        Arrays.sort(expectedArray);
        Object[] actualArray = actual.toArray();
        Arrays.sort(actualArray);

        for (int i = 0; i < expectedArray.length; i++) {
            if (!expectedArray[i].toString().equals(actualArray[i].toString())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        if (expected == null) {
            return "null";
        }
        return expected.toString();
    }    
}
