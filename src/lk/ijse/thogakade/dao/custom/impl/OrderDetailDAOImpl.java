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
import lk.ijse.thogakade.dao.custom.OrderDetailDAO;
import lk.ijse.thogakade.dto.OrderDetailDTO;

/**
 *
 * @author acer
 */
public class OrderDetailDAOImpl implements OrderDetailDAO{
    private Connection connection;
    
     @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection=connection;
    }
    

    @Override
    public boolean add(OrderDetailDTO orderDetail) throws Exception {
        System.out.println("dao add od");
        PreparedStatement pst = connection.prepareStatement("INSERT INTO OrderDetail VALUES(?,?,?,?)");
        pst.setObject(1, orderDetail.getOrderId());
        pst.setObject(2, orderDetail.getCode());
        pst.setObject(3, orderDetail.getQty());
        pst.setObject(4, orderDetail.getUnitePrice());
        int result = pst.executeUpdate();
        return (result > 0);
    }

    @Override
    public boolean update(OrderDetailDTO orderDetail) throws Exception {
        PreparedStatement pst = connection.prepareStatement("Update OrderDetail set itemCode=?, qty=?, unitPrice=?, where orderId=?");
        pst.setObject(4, orderDetail.getOrderId());
        pst.setObject(1, orderDetail.getCode());
        pst.setObject(2, orderDetail.getQty());
        pst.setObject(3, orderDetail.getUnitePrice());
        int result = pst.executeUpdate();
        return (result > 0);
    }

    @Override
    public boolean delete(String id) throws Exception {
        PreparedStatement pst = connection.prepareStatement("Delete From OrderDetail where orderId='" + id + "'");
        int result = pst.executeUpdate();
        return (result > 0);
    }

    @Override
    public OrderDetailDTO get(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OrderDetailDTO> getAll() throws Exception {
         System.out.println("Welcomto DAO Layer");
        ArrayList<OrderDetailDTO> alOrderDetails = new ArrayList<>();
        String sql = "select * from OrderDetail";
        Statement stm = connection.createStatement();
        ResultSet rset = stm.executeQuery(sql);

        while (rset.next()) {
            String id = rset.getString("orderId");
            String code = rset.getString("itemCode");
            int qty = rset.getInt("qty");
            double unitPrice = rset.getDouble("unitPrice");

            OrderDetailDTO orderDetail = new OrderDetailDTO(id, code, qty, unitPrice);
            alOrderDetails.add(orderDetail);
        }

        return alOrderDetails;
    }

    @Override
    public OrderDetailDTO getById(OrderDetailDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
