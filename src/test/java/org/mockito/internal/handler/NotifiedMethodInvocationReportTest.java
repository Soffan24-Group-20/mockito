/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.handler;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.invocation.Invocation;

public class NotifiedMethodInvocationReportTest {

    @Test
    void hashCode_invocationNull_returnExpectedValue() {
        // Arrange
        NotifiedMethodInvocationReport report = new NotifiedMethodInvocationReport(null, "value");

        // Act & Assert
        assertEquals(961, report.hashCode());
    }

    @Test
    void hashCode_returnedValueNull_returnExpectedValue() {
        // Arrange
        Invocation invocation = mock(Invocation.class);
        NotifiedMethodInvocationReport report = new NotifiedMethodInvocationReport(invocation, null);

        // Act & Assert
        assertEquals(31 * invocation.hashCode(), report.hashCode());
    }

    @Test
    void hashCode_throwableNull_returnExpectedValue() {
        // Arrange
        Invocation invocation = mock(Invocation.class);
        NotifiedMethodInvocationReport report = new NotifiedMethodInvocationReport(invocation, "value");

        // Act & Assert
        assertEquals(31 * (31 * invocation.hashCode() + "value".hashCode()), report.hashCode());
    }

    @Test
    void hashCode_allNonNull_returnExpectedValue() {
        // Arrange
        Invocation invocation = mock(Invocation.class);
        Throwable throwable = new RuntimeException("test");
        NotifiedMethodInvocationReport report = new NotifiedMethodInvocationReport(invocation, throwable);

        // Act & Assert
        assertEquals(31 * (31 * (31 * invocation.hashCode() + "test".hashCode()) + throwable.hashCode()), report.hashCode());
    }
}
