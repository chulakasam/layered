package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDao extends CrudDAO<ItemDTO> {
    /* ArrayList<ItemDTO> loadAll() throws SQLException, ClassNotFoundException;
     boolean deleteItem(String code) throws SQLException, ClassNotFoundException;
     boolean SaveItem(ItemDTO dto) throws SQLException, ClassNotFoundException ;
     boolean UpdateItem(ItemDTO dto) throws SQLException, ClassNotFoundException ;
     String nextId() throws SQLException, ClassNotFoundException ;
     boolean existItem(String code) throws SQLException, ClassNotFoundException ;

      ArrayList<ItemDTO> loadAllItemIds() throws SQLException, ClassNotFoundException;
      boolean UpdateItemQTY(ItemDTO item, Connection connection) throws SQLException, ClassNotFoundException;
     ItemDTO findItems(String code) throws SQLException, ClassNotFoundException;
     */
    ArrayList<ItemDTO> loadAllItemIds() throws SQLException, ClassNotFoundException;
    boolean UpdateItemQTY(ItemDTO item) throws SQLException, ClassNotFoundException;
    ItemDTO findItems(String code) throws SQLException, ClassNotFoundException;
}
