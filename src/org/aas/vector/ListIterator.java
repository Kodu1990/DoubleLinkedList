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
public interface ListIterator<E> extends Iterable<E> {
    public void add (E element);
    public int nextIndex();
    public void set(E element);
}
