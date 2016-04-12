/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aas.vector;

import java.util.NoSuchElementException;
import java.lang.IndexOutOfBoundsException;


/**
 *
 * @author Adam
 * @param <E>
 */
public class Vector<E> {
    
    private class VectorNode {
         E data;
         VectorNode next;
         VectorNode prev;

   
        public VectorNode(E data, VectorNode next, VectorNode prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
        public VectorNode(E data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
      
        @Override
         public String toString(){
            return data.toString();
         }
    }
    
    private VectorNode head;    
    private VectorNode tail;
    private static int size;
    /**
     *  base constructor
     */
    public Vector(){
       this.head =null;       
       this.tail =null;
       Vector.size = 0; 
    }
    /**
     * constructor to initialize head/tail
     * @param data E 
     */
    public Vector(E data){
        this.head = new VectorNode(data,null,null);
        this.tail =head;
        Vector.size = 1;
    }
    /**
     * add element to front of list
     * @param element 
     */
    public void addFirst(E element){
        VectorNode temp = new VectorNode(element,head,null);
        if(head != null) 
           head.prev =temp;
        
        head = temp;
        
        if(tail == null)
            tail = temp;
        
        size++;
    }
    /**
     * add element to end of list
     * @param element  
     */
    public void addLast(E element){
        VectorNode temp = new VectorNode(element,null,tail);
        if(tail != null) 
           tail.next =temp;
        
        tail = temp;
        
        if(head == null)
            head = temp;
        
        size++;
    }
    /**
     * add element to list
     * @param element
     * @param index 
     */
    public void addAtIndex(E element, int index){
        VectorNode temp =  new VectorNode(element);
        VectorNode current = head;
        if(index <=0 || index > this.size()) 
            throw new IndexOutOfBoundsException();
        if(current != null){
            for (int i = 1 ; i< index && current.next != null ; i++){
                current = current.next;
            }
            temp.next = current.next;
            temp.prev = current;
            current.next =temp;
            tail = temp;
        }        
        else{
            head = new VectorNode(element);
            tail = head;
        }
                    
    }
    /**
     * 
     * @return size
     */
    public int size(){
        return Vector.size;
    }
    /**
     * 
     * @return size == 0
     */
    public boolean isEmpty(){
        return size == 0;
    }
    /**
     * returns the data element at the head of the list
     * @return head.data
     */      
    public E getHead(){
        return this.head.data;
    }
    /**
     * returns the data element at the tail of the list
     * @return tail.data
     */
    public E getTail(){
       return this.tail.data;
    }
    /**
     * 
     * @param index
     * @return 
     */
    public boolean removeAtIndex(int index){
        if(index <=0 || index >Vector.size)
            throw new IndexOutOfBoundsException();
                   
        VectorNode current = head;
        if(current != null){
            for(int i =1; i<index ; i++){
                if(current.next==null)
                    return false;
                
                current = current.next;
            }
            // gets index + 1 next
            current.prev.next = current.next;            
            current.next.prev = current.prev;
            current=null;
            size--;
            return true;
        }
        return false;
    }
    public E popFirstElement(){
        if (size == 0) 
            throw new NoSuchElementException();
        
        VectorNode tmp = head;
        head = head.next;
        head.prev = null;
        size --;
        return tmp.data;

    }
    
    public E popLastElement(){
        if(size == 0) 
            throw new NoSuchElementException();
        
        VectorNode tmp = tail;
        tail = tail.prev;
        tail.next = null;
        size --;
        return tmp.data;
    }
    
    public E get (int index){
        if(index <=0 || index >Vector.size)
            throw new IndexOutOfBoundsException();
        
        VectorNode current = null;
        if(head !=null){
            current = head.next;
            for(int i= 0; i < index; i++){
                if(current.next == null)
                    return null;
                
                current = current.next;
                
            }
            return current.data;
        }
        return null;
    }
    
    @Override
    public String toString(){
        String output = "";
	if (head != null) {
            VectorNode current = head;
            while (current != null) {
		output += "[" + current.data.toString() + "]";
                current = current.next;
            }
	}
	return output;
    }



    
}
