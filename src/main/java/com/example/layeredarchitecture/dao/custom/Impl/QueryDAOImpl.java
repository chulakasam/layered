package com.example.layeredarchitecture.dao.custom.Impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.model.SearchDto;
import com.example.layeredarchitecture.model.TableDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {


    @Override
    public ArrayList<SearchDto> search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.test("SELECT c.name, o.oid, o.date FROM Customer c JOIN Orders o on c.id = o.customerID WHERE c.id = ?",id);

        ArrayList<SearchDto> getAllsearch = new ArrayList<>();
        while (rst.next()) {
            SearchDto searchDto = new SearchDto(rst.getString(1), rst.getString(2), rst.getString(3));
            getAllsearch.add(searchDto);
        }
        return getAllsearch;
    }

    @Override
    public ArrayList LoadToTable(String id) throws SQLException, ClassNotFoundException {

        ResultSet rst=SQLUtil.test("SELECT od.oid, o.date, od.itemCode, i.description, od.qty, od.unitPrice from OrderDetails od join Item i on od.itemCode = i.code join Orders o on od.oid = o.oid where o.oid = ?",id);
        ArrayList<TableDTO> getAlldetails = new ArrayList<>();

        while (rst.next()) {
            TableDTO tableDTO = new TableDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6));
            getAlldetails.add(tableDTO);
        }


        return getAlldetails;
    }


}
