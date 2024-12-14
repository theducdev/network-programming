/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luyentapltm;

/**
 *
 * @author duc.nt
 */
import java.util.*;
public class TCP_Data_Stream {
    public static void main(String[] args) {
        int[] a = {5, 9, 3, 6, 8};
        int tong = 0;
        for (int i = 0; i < a.length; i++) {
            tong+=a[i];
        }
        System.out.println(tong);
        float tbc = Float.parseFloat(String.valueOf(tong))/a.length;
        float phuongsai = 0;
        for (int i = 0; i < a.length; i++) {
            phuongsai+=Math.pow(a[i]-tbc,2);
        }
        System.out.println(tbc);
        System.out.println(phuongsai/a.length);
              
    }
}
