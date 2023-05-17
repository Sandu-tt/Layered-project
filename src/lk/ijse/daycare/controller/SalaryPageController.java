package lk.ijse.daycare.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.daycare.bo.BOFactory;
import lk.ijse.daycare.bo.custom.EmployeeBO;
import lk.ijse.daycare.bo.custom.SalaryBO;
import lk.ijse.daycare.dto.EmployeeDTO;
import lk.ijse.daycare.dto.SalaryDTO;
import lk.ijse.daycare.view.tm.SalaryTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalaryPageController {
    public TextField txtAmount;
    public TextField txtSalaryID;
    public ComboBox<String> cmbEID;
    public TextField txtEName;
    public TableColumn colSalID;
    public TableColumn colEmpID;
    public TableColumn colEmpName;
    public TableColumn colAmount;
    public TableView tblSalary;

    ObservableList<SalaryTM> obList = FXCollections.observableArrayList();
    ObservableList<String> obEmp = FXCollections.observableArrayList();

    //EmployeeDAO employeeDAO=new EmployeeDAOImpl ();
    //SalaryDAO salaryDAO=new SalaryDAOImpl ();
   // SalaryBO salaryBO=new SalaryBOImpl ();
    //EmployeeBO employeeBO=new EmployeeBOImpl ();
    EmployeeBO employeeBO  = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EMPLOYEE);
    SalaryBO salaryBO  = (SalaryBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SALARY);

    public void initialize() {
        colSalID.setCellValueFactory(new PropertyValueFactory<>("salID"));
        colEmpID.setCellValueFactory(new PropertyValueFactory<>("empID"));
        colEmpName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));

        setData();
    }

    private void setData() {
        try {
            setCMB();
            tblSalary.getItems().clear();
            try {
                ArrayList<SalaryDTO> allSalaries = salaryBO.getAllSalary ();

                for (SalaryDTO s : allSalaries
                ) {
                    obList.add(
                            new SalaryTM(
                                    s.getSalID(),
                                    s.getEmpID(),
                                    s.getName(),
                                    s.getAmount()
                            )
                    );
                }

                tblSalary.setItems(obList);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void setCMB() throws SQLException, ClassNotFoundException {
        ArrayList<EmployeeDTO> allEmployee = employeeBO.getAllEmployee ();
        for (EmployeeDTO e : allEmployee
        ) {
            obEmp.add(e.getEno());
        }
        cmbEID.setItems(obEmp);
    }

    public void saveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean b = salaryBO.addSalary (
                new SalaryDTO (
                        txtSalaryID.getText(),
                        cmbEID.getValue().toString(),
                        txtEName.getText(),
                        Double.parseDouble(txtAmount.getText())
                )
        );

        if (b) {
            new Alert(Alert.AlertType.INFORMATION, "Added").show();
            setData();
        }
    }

    public void cmbAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        txtEName.setText(employeeBO.getByID(cmbEID.getValue().toString()).getName());
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
