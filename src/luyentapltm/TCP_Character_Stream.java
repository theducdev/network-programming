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
public class TCP_Character_Stream {
    public static void main(String[] args) {
        String a = "dgUOo ch2k22ldsOo";
        LinkedHashMap <Character, Integer> mp = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < a.length(); i++) {
            mp.put(a.charAt(i), mp.getOrDefault(a.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            if (entry.getValue() >= 2) {
                System.out.print(entry.getKey() + ":" + entry.getValue() + ",");
            }
        }
    }
}
