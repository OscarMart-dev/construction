package Modelo;

import java.time.LocalDate;

public class users {
    
    String code;
    String name;
    String password;
    String email;
    String state;
    LocalDate entry_date;

    public users() {
    }

    public users(String code, String name, String password, String email, String state, LocalDate entry_date) {
        this.code = code;
        this.name = name;
        this.password = password;
        this.email = email;
        this.state = state;
        this.entry_date = entry_date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDate getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(LocalDate entry_date) {
        this.entry_date = entry_date;
    }
    
    
}
