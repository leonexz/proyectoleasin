package BE;
public class UsuarioBE {
    private Integer id_usuario;
    private String nom_usu,contrasenha;
    private Integer id_rol;

    public UsuarioBE() {
    }

    public UsuarioBE(Integer id_usuario, String nom_usu, String contrasenha, Integer id_rol) {
        this.id_usuario = id_usuario;
        this.nom_usu = nom_usu;
        this.contrasenha = contrasenha;
        this.id_rol = id_rol;
    }

    public boolean tieneID() {
        return id_usuario != null;
    }

    public boolean isAdmin() {
        return id_rol == 1;
    }

    public boolean isCliente() {
        return id_rol == 2;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNom_usu() {
        return nom_usu;
    }

    public void setNom_usu(String nom_usu) {
        this.nom_usu = nom_usu;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public Integer getId_rol() {
        return id_rol;
    }

    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }
    
}
