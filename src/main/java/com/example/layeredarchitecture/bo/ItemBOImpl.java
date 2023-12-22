package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.custom.Impl.ItemDAO;
import com.example.layeredarchitecture.dao.custom.ItemDao;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO{

    ItemDao itemDao=new ItemDAO();
    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        return itemDao.getAll();
    }

    @Override
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return itemDao.exist(code);
    }

    @Override
    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        return itemDao.delete(code);
    }

    @Override
    public boolean SaveItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDao.Save(dto);
    }

    @Override
    public boolean UpdateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDao.Update(dto);
    }

    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        return itemDao.generateNextId();
    }
}
