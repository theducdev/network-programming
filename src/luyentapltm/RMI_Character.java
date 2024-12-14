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
public class RMI_Character {
    public static void main(String[] args) {
        String b = "A;HELLO";
        String[] tmp = b.split(";");
        String key = tmp[0];
        String a = tmp[1];
        System.out.println(xorCharacter(key, a));
    }
    
    public static String xorCharacter(String key, String a) {
        String ans = "";
        int keyLength = key.length();
        for (int i = 0; i<a.length(); i++) {
            ans += (a.charAt(i) ^ key.charAt(i%keyLength));
            System.out.println(a.charAt(i) ^ key.charAt(i%keyLength));
        }
        return ans;
    }
}
