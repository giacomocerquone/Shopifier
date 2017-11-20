package gglp.shopifier.Model;

public class Shop {

    private String name;
    private String address;
    private String tel;
    private String email;

    public Shop(){}

    public Shop(String name, String address, String tel, String email) {
        setName(name);
        setAddress(address);
        setTel(tel);
        setEmail(email);
    }

    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getTel() {
        return tel;
    }
    public String getEmail() {
        return email;
    }

    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setTel(String tel) { this.tel = tel; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return this.name + ' ' + this.address;
    }
}