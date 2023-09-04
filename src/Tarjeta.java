
import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author michimisimo
 */
public class Tarjeta {
    
    private int clave,monto;
    BigInteger codigo = new BigInteger("1000000000000000");
    private Trabajador trabajador;
    private Date vigencia;

    public Tarjeta() {
    }

    public Tarjeta(int clave, int monto, Trabajador trabajador, Date vigencia) {
        this.clave = clave;
        this.monto = monto;
        this.trabajador = trabajador;
        this.vigencia = vigencia;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public BigInteger getCodigo() {
        return codigo;
    }

    public void setCodigo(BigInteger codigo) {
        this.codigo = codigo;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    @Override
    public String toString() {
        return "Tarjeta{" + "clave=" + clave + ", monto=" + monto + ", codigo=" + codigo + ", trabajador=" + trabajador + ", vigencia=" + vigencia + '}';
    }

    public BigInteger obtCod(){
        return this.codigo.add(BigInteger.ONE);
    }
    
    public boolean verifClave(int vClave){
        
        int vrut= trabajador.getRut();
        
        if (vClave>999 && vClave<=9999){
            
            while (vrut>9999){
                vrut/=10;
            }
        }
        return vClave==vrut;
    }
    
    public boolean compra(int compra){
        return this.monto >= compra;
    }
    
    public int descCompra(int compra){
        return this.monto-=compra;
    }
    
    public boolean tarVig(Date fechaVig){
        Date fechaAct = new Date();
       return fechaVig.compareTo(fechaAct)>=0;
    }
}
