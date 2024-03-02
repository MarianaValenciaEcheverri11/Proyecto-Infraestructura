package Cliente.model;

public class Materia {

//    agregale codigo, creditos, nombre, costo
    private String codigo;
    private String creditos;
    private String nombre;
    private String valor;

    public Materia(String codigo, String creditos, String nombre, String costo) {
        this.codigo = codigo;
        this.creditos = creditos;
        this.nombre = nombre;
        this.valor = costo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCreditos() {
        return creditos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String toString(){
        return "Codigo: "+codigo+" Creditos: "+creditos+" Nombre: "+nombre+" Costo: "+ valor;
    }

}
