package DAO;
import BE.ProductoBE;
import BE.ProductoVW;
import Conexion.Conexion;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoDAO {
    public static int registrarProducto(ProductoBE unProducto){
        Conexion con = null;
        int cantidad = 0;
        try{
            con = Conexion.getConexion();
            con.prepararSQL("INSERT INTO `tb_producto`(id_pro,"
                    + "nom_pro, foto, sku, valor_referencial, color, id_modelo,"
                    + "id_marca, id_procesador, id_sistema_operativo, id_memoria_ram)VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            con.setString(1, unProducto.getId_pro());
            con.setString(2, unProducto.getNom_pro());
            con.setString(3, unProducto.getFoto());
            con.setString(4,unProducto.getSku());
            con.setFloat(5,unProducto.getValor_referencial());
            con.setString(6,unProducto.getColor());
            con.setInt(7,unProducto.getId_modelo());
            con.setInt(8,unProducto.getId_marca());
            con.setInt(9,unProducto.getId_procesador());
            con.setInt(10,unProducto.getId_sistema_operativo());
            con.setInt(11,unProducto.getId_memoria_ram());
            cantidad = con.ejecutarActualizacion();
        }catch(SQLException ex){
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(con != null){
                con.desconectar();
                con = null;
            }
            return cantidad;
        }
    }

    public static int actualizarProducto(ProductoBE unProducto){
        Conexion con = null;
        int cantidad = 0;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("UPDATE `tb_producto` SET `nom_pro`= ? WHERE `id_pro`= ?");
            con.setString(1,unProducto.getNom_pro());
            con.setString(2,unProducto.getId_pro());
            cantidad = con.ejecutarActualizacion();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar(); 
                con = null;
            }
            return cantidad;
        }
    }

    public static ProductoBE buscarProducto(int id_pro) {
        Conexion con = null;
        ProductoBE unProducto = null;
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_pro`, `nom_pro`, `foto`, `sku`, `valor_referencial`, `color`, `id_modelo`, `id_marca`, `id_procesador`, `id_sistema_operativo`, `id_memoria_RAM` FROM `tb_producto` WHERE `id_pro`=?");
            con.setInt(1,id_pro);
            con.ejecutarConsulta();
            if (con.siguiente()) {
                unProducto = new ProductoBE(con.getString("id_pro"),con.getString("nom_pro"),con.getString("foto"),con.getString("sku"),con.getFloat("valor_referencial"),con.getString("color"),con.getInt("id_modelo"),con.getInt("id_marca"),con.getInt("id_procesador"),con.getInt("id_sistema_operativo"),con.getInt("id_memoria_RAM"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return unProducto;
        }
    }

    public static ArrayList<ProductoBE> listarProducto() {
        Conexion con = null;
        ArrayList<ProductoBE> productoLista = new ArrayList<>();
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_pro`, `nom_pro`, `foto`, `sku`, `valor_referencial`, `color`, `id_modelo`, `id_marca`, `id_procesador`, `id_sistema_operativo`, `id_memoria_RAM` FROM `tb_producto`");
            con.ejecutarConsulta();
            while (con.siguiente()) {
                productoLista.add( new ProductoBE(con.getString("id_pro"),con.getString("nom_pro"),con.getString("foto"),con.getString("sku"),con.getFloat("valor_referencial"),con.getString("color"),con.getInt("id_modelo"),con.getInt("id_marca"),con.getInt("id_procesador"),con.getInt("id_sistema_operativo"),con.getInt("id_memoria_RAM")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return productoLista;
        }
    }

    public static String listarProductoDisponiblesJson() {
        Conexion con = null;
        ArrayList<ProductoVW> productoLista = new ArrayList<>();
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT `id_pro` AS id, `nom_pro` AS nombre, `foto` AS imagen,  `valor_referencial` AS precio FROM `tb_producto` WHERE disponible = 1");
            con.ejecutarConsulta();
            while (con.siguiente()) {
                productoLista.add( new ProductoVW(con.getFloat("precio"),con.getString("nombre"),con.getString("imagen"),con.getString("id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return new Gson().toJson(productoLista);
        }
    }
}
