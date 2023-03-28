package DAO;
import BE.DistritoBE; 
import Conexion.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DistritoDAO {
    public static int registrarDistrito(DistritoBE undistrito){
        Conexion con = null;
        int cantidad = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("INSERT INTO `tb_distrito`(`nom_distrito`, `id_provincia`) VALUES (?,?)");
            con.setString(1,undistrito.getNom_distrito());
            con.setInt(2,undistrito.getId_provincia());
            cantidad = con.ejecutarActualizacion();
        } catch (SQLException ex) {
            Logger.getLogger(DistritoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return cantidad;
        }
    }

    public static int actualizarDistrito(DistritoBE undistrito){
        Conexion con = null;
        int cantidad = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("UPDATE `tb_distrito` SET `nom_distrito`=?,`id_provincia`=? WHERE `id_distrito`=?");
            con.setString(1,undistrito.getNom_distrito()); 
            con.setInt(2,undistrito.getId_provincia());
            con.setInt(3,undistrito.getId_distrito());
            cantidad = con.ejecutarActualizacion();
        } catch (SQLException ex) {
            Logger.getLogger(DistritoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar(); 
                con = null;
            }
            return cantidad;
        }
    }
    
    public static DistritoBE buscarDistrito(int id_distrito) {
        Conexion con = null;
        DistritoBE undistrito = null;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_distrito`, `nom_distrito`, `id_provincia` FROM `tb_distrito` WHERE `id_distrito`=?");
            con.setInt(1,id_distrito);
            con.ejecutarConsulta();
            if (con.siguiente()) {
                undistrito = new DistritoBE(con.getInt("id_distrito"),con.getString("nom_distrito"),con.getInt("id_provincia"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DistritoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return undistrito;
        }
    }

    public static ArrayList<DistritoBE> listarDistrito() {
        Conexion con = null;
        ArrayList<DistritoBE> distritoLista = new ArrayList<>();
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_distrito`, `nom_distrito`, `id_provincia` FROM `tb_distrito`");
            con.ejecutarConsulta();
            while (con.siguiente()) {
                distritoLista.add( new DistritoBE(con.getInt("id_distrito"),con.getString("nom_distrito"),con.getInt("id_provincia")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DistritoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return distritoLista;
        }
    }
}
