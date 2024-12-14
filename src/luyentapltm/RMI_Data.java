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
public class RMI_Data {
    public static void main(String[] args) {
        int amount = 12;
        System.out.println(tinhDongXu(amount));
    }
    
    public static String tinhDongXu(int amount) {
        int[] menhgia = {10,5};
        int count = 0;
        int idx = 0;
        String ans = "";
        while (amount != 0) {
            if (idx == menhgia.length) return "-1";
            if (amount >= menhgia[idx]) {
                amount-=menhgia[idx];
                ans+=menhgia[idx]+ ",";
                count+=1;
            }
            else{
                idx+=1;
            }
            
        }
        return String.valueOf(count)+";"+ans.substring(0, ans.length()-1);
                
    }
}
