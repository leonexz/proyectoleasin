package DAO;

import BE.ProvinciaBE;
import Conexion.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProvinciaDAO {
    public static int registrarProvincia(ProvinciaBE unaProvincia){
        Conexion con = null;
        int cantidad = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("INSERT INTO `tb_provincia`(`nom_provincia`, `id_region`) VALUES (?,?)");
            con.setString(1,unaProvincia.getNom_provincia());
            con.setInt(2,unaProvincia.getId_region());
            cantidad = con.ejecutarActualizacion();
        } catch (SQLException ex) {
            Logger.getLogger(ProvinciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return cantidad;
        }
    }

    public static int actualizarProvincia(ProvinciaBE unaProvincia){
        Conexion con = null;
        int cantidad = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("UPDATE `tb_provincia` SET `nom_provincia`='?',`id_region`='?' WHERE `id_provincia`= ?");
            con.setString(1,unaProvincia.getNom_provincia());
            con.setInt(2,unaProvincia.getId_region());
            con.setInt(3,unaProvincia.getId_provincia());
            cantidad = con.ejecutarActualizacion();
        } catch (SQLException ex) {
            Logger.getLogger(ProvinciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar(); 
                con = null;
            }
            return cantidad;
        }
    }
    
    public static ProvinciaBE buscarProvincia(int id_provincia) {
        Conexion con = null;
        ProvinciaBE unaProvincia = null;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_provincia`, `nom_provincia`, `id_region` FROM `tb_provincia` WHERE `id_provincia`= ?");
            con.setInt(1,id_provincia);
            con.ejecutarConsulta();
            if (con.siguiente()) {
                unaProvincia = new ProvinciaBE(con.getInt("id_provincia"),con.getString("nom_provincia"),con.getInt("id_region"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProvinciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return unaProvincia;
        }
    }

    public static ArrayList<ProvinciaBE> listarProvincia() {
        Conexion con = null;
        ArrayList<ProvinciaBE> provinciaLista = new ArrayList<>();
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_provincia`, `nom_provincia`, `id_region` FROM `tb_provincia`");
            con.ejecutarConsulta();
            while (con.siguiente()) {
                provinciaLista.add( new ProvinciaBE(con.getInt("id_provincia"),con.getString("nom_provincia"),con.getInt("id_region")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProvinciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return provinciaLista;
        }
    }
}
