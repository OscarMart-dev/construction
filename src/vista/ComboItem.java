/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author oscar
 */
public class ComboItem  {
    private String id;
    private String state;

    public ComboItem() {
    }
    
    public ComboItem(String id, String state) {
         this.id = id;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    @Override
        public String toString() {
            return state; // Esto es lo que se mostrará en el JComboBox
        }
}
