/**
 *
 * @author michimisimo
 */
public class Trabajador {
    
    private String nombre;
    private int rut;
    private char dv;

    public Trabajador() {
    }

    public Trabajador(String nombre, int rut, char dv) {
        this.nombre = nombre;
        this.rut = rut;
        this.dv = dv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public char getDv() {
        return dv;
    }

    public void setDv(char dv) {
        this.dv = dv;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "nombre=" + nombre + ", rut=" + rut + ", dv=" + dv + '}';
    }

}
