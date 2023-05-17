package lk.ijse.daycare.view.tm;

import javafx.scene.control.Button;

public class ChildrenTM {
    private String cid;
    private String name;
    private String address;
    private String dob;
    private String age;
    private String contact;
    private Button view;

    public ChildrenTM() {
    }

    public ChildrenTM(String cid,
                      String name, String address, String dob, String age, String contact, Button view) {
        this.cid = cid;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.age = age;
        this.contact = contact;
        this.view = view;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Button getView() {
        return view;
    }

    public void setView(Button view) {
        this.view = view;
    }
}
