package lk.ijse.daycare.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.daycare.bo.BOFactory;
import lk.ijse.daycare.bo.custom.EmployeeBO;
import lk.ijse.daycare.bo.custom.SalaryBO;
import lk.ijse.daycare.dto.EmployeeDTO;
import lk.ijse.daycare.util.Validator;
import lk.ijse.daycare.view.tm.EmployeeTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class ManageEmployeeFormController {
    private final ObservableList<EmployeeTM> obList = FXCollections.observableArrayList();
    public TableView<EmployeeTM> tblemployee;
    public TableColumn<EmployeeTM, String> colEno;
    public TableColumn<EmployeeTM, String> colName;
    public TableColumn<EmployeeTM, String> colAddress;
    public TableColumn<EmployeeTM, String> colContactNo;
    public TableColumn<EmployeeTM, String> colpossition;
    public TextField txtENo;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtContactNo;
    public TextField txtpossition;
    public AnchorPane pane2;
    public AnchorPane pane;
    public TableColumn colUpdate;
    public TableColumn colDelete;

    //EmployeeDAO employeeDAO=new EmployeeDAOImpl ();
    //SalaryDAO salaryDAO=new SalaryDAOImpl ();
   // EmployeeBO employeeBO=new EmployeeBOImpl ();
    //SalaryBO salaryBO=new SalaryBOImpl ();
    EmployeeBO employeeBO  = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EMPLOYEE);
    SalaryBO salaryBO  = (SalaryBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SALARY);

    public void initialize() {
        colEno.setCellValueFactory(new PropertyValueFactory<>("eno"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colpossition.setCellValueFactory(new PropertyValueFactory<>("possition"));
        colUpdate.setCellValueFactory(new PropertyValueFactory<>("view"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("delete"));
        txtName.textProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (Validator.isNameMatch(txtName.getText())) {
                        txtName.setStyle("-jfx-unfocus-color : black");
                        txtName.setStyle("-jfx-focus-color : #4059a9");
                    } else {
                        txtName.setStyle("-jfx-unfocus-color : red");
                        txtName.setStyle("-jfx-focus-color : red");
                    }
                });

        lodeEmployeeData();
        // setCellValueFactory();
    }

    private void lodeEmployeeData() {
        tblemployee.getItems().clear();
        try {
            ArrayList<EmployeeDTO> allEmployee = employeeBO.getAllEmployee ();

            for (EmployeeDTO e : allEmployee
            ) {
                Button view = new Button("Update");
                Button delete = new Button("View");
                obList.add(
                        new EmployeeTM(
                                e.getEno(), e.getName(), e.getAddress(), e.getContact(), e.getPossition(),
                                view, delete)
                );
                delete.setOnAction(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                            "are you sure whether do you want to delete this employee?",
                            ButtonType.YES, ButtonType.NO);
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if (buttonType.get() == ButtonType.YES) {
                        try {
                            if (salaryBO.idIsExsist(e.getEno())) {
                                if (salaryBO.deleteSalary (e.getEno())) {
                                    new Alert(Alert.AlertType.INFORMATION, "Employee Deleted!").show();
                                }
                            } else {
                                if (employeeBO.deleteEmployee (e.getEno())) {
                                    new Alert(Alert.AlertType.INFORMATION, "Employee Deleted!").show();
                                    lodeEmployeeData();
                                } else {
                                    new Alert(Alert.AlertType.WARNING, "Try Again!").show();
                                }
                            }


                        } catch (ClassNotFoundException | SQLException ev) {
                            ev.printStackTrace();
                        }


                    }
                });

                view.setOnAction(event -> {
                    txtENo.setText(e.getEno());
                    txtAddress.setText(e.getAddress());
                    txtpossition.setText(e.getPossition());
                    txtContactNo.setText(e.getContact());
                    txtName.setText(e.getName());
                });
            }
            tblemployee.setItems(obList);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public void btnAddCOnAction(ActionEvent actionEvent) {
        if (txtName.getText().isEmpty() | txtENo.getText().isEmpty()
                | txtAddress.getText().isEmpty() | txtContactNo.getText().isEmpty() |
                txtpossition.getText().isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Please fill the data").show();
            return;
        }
        String eno = txtENo.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contactNo = txtContactNo.getText();
        String possition = txtpossition.getText();

            try {
                boolean savedEmp = employeeBO.addEmployee (
                        new EmployeeDTO (
                                eno,
                                name,
                                address,
                                contactNo,
                                possition));


                if (savedEmp) {
                    new Alert(Alert.AlertType.INFORMATION, "Success").show();
                    lodeEmployeeData();
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

    }

    public void btnUpdateCOnAction(ActionEvent actionEvent) {

        if (txtName.getText().isEmpty() | txtENo.getText().isEmpty()
                | txtAddress.getText().isEmpty() | txtContactNo.getText().isEmpty() |
                txtpossition.getText().isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Please fill the data").show();
            return;
        }
        String eno = txtENo.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contactNo = txtContactNo.getText();
        String possition = txtpossition.getText();


            EmployeeDTO employeeDTO = new EmployeeDTO (eno, name, address, contactNo, possition);

            try {
                if (employeeBO.updateEmployee (employeeDTO)) {
                    new Alert(Alert.AlertType.INFORMATION, "Employee update Successful").show();
                    lodeEmployeeData();
                } else {
                    new Alert(Alert.AlertType.INFORMATION, "something went wrong").show();
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }


    }

    public void SelectallbtnOnAction(ActionEvent actionEvent) {
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../view/AdminPageForm.fxml")));
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }


}
