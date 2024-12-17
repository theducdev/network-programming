/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

/**
 *
 * @author duc.nt
 */
import luyentapltm.*;
import java.util.*;
import java.rmi.*;
import java.rmi.registry.*;
public class RMI_Character {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109");
        CharacterService characterService = (CharacterService) registry.lookup("RMICharacterService");
        String studentCode = "B21DCCN251";
        String qCode = "etznHfGH";
        String a = characterService.requestCharacter(studentCode, qCode);
        System.out.println(a);
        String[] tach = a.split(";");


        String key = tach[0];
        String chuoi = tach[1];
        String ans = "";
        int keyLength = key.length();
        for (int i = 0; i < chuoi.length(); i++) {
            ans += xorCharacter(key.charAt(i%keyLength), chuoi.charAt(i));
        }
        
        characterService.submitCharacter(studentCode, qCode, ans);
        System.out.println(ans);
        
        
    }
    
    public static Character xorCharacter(Character key, Character a) {

//        int tmp = (((int) key) + ((int) a) - 96*2-1)%26 + ((int) 'a');
        int tmp =(int) key ^ (int) a;
        return (char) tmp;
    }
}
