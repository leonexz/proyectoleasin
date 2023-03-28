package DAO;
import BE.AlquilerBE;
import Conexion.Conexion;
import java.sql.SQLException; 
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlquilerDAO { 
    
    public static int ultimoID(){
        Conexion con = null;
        int id = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT MAX(id_alquiler) as id FROM tb_alquiler"); 
            con.ejecutarConsulta();
            if (con.siguiente()) {
                id = con.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlquilerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return id;
        }
    }
    
    public static int registrarAlquiler(AlquilerBE unAlquiler){
        Conexion con = null;
        int cantidad = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("INSERT INTO tb_alquiler (id_responsable, tiempo_prestamo, precio_alquiler, cantidad_equipos, descuento, estado) VALUES(?, ?, ?, ?, ?, ?)");
            con.setInt(1, unAlquiler.getId_responsable());
            con.setInt(2, unAlquiler.getTiempo_prestamo());
            con.setDouble(3, unAlquiler.getPrecio_alquiler());
            con.setInt(4, unAlquiler.getCantidad_equipos());
            con.setDouble(5, unAlquiler.getDescuento());
            con.setString(6, unAlquiler.getEstado());
            cantidad = con.ejecutarActualizacion();
        } catch (SQLException ex) {
            Logger.getLogger(AlquilerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return cantidad;
        }
    } 
}
