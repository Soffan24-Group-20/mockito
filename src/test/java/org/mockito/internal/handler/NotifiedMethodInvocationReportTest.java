package org.mockito.internal.handler;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.internal.invocation.InvocationBuilder;
import org.mockito.invocation.Invocation;

class NotifiedMethodInvocationReportTest {

    @Test
    void equals_sameObject_shouldReturnTrue() {
        // Arrange
        Invocation invocation = mock(Invocation.class);
        NotifiedMethodInvocationReport report = new NotifiedMethodInvocationReport(invocation, null);

        // Act & Assert
        assertTrue(report.equals(report));
    }

    @Test
    void equals_nullObject_shouldReturnFalse() {
        // Arrange
        Invocation invocation = mock(Invocation.class);
        NotifiedMethodInvocationReport report = new NotifiedMethodInvocationReport(invocation, null);

        // Act & Assert
        assertFalse(report.equals(null));
    }

    @Test
    void equals_differentClass_shouldReturnFalse() {
        // Arrange
        Invocation invocation = mock(Invocation.class);
        NotifiedMethodInvocationReport report = new NotifiedMethodInvocationReport(invocation, null);

        // Act & Assert
        assertFalse(report.equals(new Object()));
    }

    @Test
    void equals_differentInvocation_shouldReturnFalse() {
        // Arrange
        Invocation invocation1 = new InvocationBuilder().toInvocation();
        Invocation invocation2 = new InvocationBuilder().toInvocation();
        NotifiedMethodInvocationReport report1 = new NotifiedMethodInvocationReport(invocation1, null);
        NotifiedMethodInvocationReport report2 = new NotifiedMethodInvocationReport(invocation2, null);

        // Act & Assert
        assertFalse(report1.equals(report2));
    }

    @Test
    void equals_sameInvocationDifferentReturnedValue_shouldReturnFalse() {
        // Arrange
        Invocation invocation = new InvocationBuilder().toInvocation();
        NotifiedMethodInvocationReport report1 = new NotifiedMethodInvocationReport(invocation, "value1");
        NotifiedMethodInvocationReport report2 = new NotifiedMethodInvocationReport(invocation, "value2");

        // Act & Assert
        assertFalse(report1.equals(report2));
    }

    @Test
    void equals_sameInvocationDifferentThrowable_shouldReturnFalse() {
        // Arrange
        Invocation invocation = new InvocationBuilder().toInvocation();
        Throwable throwable1 = new RuntimeException("exception1");
        Throwable throwable2 = new RuntimeException("exception2");
        NotifiedMethodInvocationReport report1 = new NotifiedMethodInvocationReport(invocation, throwable1);
        NotifiedMethodInvocationReport report2 = new NotifiedMethodInvocationReport(invocation, throwable2);

        // Act & Assert
        assertFalse(report1.equals(report2));
    }

    @Test
    void equals_sameInvocationSameReturnedValueAndThrowable_shouldReturnTrue() {
        // Arrange
        Invocation invocation = new InvocationBuilder().toInvocation();
        NotifiedMethodInvocationReport report1 = new NotifiedMethodInvocationReport(invocation, "value");
        NotifiedMethodInvocationReport report2 = new NotifiedMethodInvocationReport(invocation, "value");

        // Act & Assert
        assertTrue(report1.equals(report2));
    }

    @Test
    void equals_sameInvocationSameReturnedValueAndNullThrowable_shouldReturnFalse() {
        // Arrange
        Invocation invocation = new InvocationBuilder().toInvocation();
        NotifiedMethodInvocationReport report1 = new NotifiedMethodInvocationReport(invocation, "value");
        NotifiedMethodInvocationReport report2 = new NotifiedMethodInvocationReport(invocation, null);

        // Act & Assert
        assertFalse(report1.equals(report2));
    }
}
