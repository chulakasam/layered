package com.example.layeredarchitecture.controller;

import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.Impl.CustomerDAOImpl;
import com.example.layeredarchitecture.dao.custom.Impl.QueryDAOImpl;
import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.SearchDto;
import com.example.layeredarchitecture.model.TableDTO;
import com.example.layeredarchitecture.view.tdm.TableTM;
import com.jfoenix.controls.JFXComboBox;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchController {
    public AnchorPane root;
    public TableColumn colCode;
    public TableColumn colQty;
    public TableColumn colUnitPrice;
    public JFXComboBox cmbcusId;
    public Label lblName;
    public Label lblDate;
    public JFXComboBox cmbOrderId;
    public JFXComboBox cmbCode;
    public TableView <TableTM> tblOrderDetail;
    public TableColumn colDesc;
    QueryDAO queryDAO=new QueryDAOImpl();
    CustomerDAO customerDAO=new CustomerDAOImpl();



    public void btnBackToHome(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/com/example/layeredarchitecture/main-form.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        Platform.runLater(() -> primaryStage.sizeToScene());
    }
    private void loadallcustomerIds() {
        try {

            ArrayList<CustomerDTO> allCustomers = customerDAO.getAll();

            for (CustomerDTO c : allCustomers) {
                cmbcusId.getItems().add(c.getId());
            }



        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to load customer ids").show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void initialize(){
        loadallcustomerIds();

    }
    public void cusIdOnAction(ActionEvent actionEvent) {

        String id = (String) cmbcusId.getValue();
        cmbOrderId.getItems().clear();
        try {
            ArrayList<SearchDto> dtolist = queryDAO.search(id);

            for (SearchDto c : dtolist) {
               cmbOrderId.getItems().add(c.getOid());
               lblName.setText(c.getName());
               lblDate.setText(c.getDate());

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void orderIdOnAction(ActionEvent actionEvent) {
        String id = (String) cmbOrderId.getValue();
         try {
             ArrayList<TableDTO> details = queryDAO.LoadToTable(id);

         for (TableDTO c : details) {
             tblOrderDetail.getItems().add(new TableTM(c.getItemcode(), c.getDescription(), c.getQty(), c.getUnitprice()));
         }

         tblOrderDetail.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("code"));
         tblOrderDetail.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
         tblOrderDetail.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qty"));
         tblOrderDetail.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        }catch (SQLException e){
              throw new RuntimeException(e);
        }catch (ClassNotFoundException e){
              throw new RuntimeException(e);
        }
    }
}
