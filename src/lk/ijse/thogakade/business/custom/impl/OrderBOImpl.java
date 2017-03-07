/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.business.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.thogakade.business.custom.OrderBO;
import lk.ijse.thogakade.dao.ConnectionFactory;
import lk.ijse.thogakade.dao.DAOFactory;
import lk.ijse.thogakade.dao.SuperDAO;
import lk.ijse.thogakade.dto.OrderDTO;

/**
 *
 * @author student
 */
public class OrderBOImpl implements OrderBO{

    @Override
    public boolean add(OrderDTO t) throws Exception {
         Connection connection=ConnectionFactory.getInstance().getConnection();
        SuperDAO<OrderDTO> orderDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER);
        orderDAO.setConnection(connection);
        boolean result =orderDAO.add(t);
        connection.close();
        return result;
    }

    @Override
    public boolean update(OrderDTO t) throws Exception {
         Connection connection=ConnectionFactory.getInstance().getConnection();
        SuperDAO<OrderDTO> orderDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER);
        orderDAO.setConnection(connection);
        boolean result =orderDAO.update(t);
        connection.close();
        return result;
    }


    @Override
    public ArrayList<OrderDTO> getAll() throws Exception {
         Connection connection=ConnectionFactory.getInstance().getConnection();
        SuperDAO<OrderDTO> orderDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER);
        orderDAO.setConnection(connection);
       ArrayList<OrderDTO>  result =orderDAO.getAll();
        connection.close();
        return result;
    }

    @Override
    public boolean delete(OrderDTO t) throws Exception {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        SuperDAO<OrderDTO> orderDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER);
        orderDAO.setConnection(connection);
        boolean result =orderDAO.delete(t.getId());
        connection.close();
        return result;
    }

    @Override
    public OrderDTO get(String id) throws Exception {
         Connection connection=ConnectionFactory.getInstance().getConnection();
        SuperDAO<OrderDTO> orderDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER);
        orderDAO.setConnection(connection);
        OrderDTO result =orderDAO.get(id);
        connection.close();
        return result;
    }
   
   
    
}
