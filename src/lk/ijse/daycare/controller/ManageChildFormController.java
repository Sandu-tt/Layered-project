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
import lk.ijse.daycare.dto.ChildrenDTO;
import lk.ijse.daycare.view.tm.ChildrenTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageChildFormController {
    private final ObservableList<ChildrenTM> obList = FXCollections.observableArrayList();
    public AnchorPane pane;
    public AnchorPane pane2;
    public TableView<ChildrenTM> tblChildren;
    public TableColumn<ChildrenTM, String> colCID;
    public TableColumn<ChildrenTM, String> colName;
    public TableColumn<ChildrenTM, String> colDoB;
    public TableColumn<ChildrenTM, String> colAge;
    public TableColumn<ChildrenTM, String> colAddress;
    public TableColumn<ChildrenTM, String> colContact;
    public TextField txtname;
    public TextField txtcid;
    public TextField txtAddress;
    public TextField txtage;
    public TextField txtcontact;
    public TextField txtdob;
    public TableColumn collView;

    //ChildrenDAO childrenDAO=new ChildrenDAOImpl ();
    //ChildrenBO childrenBO=new ChildrenBOImpl ();
    ChildrenBO childrenBO  = (ChildrenBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CHILDREN);

    public void initialize() {
        colCID.setCellValueFactory(new PropertyValueFactory<>("cid"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colDoB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        collView.setCellValueFactory(new PropertyValueFactory<>("view"));


        lodeChildenData();
        // setCellValueFactory();
    }

    private void lodeChildenData() {
        tblChildren.getItems().clear();
        try {
            ArrayList<ChildrenDTO> allChildren = childrenBO.getAllChildrens ();
            for (ChildrenDTO c : allChildren
            ) {
                Button view = new Button("View");
                obList.add(
                        new ChildrenTM(
                                c.getCid(), c.getName(), c.getAddress(), c.getDob(), c.getAge(), c.getContact()
                                , view)
                );
                view.setOnAction(event -> {
                    txtcid.setText(c.getCid());
                    txtAddress.setText(c.getAddress());
                    txtname.setText(c.getName());
                    txtdob.setText(c.getDob());
                    txtage.setText(c.getAge());
                    txtcontact.setText(c.getContact());
                });
            }
            tblChildren.setItems(obList);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnAddCOnAction(ActionEvent actionEvent) throws IOException {
        try {
            boolean b = childrenBO.add(
                    new ChildrenDTO (
                            txtcid.getText(),
                            txtname.getText(),
                            txtAddress.getText(),
                            txtdob.getText(),
                            txtage.getText(),
                            txtcontact.getText()
                    )
            );
            if (b) {
                new Alert(Alert.AlertType.INFORMATION, "Success!").show();
                lodeChildenData();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnUpdateCOnAction(ActionEvent actionEvent) {
        String id = txtcid.getText();
        String name = txtname.getText();
        String address = txtAddress.getText();
        String dob = txtdob.getText();
        String age = txtage.getText();
        String contact = txtcontact.getText();
        ChildrenDTO childrenDTO = new ChildrenDTO (id, name, address, dob,age ,contact);

        try {

            if (childrenBO.update(childrenDTO)){
                new Alert(Alert.AlertType.INFORMATION, "Customer update Successful").show();
                lodeChildenData();
            }else {
                new Alert(Alert.AlertType.INFORMATION, "Smoothing Was Wrong").show();

            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }


    public void btnDeleteCOnAction(ActionEvent actionEvent) {

        try {
            boolean isDelete = childrenBO.delete(txtcid.getText());
            if (isDelete) {
                new Alert(Alert.AlertType.INFORMATION, "Children Delete Successful").show();
                lodeChildenData();
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Something Was Wrong").show();
            }
        } catch (Exception ex) {

        }

    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../view/AdminPageForm.fxml")));
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void SelectallbtnOnAction(ActionEvent actionEvent) {
       /* try {
            Children children = searchchildren(txtcid.getText());
            if (children != null) {
                txtname.setText(children.getName());
                txtAddress.setText(children.getAddress());
                txtdob.setText(children.getDob());
                txtage.setText(children.getAge());
                txtcontact.setText(children.getContact());
            }
        } catch (Exception ex) {
            System.out.println(ex);*/
    }
}
