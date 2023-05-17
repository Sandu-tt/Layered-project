package lk.ijse.daycare.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.ijse.daycare.bo.BOFactory;
import lk.ijse.daycare.bo.custom.ChildrenBO;
import lk.ijse.daycare.bo.custom.EmployeeBO;
import lk.ijse.daycare.dto.ChildrenDTO;
import lk.ijse.daycare.dto.EmployeeDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class HomePageFormController {
    public AnchorPane pane;
    public Text txtEmpCount;
    public Text txtChiCount;
    //EmployeeBO employeeBO=new EmployeeBOImpl ();
    EmployeeBO employeeBO  = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EMPLOYEE);
    ChildrenBO childrenBO  = (ChildrenBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CHILDREN);

    public void initialize() {
        setData();
    }

    private void setData() {
        try {
            ArrayList<EmployeeDTO> e = employeeBO.getAllEmployee();
            txtEmpCount.setText(String.valueOf(e.size()));

            ArrayList<ChildrenDTO> c = childrenBO.getAllChildrens();
            txtChiCount.setText(String.valueOf(c.size()));


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void backbtnOnAction(ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../view/AdminPageForm.fxml")));
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

}

