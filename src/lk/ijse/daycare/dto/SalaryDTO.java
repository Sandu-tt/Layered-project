package lk.ijse.daycare.dto;

public class SalaryDTO {
    private String salID;
    private String empID;
    private String name;
    private double amount;

    public SalaryDTO() {
    }

    public SalaryDTO(String salID, String empID, String name, double amount) {
        this.salID = salID;
        this.empID = empID;
        this.name = name;
        this.amount = amount;
    }

    public String getSalID() {
        return salID;
    }

    public void setSalID(String salID) {
        this.salID = salID;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
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
}
