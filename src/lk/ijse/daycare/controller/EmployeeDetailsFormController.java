package lk.ijse.daycare.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.ijse.daycare.bo.BOFactory;
import lk.ijse.daycare.bo.custom.EmployeeBO;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EmployeeDetailsFormController implements Initializable {

    public AnchorPane pane1;
    public Text txtEmpCount;

   // EmployeeDAO employeeDAO=new EmployeeDAOImpl ();
    //EmployeeBO employeeBO=new EmployeeBOImpl ();
    EmployeeBO employeeBO  = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EMPLOYEE);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setEmployeeCount();
    }

    private void setEmployeeCount() {
        try {
            ResultSet set= employeeBO.getCount();
            if (set.next()){
                txtEmpCount.setText(set.getString(1));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void backbtnOnAction(ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../view/EmployeePageForm.fxml")));
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
