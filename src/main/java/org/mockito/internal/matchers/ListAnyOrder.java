/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.matchers;

import java.util.Collection;
import org.mockito.ArgumentMatcher;

public class ListAnyOrder<T> implements ArgumentMatcher<Collection<T>>{
    private final Collection<T> expected;

    public ListAnyOrder(Collection<T> expected) {
        this.expected = expected;
    }

    @Override
    public boolean matches(Collection<T> argument) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'matches'");
    }

    public boolean deepMatches(Collection<T> actual) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deepMatches'");
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }    
}
