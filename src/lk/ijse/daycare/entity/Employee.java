package lk.ijse.daycare.entity;

public class Employee {
    private String eno;
    private String name;
    private String address;
    private String contact;
    private String possition;

    public Employee() {

    }
    public Employee(String eno,
                    String name, String address, String contact, String possition) {
        this.eno = eno;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.possition = possition;
    }

    public String getEno() {return eno;
    }

    public void setEno(String eno) {
        this.eno = eno;
    }

    public String getName() {return name;
    }

    public void setName(String name) {this.name = name;
    }

    public String getAddress() {return address;
    }

    public void setAddress(String address) {this.address = address;
    }

    public String getContact() {return contact;
    }

    public void setContact(String contact) {this.contact = contact;
    }


    public String getPossition() {return possition;
    }

    public void setPossition(String possition) {this.possition = possition;
    }
}
