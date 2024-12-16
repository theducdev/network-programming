/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package luyentapltm;

/**
 *
 * @author duc.nt
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.*;
public class UDP_Data_Type {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("203.162.10.109");
        int port = 2207;
        
        String mes = ";B21DCCN251;ThBcrDAS";
        byte[] mes_buffer = mes.getBytes();
        DatagramPacket mes_packet = new DatagramPacket(mes_buffer, 0, mes_buffer.length, address, port);
        datagramSocket.send(mes_packet);
        
        byte[] chuoi_nhan_buffer = new byte[1024];
        DatagramPacket chuoi_nhan_packet = new DatagramPacket(chuoi_nhan_buffer, 0, chuoi_nhan_buffer.length, address, port);
        datagramSocket.receive(chuoi_nhan_packet);
        
        String a = new String(chuoi_nhan_buffer, 0, chuoi_nhan_packet.getLength());
        System.out.println(a);
        

        ArrayList<String> b = new ArrayList<>(Arrays.asList(a.split(";")));
        String requestId = b.get(0);
        int n = Integer.valueOf(b.get(1));
        ArrayList<String> nums = new ArrayList<>(Arrays.asList(b.get(2).split(",")));
        System.out.println(requestId);
        System.out.println(n);
        Boolean[] danhdau = new Boolean[n+1];
        Arrays.fill(danhdau, false);
        for (int i = 0; i < nums.size(); i++) {
            danhdau[Integer.parseInt(nums.get(i))] = true;
        } 
        String ans = requestId+";";
        for (int i = 1; i < danhdau.length; i++) {
            if (danhdau[i] == false) {
                ans+=i+",";
            }
        }
        String ans1 = ans.substring(0, ans.length()-1);
        System.out.println(ans1);
        
        byte[] kq_buffer = ans1.getBytes();
        DatagramPacket kq_packet = new DatagramPacket(kq_buffer, 0, kq_buffer.length, address, port);
        datagramSocket.send(kq_packet);
        
        datagramSocket.close();
       
            
    }
     
    
}
