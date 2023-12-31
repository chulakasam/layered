package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.SuperDAO;
import com.example.layeredarchitecture.model.SearchDto;
import com.example.layeredarchitecture.model.TableDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {

    ArrayList<SearchDto> search(String id) throws SQLException, ClassNotFoundException;


    ArrayList <TableDTO>LoadToTable(String id) throws SQLException, ClassNotFoundException;
}
