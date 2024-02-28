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
        ListAnyOrder<Integer> list = new ListAnyOrder<>(list1);
        assertTrue(list.matches(list2));
    }

    @Test 
    public void shouldReturnDifferentLengthLists(){
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1));
        ListAnyOrder<Integer> list = new ListAnyOrder<>(list1);

        assertFalse(list.matches(list2));
    }

    @Test
    public void shouldReturnDifferentElementsInLists(){

        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(3, 4));
        ListAnyOrder<Integer> listAnyOrderObject = new ListAnyOrder<>(list1);

        assertFalse(listAnyOrderObject.matches(list2));
    }
    
    @Test
    public void shouldReturnSameElementsButDifferentListTypes(){
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2));
        Deque<Integer> anotherTypeOfList = new ArrayDeque<>(2);
        anotherTypeOfList.addFirst(1);
        anotherTypeOfList.addLast(2);
        ListAnyOrder<Integer> listAnyOrderObject = new ListAnyOrder<>(list);
        
        assertTrue(listAnyOrderObject.matches(anotherTypeOfList));
    }
    
    @Test
    public void shouldDeepMatchSameElementsDifferentClassesDifferentOrder(){
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2));
        List<Short> list2 = new ArrayList<>(List.of((short) 2, (short) 1));
        ListAnyOrder<Integer> list = new ListAnyOrder<>(list1);
        assertTrue(list.deepMatches(list2));
    }
    
    @Test
    public void shouldDeepMatchDifferentElementsDifferentClasses(){
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2));
        List<Short> list2 = new ArrayList<>(List.of((short) 2, (short) 3));
        ListAnyOrder<Integer> list = new ListAnyOrder<>(list1);
        assertFalse(list.deepMatches(list2));
    }

    @Test 
    public void shouldReturnToString(){
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        ListAnyOrder<Integer> listAnyOrderInteger = new ListAnyOrder<>(list);

        List<String> listString = new ArrayList<>(Arrays.asList("1","2","3"));
        ListAnyOrder<String> listAnyOrderString = new ListAnyOrder<>(listString);

        assertTrue(listAnyOrderInteger.toString().equals("[1, 2]"));
        assertTrue(listAnyOrderString.toString().equals("[\"1\", \"2\", \"3\"]"));
    }    
}