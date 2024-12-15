package luyentapltm;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.*;

public class TCP_Data_Stream {
    public static void main(String[] args) {
        try(Socket socket = new Socket("203.162.10.109", 2207)) {
          
            DataInputStream inp = new DataInputStream(socket.getInputStream());
            DataOutputStream oup = new DataOutputStream(socket.getOutputStream());

            String mes = "B21DCCN251;jgzCSJnR";
            oup.writeUTF(mes);
            oup.flush();

            ArrayList <Integer> a = new ArrayList<>();
            
            int tong = 0;
            int n = inp.readInt();
            for (int i = 0; i<n; i++) {
                int x = inp.readInt();
                a.add(x);
                tong += x;
                System.out.println(x);
            }
            System.out.println(a.size());
            oup.writeInt(tong);
            System.out.println("Tổng: " + tong);
            float tbc = Float.parseFloat(String.valueOf(tong)) / a.size();
            float phuongsai = 0;
            for (int i = 0; i < a.size(); i++) {
                phuongsai += Math.pow(a.get(i) - tbc, 2);
            }
            oup.writeFloat(tbc);
            System.out.println("Trung bình cộng: " + tbc);
            oup.writeFloat(phuongsai / a.size());
            System.out.println("Phương sai: " + phuongsai);////////
            oup.flush();
            
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
