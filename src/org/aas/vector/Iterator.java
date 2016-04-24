/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aas.vector;

import java.util.NoSuchElementException;
import org.aas.vector.Vector.Node;


/**
 *
 * @author Adam
 * @param <E>
 */
public class Iterator<E> implements DoubleLinkedListIterator<E>{
    
        private final Vector<E> List;   
        public static enum Direction { FORWARD, REVERSE };
        private int index;
        private Node current;
        
        protected Iterator(Vector<E> list, Direction d ){
            this.List =list;
            if(d == Direction.FORWARD){
                current = list.head;
                index =0;
            }
            else{
                current = list.tail;
                index = list.size()+1;
            }            
        }
               
        @Override
        public boolean hasNext() { return List.size() == index; }
        
        @Override
        public E next() {
            if(hasNext())
                current = current.next;
            
            else throw new NoSuchElementException();
            
            return (E) current.data;
        }
        
        @Override
        public int nextIndex() { 
            if(!hasNext())
                return index;
            return index+1; 
        }
        
        @Override
        public boolean hasPrevious() { return index != 0 ; }
        
        @Override
        public E previous() {
            if(hasPrevious())
                current = current.prev;
            
            else throw new NoSuchElementException();
            
            return (E) current.data;
        }

        @Override
        public int previousIndex() {
           if(!hasPrevious())
               return -1;
           return index-1;
        }

        @Override
        public void set(E element) { current.data = element; }

        @Override
        public void add(E element) {
            if(index ==0 || index == List.size()+1)
                throw new IllegalStateException();
            
            List.addAtIndex(element, index);
            index ++;
        }

        @Override
        public void remove() {
            if(index ==0 || index == List.size()+1)
                throw new IllegalStateException();
            List.remove(index);
            index --;
        }
        
        public E popElement() {
            index --;
            Node temp = current;
            current = current.prev;
            return (E) List.popElement(temp);        
        }
}
        