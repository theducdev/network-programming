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
public class RMI_Byte {
    public static void main(String[] args) {
        int[] a = {10, 10, 10, 20, 20, 30, 30, 30, 30};
        LinkedHashMap <Integer, Integer> mp = new LinkedHashMap<>();
        for (int i = 0; i < a.length; i++) {
            mp.put(a[i], mp.getOrDefault(a[i], 0) + 1);
        }
        int[] ans = new int[mp.size()*2];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            ans[idx] = entry.getKey();
            ans[idx+1] = entry.getValue();
            idx+=2;
        }
        for (int i = 0; i < mp.size()*2; i++ ) {
            System.out.println(ans[i]);
        }
        
        
    }
}
