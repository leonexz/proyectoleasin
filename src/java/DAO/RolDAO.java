package DAO;
import BE.RolBE;
import BE.SistemaOperativoBE;
import Conexion.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RolDAO {
    public static int registrarRol(RolBE unRol){
        Conexion con = null;
        int cantidad = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("INSERT INTO `tb_rol`(`nom_rol`) VALUES (?)");
            con.setString(1,unRol.getNom_rol());
            cantidad = con.ejecutarActualizacion();
        } catch (SQLException ex) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return cantidad;
        }
    }

    public static int actualizarRol(RolBE unRol){
        Conexion con = null;
        int cantidad = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("UPDATE `tb_rol` SET `nom_rol`='?' WHERE `id_rol`=?");
            con.setString(1,unRol.getNom_rol());
            con.setInt(2,unRol.getId_rol()); 
            cantidad = con.ejecutarActualizacion();
        } catch (SQLException ex) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar(); 
                con = null;
            }
            return cantidad;
        }
    }
    
    public static RolBE buscarRol(int id_rol) {
        Conexion con = null;
        RolBE unRol = null;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_rol`, `nom_rol` FROM `tb_rol` WHERE `id_rol`=?");
            con.setInt(1,id_rol);
            con.ejecutarConsulta();
            if (con.siguiente()) {
                unRol = new RolBE(con.getInt("id_rol"),con.getString("nom_rol"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return unRol;
        }
    }

    public static ArrayList<RolBE> listarRol() {
        Conexion con = null;
        ArrayList<RolBE> rolLista = new ArrayList<>();
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_rol`, `nom_rol` FROM `tb_rol`");
            con.ejecutarConsulta();
            while (con.siguiente()) {
                rolLista.add( new RolBE(con.getInt("id_rol"),con.getString("nom_rol")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return rolLista;
        }
    }
}
