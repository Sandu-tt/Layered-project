package lk.ijse.daycare.util;

/*
    @author DanujaV
    @created 11/1/22 - 1:27 PM   
*/

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;
    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();

        switch (route) {
            case LOGIN:
                window.setTitle("LOGIN PAGE");
                initUI("LoginPageForm.fxml");
                break;
            case ADMIN:
                window.setTitle("ADMIN PAGE");
                initUI("AdminPageForm.fxml");
                break;
            case MANAGECHILDERN:
                window.setTitle("MANAGECHILDERN Form");
                initUI("ManageChildForm.fxml");
                break;
            case EMPLOYEE:
                window.setTitle("EMPLOYEE Form");
                initUI("EmployeePageForm.fxml");
                break;
          /*  default:
                new Alert(Alert.AlertType.ERROR, "Not suitable UI found!").show();*/
        }
    }
    private static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class
                        .getResource("/lk/ijse/daycare/view/" + location)));
    }
}
