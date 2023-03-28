package Conexion;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private final String login = "root";
    private final String clave = "";
    private final String url = "jdbc:mysql://localhost:3306/bdproyectosowad?useTimezone=true&serverTimezone=UTC";
    

    protected Conexion() {
        con = null;
        ps = null;
        rs = null;
    }

    public static Conexion getConexion() throws SQLException {
        Conexion conexion = new Conexion();
        if (conexion.conectar()) {
            return conexion;
        }
        throw new SQLException("No Existe Conexion");
    }

    private boolean conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, login, clave);
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void desconectar() {
        try {
            if (con != null) {
                con.close();
                con = null;
                ps = null;
                rs = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int cantidadFilas() throws SQLException {
        int fila = 0;
        if (rs != null) {
            int filaActual = rs.getRow();
            if (rs.last()) {
                fila = rs.getRow();
                rs.absolute(filaActual);
            }
        }
        return fila;
    }

    public void prepararSQL(String sql) throws SQLException {
        ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }

    public int ejecutarActualizacion() throws SQLException {
        //retorna cantidad de filas afectadas
        return ps.executeUpdate();
    }

    public void ejecutarConsulta() throws SQLException {
        rs = ps.executeQuery();
    }

    public int[] ejecutarLote() throws SQLException {
        //retorna una array con la cantidad de filas que afecto cada batch
        return ps.executeBatch();
    }

    public boolean siguiente() throws SQLException {
        return rs.next();
    }

    public boolean anterior() throws SQLException {
        return rs.previous();
    }

    public void agregarLote() throws SQLException {
        ps.addBatch();
    }
     

    public int getInt(String nom_columna) throws SQLException {
        return rs.getInt(nom_columna);
    }

    public void setInt(int indice, int valor) throws SQLException {
        ps.setInt(indice, valor);
    }

    public long getLong(String nom_columna) throws SQLException {
        return rs.getLong(nom_columna);
    }

    public void setLong(int indice, long valor) throws SQLException {
        ps.setLong(indice, valor);
    }

    public float getFloat(String nom_columna) throws SQLException {
        return rs.getFloat(nom_columna);
    }

    public void setFloat(int indice, float valor) throws SQLException {
        ps.setFloat(indice, valor);
    }

    public double getDouble(String nom_columna) throws SQLException {
        return rs.getDouble(nom_columna);
    }

    public void setDouble(int indice, double valor) throws SQLException {
        ps.setDouble(indice, valor);
    }

    public boolean getBoolean(String nom_columna) throws SQLException {
        return rs.getBoolean(nom_columna);
    }

    public void setBoolean(int indice, boolean valor) throws SQLException {
        ps.setBoolean(indice, valor);
    }

    public String getString(String nom_columna) throws SQLException {
        return rs.getString(nom_columna);
    }

    public void setString(int indice, String valor) throws SQLException {
        ps.setString(indice, valor);
    }

    public Date getDate(String nom_columna) throws SQLException {
        return rs.getDate(nom_columna);
    }

    public void setDate(int indice, Date valor) throws SQLException {
        ps.setDate(indice, valor);
    }

    public Time getTime(String nom_columna) throws SQLException {
        return rs.getTime(nom_columna);
    }

    public void setTime(int indice, Time valor) throws SQLException {
        ps.setTime(indice, valor);
    }

    public Timestamp getTimestamp(String nom_columna) throws SQLException {
        return rs.getTimestamp(nom_columna);
    }

    public void setTimestamp(int indice, Timestamp valor) throws SQLException {
        ps.setTimestamp(indice, valor);
    }

    public InputStream getBinaryStream(String nom_columna) throws SQLException {
        return rs.getBinaryStream(nom_columna);
    }

    public void setBinaryStream(int indice, InputStream valor) throws SQLException {
        ps.setBinaryStream(indice, valor);
    }

    public byte getByte(String nom_columna) throws SQLException {
        return rs.getByte(nom_columna);
    }

    public void setByte(int indice, byte valor) throws SQLException {
        ps.setByte(indice, valor);
    }

    public short getShort(String nom_columna) throws SQLException {
        return rs.getShort(nom_columna);
    }

    public void setShort(int indice, short valor) throws SQLException {
        ps.setShort(indice, valor);
    }

    public byte[] getBytes(String nom_columna) throws SQLException {
        return rs.getBytes(nom_columna);
    }

    public void setBytes(int indice, byte[] valor) throws SQLException {
        ps.setBytes(indice, valor);
    }
 
    public Connection getCon() {
        return con;
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public ResultSet getRs() {
        return rs;
    }
}
