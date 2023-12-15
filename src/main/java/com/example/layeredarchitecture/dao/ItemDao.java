package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDao {
     ArrayList<ItemDTO> loadAll() throws SQLException, ClassNotFoundException;
     boolean deleteItem(String code) throws SQLException, ClassNotFoundException;
     boolean SaveItem(ItemDTO dto) throws SQLException, ClassNotFoundException ;
     boolean UpdateItem(ItemDTO dto) throws SQLException, ClassNotFoundException ;
     String nextId() throws SQLException, ClassNotFoundException ;
     boolean existItem(String code) throws SQLException, ClassNotFoundException ;
}
