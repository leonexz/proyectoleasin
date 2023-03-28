package DAO;
import BE.SedeBE;
import Conexion.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SedeDAO {
    public static int registrarSede(SedeBE unaSede){
        Conexion con = null;
        int cantidad = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("INSERT INTO `tb_sede`(`direccion`, `id_distrito`, `id_empresa`) VALUES (?,?,?)");
            con.setString(1,unaSede.getDireccion());
            con.setInt(2,unaSede.getId_distrito());
            con.setString(3,unaSede.getId_empresa());
            cantidad = con.ejecutarActualizacion();
        } catch (SQLException ex) {
            Logger.getLogger(SedeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return cantidad;
        }
    }

    public static int actualizarSede(SedeBE unaSede){
        Conexion con = null;
        int cantidad = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("UPDATE `tb_sede` SET `direccion`=?,`id_distrito`=?,`id_empresa`=? WHERE `id_sede`=?");
            con.setString(1,unaSede.getDireccion()); 
            con.setInt(2,unaSede.getId_distrito()); 
            con.setString(3,unaSede.getId_empresa()); 
            con.setInt(4,unaSede.getId_Sede());
            cantidad = con.ejecutarActualizacion();
        } catch (SQLException ex) {
            Logger.getLogger(SedeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar(); 
                con = null;
            }
            return cantidad;
        }
    }
    
    public static SedeBE buscarSede(int id_sede) {
        Conexion con = null;
        SedeBE unaSede = null;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_sede`, `direccion`, `id_distrito`, `id_empresa` FROM `tb_sede` WHERE `id_sede`= ?");
            con.setInt(1,id_sede);
            con.ejecutarConsulta();
            if (con.siguiente()) {
                unaSede = new SedeBE(con.getInt("id_sede"),con.getString("direccion"),con.getInt("id_distrito"),con.getString("id_empresa"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SedeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return unaSede;
        }
    }

    public static ArrayList<SedeBE> listarSede() {
        Conexion con = null;
        ArrayList<SedeBE> sedeLista = new ArrayList<>();
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_sede`, `direccion`, `id_distrito`, `id_empresa` FROM `tb_sede`");
            con.ejecutarConsulta();
            while (con.siguiente()) {
                sedeLista.add( new SedeBE(con.getInt("id_sede"),con.getString("direccion"),con.getInt("id_distrito"),con.getString("id_empresa")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SedeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return sedeLista;
        }
    }
}
