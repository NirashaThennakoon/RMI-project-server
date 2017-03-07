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
import lk.ijse.thogakade.business.custom.OrderBO;
import lk.ijse.thogakade.dto.OrderDTO;
import lk.ijse.thogakade.service.SuperService;
import lk.ijse.thogakade.service.custom.OrderService;

/**
 *
 * @author student
 */
public class OrderServiceImpl extends UnicastRemoteObject implements OrderService{
    public OrderServiceImpl() throws RemoteException{
    }
    @Override
    public boolean add(OrderDTO t) throws Exception {
        OrderBO orderBO = (OrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDER);
        return orderBO.add(t);
    }

    @Override
    public boolean update(OrderDTO t) throws Exception {
        OrderBO orderBO = (OrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDER);
        return orderBO.update(t);
    }

    @Override
    public boolean delete(OrderDTO t) throws Exception {
        OrderBO orderBO = (OrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDER);
        return orderBO.delete(t);
    }

    @Override
    public OrderDTO get(String id) throws Exception {
        OrderBO orderBO = (OrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDER);
        return orderBO.get(id);
    }

    @Override
    public ArrayList<OrderDTO> getAll() throws Exception {
        OrderBO orderBo= (OrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDER);
        return orderBo.getAll();
    }
    

//    @Override
//    public OrderDTO getById(OrderDTO t) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public boolean reserve(String customerId, SuperService service) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean release(String customerId) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
