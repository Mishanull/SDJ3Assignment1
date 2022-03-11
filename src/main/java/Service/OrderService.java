package Service;

import Objects.Order;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;

@WebService
public interface OrderService {
    @WebMethod
    ArrayList<Order> getOrders();
    @WebMethod
    void addOrder(  String description,float amount, boolean delivered);
    @WebMethod
    void updateOrder(Order o);
    @WebMethod
    void deleteOrder(int i);
}
