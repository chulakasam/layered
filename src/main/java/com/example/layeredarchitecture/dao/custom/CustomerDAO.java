package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<CustomerDTO> {
    /* ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException ;
     boolean SaveCustomer(String id, String name, String address) throws SQLException, ClassNotFoundException;
     boolean UpdateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;
     boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
     String generateNextId() throws SQLException, ClassNotFoundException;
     boolean existCustomer(String id) throws SQLException, ClassNotFoundException;

     */
    ArrayList<CustomerDTO> loadAllCustomerIds() throws SQLException, ClassNotFoundException ;

}
