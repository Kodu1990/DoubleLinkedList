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
public class main {
    public static void main(String[]args){
        Vector<Integer> v = new Vector();
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4; 
        v.add(one);
        v.add(two);
        v.add(three);
        v.add(four);
        
        System.out.println(v);
        v.addAtIndex(one, 2);
        System.out.println(v);
    }
}
