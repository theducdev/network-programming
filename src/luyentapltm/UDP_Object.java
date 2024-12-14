/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luyentapltm;

/**
 *
 * @author duc.nt
 */
import java.util.*;
public class UDP_Object {
    public static void main(String[] args) {
        Student st = new Student("01", "codeabc", "nguyEn the DUC", "..");
        st.name = st.chuanHoaTen(st.name);
        st.email = st.chuanHoaEmail(st.name);
        System.out.println(st);
    }
    
}
class Student {
    String id;
    String code;
    String name;
    String email;
    private static final long serialVersionUID = 20171107;

    public Student(String id, String code, String name, String email) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.email = email;
    }

    public Student(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", code=" + code + ", name=" + name + ", email=" + email + '}';
    }
    
    public String chuanHoaTen(String name) {
        String[] a = name.trim().split("\\s+");
        String ans = "";
        for (int i = 0; i < a.length; i++) {
            ans+=toCapital(a[i]) + " ";
        }
        return ans.substring(0, ans.length()-1);
    }
    
    public String chuanHoaEmail(String name) {
        String[] a = name.trim().split("\\s+");
        String ans = "";
        for (int i = 0; i < a.length-1; i++) {
            ans+=a[i].substring(0,1).toLowerCase();
        }
        return ans+a[a.length-1].toLowerCase();
    }
    
    public String toCapital(String a) {
        return a.substring(0,1).toUpperCase() + a.substring(1, a.length()).toLowerCase();
    }
    
}
