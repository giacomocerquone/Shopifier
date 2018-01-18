package gglp.shopifier.Model;

import java.io.Serializable;

public class Shop implements Serializable{

    private String name;
    private String address;
    private String phone;
    private String descr;
    private String email;
    private String image;
    private String lat;
    private String lon;


    public Shop(String name, String address, String phone, String descr, String email, String image, String lat,String lon) {
        setName(name);
        setAddress(address);
        setTel(phone);
        setDescr(descr);
        setEmail(email);
        setImage(image);
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
        return phone;
    }
    public String getDescr() {return descr;}
    public String getEmail() {return email; }
    public String getImage() {return image; }
    public String getLat() {return lat; }
    public String getLon() {return lon; }


    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setTel(String phone) { this.phone = phone; }
    public void setDescr(String descr) {this.descr = descr;}
    public void setEmail(String email) { this.email = email; }
    public void setImage(String image) { this.image = image; }
    public void setLat(String lat) { this.lat = lat; }
    public void setLon(String lon) { this.lon = lon; }


    @Override
    public String toString() {
        return this.name ;
    }
}