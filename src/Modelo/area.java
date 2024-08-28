
package Modelo;


public class area {
    
    int code;
    String name;
    char state;

    public area() {
    }

    public area(int code, String name,char state) {
        this.code = code;
        this.name = name;
        this.state = state;
    }

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
