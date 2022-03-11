package DataAccess;

import Objects.Order;

import java.sql.*;
import java.util.ArrayList;

public class OrderDataAccessImpl implements OrderDataAccess {
    private final String SCHEMA="assignment";
    @Override
    public ArrayList<Order> getOrders() {
        String SQL = "SELECT * FROM " +SCHEMA+ ".orders" ;
        ArrayList<Order> orders=new ArrayList<>();
        try (Connection conn =  DBSConnection.getInstance().connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            while (rs.next())
            {
                orders.add(new Order(rs.getInt("id"),rs.getString("description"),rs.getFloat("amount"),rs.getBoolean("delivered")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return orders;
    }

    @Override
    public void addOrder(Order o) {
        try(Connection con=DBSConnection.getInstance().connect()){
            String SQL="INSERT INTO "+SCHEMA+".orders"+"(description,amount,delivered)"+"VALUES(?,?,?)";
            PreparedStatement statement = con.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,o.getDescription());
            statement.setFloat(2,o.getAmount());
            statement.setBoolean(3,o.isDelivered());
            int nr=statement.executeUpdate();
            if(nr<=0)
                throw new RuntimeException("Error adding order");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrder(Order o) {
        try(Connection con=DBSConnection.getInstance().connect()){
            String SQL="Update "+SCHEMA+".orders "+" SET description= "+o.getDescription()+" ,amount= "+o.getAmount()+" ,delivered"+o.isDelivered()+" where id="+o.getId();
            PreparedStatement statement=con.prepareStatement(SQL);
            int result=statement.executeUpdate();
            if(result<=0)
                throw new RuntimeException("Update failed");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void removeOrder(int id) {
        try(Connection con=DBSConnection.getInstance().connect()){
            String SQL="Delete from  "+SCHEMA+".orders "+" where id="+id;
            PreparedStatement statement=con.prepareStatement(SQL);
            int result=statement.executeUpdate();
            if(result<=0)
                throw new RuntimeException("Update failed");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
