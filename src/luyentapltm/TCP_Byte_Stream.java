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
public class TCP_Byte_Stream {
    public static void main(String[] args) {
        String a = "5,10,20,25,50,40,30,35";
        System.out.println(solve(a));
        
        
    }
    
    public static String solve(String a) {
        ArrayList <Integer> b = new ArrayList<>();
        for (String s : a.split(",")) {
            b.add(Integer.parseInt(s));
        }
        int[] x = new int[b.size()+1];
        Arrays.fill(x, 1);
        int[] prev = new int[b.size()+1];
        Arrays.fill(prev, -1);
        int ans = 1;
        int lastIdx = 0;
        for (int i = 0; i < b.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (b.get(i) > b.get(j)) {
                    if (x[i] < x[j]+1) {
                        prev[i] = j;
                    }
                    x[i] = Math.max(x[i], x[j]+1);
                }
            }
            if (x[i] > ans) {
                ans = x[i];
                lastIdx = i;
            }
        }
        String daycontang = "";
        while (lastIdx != -1) {
            daycontang = b.get(lastIdx) + "," + daycontang;
            lastIdx = prev[lastIdx];
        }
        System.out.println(daycontang);
        return String.valueOf(ans);
        
    }
} 