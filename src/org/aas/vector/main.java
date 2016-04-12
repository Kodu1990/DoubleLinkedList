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
     public static void main(String[] args) {
         Integer one = 1;
         Integer two = 2; 
         Integer three = 3;
         Integer four = 4;
         Vector<Integer> v = new Vector();
         v.addFirst(one);
         v.addLast(two);
         v.addLast(three);
         v.addLast(four);
         
         System.out.println(v.toString());
         System.out.println(" popped val : "+v.popFirstElement());
     }
}
