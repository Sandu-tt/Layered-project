package lk.ijse.daycare.entity;

public class Children {
    private String cid;
    private String name;
    private String address;
    private String dob;
    private String age;
    private String contact;

    public Children() {
    }

    public Children(String cid, String name, String address, String dob, String age, String contact) {
        this.cid = cid;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.age = age;
        this.contact = contact;
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

    @Override
    public String toString() {
        return "Children{" +
                "cid='" + cid + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", dob='" + dob + '\'' +
                ", age='" + age + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
