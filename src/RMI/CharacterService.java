/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RMI;

/**
 *
 * @author duc.nt
 */
import java.rmi.*;
public interface CharacterService extends Remote { 
public String requestCharacter(String studentCode, String qCode) throws RemoteException; 
public void submitCharacter(String studentCode, String qCode, String strSubmit) throws RemoteException; 
}
