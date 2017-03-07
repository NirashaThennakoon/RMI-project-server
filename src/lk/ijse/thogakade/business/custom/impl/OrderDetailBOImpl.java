/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.business.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.thogakade.business.custom.OrderBO;
import lk.ijse.thogakade.business.custom.OrderDetailBO;
import lk.ijse.thogakade.dao.ConnectionFactory;
import lk.ijse.thogakade.dao.DAOFactory;
import lk.ijse.thogakade.dao.SuperDAO;
import lk.ijse.thogakade.dto.OrderDetailDTO;

/**
 *
 * @author acer
 */
public class OrderDetailBOImpl implements OrderDetailBO{

    @Override
    public boolean add(OrderDetailDTO t) throws Exception {
         System.out.println("businness add od");
         Connection connection=ConnectionFactory.getInstance().getConnection();
        SuperDAO<OrderDetailDTO> orderDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER_DETAIL);
        
        orderDAO.setConnection(connection);
        
        boolean result =orderDAO.add(t);
        connection.close();
        return result;
       
    
    }

    @Override
    public boolean update(OrderDetailDTO t) throws Exception {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        SuperDAO<OrderDetailDTO> orderDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER_DETAIL);
        
        orderDAO.setConnection(connection);
        
        boolean result =orderDAO.update(t);
        connection.close();
        return result;
    }

    @Override
    public boolean delete(OrderDetailDTO t) throws Exception {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        SuperDAO<OrderDetailDTO> orderDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER_DETAIL);
        
        orderDAO.setConnection(connection);
        
        boolean result =orderDAO.delete(t.getOrderId());
        connection.close();
        return result;
    }

    @Override
    public OrderDetailDTO get(String id) throws Exception {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        SuperDAO<OrderDetailDTO> orderDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER_DETAIL);
        
        orderDAO.setConnection(connection);
        
        OrderDetailDTO result =orderDAO.get(id);
        connection.close();
        return result;
    }

    @Override
    public ArrayList<OrderDetailDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
