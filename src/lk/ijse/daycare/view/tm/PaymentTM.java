package lk.ijse.daycare.view.tm;


import javafx.scene.control.Button;

public class PaymentTM {
    private String pmID;
    private String c_Id;
    private String name;
    private double amount;
    private Button delete;
    private Button view;

    public PaymentTM() {
    }

    public PaymentTM(String pmID, String c_Id, String name, double amount, Button delete, Button view) {
        this.pmID = pmID;
        this.c_Id = c_Id;
        this.name = name;
        this.amount = amount;
        this.delete = delete;
        this.view = view;
    }

    public String getPmID() {
        return pmID;
    }

    public void setPmID(String pmID) {
        this.pmID = pmID;
    }

    public String getC_Id() {
        return c_Id;
    }

    public void setC_Id(String c_Id) {
        this.c_Id = c_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    public Button getView() {
        return view;
    }

    public void setView(Button view) {
        this.view = view;
    }

    @Override
    public String toString() {
        return "PaymentTM{" +
                "pmID='" + pmID + '\'' +
                ", c_Id='" + c_Id + '\'' +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", delete=" + delete +
                ", view=" + view +
                '}';
    }
}


