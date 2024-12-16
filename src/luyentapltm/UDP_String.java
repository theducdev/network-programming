/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luyentapltm;

/**
 *
 * @author duc.nt
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.*;

public class UDP_String {
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("203.162.10.109");
        String mes = ";B21DCCN251;id8cpVDB";
        byte[] buffer = mes.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length, address, 2208);
        datagramSocket.send(packet);
        
        byte[] nhan = new byte[1024];
        DatagramPacket nhanPacket = new DatagramPacket(nhan, nhan.length);
        datagramSocket.receive(nhanPacket);
        String a = new String(nhan, 0, nhanPacket.getLength());
        String[] tmp = a.split(";");
        String requestId = tmp[0];
        String data = tmp[1];
      
        ArrayList <String> b = new ArrayList<>(Arrays.asList(data.split("\\s+")));
        String ans = "";
        for (String z : b) {
            ans += toCapital(z) + " ";
        }
        String kq = requestId + ";" + ans;
        byte[] gui = kq.getBytes();
        DatagramPacket gui_b = new DatagramPacket(gui, 0, gui.length, address, 2208);
        datagramSocket.send(gui_b);
        
        datagramSocket.close();
    }
    
    public static String toCapital(String name) {
        return name.substring(0,1).toUpperCase() + name.substring(1, name.length()).toLowerCase();
    }
}
