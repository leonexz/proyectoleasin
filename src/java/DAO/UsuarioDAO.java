package DAO;
import BE.UsuarioBE;
import Conexion.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {
    public static int registrarUsuario(UsuarioBE unUsuario){
        Conexion con = null;
        int cantidad = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("INSERT INTO `tb_usuario`(`nom_usu`, `contrasenha`, `id_rol`) VALUES (?,?,?)"); 
            con.setString(1,unUsuario.getNom_usu());
            con.setString(2,unUsuario.getContrasenha());
            con.setInt(3,unUsuario.getId_rol());
            cantidad = con.ejecutarActualizacion();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return cantidad;
        }
    }
    public static int actualizarUsuario(UsuarioBE unUsuario){
        Conexion con = null;
        int cantidad = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("UPDATE `tb_usuario` SET `nom_usu`=?,`contrasenha`=?,`id_rol`=? WHERE `id_usuario`=?");
            con.setString(1,unUsuario.getNom_usu()); 
            con.setString(2,unUsuario.getContrasenha());
            con.setInt(3,unUsuario.getId_rol());
            con.setInt(4,unUsuario.getId_usuario());
            cantidad = con.ejecutarActualizacion();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar(); 
                con = null;
            }
            return cantidad;
        }
    }
    
    public static UsuarioBE buscarUsuario(int id_usuario) {
        Conexion con = null;
        UsuarioBE unUsuario = null;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_usuario`, `nom_usu`, `contrasenha`, `id_rol` FROM `tb_usuario` WHERE `id_usuario`=?");
            con.setInt(1,id_usuario);
            con.ejecutarConsulta();
            if (con.siguiente()) {
                unUsuario = new UsuarioBE(con.getInt("id_usuario"),con.getString("nom_usu"),con.getString("contrasenha"),con.getInt("id_rol"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SistemaOperativoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return unUsuario;
        }
    }
    
    public static UsuarioBE iniciarSesion(UsuarioBE unUsuario) {
        Conexion con = null; 
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_usuario`, `nom_usu`, `contrasenha`, `id_rol` FROM `tb_usuario` WHERE `nom_usu`= ? AND `contrasenha`= ?");
            con.setString(1,unUsuario.getNom_usu()); 
            con.setString(2,unUsuario.getContrasenha());
            con.ejecutarConsulta();
            if (con.siguiente()) {
                unUsuario = new UsuarioBE(con.getInt("id_usuario"),con.getString("nom_usu"),con.getString("contrasenha"),con.getInt("id_rol"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SistemaOperativoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return unUsuario;
        }
    }

    public static ArrayList<UsuarioBE> listarUsuario() {
        Conexion con = null;
        ArrayList<UsuarioBE> usuarioLista = new ArrayList<>();
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_usuario`, `nom_usu`, `contrasenha`, `id_rol` FROM tb_usuario");
            con.ejecutarConsulta();
            while (con.siguiente()) {
                usuarioLista.add( new UsuarioBE(con.getInt("id_usuario"),con.getString("nom_usu"),con.getString("contrasenha"),con.getInt("id_rol")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SistemaOperativoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return usuarioLista;
        }
    }

    public static ArrayList<UsuarioBE> listarAdministradores() {
        Conexion con = null;
        ArrayList<UsuarioBE> usuarioLista = new ArrayList<>();
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_usuario`, `nom_usu`, `contrasenha`, `id_rol` FROM tb_usuario WHERE id_rol = 1");
            con.ejecutarConsulta();
            while (con.siguiente()) {
                usuarioLista.add( new UsuarioBE(con.getInt("id_usuario"),con.getString("nom_usu"),con.getString("contrasenha"),con.getInt("id_rol")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SistemaOperativoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return usuarioLista;
        }
    }

    public static ArrayList<UsuarioBE> listarClientes() {
        Conexion con = null;
        ArrayList<UsuarioBE> usuarioLista = new ArrayList<>();
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_usuario`, `nom_usu`, `contrasenha`, `id_rol` FROM tb_usuario WHERE id_rol = 2");
            con.ejecutarConsulta();
            while (con.siguiente()) {
                usuarioLista.add( new UsuarioBE(con.getInt("id_usuario"),con.getString("nom_usu"),con.getString("contrasenha"),con.getInt("id_rol")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SistemaOperativoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return usuarioLista;
        }
    }
}
