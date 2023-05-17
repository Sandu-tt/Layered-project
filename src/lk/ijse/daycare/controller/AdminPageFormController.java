package lk.ijse.daycare.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminPageFormController {
    public AnchorPane pane;



    public void HomebtnOnAction(ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../view/HomePageForm.fxml")));
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }


    public void ChildrenbtnOnAction(ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../view/ManageChildForm.fxml")));
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void ClassbtnOnAction(ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../view/ClassroomForm.fxml")));
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void SalarybtnOnAction(ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../view/SalaryPage.fxml")));
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void PaymentbtnOnAction(ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../view/PaymentPageForm.fxml")));
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void EmployeebtnOnAction(ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../view/ManageEmployeeForm.fxml")));
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void ReportsbtnOnAction(ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../view/Reports.fxml")));
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();


    }

}
