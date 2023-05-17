package lk.ijse.daycare.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.daycare.util.Navigation;
import lk.ijse.daycare.util.Routes;

import java.io.IOException;

public class LoginPageFormController {
    public AnchorPane pane;
    public AnchorPane pane2;
    public JFXPasswordField txtPassword;
    public JFXTextField txtName;
    public JFXButton btnLogin;

    public void loginOnAction(ActionEvent actionEvent) throws IOException {


      /* String userName = txtName.getText();
        String pw = txtPassword.getText();

        if(pw.equals("123") && userName.equals("admin")){
            Navigation.navigate(Routes.DASHBOARD, pane);
        } else{
            new Alert(Alert.AlertType.ERROR, " Login Error ! \n Recheck Username And Password !").show();
        }*/

//        Node node = (Node) actionEvent.getSource();
//        Stage stage = (Stage) node.getScene().getWindow();
//        stage.close();
//        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../view/AdminPageForm.fxml")));
//        stage.setScene(scene);
//        stage.centerOnScreen();
//        stage.show();

        if (txtName.getText().equals("Admin") && txtPassword.getText().equals("1234")) {
            Navigation.navigate(Routes.ADMIN, pane);
        } else if (txtName.getText().equals("Employee") && txtPassword.getText().equals("1234")) {
            Navigation.navigate(Routes.EMPLOYEE, pane);
        } else {
            new Alert(Alert.AlertType.ERROR, " Login Error ! \n Recheck Username And Password !").show();
        }


    }
}
