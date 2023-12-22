package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.Impl.CustomerDAOImpl;
import com.example.layeredarchitecture.dao.custom.Impl.ItemDAO;
import com.example.layeredarchitecture.dao.custom.Impl.OrderDAO;
import com.example.layeredarchitecture.dao.custom.Impl.OrderDetailDAOImpl;
import com.example.layeredarchitecture.dao.custom.ItemDao;
import com.example.layeredarchitecture.dao.custom.OrderDao;
import com.example.layeredarchitecture.dao.custom.OrderDetailDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlaceOrderBOImpl implements PlaceOrderBO{

    OrderDao orderDAO = new OrderDAO();
    CustomerDAO customerDAO = new CustomerDAOImpl();
    ItemDao itemDAO = new ItemDAO();
    OrderDetailDAO orderDetailDAOImpl = new OrderDetailDAOImpl();

    public boolean PlaceOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {
        Connection connection = null;

            connection = DBConnection.getDbConnection().getConnection();
            /*if order id already exist*/
            boolean isExixst = orderDAO.existOrder(orderId);

            if (isExixst) {
                connection.setAutoCommit(false);
            } else {
                connection.setAutoCommit(false);
            }

            boolean isSaved = orderDAO.SaveOrder(orderId, orderDate, customerId);
            if (!isSaved) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            boolean isAdded = orderDetailDAOImpl.SaveOrderDetails(orderId, orderDetails, connection);
            if (!isAdded) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
            //Search & Update Item
            for (OrderDetailDTO detail : orderDetails) {
                ItemDTO item = findItem(detail.getItemCode());

                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());
                ItemDAO itemDAO = new ItemDAO();
                boolean isUpdated = itemDAO.UpdateItemQTY(item);
                if (!isUpdated) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }
            connection.commit();
            connection.setAutoCommit(true);
            return true;
        }

    @Override
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.search(id);
    }

    @Override
    public ItemDTO searchItem(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.search(id);
    }

    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        return orderDAO.generateNextId();
    }

    @Override
    public ArrayList<CustomerDTO> loadAllCustomerIds() throws SQLException, ClassNotFoundException {
        return customerDAO.loadAllCustomerIds();
    }

    @Override
    public ArrayList<ItemDTO> loadAllItemIds() throws SQLException, ClassNotFoundException {
        return itemDAO.loadAllItemIds();
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }

    @Override
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }


    public ItemDTO findItem(String code) {
        try {
            return itemDAO.findItems(code);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find the Item " + code, e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    }


