
package Modelo;

import java.util.Date;
public class employee {

    int id;
    String name;
    Date birthdate; // Usando LocalDate para fechas
    String address;
    int phone;
    int year;
    String email;
    String post;
    String state;
    String area;
    String fecha;

    public employee() {
    }

    public employee(int id, String name, Date birthdate, String address, int phone, int year, String email, String post, String state, String area,String fecha) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.address = address;
        this.phone = phone;
        this.year = year;
        this.email = email;
        this.post = post;
        this.state = state;
        this.area= area;
        this.fecha=fecha;
    }

    public String getArea() {
        return area;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
