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
import lk.ijse.thogakade.business.custom.OrderDetailBO;
import lk.ijse.thogakade.dto.OrderDetailDTO;
import lk.ijse.thogakade.service.SuperService;
import lk.ijse.thogakade.service.custom.OrderDetailService;

/**
 *
 * @author CHATHURI
 */
public class OrderDetailServiceImpl  extends UnicastRemoteObject implements OrderDetailService {
    public OrderDetailServiceImpl()throws RemoteException{
        
    }
    @Override
    public boolean add(OrderDetailDTO t) throws Exception {
        System.out.println("service add od");
         OrderDetailBO orderDetailBO =  (OrderDetailBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDER_DETAIL);
        return orderDetailBO.add(t);
    }

    @Override
    public boolean update(OrderDetailDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(OrderDetailDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderDetailDTO get(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OrderDetailDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
