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

public class UDP_String {
    public static void main(String[] args) {
        String a = "t    a a a a ";
        ArrayList <String> b = new ArrayList<>(Arrays.asList(a.split("\\s+")));
        String ans = "";
        for (String z : b) {
            ans += toCapital(z) + " ";
        }
        System.out.println(ans.substring(0, ans.length()-1));
    }
    
    public static String toCapital(String name) {
        return name.substring(0,1).toUpperCase() + name.substring(1, name.length()).toLowerCase();
    }
}
