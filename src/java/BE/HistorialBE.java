/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import java.sql.Date;

/**
 *
 * @author USER
 */
public class HistorialBE {
    private Integer id_alquiler,tiempo_prestamo,cantidad_equipos;
    private String razonSocial,ruc,estado,nombre;
    private Double precio_alquiler,descuento;
    private Date fechaEntrega,fechaDevolucion;

    public HistorialBE() {
    }

    public HistorialBE(Integer id_alquiler, Integer tiempo_prestamo, Integer cantidad_equipos, String razonSocial, String ruc, String estado, String nombre, Double precio_alquiler, Double descuento, Date fechaEntrega, Date fechaDevolucion) {
        this.id_alquiler = id_alquiler;
        this.tiempo_prestamo = tiempo_prestamo;
        this.cantidad_equipos = cantidad_equipos;
        this.razonSocial = razonSocial;
        this.ruc = ruc;
        this.estado = estado;
        this.nombre = nombre;
        this.precio_alquiler = precio_alquiler;
        this.descuento = descuento;
        this.fechaEntrega = fechaEntrega;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Integer getId_alquiler() {
        return id_alquiler;
    }

    public void setId_alquiler(Integer id_alquiler) {
        this.id_alquiler = id_alquiler;
    }

    public Integer getTiempo_prestamo() {
        return tiempo_prestamo;
    }

    public void setTiempo_prestamo(Integer tiempo_prestamo) {
        this.tiempo_prestamo = tiempo_prestamo;
    }

    public Integer getCantidad_equipos() {
        return cantidad_equipos;
    }

    public void setCantidad_equipos(Integer cantidad_equipos) {
        this.cantidad_equipos = cantidad_equipos;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio_alquiler() {
        return precio_alquiler;
    }

    public void setPrecio_alquiler(Double precio_alquiler) {
        this.precio_alquiler = precio_alquiler;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    
}
