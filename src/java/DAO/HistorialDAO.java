/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BE.HistorialBE;
import Conexion.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class HistorialDAO {
    public static ArrayList<HistorialBE> listarHistorial() {
        Conexion con = null;
        ArrayList<HistorialBE> historial = new ArrayList<>();
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT A.id_alquiler,  A.tiempo_prestamo, "
                    + "A.cantidad_equipos, E.razonSocial, E.ruc, A.estado, "
                    + "CONCAT(R.nombre ,' ',R.apellido) AS nombre, A.precio_alquiler, "
                    + "A.descuento, D.fechaEntrega, D.fechaDevolucion "
                    + "FROM tb_alquiler AS A "
                    + "INNER JOIN tb_responsable AS R ON R.id_responsable = A.id_responsable "
                    + "INNER JOIN tb_empresa AS E ON E.id_empresa = R.id_empresa "
                    + "INNER JOIN tb_detalle AS D ON D.id_alquiler = A.id_alquiler "
                    + "INNER JOIN tb_producto AS P ON D.id_producto = P.id_pro "
                    + "GROUP BY id_alquiler");
            con.ejecutarConsulta();
            while (con.siguiente()) {
                historial.add(new HistorialBE(con.getInt("id_alquiler"),
                        con.getInt("tiempo_prestamo"),
                        con.getInt("cantidad_equipos"),
                        con.getString("razonSocial"),
                        con.getString("ruc"), 
                        con.getString("estado"),
                        con.getString("nombre"),
                        con.getDouble("precio_alquiler"),
                        con.getDouble("descuento"), 
                        con.getDate("fechaEntrega"), 
                        con.getDate("fechaDevolucion"))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(HistorialDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return historial;
           
        }
    }
     public static ArrayList<HistorialBE> listarHistorialDeUnUsuario(int id_usuario) {
        Conexion con = null;
        ArrayList<HistorialBE> historial = new ArrayList<>();
        try {
            con = Conexion.getConexion();
            con.prepararSQL("SELECT A.id_alquiler,  A.tiempo_prestamo, "
                    + "A.cantidad_equipos, E.razonSocial, E.ruc, A.estado, "
                    + "CONCAT(R.nombre ,' ',R.apellido) AS nombre, A.precio_alquiler, "
                    + "A.descuento, D.fechaEntrega, D.fechaDevolucion "
                    + "FROM tb_alquiler AS A "
                    + "INNER JOIN tb_responsable AS R ON R.id_responsable = A.id_responsable "
                    + "INNER JOIN tb_empresa AS E ON E.id_empresa = R.id_empresa "
                    + "INNER JOIN tb_detalle AS D ON D.id_alquiler = A.id_alquiler "
                    + "INNER JOIN tb_producto AS P ON D.id_producto = P.id_pro "
                    + "WHERE R.id_responsable = ? "
                    + "GROUP BY id_alquiler");
            con.setInt(1, id_usuario);
            con.ejecutarConsulta();
            while (con.siguiente()) {
                historial.add(new HistorialBE(con.getInt("id_alquiler"),
                        con.getInt("tiempo_prestamo"),
                        con.getInt("cantidad_equipos"),
                        con.getString("razonSocial"),
                        con.getString("ruc"), 
                        con.getString("estado"),
                        con.getString("nombre"),
                        con.getDouble("precio_alquiler"),
                        con.getDouble("descuento"), 
                        con.getDate("fechaEntrega"), 
                        con.getDate("fechaDevolucion"))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(HistorialDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.desconectar();
                con = null;
            }
            return historial;
           
        }
    }
}
