/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.dao;

import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author student
 */
public interface SuperDAO<T> {
    
    public boolean add(T t)throws Exception;
    public boolean update(T t)throws Exception;
    public boolean delete(String id) throws Exception;
    public T get(String id) throws Exception;
    public T getById(T t) throws Exception;
    public ArrayList<T> getAll() throws Exception;
    public void setConnection(Connection connection)throws Exception;
    
    
}
