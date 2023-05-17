package lk.ijse.daycare.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.daycare.util.Navigation;
import lk.ijse.daycare.util.Routes;

import java.io.IOException;

public class WelcomePageFormController {

    public AnchorPane pane;

    public void btnloginOnAction(ActionEvent actionEvent) throws IOException {

        Navigation.navigate(Routes.LOGIN, pane);
    }
}
