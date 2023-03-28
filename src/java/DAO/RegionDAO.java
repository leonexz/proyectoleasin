package DAO;

import BE.RegionBE;
import Conexion.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegionDAO {
    public static int registrarRegion(RegionBE unRegion){
        Conexion con = null;
        int cantidad = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("INSERT INTO `tb_region`(`nom_region`) VALUES (?)");
            con.setString(1,unRegion.getNom_region());
            cantidad = con.ejecutarActualizacion();
        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return cantidad;
        }
    }

    public static int actualizarRegion(RegionBE unRegion){
        Conexion con = null;
        int cantidad = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("UPDATE `tb_region` SET `nom_region`='?' WHERE `id_region` = ?");
            con.setString(1,unRegion.getNom_region()); 
            con.setInt(2,unRegion.getId_region());
            cantidad = con.ejecutarActualizacion();
        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar(); 
                con = null;
            }
            return cantidad;
        }
    }
    
    public static RegionBE buscarRegion(int id_region) {
        Conexion con = null;
        RegionBE unRegion = null;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_region`, `nom_region` FROM `tb_region` WHERE `id_region`= ?");
            con.setInt(1,id_region);
            con.ejecutarConsulta();
            if (con.siguiente()) {
                unRegion = new RegionBE(con.getInt("id_region"),con.getString("nom_region"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return unRegion;
        }
    }

    public static ArrayList<RegionBE> listarRegion() {
        Conexion con = null;
        ArrayList<RegionBE> regionLista = new ArrayList<>();
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_region`, `nom_region` FROM `tb_region`");
            con.ejecutarConsulta();
            while (con.siguiente()) {
                regionLista.add( new RegionBE(con.getInt("id_region"),con.getString("nom_region")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return regionLista;
        }
    }
}
