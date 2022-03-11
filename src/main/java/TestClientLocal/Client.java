package TestClientLocal;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

import Objects.Order;
import Service.OrderService;

public class Client {
    //Local client to test CRUD (better to use the more complex separate client)
    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("http://localhost:55000/orderservice?wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        QName name= new QName("http://Service/", "OrderService");
        //Create service
        Service service = Service.create(url, name);
        System.out.println("SOAP service is now created");
        //use the getPort method to obtain service interface
        OrderService orderService=service.getPort(OrderService.class);
        orderService.addOrder("yesindeed",830,true);
        System.out.println(orderService.getOrders());
        Order order=new Order(2,"lol",780,true);
        orderService.updateOrder(order);
        orderService.deleteOrder(15);
    }
}
