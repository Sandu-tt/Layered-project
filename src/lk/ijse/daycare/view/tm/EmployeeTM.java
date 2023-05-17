package lk.ijse.daycare.view.tm;

import javafx.scene.control.Button;
import lk.ijse.daycare.entity.Employee;

public class EmployeeTM extends Employee {
    private Button view;
    private Button delete;
    private String eno;
    private String name;
    private String address;
    private String contact;
    private String possition;


    public EmployeeTM() {
    }

    public EmployeeTM(String eno,
                      String name, String address, String contact, String possition, Button view, Button delete) {
        this.eno = eno;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.possition = possition;
        this.view = view;
        this.delete = delete;
    }

    public String getEno() {
        return eno;
    }

    public void setEno(String eno) {
        this.eno = eno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }


    public String getPossition() {
        return possition;
    }

    public void setPossition(String possition) {
        this.possition = possition;
    }

    public Button getView() {
        return view;
    }

    public void setView(Button view) {
        this.view = view;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }
}


