/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luyentapltm;

/**
 *
 * @author duc.nt
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.CharBuffer;
import java.util.*;
public class TCP_Character_Stream {
    public static void main(String[] args) {
        try(Socket sc = new Socket("203.162.10.109", 2208)) {
            BufferedReader inp = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            BufferedWriter outp = new BufferedWriter(new OutputStreamWriter(sc.getOutputStream()));
            
            String mes = "B21DCCN251;fbtV6wKm";
            outp.write(mes);
            outp.newLine();
            outp.flush();
            
            String a = inp.readLine();
            String ans = soLanXuatHien(a);
            System.out.println(ans);
            outp.write(ans);
            outp.newLine();
            outp.flush();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static String soLanXuatHien(String a) {
        LinkedHashMap <Character, Integer> mp = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != ' ') {
                mp.put(a.charAt(i), mp.getOrDefault(a.charAt(i), 0) + 1);
            }
        }
        String ans = "";
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            if (entry.getValue() >= 2) {
                ans += (entry.getKey() + ":" + entry.getValue() + ",");
            }
        }
        return ans;
    }
}
