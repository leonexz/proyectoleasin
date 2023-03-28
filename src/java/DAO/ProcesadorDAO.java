package DAO;
import BE.ProcesadorBE;
import Conexion.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProcesadorDAO {
    public static int registrarProcesador(ProcesadorBE unProcesador){
        Conexion con = null;
        int cantidad = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("INSERT INTO `tb_procesador`(`tipo_procesador`) VALUES (?)");
            con.setString(1,unProcesador.getTipo_procesador());
            cantidad = con.ejecutarActualizacion();
        } catch (SQLException ex) {
            Logger.getLogger(ProcesadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return cantidad;
        }
    }

    public static int actualizarProcesador(ProcesadorBE unProcesador){
        Conexion con = null;
        int cantidad = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("UPDATE `tb_procesador` SET `tipo_procesador`= ? WHERE `id_procesador`= ?");
            con.setString(1,unProcesador.getTipo_procesador()); 
            con.setInt(2,unProcesador.getId_procesador());
            cantidad = con.ejecutarActualizacion();
        } catch (SQLException ex) {
            Logger.getLogger(ProcesadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar(); 
                con = null;
            }
            return cantidad;
        }
    }
    
    public static ProcesadorBE buscarProcesador(int id_procesador) {
        Conexion con = null;
        ProcesadorBE unProcesador = null;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_procesador`, `tipo_procesador` FROM `tb_procesador` WHERE `id_procesador`= ?");
            con.setInt(1,id_procesador);
            con.ejecutarConsulta();
            if (con.siguiente()) {
                unProcesador = new ProcesadorBE(con.getInt("id_procesador"),con.getString("tipo_procesador"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProcesadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return unProcesador;
        }
    }

    public static ArrayList<ProcesadorBE> listarProcesador() {
        Conexion con = null;
        ArrayList<ProcesadorBE> procesadorLista = new ArrayList<>();
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_procesador`, `tipo_procesador` FROM `tb_procesador`");
            con.ejecutarConsulta();
            while (con.siguiente()) {
                procesadorLista.add( new ProcesadorBE(con.getInt("id_procesador"),con.getString("tipo_procesador")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProcesadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return procesadorLista;
        }
    }
}
