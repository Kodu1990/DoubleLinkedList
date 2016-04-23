/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aas.vector;

/**
 *
 * @author Adam
 * @param <E>
 */
public interface DoubleLinkedList<E> extends LinkedList<E>  {
    public E getTail();
    public Iterator<E> reverseItr();
}
