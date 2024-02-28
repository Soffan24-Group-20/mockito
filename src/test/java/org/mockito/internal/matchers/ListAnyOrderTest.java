/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.matchers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockitoutil.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

public class ListAnyOrderTest extends TestBase {

    @Test 
    public void shouldMatchSameElementsDifferentOrderOfLists(){
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(2, 1));
        ListAnyOrder<Integer> listMatcher = new ListAnyOrder<>(list1);

        assertTrue(listMatcher.matches(list2));
    }

    @Test 
    public void shouldReturnDifferentLengthLists(){
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1));
        ListAnyOrder<Integer> listMatcher = new ListAnyOrder<>(list1);

        assertFalse(listMatcher.matches(list2));
    }

    @Test
    public void shouldReturnDifferentElementsInLists(){

        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(3, 4));
        ListAnyOrder<Integer> listMatcher = new ListAnyOrder<>(list1);

        assertFalse(listMatcher.matches(list2));
    }
    
    @Test
    public void shouldReturnSameElementsButDifferentListTypes(){
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2));
        Deque<Integer> anotherTypeOfList = new ArrayDeque<>(2);
        anotherTypeOfList.addFirst(1);
        anotherTypeOfList.addLast(2);
        ListAnyOrder<Integer> listMatcher = new ListAnyOrder<>(list);
        
        assertTrue(listMatcher.matches(anotherTypeOfList));
    }

    @Test
    public void shouldReturnDifferentElementsButDifferentListTypes(){
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2));
        Deque<Integer> anotherTypeOfList = new ArrayDeque<>(2);
        anotherTypeOfList.addFirst(3);
        anotherTypeOfList.addLast(2);
        ListAnyOrder<Integer> listAnyOrderObject = new ListAnyOrder<>(list);
        
        assertFalse(listAnyOrderObject.matches(anotherTypeOfList));
    }
    
    @Test
    public void shouldDeepMatchSameElementsDifferentClassesDifferentOrder(){
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2));
        List<Short> list2 = new ArrayList<>(List.of((short) 2, (short) 1));
        ListAnyOrder<Integer> listMatcher = new ListAnyOrder<>(list1);

        assertTrue(listMatcher.deepMatches(list2));
    }
    
    @Test
    public void shouldDeepMatchDifferentElementsDifferentClasses(){
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2));
        List<Short> list2 = new ArrayList<>(List.of((short) 2, (short) 3));
        ListAnyOrder<Integer> listMatcher = new ListAnyOrder<>(list1);
        
        assertFalse(listMatcher.deepMatches(list2));
    }

    @Test
    public void shouldMatchSameElementsMultipleTimes() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 2, 3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(2, 1, 3, 2));
        ListAnyOrder<Integer> listMatcher = new ListAnyOrder<>(list1);

        assertTrue(listMatcher.matches(list2));
    }

    @Test
    public void shouldDeepMatchSameElementsMultipleTimes() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 2, 3));
        List<Short> list2 = new ArrayList<>(List.of((short) 2, (short) 1, (short) 3, (short) 2));
        ListAnyOrder<Integer> listMatcher = new ListAnyOrder<>(list1);

        assertTrue(listMatcher.deepMatches(list2));
    }

    @Test
    public void shouldMatchWhenNull () {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 2, 3));
        List<Integer> list2 = null;
        ListAnyOrder<Integer> listMatcher = new ListAnyOrder<>(list1);

        assertFalse(listMatcher.matches(list2));
    }

    @Test
    public void shouldDeepMatchWhenNull () {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 2, 3));
        List<Integer> list2 = null;
        ListAnyOrder<Integer> listMatcher = new ListAnyOrder<>(list1);

        assertFalse(listMatcher.deepMatches(list2));
    }

    @Test 
    public void shouldReturnToString(){
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        ListAnyOrder<Integer> listAnyOrderInteger = new ListAnyOrder<>(list);
        String expectedIntegerString = listAnyOrderInteger.toString();

        List<String> listString = new ArrayList<>(Arrays.asList("1","2","3"));
        ListAnyOrder<String> listAnyOrderString = new ListAnyOrder<>(listString);
        String expectedStringString = listAnyOrderString.toString();

        assertTrue(expectedIntegerString.equals("[1, 2, 3]"));
        assertTrue(expectedStringString.equals("[1, 2, 3]"));
    }

    @Test
    public void shouldReturnToStringWhenNull() {
        List<Integer> list = null;
        ListAnyOrder<Integer> listAnyOrderInteger = new ListAnyOrder<>(list);
        String expectedIntegerString = listAnyOrderInteger.toString();

        List<String> listString = null;
        ListAnyOrder<String> listAnyOrderString = new ListAnyOrder<>(listString);
        String expectedStringString = listAnyOrderString.toString();

        assertTrue(expectedIntegerString.equals("null"));
        assertTrue(expectedStringString.equals("null"));
    }
}