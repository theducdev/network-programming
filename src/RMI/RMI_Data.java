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
import java.rmi.registry.*;
import java.rmi.*;
public class RMI_Data {
    public static void main(String[] args) throws RemoteException, NotBoundException {

        Registry registry = LocateRegistry.getRegistry("203.162.10.109");
        DataService dataService = (DataService) registry.lookup("RMIDataService");
        
        int amount = (int) dataService.requestData("B21DCCN251", "AL5GGbj7");
        
        System.out.println(amount);
        System.out.println(tinhDongXu(amount));
        dataService.submitData("B21DCCN251", "AL5GGbj7", tinhDongXu(amount));
    }
    
    public static String tinhDongXu(int amount) {
        int[] menhgia = {10,5,2,1};
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
        return String.valueOf(count)+";" +" "+ans.substring(0, ans.length()-1);
                
    }
}
