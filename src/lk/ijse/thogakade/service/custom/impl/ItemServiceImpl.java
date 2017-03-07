/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.service.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import lk.ijse.thogakade.business.BOFactory;
import lk.ijse.thogakade.business.custom.CustomerBO;
import lk.ijse.thogakade.business.custom.ItemBO;
import lk.ijse.thogakade.dto.ItemDTO;
import lk.ijse.thogakade.service.SuperService;
import lk.ijse.thogakade.service.custom.CustomerService;
import lk.ijse.thogakade.service.custom.ItemService;

/**
 *
 * @author CHATHURI
 */
public class ItemServiceImpl extends UnicastRemoteObject implements ItemService{

    public ItemServiceImpl()throws RemoteException{
        
    }
   

    @Override
    public boolean add(ItemDTO t) throws Exception {
        ItemBO itemBO = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEM);
        return itemBO.add(t);
    }

    @Override
    public boolean update(ItemDTO t) throws Exception {
        ItemBO itemBO = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEM);
        return itemBO.update(t);
    }

    @Override
    public boolean delete(ItemDTO t) throws Exception {
        ItemBO itemBO = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEM);
        return itemBO.delete(t);
    }

    @Override
    public ItemDTO get(String id) throws Exception {
        ItemBO itemBO = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEM);
        return itemBO.get(id);
    }

    @Override
    public ArrayList<ItemDTO> getAll() throws Exception {
        ItemBO itemBO = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEM);
        return itemBO.getAll();
    
    }

    @Override
    public boolean reserve(String customerId, SuperService service) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean release(String customerId) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
