/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luyentapltm;

/**
 *
 * @author admin
 */
import java.util.*;
public class WS_DataService {
    public static void main(String[] args) {
        List <Integer> a = Arrays.asList(1, 2, 2, 3, 3, 3);
        int[] check = new int[1000];
        Arrays.fill(check, 0);
        for (Integer i : a) {
            check[i]+=1;
        }
        List <String> ans = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            if (check[i] > 0) {
                ans.add(i + ", " + check[i]);
            }
        }
        System.out.println(ans);
    }
}
