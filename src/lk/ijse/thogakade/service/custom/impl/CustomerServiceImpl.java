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
import lk.ijse.thogakade.business.SuperBO;
import lk.ijse.thogakade.business.custom.CustomerBO;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.reservation.Reservation;
import lk.ijse.thogakade.reservation.impl.ReservationImpl;
import lk.ijse.thogakade.service.SuperService;


import lk.ijse.thogakade.service.custom.CustomerService;

/**
 *
 * @author student
 */
public class CustomerServiceImpl extends UnicastRemoteObject implements CustomerService{
private static Reservation customerReservation =new ReservationImpl();
    public CustomerServiceImpl()throws RemoteException{
        
    }
    

    @Override
    public boolean add(CustomerDTO t) throws Exception {
        CustomerBO customerBO = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
        return customerBO.add(t);
    }

    @Override
    public boolean update(CustomerDTO t) throws Exception {
        CustomerBO customerBO = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
        return customerBO.update(t);
    }

    @Override
    public boolean delete(CustomerDTO t) throws Exception {
        CustomerBO customerBO = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
        return customerBO.delete(t);
    }

    @Override
    public CustomerDTO get(String id) throws Exception {
        CustomerBO customerBO = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
        return customerBO.get(id);
    }

    @Override
    public ArrayList<CustomerDTO> getAll() throws Exception {
                System.out.println("servicegetall");

        CustomerBO customerBO = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
        return customerBO.getAll();
    }

//    @Override
//    public CustomerDTO getById(CustomerDTO t) throws Exception {
//        CustomerBO customerBO = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
//        return customerBO.getById(t);
//    }
     @Override
    public boolean reserve(String customerId, SuperService service) throws RemoteException {
        return customerReservation.reserve(customerId, this);
    }

    @Override
    public boolean release(String customerId) throws RemoteException {
        return customerReservation.release(customerId);
    }

}
