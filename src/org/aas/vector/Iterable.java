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
public interface Iterable <E>{
    public E next();
    public boolean hasNext();
    public void remove();
}
