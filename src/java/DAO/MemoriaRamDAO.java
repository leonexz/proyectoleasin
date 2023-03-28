package DAO;
import BE.MemoriaRamBE;
import Conexion.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MemoriaRamDAO {
    public static int registrarMemoria(MemoriaRamBE unaMemoria){
        Conexion con = null;
        int cantidad = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("INSERT INTO `tb_memoria_ram`(`tipo_memoria_ram`) VALUES (?)");
            con.setString(1,unaMemoria.getTipo_memoria_ram());
            cantidad = con.ejecutarActualizacion();
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaRamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return cantidad;
        }
    }

    public static int actualizarMemoriaRam(MemoriaRamBE unaMemoria){
        Conexion con = null;
        int cantidad = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("UPDATE `tb_memoria_ram` SET `tipo_memoria_ram`= ? WHERE `id_memoria_ram`= ?");
            con.setString(1,unaMemoria.getTipo_memoria_ram()); 
            con.setInt(2,unaMemoria.getId_memoria_ram());
            cantidad = con.ejecutarActualizacion();
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaRamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar(); 
                con = null;
            }
            return cantidad;
        }
    }
    
    public static MemoriaRamBE buscarMemoria(int id_memoria_ram) {
        Conexion con = null;
        MemoriaRamBE unaMemoria = null;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_memoria_ram`, `tipo_memoria_ram` FROM `tb_memoria_ram` WHERE `id_memoria_ram`= ?");
            con.setInt(1,id_memoria_ram);
            con.ejecutarConsulta();
            if (con.siguiente()) {
                unaMemoria = new MemoriaRamBE(con.getInt("id_memoria_ram"),con.getString("tipo_memoria_ram"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaRamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return unaMemoria;
        }
    }

    public static ArrayList<MemoriaRamBE> listarMemoriaRam() {
        Conexion con = null;
        ArrayList<MemoriaRamBE> memoriaLista = new ArrayList<>();
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_memoria_ram`, `tipo_memoria_ram` FROM `tb_memoria_ram`");
            con.ejecutarConsulta();
            while (con.siguiente()) {
                memoriaLista.add( new MemoriaRamBE(con.getInt("id_memoria_ram"),con.getString("tipo_memoria_ram")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaRamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return memoriaLista;
        }
    }
}
