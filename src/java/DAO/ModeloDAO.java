package DAO;
import BE.ModeloBE;
import Conexion.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloDAO {
    public static int registrarModelo(ModeloBE unModelo){
        Conexion con = null;
        int cantidad = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("INSERT INTO `tb_modelo`(`tipo_modelo`) VALUES (?)");
            con.setString(1,unModelo.getTipo_modelo());
            cantidad = con.ejecutarActualizacion();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return cantidad;
        }
    }


    public static int actualizarModelo(ModeloBE unModelo){
        Conexion con = null;
        int cantidad = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("UPDATE `tb_modelo` SET `tipo_modelo`= ? WHERE `id_modelo`= ?");
            con.setString(1,unModelo.getTipo_modelo()); 
            con.setInt(2,unModelo.getId_modelo());
            cantidad = con.ejecutarActualizacion();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar(); 
                con = null;
            }
            return cantidad;
        }
    }
    
    public static ModeloBE buscarModelo(int id_modelo) {
        Conexion con = null;
        ModeloBE unModelo = null;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_modelo`, `tipo_modelo` FROM `tb_modelo` WHERE `id_modelo`= ?");
            con.setInt(1,id_modelo);
            con.ejecutarConsulta();
            if (con.siguiente()) {
                unModelo = new ModeloBE(con.getInt("id_modelo"),con.getString("tipo_modelo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return unModelo;
        }
    }



    public static ArrayList<ModeloBE> listarModelo() {
        Conexion con = null;
        ArrayList<ModeloBE> modeloLista = new ArrayList<>();
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_modelo`, `tipo_modelo` FROM `tb_modelo`");
            con.ejecutarConsulta();
            while (con.siguiente()) {
                modeloLista.add(new ModeloBE(con.getInt("id_modelo"), con.getString("tipo_modelo")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return modeloLista;
        }
    }
}
