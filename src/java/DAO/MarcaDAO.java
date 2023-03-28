package DAO;
import BE.MarcaBE;
import Conexion.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MarcaDAO {
    public static int registrarMarca(MarcaBE unaMarca){
        Conexion con = null;
        int cantidad = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("INSERT INTO `tb_marca`(`tipo_marca`) VALUES (?)");
            con.setString(1,unaMarca.getTipo_marca());
            cantidad = con.ejecutarActualizacion();
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return cantidad;
        }
    }


    public static int actualizarMarca(MarcaBE unaMarca){
        Conexion con = null;
        int cantidad = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("UPDATE `tb_marca` SET `tipo_marca`= ? WHERE `id_marca`= ?");
            con.setString(1,unaMarca.getTipo_marca()); 
            con.setInt(2,unaMarca.getId_marca());
            cantidad = con.ejecutarActualizacion();
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar(); 
                con = null;
            }
            return cantidad;
        }
    }
    
    public static MarcaBE buscarMarca(int id_marca) {
        Conexion con = null;
        MarcaBE unaMarca = null;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_marca`, `tipo_marca` FROM `tb_marca` WHERE `id_marca`= ?");
            con.setInt(1,id_marca);
            con.ejecutarConsulta();
            if (con.siguiente()) {
                unaMarca = new MarcaBE(con.getInt("id_marca"),con.getString("tipo_marca"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return unaMarca;
        }
    }



    public static ArrayList<MarcaBE> listarMarca() {
        Conexion con = null;
        ArrayList<MarcaBE> marcaLista = new ArrayList<>();
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_marca`, `tipo_marca` FROM `tb_marca`");
            con.ejecutarConsulta();
            while (con.siguiente()) {
                marcaLista.add(new MarcaBE(con.getInt("id_marca"), con.getString("tipo_marca")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return marcaLista;
        }
    }
}
