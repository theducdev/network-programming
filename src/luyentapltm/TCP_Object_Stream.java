/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luyentapltm;

/**
 *
 * @author duc.nt
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;
public class TCP_Object_Stream {
    public static void main(String[] args) throws ParseException {
         Customer918 customer = new Customer918(1, "C001", "nguyen van hai duong", "05-15-1999", "a");
         customer.userName = customer.chuanHoaUsername(customer.name);
         customer.name = customer.chuanHoaHoTen(customer.name);
         customer.dayOfBirth = customer.chuanHoaNgaySinh(customer.dayOfBirth);
         System.out.println(customer);
         
    }
}

class Customer918 {
    int id;
    String code;
    String name;
    String dayOfBirth;
    String userName;
    private static final long serialVersionUID = 918;

    public Customer918(int id, String code, String name, String dayOfBirth, String userName) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Customer918{" + "id=" + id + ", code=" + code + ", name=" + name + ", dayOfBirth=" + dayOfBirth + ", userName=" + userName + '}';
    }
    
    public String chuanHoaHoTen(String name) {
        ArrayList <String> a = new ArrayList<>(Arrays.asList(name.split(" ")));
        String ans = a.get(a.size()-1).toUpperCase() + ",";
        for (int i = 0; i < a.size()-1; i++) {
            ans += " " + toCapital(a.get(i));
        }
        return ans;
    }
    
    public String chuanHoaNgaySinh(String date) throws ParseException {
        SimpleDateFormat bandau = new SimpleDateFormat("mm-dd-yyyy");
        SimpleDateFormat lucsau = new SimpleDateFormat("dd/mm/yyyy");
        Date a = bandau.parse(date);
        return lucsau.format(a);
    }
    
    public String chuanHoaUsername(String name) {
        ArrayList <String> a = new ArrayList<>(Arrays.asList(name.split(" ")));
        String ten = a.get(a.size()-1).toLowerCase();
        String username = "";
        for (int i = 0; i < a.size()-1; i++) {
            username += a.get(i).toLowerCase().charAt(0);
        }
        return username+ten;
    }
    
    public static String toCapital(String name) {
        return name.substring(0,1).toUpperCase() + name.substring(1, name.length()).toLowerCase();
    }
    
}


