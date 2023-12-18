package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.*;
import java.time.LocalDate;

public class OrderDAO implements OrderDao{
    @Override
    public String generateNextID() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");

        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }
    @Override
    public boolean SaveOrder(String orderId, LocalDate orderDate, String customerId, Connection connection) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
        stm.setString(1, orderId);
        stm.setDate(2, Date.valueOf(orderDate));
        stm.setString(3, customerId);

        if(stm.executeUpdate()!=1){
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }else {
            return true;
        }
    }
    @Override
    public boolean existOrder(String orderId, Connection connection) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
        stm.setString(1, orderId);
        if (stm.executeQuery().next()){
            connection.setAutoCommit(false);
            return true;
        }else{
            connection.setAutoCommit(false);
            return false;
        }
    }
}
