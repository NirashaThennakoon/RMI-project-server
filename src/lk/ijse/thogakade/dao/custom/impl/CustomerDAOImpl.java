/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.thogakade.dao.custom.CustomerDAO;
import lk.ijse.thogakade.dto.CustomerDTO;

/**
 *
 * @author student
 */
public class CustomerDAOImpl implements CustomerDAO{
    private Connection connection;
     @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection=connection;
    }
    @Override
    public boolean add(CustomerDTO customer) throws SQLException {

        PreparedStatement pst = connection.prepareStatement("INSERT INTO Customer VALUES(?,?,?,?)");
        pst.setObject(1, customer.getId());
        pst.setObject(2, customer.getName());
        pst.setObject(3, customer.getAddress());
        pst.setObject(4, customer.getSalary());
        int result = pst.executeUpdate();
        return (result > 0);
    }

    @Override
    public boolean update(CustomerDTO customer) throws SQLException {
       PreparedStatement pst = connection.prepareStatement("Update Customer set name=?, address=?, salary=? where id=?");
        pst.setObject(4, customer.getId());
        pst.setObject(1, customer.getName());
        pst.setObject(2, customer.getAddress());
        pst.setObject(3, customer.getSalary());
        int result = pst.executeUpdate();
        return (result > 0);
    }

    

    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException {
        
        System.out.println("Welcomto DAO Layer");
        ArrayList<CustomerDTO> alCustomers = new ArrayList<>();
        String sql = "select * from Customer";
        Statement stm = connection.createStatement();
        ResultSet rset = stm.executeQuery(sql);

        while (rset.next()) {
            String id = rset.getString("id");
            String name = rset.getString("name");
            String address = rset.getString("address");
            double salary = rset.getDouble("salary");

            CustomerDTO customer = new CustomerDTO(id, name, address, salary);
            alCustomers.add(customer);
        }
        System.out.println("dao end getall");

        return alCustomers;
    }

    @Override
    public boolean delete(String id) throws Exception {
         PreparedStatement pst = connection.prepareStatement("Delete From Customer where id='" + id + "'");
        int result = pst.executeUpdate();
        return (result > 0);
    }

    @Override
    public CustomerDTO get(String id) throws Exception {
        System.out.println("Welcomto DAO Layer");
        CustomerDTO customer = null;
        String sql = "SELECT * FROM Customer WHERE id = '" + id + "' ";
        Statement stm = connection.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        if (rset.next()) {
            customer = new CustomerDTO(
                    rset.getString(1),
                    rset.getString(2),
                    rset.getString(3),
                    rset.getDouble(4));
        }
        return customer;
    }

    @Override
    public CustomerDTO getById(CustomerDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
