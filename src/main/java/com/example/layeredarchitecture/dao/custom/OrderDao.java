package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;
import java.time.LocalDate;

public interface OrderDao extends CrudDAO<OrderDTO> {
   /*  String generateNextID() throws SQLException, ClassNotFoundException;
     boolean SaveOrder(String orderId, LocalDate orderDate, String customerId, Connection connection) throws SQLException, ClassNotFoundException;

     boolean existOrder(String orderId, Connection connection) throws SQLException, ClassNotFoundException;

    */
     boolean SaveOrder(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException;
     boolean existOrder(String orderId) throws SQLException, ClassNotFoundException;
}
