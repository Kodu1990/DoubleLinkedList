/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aas.vector;

import java.util.NoSuchElementException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adam
 */
public class VectorTest {
    


    /**
     * Test of addFirst method, of class Vector.
     * two scenarios 
     */
    @Test
    public void testAddFirst() {
        System.out.println("addFirst");
        Integer element = 1;
        Vector instance = new Vector();
        
        instance.add(element);
        assertEquals(instance.size(),1);
        
        instance.add(element);
        assertEquals(instance.size(),2);

    }

    /**
     * Test of addLast method, of class Vector.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Integer element = 1;
        Vector instance = new Vector();
        
        instance.add(element);
        assertEquals(instance.size(),1);
        
        instance.add(element);
        assertEquals(instance.size(),2);
    }

    /**
     * Test of addAtIndex method, of class Vector.
     */
    @Test(expected=IndexOutOfBoundsException.class)
    public void testAddAtIndex() {
        System.out.println("addAtIndex");
        Integer one = 1;
        Integer two = 2;        
        int index = -1;
        Vector instance = new Vector();
        instance.addAtIndex(one, index);        
        assertEquals(0,instance.size());
            
        instance.add(one);
        instance.add(one);
        instance.addAtIndex(two, 2);
        assertEquals(3,instance.size());
        assertEquals(one,instance.getHead());
        assertEquals(two,instance.get(2));
        assertEquals(one,instance.getTail());
    }

    /**
     * Test of size method, of class Vector.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        Vector<Object> instance = new Vector();      
        assertEquals(0,instance.size());
        
        Integer one = 1;
        Vector<Integer> instance2 = new Vector(one);
        assertEquals(1,instance2.size());

    }

    /**
     * Test of isEmpty method, of class Vector.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Vector<Object> instance = new Vector();      
        assertTrue(instance.isEmpty());
        
        Integer one = 1;
        Vector<Integer> instance2 = new Vector(one);
        assertFalse(instance2.isEmpty());

    }

    /**
     * Test of getHead method, of class Vector.
     */
    @Test
    public void testGetHead() {
        System.out.println("getHead");
        Integer one = 1;
        Vector<Integer> instance2 = new Vector(one);
        assertEquals(one,instance2.getHead());
    }

    /**
     * Test of getTail method, of class Vector.
     */
    @Test
    public void testGetTail() {
        System.out.println("getTail");
        
        Integer one = 1;
        Vector<Integer> instance2 = new Vector(one);
        assertEquals(one,instance2.getTail());

    }

    /**
     * Test of removeAtIndex method, of class Vector.
     */
    @Test(expected=IndexOutOfBoundsException.class)
    public void testRemoveAtIndex() {
        System.out.println("removeAtIndex");
        int index = -1;
        Vector instance = new Vector();
        
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        
        instance.add(one);
        instance.add(two);
        instance.add(three);
        
        instance.remove(index);
        assertTrue(instance.remove(2));
        assertEquals(2,instance.size());
        assertEquals(three,instance.getHead());
        assertEquals(one,instance.getTail());

    }

    /**
     * Test of popFirstElement method, of class Vector.
     */
    @Test(expected=NoSuchElementException.class)
    public void testPopFirstElement() {
        System.out.println("popFirstElement");
       
        Vector instance = new Vector();
        instance.popFirstElement();
        
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        instance.add(one);
        instance.add(two);
        instance.add(three);
        
        assertEquals(three, instance.popFirstElement());
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of popLastElement method, of class Vector.
     */
    @Test(expected=NoSuchElementException.class)
    public void testPopLastElement() {
        System.out.println("popLastElement"); 
        Vector instance = new Vector();
        instance.popLastElement();
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        instance.add(one);
        instance.add(two);
        instance.add(three);
        
        assertEquals(one, instance.popLastElement());
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of get method, of class Vector.
     */
    @Test(expected=IndexOutOfBoundsException.class)
    public void testGet() {
        System.out.println("get");
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        int index = -1;
        
        Vector instance = new Vector();
        instance.addAtIndex(one, index);        
        assertEquals(0,instance.size());
                      
        instance.add(one);
        instance.add(two);
        instance.add(three);
        
        assertEquals(one,instance.get(3));
        assertEquals(two,instance.get(2));
        assertEquals(three,instance.get(1));
    }


    
}
