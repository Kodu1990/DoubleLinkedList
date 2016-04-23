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
public interface List <E> {
    public void add(E element);
    public void addAll(Vector<? extends E> c);
    public void addFirst(E element);
    public int size();
    public E get(int index);
    public boolean isEmpty();
    public void reverse();
    public Iterator iterator();
}
