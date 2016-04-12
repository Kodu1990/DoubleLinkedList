/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aas.vector;

import java.util.NoSuchElementException;



/**
 *
 * @author Adam
 * @param <E>
 */
public class Vector<E> {
    
    private class Node {
         E data;
         Node next;
         Node prev;

   
        public Node(E data, Node next, Node prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
        public Node(E data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
      
        @Override
         public String toString(){
            return data.toString();
         }
    }
    
    private Node head;    
    private Node tail;
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
     * @param E data  
     */
    public Vector(E data){
        this.head = new Node(data,null,null);
        this.tail =head;
        Vector.size = 1;
    }
    /**
     * add element to front of list
     * O(1)
     * @param E element 
     */
    public void addFirst(E element){
        Node temp = new Node(element,head,null);
        if(head != null) 
           head.prev =temp;
        
        head = temp;
        
        if(tail == null)
            tail = temp;
        
        size++;
    }
    /**
     * add element to end of list
     * O(1)
     * @param element  
     */
    public void addLast(E element){
        Node temp = new Node(element,null,tail);
        if(tail != null) 
           tail.next =temp;
        
        tail = temp;
        
        if(head == null)
            head = temp;
        
        size++;
    }
    /**
     * add element to list at index
     * O(n)
     * @param E element
     * @param int index 
     */
    public void addAtIndex(E element, int index){
        Node temp =  new Node(element);
        Node current = head;
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
            head = new Node(element);
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
     * retrieves the data element at index and removes it(pretty useless for dll)
     * @param index
     * @return true ? false
     */
    public boolean removeAtIndex(int index){
        if(index <=0 || index >Vector.size)
            throw new IndexOutOfBoundsException();
                   
        Node current = head;
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
    /**
     * pops the first element off the list
     * O(1)
     * @return E data
     */
    public E popFirstElement(){
        if (size == 0) 
            throw new NoSuchElementException();
        
        Node tmp = head;
        head = head.next;
        head.prev = null;
        size --;
        return tmp.data;

    }
    /**
     * pops the last element off the list
     * O(1)
     * @return E element
     */
    public E popLastElement(){
        if(size == 0) 
            throw new NoSuchElementException();
        
        Node tmp = tail;
        tail = tail.prev;
        tail.next = null;
        size --;
        return tmp.data;
    }
    /**
     * retrieves the data element at index 
     * O(n)
     * @param int index
     * @return E element
     */
    public E get (int index){
        if(index <=0 || index >Vector.size)
            throw new IndexOutOfBoundsException();
        
        Node current = null;
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
    /**
     * 
     * @return string representation of list
     */
    @Override
    public String toString(){
        String output = "";
	if (head != null) {
            Node current = head;
            while (current != null) {
		output += "[" + current.data.toString() + "]";
                current = current.next;
            }
	}
	return output;
    }



    
}
