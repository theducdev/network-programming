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
public class RMI_Object {
    public static void main(String[] args) {
        BookX a = new BookX("01", "abcabcabc", "Nguyen The Duc", 2023, "abc123a", "");
        a.chuanHoaCode();
        System.out.println(a);
    }
}

class BookX {
    String id;
    String title;
    String author;
    int yearPublished;
    String genre;
    String code;
    private static final long serialVersionUID = 20241124L;
    
    public BookX() {}

    public BookX(String id, String title, String author, int yearPublished, String genre, String code) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.genre = genre;
        this.code = code;
    }
    
    public void chuanHoaCode() {
        String code = "";
        String[] a = this.author.split(" ");
        code+=a[0].substring(0,1).toUpperCase() + a[a.length-1].substring(0,1).toUpperCase();
        String nam = Integer.toString(this.yearPublished);
        code+= nam.charAt(nam.length()-2) +""+ nam.charAt(nam.length()-1);

        code+= this.genre.length();
        code+=Integer.toString(this.title.length()%10);
        this.code = code;
    }

    @Override
    public String toString() {
        return "BookX{" + "id=" + id + ", title=" + title + ", author=" + author + ", yearPublished=" + yearPublished + ", genre=" + genre + ", code=" + code + '}';
    }
    
    
            
            
    
}
