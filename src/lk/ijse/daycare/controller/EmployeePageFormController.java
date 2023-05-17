package lk.ijse.daycare.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.daycare.bo.BOFactory;
import lk.ijse.daycare.bo.custom.EmployeeBO;
import lk.ijse.daycare.dto.EmployeeDTO;
import lk.ijse.daycare.entity.Employee;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;

public class EmployeePageFormController {
    public AnchorPane pane1;
    public AnchorPane pane2;
    public TextField txteno;
    public TextField txtename;
    public TableView tblEmployee;
    public TableColumn coleno;
    public TableColumn colename;
    public TableColumn colarrivaltime;
    public ComboBox<String> cmbEmp;
    ObservableList<String> obList = FXCollections.observableArrayList();

    //EmployeeDAO employeeDAO=new EmployeeDAOImpl ();
    //EmployeeBO employeeBO=new EmployeeBOImpl ();
    EmployeeBO employeeBO  = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EMPLOYEE);

    public void initialize() {
        setData();
    }

    private void setData() {
        try {
            for (EmployeeDTO employee : employeeBO.getAllEmployee ()) {
                obList.add(
                        employee.getEno()
                );
            }
            cmbEmp.setItems(obList);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void btnEdetailsOnAction(ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../view/EmployeeDetailsForm.fxml")));
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void btnEattendanceeOnAction(ActionEvent actionEvent) {
    }


    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../view/WelcomePageForm.fxml")));
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }


    public void savebtnOnAction(ActionEvent actionEvent) {
        LocalTime time = LocalTime.now();

    }

    public void setEmpOnAction(ActionEvent actionEvent) {
        try {
            Employee e = employeeBO.getByID(cmbEmp.getValue());
            txtename.setText(e.getName());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
