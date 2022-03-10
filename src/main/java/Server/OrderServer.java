package Server;

import DataAccess.OrderDataAccess;
import DataAccess.OrderDataAccessImpl;
import Objects.Order;
import Service.OrderServiceImpl;
import javax.xml.ws.Endpoint;

public class OrderServer {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:55000/orderservice",new OrderServiceImpl());
        System.out.println("<<+++++++++++++++++++++++++++++++++++++++>>");
        System.out.println("Server has started succesfully! ");
        System.out.println("<<+++++++++++++++++++++++++++++++++++++++>>");
    }
}
