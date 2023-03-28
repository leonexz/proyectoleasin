package BE;
public class AlquilerBE {
    private Integer id_alquiler,tiempo_prestamo,cantidad_equipos,id_responsable;
    private String id_producto,estado;
    private Double precio_alquiler,descuento;
    
    public AlquilerBE() {
    }

    public AlquilerBE(Integer id_alquiler, Integer tiempo_prestamo, Integer cantidad_equipos, String id_producto, Integer id_responsable, Double precio_alquiler, Double descuento, String estado) {
        this.id_alquiler = id_alquiler;
        this.tiempo_prestamo = tiempo_prestamo;
        this.cantidad_equipos = cantidad_equipos;
        this.id_producto = id_producto;
        this.id_responsable = id_responsable;
        this.precio_alquiler = precio_alquiler;
        this.descuento = descuento;
        this.estado = estado;
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

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public Integer getId_responsable() {
        return id_responsable;
    }

    public void setId_responsable(Integer id_responsable) {
        this.id_responsable = id_responsable;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
 
           
}
