package lk.ijse.daycare.dto;

public class PaymentDTO {
    private String pmID;
    private String cID;
    private String name;
    private double amount;

    public PaymentDTO() {
    }
    public PaymentDTO(String pmID, String cID, String name, double amount) {
        this.pmID = pmID;
        this.cID = cID;
        this.name = name;
        this.amount = amount;
    }
    public String getPmID() {return pmID;}

    public void setPmID(String pmID) {this.pmID = pmID;}

    public String getcID() {return cID;}

    public void setcID(String cID) {this.cID = cID;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public double getAmount() {return amount;}

    public void setAmount(double amount) {this.amount = amount;}
}
