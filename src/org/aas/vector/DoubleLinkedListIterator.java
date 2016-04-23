/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aas.vector;

/**
 *
 * @author Adam
 */
public interface DoubleLinkedListIterator<E> extends ListIterator<E> {
    public E previous();
    public boolean hasPrevious();
    public int previousIndex();
}
