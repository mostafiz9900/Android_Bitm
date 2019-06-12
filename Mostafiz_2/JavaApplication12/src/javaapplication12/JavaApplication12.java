/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;

/**
 *
 * @author Mobile App Develop
 */
public class JavaApplication12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int num=0;
        int[] arr=new int[5];
        for (int i = 1; i <arr.length; i++) {
            
                arr[i]=i;
           
        }
        for (int ab:arr) {
            System.out.println(ab);
        }
    }
    
}
