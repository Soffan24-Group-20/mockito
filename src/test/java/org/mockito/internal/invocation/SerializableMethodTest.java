/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.invocation;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;
import org.mockitoutil.TestBase;

public class SerializableMethodTest extends TestBase {

    private MockitoMethod method;
    private Method toStringMethod;
    private Class<?>[] args;

    @Before
    public void createMethodToTestWith() throws SecurityException, NoSuchMethodException {
        args = new Class<?>[0];
        toStringMethod = this.getClass().getMethod("toString", args);
        method = new SerializableMethod(toStringMethod);
    }

    @Test
    public void shouldBeSerializable() throws Exception {
        ByteArrayOutputStream serialized = new ByteArrayOutputStream();
        new ObjectOutputStream(serialized).writeObject(method);
    }

    @Test
    public void shouldBeAbleToRetrieveMethodExceptionTypes() throws Exception {
        assertArrayEquals(toStringMethod.getExceptionTypes(), method.getExceptionTypes());
    }

    @Test
    public void shouldBeAbleToRetrieveMethodName() throws Exception {
        assertEquals(toStringMethod.getName(), method.getName());
    }

    @Test
    public void shouldBeAbleToCheckIsArgVargs() throws Exception {
        assertEquals(toStringMethod.isVarArgs(), method.isVarArgs());
    }

    @Test
    public void shouldBeAbleToGetParameterTypes() throws Exception {
        assertArrayEquals(toStringMethod.getParameterTypes(), method.getParameterTypes());
    }

    @Test
    public void shouldBeAbleToGetReturnType() throws Exception {
        assertEquals(toStringMethod.getReturnType(), method.getReturnType());
    }

    @Test
    public void shouldBeEqualForTwoInstances() throws Exception {
        assertTrue(new SerializableMethod(toStringMethod).equals(method));
    }

    @Test
    public void shouldNotBeEqualForSameMethodFromTwoDifferentClasses() throws Exception {
        Method testBaseToStringMethod = String.class.getMethod("toString", args);
        assertFalse(new SerializableMethod(testBaseToStringMethod).equals(method));
    }

    // TODO: add tests for generated equals() method

    @Test
    public void shouldNotBeEqualifObjIsNull() throws Exception {
        assertFalse(method.equals(null));
    }

    @Test
    public void shouldNotBeEqualForMethodFromOtherClass() throws Exception {
        Method otherMethod = Integer.class.getMethod("parseInt", String.class);
        assertFalse(method.equals(otherMethod));
    }

    @Test
    public void shouldNotBeEqualForDifferentMethodFromSameClass() throws Exception {
        Method toStrMethod = String.class.getMethod("toString", args);
        method = new SerializableMethod(toStrMethod);
        Method toUpperMethod = String.class.getMethod("toUpperCase");
        SerializableMethod otherMethod = new SerializableMethod(toUpperMethod);
        assertFalse(method.equals(otherMethod));
    }

    @Test
    public void shouldNotBeEqualForDifferentParams() throws Exception{
        // there are no more than one toString method in Java, hence valueFor
        // method was chosen instead because of many overloaded methods of it.
        Method valueOfMethod = Integer.class.getMethod("valueOf", int.class);
        method = new SerializableMethod(valueOfMethod);
        Method otherValueOfMethod = Integer.class.getMethod("valueOf", String.class);
        SerializableMethod otherMethod = new SerializableMethod(otherValueOfMethod);
        assertFalse(method.equals(otherMethod));
    }
}
