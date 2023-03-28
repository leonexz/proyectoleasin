package DAO;
import BE.SistemaOperativoBE;
import Conexion.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SistemaOperativoDAO {
    public static int registrarSisope(SistemaOperativoBE unSISOPE){
        Conexion con = null;
        int cantidad = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("INSERT INTO `tb_sistema_operativo`(`tipo_sistema_operativo`) VALUES (?)");
            con.setString(1,unSISOPE.getTipo_sistema_operativo());
            cantidad = con.ejecutarActualizacion();
        } catch (SQLException ex) {
            Logger.getLogger(SistemaOperativoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return cantidad;
        }
    }

    public static int actualizarSisope(SistemaOperativoBE unSISOPE){
        Conexion con = null;
        int cantidad = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("UPDATE `tb_sistema_operativo` SET `tipo_sistema_operativo`= ? WHERE `id_sistema_operativo`= ?");
            con.setString(1,unSISOPE.getTipo_sistema_operativo()); 
            con.setInt(2,unSISOPE.getId_sistema_operativo());
            cantidad = con.ejecutarActualizacion();
        } catch (SQLException ex) {
            Logger.getLogger(SistemaOperativoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar(); 
                con = null;
            }
            return cantidad;
        }
    }
    
    public static SistemaOperativoBE buscarSisope(int id_sistema_operativo) {
        Conexion con = null;
        SistemaOperativoBE unSISOPE = null;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_sistema_operativo`, `tipo_sistema_operativo` FROM `tb_sistema_operativo` WHERE `id_sistema_operativo`= ?");
            con.setInt(1,id_sistema_operativo);
            con.ejecutarConsulta();
            if (con.siguiente()) {
                unSISOPE = new SistemaOperativoBE(con.getInt("id_sistema_operativo"),con.getString("tipo_sistema_operativo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SistemaOperativoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return unSISOPE;
        }
    }

    public static ArrayList<SistemaOperativoBE> listarSisope() {
        Conexion con = null;
        ArrayList<SistemaOperativoBE> sisopeLista = new ArrayList<>();
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_sistema_operativo`, `tipo_sistema_operativo` FROM `tb_sistema_operativo`");
            con.ejecutarConsulta();
            while (con.siguiente()) {
                sisopeLista.add( new SistemaOperativoBE(con.getInt("id_sistema_operativo"),con.getString("tipo_sistema_operativo")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SistemaOperativoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return sisopeLista;
        }
    }
}
