/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

/**
 *
 * @author duc.nt
 */

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;
public class TCP_Object_Stream {
    public static void main(String[] args) throws ParseException {
        try(Socket socket = new Socket("203.162.10.109", 2209)) {
            ObjectInputStream inp = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oup = new ObjectOutputStream(socket.getOutputStream());
            
            String mes = "B21DCCN251;8w22az6A";
            oup.writeObject(mes);
            oup.flush();
            System.out.println("a");
            
            TCP.Customer customer = (TCP.Customer) inp.readObject();
            customer.userName = customer.chuanHoaUsername(customer.name);
            customer.name = customer.chuanHoaHoTen(customer.name);
            customer.dayOfBirth = customer.chuanHoaNgaySinh(customer.dayOfBirth);
            
            oup.writeObject(customer);
            oup.flush();
            System.out.println(customer);
                
            
        } catch (Exception e) {
            e.printStackTrace();
        }
         
    }
}




