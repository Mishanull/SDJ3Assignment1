package Service;

import DataAccess.OrderDataAccess;
import DataAccess.OrderDataAccessImpl;
import Objects.Order;

import javax.jws.WebService;
import java.util.ArrayList;
@WebService(endpointInterface = "Service.OrderService",serviceName = "OrderService")
public class OrderServiceImpl implements OrderService {
    OrderDataAccess dataAccess;

    public OrderServiceImpl() {
        dataAccess=new OrderDataAccessImpl();
    }

    @Override
    public ArrayList<Order> getOrders() {
        return dataAccess.getOrders();
    }

    @Override
    public void addOrder( String description,float amount, boolean delivered) {
        dataAccess.addOrder(new Order(description,amount,delivered));
    }

    @Override
    public void updateOrder(Order o) {

    }

    @Override
    public void deleteOrder(int i) {

    }
}
