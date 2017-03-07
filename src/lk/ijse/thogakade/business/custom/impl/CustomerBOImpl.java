/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.business.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.thogakade.business.custom.CustomerBO;
import lk.ijse.thogakade.dao.ConnectionFactory;
import lk.ijse.thogakade.dao.DAOFactory;
import lk.ijse.thogakade.dao.SuperDAO;
import lk.ijse.thogakade.dto.CustomerDTO;

/**
 *
 * @author student
 */
public class CustomerBOImpl implements CustomerBO{

    @Override
    public boolean add(CustomerDTO t) throws Exception {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        SuperDAO<CustomerDTO> customerDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
        
        customerDAO.setConnection(connection);
        
        boolean result =customerDAO.add(t);
        connection.close();
        return result;
    }

    @Override
    public boolean update(CustomerDTO t) throws Exception {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        SuperDAO<CustomerDTO> customerDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
        customerDAO.setConnection(connection);
        boolean result =customerDAO.update(t);
        connection.close();
        return result;
    }

    

    @Override
    public ArrayList<CustomerDTO> getAll() throws Exception {
                System.out.println("bgetall");

        Connection connection=ConnectionFactory.getInstance().getConnection();
        SuperDAO<CustomerDTO> customerDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
        customerDAO.setConnection(connection);
        ArrayList<CustomerDTO>  customer=customerDAO.getAll();
        connection.close();
        return customer;
    }

    @Override
    public boolean delete(CustomerDTO t) throws Exception {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        SuperDAO<CustomerDTO> customerDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
        customerDAO.setConnection(connection);
        boolean result =customerDAO.delete(t.getId());
        connection.close();
        return result;
    }

    @Override
    public CustomerDTO get(String id) throws Exception {
       Connection connection=ConnectionFactory.getInstance().getConnection();
        SuperDAO<CustomerDTO> customerDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
        customerDAO.setConnection(connection);
        CustomerDTO result =customerDAO.get(id);
        connection.close();
        return result;
    }

    
    
}
