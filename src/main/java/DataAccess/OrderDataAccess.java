package DataAccess;

import Objects.Order;

import java.util.ArrayList;

public interface OrderDataAccess {
    ArrayList<Order> getOrders();
    void addOrder(Order o);
    void updateOrder(Order o);
    void removeOrder(int id);
}
