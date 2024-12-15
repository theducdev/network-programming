/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author admin
 */
class Customer implements Serializable{
    int id;
    String code;
    String name;
    String dayOfBirth;
    String userName;
    private static final long serialVersionUID = 20170711;

    public Customer(int id, String code, String name, String dayOfBirth, String userName) {
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
