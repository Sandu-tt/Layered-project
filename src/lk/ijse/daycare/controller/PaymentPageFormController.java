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
import lk.ijse.daycare.bo.custom.ChildrenBO;
import lk.ijse.daycare.bo.custom.PaymentBO;
import lk.ijse.daycare.dto.ChildrenDTO;
import lk.ijse.daycare.dto.PaymentDTO;
import lk.ijse.daycare.view.tm.PaymentTM;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentPageFormController {
    public AnchorPane pane;
    public AnchorPane pane2;
    public TableView tblPayment;
    public TableColumn colName;
    public TableColumn colamount;
    public TableColumn colpmID;
    public TableColumn colcid;
    public TextField txtName;
    public TextField txtPname;
    public TextField txtPmid;
    public TextField txtAmount;
    public ComboBox<String> cmbcid;
    public TableColumn colview;
    public TableColumn coldelete;


    ObservableList<PaymentTM> obList = FXCollections.observableArrayList();
    ObservableList<String> obChil = FXCollections.observableArrayList();

    //ChildrenDAO childrenDAO=new ChildrenDAOImpl ();
   // PaymentDAO paymentDAO=new PaymentDAOImpl ();
    //ChildrenBO childrenBO=new ChildrenBOImpl ();
    //PaymentBO paymentBO=new PaymentBOImpl ();

    ChildrenBO childrenBO  = (ChildrenBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CHILDREN);
    PaymentBO paymentBO  = (PaymentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PAYMENT);


    public void initialize() {
        colpmID.setCellValueFactory(new PropertyValueFactory<>("pmID"));
        colcid.setCellValueFactory(new PropertyValueFactory<>("c_Id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colamount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        coldelete.setCellValueFactory(new PropertyValueFactory<>("delete"));
        colview.setCellValueFactory(new PropertyValueFactory<>("view"));
        tblPayment.setItems(obList);

        loadPaymentData();

        try {
            //setcmb();
            setData();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public void btnlogoutOnAction(ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../view/AdminPageForm.fxml")));
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void btnSaveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean a = paymentBO.addPayment (
                new PaymentDTO (
                        txtPmid.getText(),
                        cmbcid.getValue(),
                        txtName.getText(),
                        Double.parseDouble(txtAmount.getText())
                )
        );
        if (a) {
            new Alert(Alert.AlertType.INFORMATION, "Added").show();
            setData();
        }
    }

    public void cmbAction(ActionEvent actionEvent) {

        try {
            ResultSet set=childrenBO.getvalue(String.valueOf(cmbcid.getValue()));

            if (set.next()){


                txtName.setText(set.getString(1));
                txtPmid.setText(set.getString(2));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }


    private void setData() throws SQLException, ClassNotFoundException {
        setcmb();

        tblPayment.getItems().clear();

        try {
            ArrayList<PaymentDTO> allPayments = paymentBO.getAllPayment ();

            for (PaymentDTO p : allPayments
            ) {
                Button delete = new Button();
                Button update = new Button();
                delete.setText("DELETE");
                update.setText("View");
                PaymentTM paymentTM = new PaymentTM(
                        p.getPmID(),
                        p.getcID(),
                        p.getName(),
                        p.getAmount(),
                        delete,
                        update
                );
                obList.add(paymentTM);
                delete.setOnAction(event -> {
                    Alert alert=new Alert(Alert.AlertType.WARNING,"are your suren ! ",ButtonType.YES,ButtonType.NO);
                    alert.showAndWait();
                    if (alert.getResult().equals(ButtonType.YES)) {
                        try {
                            paymentBO.deletePayment (paymentTM.getPmID());
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        obList.remove(paymentTM);
                    }

                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    private void setcmb() throws SQLException, ClassNotFoundException {
        ArrayList<ChildrenDTO> allChildren = childrenBO.getAllChildrens ();
        for (ChildrenDTO c : allChildren
        ) {

            obChil.add(c.getCid());
        }
        cmbcid.setItems(obChil);


    }

    private void loadPaymentData() {
      /*  tblPayment.getItems().clear();

        try {
            ArrayList<Payment> allPayment = PaymentModel.getAllPayment();

            for (Payment p : allPayment
            ) {
                Button view = new Button("Update");
                Button delete = new Button("View");
                obList.add(
                        new PaymentTM(
                                p.getPmID(), p.getcID(), p.getName(), p.getAmount(),
                                view, delete)
                );
                delete.setOnAction(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                            "are you sure whether do you want to delete this payment?",
                            ButtonType.YES, ButtonType.NO);
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if (buttonType.get() == ButtonType.YES) {
                        try {
                            if (PaymentModel.idIsExsist(p.getPmID())) {
                                if (PaymentModel.deletePayment(p.getcID())) {
                                    new Alert(Alert.AlertType.INFORMATION, "Payment Deleted!").show();
                                }
                            } else {
                                if (PaymentModel.deletePayment(p.getcID())) {
                                    new Alert(Alert.AlertType.INFORMATION, "Payment Deleted!").show();
                                    loadPaymentData();
                                } else {
                                    new Alert(Alert.AlertType.WARNING, "Try Again!").show();
                                }
                            }


                        } catch (SQLException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }


                });


            }
        }
    }*/
    }
}
