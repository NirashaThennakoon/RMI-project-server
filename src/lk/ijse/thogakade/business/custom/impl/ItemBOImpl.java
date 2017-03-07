/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.business.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.thogakade.business.custom.ItemBO;
import lk.ijse.thogakade.dao.ConnectionFactory;
import lk.ijse.thogakade.dao.DAOFactory;
import lk.ijse.thogakade.dao.SuperDAO;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.dto.ItemDTO;

/**
 *
 * @author CHATHURI
 */
public class ItemBOImpl implements ItemBO{

    @Override
    public boolean add(ItemDTO t) throws Exception {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        SuperDAO<ItemDTO> itemDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
        itemDAO.setConnection(connection);
        boolean result =itemDAO.add(t);
        connection.close();
        return result;
    }

    @Override
    public boolean update(ItemDTO t) throws Exception {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        SuperDAO<ItemDTO> itemDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
        itemDAO.setConnection(connection);
        boolean result =itemDAO.update(t);
        connection.close();
        return result;
    }

    @Override
    public ArrayList<ItemDTO> getAll() throws Exception {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        SuperDAO<ItemDTO> itemDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
        itemDAO.setConnection(connection);
        ArrayList<ItemDTO>  item=itemDAO.getAll();
        connection.close();
        return item;
    }

    @Override
    public boolean delete(ItemDTO t) throws Exception {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        SuperDAO<ItemDTO> itemDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
        itemDAO.setConnection(connection);
        boolean result =itemDAO.delete(t.getCode());
        connection.close();
        return result;
    }

    @Override
    public ItemDTO get(String code) throws Exception {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        SuperDAO<ItemDTO> itemDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
        itemDAO.setConnection(connection);
        ItemDTO result =itemDAO.get(code);
        connection.close();
        return result;
    }

    
    
}
