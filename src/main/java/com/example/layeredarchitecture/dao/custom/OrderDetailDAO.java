package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDAO {
     boolean SaveOrderDetails(String orderId, List<OrderDetailDTO> orderDetails, Connection connection) throws SQLException;
}
