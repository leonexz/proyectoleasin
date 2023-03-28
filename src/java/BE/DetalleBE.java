 

package BE;
 
import java.sql.Timestamp;

public class DetalleBE {
    private Integer id_alquiler;
    private String id_producto;
    private Timestamp fechaEntrega,fechaDevolucion;

    public DetalleBE() {
    }

    public DetalleBE(Integer id_alquiler, String id_producto, Timestamp fechaEntrega, Timestamp fechaDevolucion) {
        this.id_alquiler = id_alquiler;
        this.id_producto = id_producto;
        this.fechaEntrega = fechaEntrega;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Integer getId_alquiler() {
        return id_alquiler;
    }

    public void setId_alquiler(Integer id_alquiler) {
        this.id_alquiler = id_alquiler;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public Timestamp getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Timestamp fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Timestamp getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Timestamp fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    
}
