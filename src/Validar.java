/**
 *
 * @author michimisimo
 */
public class Validar {
    
    public boolean nombre(String nombre){
        return nombre.equalsIgnoreCase("");
    }
    
    public boolean dv(char dv){
        return dv>='0' && dv<='9' || dv=='K';
    }
    
    public boolean monto(int monto){
        return monto>0;
    }
}
