/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part3;

/**
 *
 * @author 1misiakrya
 */
public class Furniture {
    
    private String name;
    private double price;
    private boolean sold;
    private int id;
    
    public Furniture(){
        
    }
    
    public Furniture(int id){
        
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    @Override
    public String toString() {
        return "Furniture{" + "name=" + name + ", price=" + price + ", sold=" + sold + ", id=" + id + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Furniture other = (Furniture) obj;
        return true;
    }
    
    
    
}
