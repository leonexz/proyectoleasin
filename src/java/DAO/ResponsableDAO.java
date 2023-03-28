package DAO;
import BE.ResponsableBE;
import Conexion.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResponsableDAO {
     public static int registrarResponsable(ResponsableBE unResponsable){
        Conexion con = null;
        int cantidad = 0;
        try {
            con = Conexion.getConexion();
            
            con.prepararSQL("INSERT INTO `tb_responsable`(`nombre`, `apellido`, `dni`, `id_empresa`) VALUES (?,?,?,?)");
            con.setString(1,unResponsable.getNombre());
            con.setString(2,unResponsable.getApellido());
            con.setString(3,unResponsable.getDni());
            con.setString(4,unResponsable.getId_empresa());
            cantidad = con.ejecutarActualizacion();
        } catch (SQLException ex) {
            Logger.getLogger(ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return cantidad;
        }
    }

    public static int actualizarResponsable(ResponsableBE unResponsable){
        Conexion con = null;
        int cantidad = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("UPDATE `tb_responsable` SET `nombre`=?,`apellido`=?,`dni`=?,`id_empresa`=? WHERE `id_responsable`=?");
            con.setString(1,unResponsable.getNombre());
            con.setString(2,unResponsable.getApellido());
            con.setString(3,unResponsable.getDni());
            con.setString(4,unResponsable.getId_empresa());
            con.setInt(5,unResponsable.getId_responsable());
            cantidad = con.ejecutarActualizacion();
        } catch (SQLException ex) {
            Logger.getLogger(ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar(); 
                con = null;
            }
            return cantidad;
        }
    }
    
    public static ResponsableBE buscarResponsable(int id_responble) {
        Conexion con = null;
        ResponsableBE responsableLista = null;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_responsable`, `nombre`, `apellido`, `dni`, `id_empresa` FROM `tb_responsable` WHERE `id_responsable`=?");
            con.setInt(1,id_responble);
            con.ejecutarConsulta();
            if (con.siguiente()) {
                responsableLista = new ResponsableBE(con.getInt("id_responsable"),con.getString("nombre"),con.getString("apellido"),con.getString("dni"),con.getString("id_empresa"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return responsableLista;
        }
    }

    public static ArrayList<ResponsableBE> listarResponsable() {
        Conexion con = null;
        ArrayList<ResponsableBE> responsableLista = new ArrayList<>();
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_responsable`, `nombre`, `apellido`, `dni`, `id_empresa` FROM `tb_responsable`");
            con.ejecutarConsulta();
            while (con.siguiente()) {
                responsableLista.add( new ResponsableBE(con.getInt("id_responsable"),con.getString("nombre"),con.getString("apellido"),con.getString("dni"),con.getString("id_empresa")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return responsableLista;
        }
    }
    
    public static int UltimoID() {
        Conexion con = null;
        int id_responsable = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT id_responsable FROM tb_responsable ORDER BY id_responsable DESC LIMIT 1"); 
            con.ejecutarConsulta();
            if (con.siguiente()) {
                id_responsable = con.getInt("id_responsable");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return id_responsable;
        }
    }
}
