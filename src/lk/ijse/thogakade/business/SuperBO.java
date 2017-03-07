/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.business;

import java.rmi.Remote;
import java.util.ArrayList;

/**
 *
 * @author student
 */
public interface SuperBO<T> extends Remote {
    public boolean add(T t) throws Exception;

    public boolean update(T t) throws Exception;

    public boolean delete(T t) throws Exception;

    public T get(String id) throws Exception;

    public ArrayList<T> getAll() throws Exception;

}
