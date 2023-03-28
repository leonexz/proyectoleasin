/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BE;

/**
 * 
 * @author Jorge Ricalde
 */
public class ProductoVW { 
    private Float precio;
    private String id,nombre,imagen; 

    public ProductoVW() {
    }

    public ProductoVW(Float precio, String nombre, String imagen, String id) {
        this.precio = precio;
        this.nombre = nombre;
        this.imagen = imagen;
        this.id = id;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
}
