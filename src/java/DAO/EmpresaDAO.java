package DAO;
import BE.EmpresaBE;
import Conexion.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmpresaDAO {
    public static int registrarEmpresa(EmpresaBE unaEmpresa){
        Conexion con = null;
        int cantidad = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("INSERT INTO `tb_empresa`(`id_empresa`, `razonSocial`, `ruc`) VALUES (?,?,?)");
            con.setString(1,unaEmpresa.getId_empresa());
            con.setString(2,unaEmpresa.getRazonSocial());
            con.setString(2,unaEmpresa.getRuc());
            cantidad = con.ejecutarActualizacion();
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return cantidad;
        }
    }

    public static int actualizarEmpresa(EmpresaBE unaEmpresa){
        Conexion con = null;
        int cantidad = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("UPDATE `tb_empresa` SET `razonSocial`=?,`ruc`=? WHERE `id_empresa`=?");
            con.setString(1,unaEmpresa.getRazonSocial()); 
            con.setString(2,unaEmpresa.getRuc());
            con.setString(2,unaEmpresa.getId_empresa());
            cantidad = con.ejecutarActualizacion();
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar(); 
                con = null;
            }
            return cantidad;
        }
    }
    
    public static EmpresaBE buscarEmpresa(int id_empresa) {
        Conexion con = null;
        EmpresaBE unaEmpresa = null;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_empresa`, `razonSocial`, `ruc` FROM `tb_empresa` WHERE `id_empresa`=?");
            con.setInt(1,id_empresa);
            con.ejecutarConsulta();
            if (con.siguiente()) {
                unaEmpresa = new EmpresaBE(con.getString("id_empresa"),con.getString("razonSocial"),con.getString("ruc"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return unaEmpresa;
        }
    }

    public static ArrayList<EmpresaBE> listarEmpresa() {
        Conexion con = null;
        ArrayList<EmpresaBE> empresaLista = new ArrayList<>();
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_empresa`, `razonSocial`, `ruc` FROM `tb_empresa`");
            con.ejecutarConsulta();
            while (con.siguiente()) {
                empresaLista.add( new EmpresaBE(con.getString("id_empresa"),con.getString("razonSocial"),con.getString("ruc")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return empresaLista;
        }
    }
}
