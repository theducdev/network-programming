/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package luyentapltm;

/**
 *
 * @author duc.nt
 */
import java.util.*;
public class UDP_Data_Type {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String a = "requestId;10;2,3,5,6,5";
        ArrayList<String> b = new ArrayList<>(Arrays.asList(a.split(";")));
        String requestId = b.get(0);
        int n = Integer.valueOf(b.get(1));
        ArrayList<String> nums = new ArrayList<>(Arrays.asList(b.get(2).split(",")));
        System.out.println(requestId);
        System.out.println(n);
        Boolean[] danhdau = new Boolean[n+1];
        Arrays.fill(danhdau, false);
        for (int i = 0; i < nums.size(); i++) {
            danhdau[Integer.parseInt(nums.get(i))] = true;
        } 
        String ans = requestId+";";
        for (int i = 1; i < danhdau.length; i++) {
            if (danhdau[i] == false) {
                ans+=i+",";
            }
        }
        String ans1 = ans.substring(0, ans.length()-1);
        System.out.println(ans1);
            
    }
    
}
