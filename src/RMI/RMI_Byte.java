package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.util.*;

public class RMI_Byte {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        // Kết nối đến Registry Server
        Registry registry = LocateRegistry.getRegistry("203.162.10.109");
        ByteService byteService = (ByteService) registry.lookup("RMIByteService");

        // Mã sinh viên và mã câu hỏi
        String studentCode = "B21DCCN251";
        String qCode = "8h2j4oVK";

        // a. Gọi requestData để nhận dữ liệu byte từ server
        byte[] a = byteService.requestData(studentCode, qCode);

        // b. Thực hiện nén dữ liệu bằng RLE
        byte[] compressedData = compressRLE(a);

        // c. Gửi dữ liệu đã nén trở lại server
        byteService.submitData(studentCode, qCode, compressedData);
    }

    // Thuật toán RLE để nén dữ liệu
    public static byte[] compressRLE(byte[] data) {
        List<Byte> compressedList = new ArrayList<>();
        int n = data.length;

        byte currentByte = data[0];
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (data[i] == currentByte) {
                count++;
            } else {
                // Ghi nhận byte hiện tại và số lần lặp
                compressedList.add(currentByte);
                compressedList.add((byte) count);

                // Cập nhật byte mới và reset bộ đếm
                currentByte = data[i];
                count = 1;
            }
        }
        // Ghi nhận byte và số lần lặp cuối cùng
        compressedList.add(currentByte);
        compressedList.add((byte) count);

        // Chuyển từ List<Byte> sang mảng byte[]
        byte[] compressedData = new byte[compressedList.size()];
        for (int i = 0; i < compressedList.size(); i++) {
            compressedData[i] = compressedList.get(i);
        }
        return compressedData;
    }
}
