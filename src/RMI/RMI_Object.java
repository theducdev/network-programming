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
public class RMI_Object {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109");
        ObjectService objectService = (ObjectService) registry.lookup("RMIObjectService");
        String studentCode = "B21DCCN251";
        String qCode = "or5Fnurn";
        BookX a = (BookX) objectService.requestObject(studentCode, qCode);
        
        
        a.chuanHoaCode();
        objectService.submitObject(studentCode, qCode, a);
    }
}


    

