package gglp.shopifier.Model;

public class Shop {

    private String name;
    private String address;
    private String tel;
    private String email;
    private String lat;
    private String lon;


    public Shop(String name, String address, String tel, String email,String lat,String lon) {
        setName(name);
        setAddress(address);
        setTel(tel);
        setEmail(email);
        setLat(lat);
        setLon(lon);
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
    public String getEmail() {return email; }
    public String getLat() {return lat; }
    public String getLon() {return lon; }


    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setTel(String tel) { this.tel = tel; }
    public void setEmail(String email) { this.email = email; }
    public void setLat(String lat) { this.lat = lat; }
    public void setLon(String lon) { this.lon = lon; }


    @Override
    public String toString() {
        return this.name + ' ' + this.address ;
    }
}