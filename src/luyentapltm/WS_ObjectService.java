/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luyentapltm;

/**
 *
 * @author admin
 */
import java.util.*;
public class WS_ObjectService {
    public static void main(String[] args) {
        List<OrderY> orders = new ArrayList<>();
        Random random = new Random();
        String[] statuses = {"pending", "processing", "completed"};

        for (int i = 1; i <= 20; i++) {
            String orderId = "ORD" + String.format("%03d", i);
            Date orderDate = new Date(System.currentTimeMillis() - (random.nextInt(60) + 1L) * 24 * 60 * 60 * 1000); // Random date within last 60 days
            String status = statuses[random.nextInt(statuses.length)];
            String customerId = "CUST" + random.nextInt(1000);

            orders.add(new OrderY(orderId, orderDate, status, customerId));
        }

        // Lọc danh sách các đơn hàng cần ưu tiên xử lý
        List<OrderY> prioritizedOrders = filterOrders(orders);

        // In danh sách các đơn hàng được lọc
        System.out.println("Danh sách các đơn hàng cần ưu tiên xử lý:");
        for (OrderY order : prioritizedOrders) {
            System.out.println(order);
        }
    }
    
    public static List<OrderY> filterOrders(List<OrderY> orders) {
        List<OrderY> prioritizedOrders = new ArrayList<>();
        Date currentDate = new Date();
        long THIRTY_DAYS_IN_MILLISECONDS = 30L * 24 * 60 * 60 * 1000;

        for (OrderY order : orders) {
            // Kiểm tra trạng thái và thời gian
            if ((order.status.equals("pending") || order.status.equals("processing")) &&
                    (currentDate.getTime() - order.orderDate.getTime() > THIRTY_DAYS_IN_MILLISECONDS)) {
                prioritizedOrders.add(order);
            }
        }

        return prioritizedOrders;
    }
}
class OrderY {
    String orderID;
    Date orderDate;
    String status;
    String customerId;

    public OrderY(String orderID, Date orderDate, String status, String customerId) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.status = status;
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "OrderY{" + "orderID=" + orderID + ", orderDate=" + orderDate + ", status=" + status + ", customerId=" + customerId + '}';
    }
    
}
