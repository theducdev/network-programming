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
import javax.xml.*;
import java.net.*;
import java.security.Provider.Service;
import javax.xml.namespace.QName;
public class WS_CharacterService {
    public static void main(String[] args) throws MalformedURLException {
        List<String> data = Arrays.asList("apple", "kiwi", "banana", "pear");
        Collections.sort(data, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(soNguyenAm(o1), soNguyenAm(o2));
            }
        });
        
        for (String x : data) {
            System.out.println(x + " " + soNguyenAm(x));
        }
    }
    
    public static int soNguyenAm(String a) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            Character x = a.charAt(i);
            if (x=='u' || x =='e' || x=='o' || x =='a' || x=='i' || x =='U' || x=='E' || x =='O' ||  x=='A' || x =='I' ) {
                cnt+=1;
            }
        }
        return cnt;
    }
}
