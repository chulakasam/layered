package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.*;
import java.time.LocalDate;

public interface OrderDao {
     String generateNextID() throws SQLException, ClassNotFoundException;
     boolean SaveOrder(String orderId, LocalDate orderDate, String customerId, Connection connection) throws SQLException ;

     boolean existOrder(String orderId, Connection connection) throws SQLException ;
}
