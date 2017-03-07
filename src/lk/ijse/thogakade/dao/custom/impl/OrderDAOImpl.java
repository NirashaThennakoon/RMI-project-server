/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import lk.ijse.thogakade.dao.custom.OrderDAO;
import lk.ijse.thogakade.dto.OrderDTO;

/**
 *
 * @author student
 */
public class OrderDAOImpl implements OrderDAO{
    private Connection connection;
     @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection=connection;
    }

    @Override
    public boolean add(OrderDTO order) throws Exception {
        PreparedStatement pst = connection.prepareStatement("INSERT INTO Orders VALUES(?,?,?)");
        pst.setObject(1, order.getId());
        pst.setObject(2, order.getDate());
        pst.setObject(3, order.getCustomerId());
       
        int result = pst.executeUpdate();
        return (result > 0);
    }

    @Override
    public boolean update(OrderDTO order) throws Exception {
        PreparedStatement pst = connection.prepareStatement("Update orders set date=?,CustomerId=? where id=?");
        pst.setObject(3, order.getId());
        pst.setObject(1, order.getDate());
        pst.setObject(2, order.getCustomerId());
        
        int result = pst.executeUpdate();
        return (result > 0);
    }

    @Override
    public boolean delete(String id) throws Exception {
        PreparedStatement pst = connection.prepareStatement("Delete From orders where id='" + id + "'");
        int result = pst.executeUpdate();
        return (result > 0);
    }

    @Override
    public OrderDTO get(String id) throws Exception {
        System.out.println("Welcomto DAO Layer");
        OrderDTO order = null;
        String sql = "SELECT * FROM orders WHERE id = '" + id + "' ";
        Statement stm = connection.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        if (rset.next()) {
            order = new OrderDTO(
                    rset.getString(1),
                    rset.getDate(2),
                    rset.getString(3));
                   
        }
        return order;
    }

    @Override
    public ArrayList<OrderDTO> getAll() throws Exception {
        System.out.println("Welcomto DAO Layer");
        ArrayList<OrderDTO> alOrders = new ArrayList<>();
        String sql = "select * from Orders";
        Statement stm = connection.createStatement();
        ResultSet rset = stm.executeQuery(sql);

        while (rset.next()) {
            String id = rset.getString("id");
            Date date = rset.getDate("date");
            String customerId = rset.getString("customerId");
           

            OrderDTO order = new OrderDTO(id, date, customerId);
            alOrders.add(order);
        }

        return alOrders;

    }

    @Override
    public OrderDTO getById(OrderDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    
    
}
