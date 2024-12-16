/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

/**
 *
 * @author duc.nt
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import luyentapltm.*;
import java.util.*;
public class UDP_Object {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("203.162.10.109");
        
        String mes = ";B21DCCN251;QLJu2frf";
        byte[] mes_buffer = mes.getBytes();
        DatagramPacket mes_packet = new DatagramPacket(mes_buffer, 0, mes_buffer.length, address, 2209);
        datagramSocket.send(mes_packet);
        
        byte[] nhan_buffer = new byte[1024];
        DatagramPacket nhan_packet = new DatagramPacket(nhan_buffer, nhan_buffer.length);
        datagramSocket.receive(nhan_packet);
        
        System.out.println("nhan duoc: " + byteToString(nhan_buffer)); 
        byte[] request_id_buffer = new byte[8];
        System.arraycopy(nhan_buffer, 0, request_id_buffer, 0, 8);
        String request_id = new String(request_id_buffer);
        System.out.println(request_id);
        byte[] student_buffer = new byte[nhan_buffer.length - 8];
        System.arraycopy(nhan_buffer, 8, student_buffer, 0, student_buffer.length);
        
        ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(student_buffer));
        Student st = (Student) inputStream.readObject();
        
        st.name = st.chuanHoaTen(st.name);
        st.email = st.chuanHoaEmail(st.name);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(st);
        byte[] gui_student_buffer = byteArrayOutputStream.toByteArray();
        
        byte[] gui_buffer = new byte[8 + gui_student_buffer.length];
        System.arraycopy(request_id_buffer, 0, gui_buffer, 0, 8);
        System.arraycopy(gui_student_buffer, 0, gui_buffer, 8, gui_student_buffer.length);
        
        DatagramPacket gui_packet = new DatagramPacket(gui_buffer, 0, gui_buffer.length, address, 2209);
        System.out.println("thu lai: " + byteToString(gui_buffer)); 
        datagramSocket.close();
    }
    
    public static String byteToString(byte[] gui_buffer) throws IOException, ClassNotFoundException {
        String ans = "";
        
        byte[] request_id_buffer = new byte[8];
        System.arraycopy(gui_buffer, 0, request_id_buffer, 0, 8);
        String request_id = new String(request_id_buffer);
        byte[] student_buffer = new byte[gui_buffer.length - 8];
        System.arraycopy(gui_buffer, 8, student_buffer, 0, student_buffer.length);
        
        ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(student_buffer));
        Student st = (Student) inputStream.readObject();
        
        st.name = st.chuanHoaTen(st.name);
        st.email = st.chuanHoaEmail(st.name);
        return request_id + " " + st.toString();
    }
}

