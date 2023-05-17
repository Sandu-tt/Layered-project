package lk.ijse.daycare.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lk.ijse.daycare.db.DBConnection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.sql.SQLException;

public class ReportsController {
    public AnchorPane pane;
    public Pane pane2;

    public void EmployeebtnOnAction(ActionEvent actionEvent) {

        try {
            JasperDesign jd = JRXmlLoader.load("C:\\Users\\Asus\\Desktop\\DayCare\\src\\lk\\ijse\\daycare\\reports\\Report.jrxml");
            String sql = "SELECT * FROM salary";
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql);
            jd.setQuery(newQuery);

            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jp);
        } catch (JRException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void ChildrenbtnOnAction(ActionEvent actionEvent) {

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
