 

package DAO;
  
import Conexion.Conexion; 
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DetalleDAO {
    public static int[] registrarDetalleEnLote(int idalquiler, String[] idsProducto){
        Conexion con = null;
        int[] cantidad = null;
        try {
            con = Conexion.getConexion();        
            con.prepararSQL("INSERT INTO tb_detalle (id_alquiler, id_producto) VALUES(?, ?)");
            for (String idProducto : idsProducto) { 
                con.setInt(1, idalquiler);
                con.setString(2, idProducto);
                con.agregarLote();
            }
            cantidad = con.ejecutarLote();
        } catch (SQLException ex) {
            Logger.getLogger(DetalleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return cantidad;
        }
    }
    
}
