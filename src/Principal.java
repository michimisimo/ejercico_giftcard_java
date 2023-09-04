
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author michimisimo
 */
public class Principal {
    
    public static void main(String[] args) {
        //trabajador
        String nombre;
        int rut;
        char dv;
        //tarjeta
        int monto,clave;
        String vigencia;

        boolean flag;
        int opcion;
        Scanner input = new Scanner(System.in);
        Trabajador trabajador = new Trabajador();
        Tarjeta tarjeta = new Tarjeta();
        Validar validar = new Validar();
        
        do {
            System.out.println("------MENU------");
            System.out.println("1) ingresar trabajador");
            System.out.println("2) generar giftcard");
            System.out.println("3) agregar saldo");
            System.out.println("4) realizar compra");
            System.out.println("5) salir");
            opcion = input.nextInt();
            
            switch (opcion) {
                case 1:
                    do {
                        System.out.println("ingrese nombre del trabajador:");
                        nombre=input.next();
                        flag=validar.nombre(nombre);
                        
                        if (flag==false) {
                            trabajador.setNombre(nombre);
                        }
                        
                    } while (flag==true);
                    
                    System.out.println("ingrese rut sin dv:");
                    rut=input.nextInt();
                    trabajador.setRut(rut);
                    
                    do {
                        System.out.println("ingrese dv:");
                        dv=input.next().charAt(0);
                        flag=validar.dv(dv);
                        
                        if (flag==true) {
                            trabajador.setDv(dv);
                        }
                        
                    } while (flag==false);
                    
                    System.out.println("\nTRABAJADOR INGRESADO CON EXITO");
                    System.out.println(trabajador+"\n");
                    break;
                    
                case 2:
                    tarjeta.setTrabajador(trabajador);
                    tarjeta.setCodigo(tarjeta.obtCod());
                    
                    do {
                        System.out.println("ingrese fecha vencimiento tarjeta(dd-mm-yyyy):");
                        vigencia=input.next();
                        
                        Date fechaVig = new Date();
                        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                        
                        try {
                            fechaVig = formato.parse(vigencia);
   
                        } 
                        catch (ParseException e) {
                            System.out.println("error convertir fecha");
                        }
                        
                        flag=tarjeta.tarVig(fechaVig);
                        
                        if (flag==true) {
                            
                            tarjeta.setVigencia(fechaVig);
                        }
                        
                        
                    } while (flag==false);
                    
                    do {
                        System.out.println("ingrese clave (4 primeros digotos del rut)");
                        clave=input.nextInt();
                        flag=tarjeta.verifClave(clave);
                        
                        if (flag==true) {
                            tarjeta.setClave(clave);
                        }
                        
                    } while (flag==false);
                    
                    monto=0;
                    tarjeta.setMonto(monto);
                    
                    /*int nuevaClave=trabajador.getRut();
                    while (nuevaClave>9999){
                        
                        if (nuevaClave<10000) {
                            tarjeta.setClave(nuevaClave);
                        } 
                        else {
                            nuevaClave/=10;
                        }
                    }
                    */

                    System.out.println("\n GIFTCARD CREADA CON EXITO");
                    System.out.println(tarjeta);
                    break;
                    
                case 3:
                    do {
                        System.out.println("ingrese monto a agregar a la giftcard:");
                        monto=input.nextInt();
                        flag=validar.monto(monto);
                        
                        if (flag==true) {
                            monto+=tarjeta.getMonto();
                            tarjeta.setMonto(monto);
                        }
                        
                    } while (flag==false);
                    
                    System.out.println("\nNMONTO INGRESADO CON EXITO");
                    System.out.println("nuevo monto: $"+tarjeta.getMonto()+"\n");
                    break;
                    
                case 4:
                    do {
                        System.out.println("ingrese valor de la compra:");
                        int compra=input.nextInt();
                        flag=tarjeta.compra(compra);

                        if (flag==true) {
                            tarjeta.descCompra(compra);
                            System.out.println("\n COMPRA RESALIZADA CON EXITO");
                            System.out.println("nuevo monto: $"+tarjeta.getMonto()+"\n");  
                        }

                    } while (flag==false);
                    break;
                
                case 5:
                    System.out.println("\n-----GRACIAS POR USAR EL PROGRAMA-----");
                    
                default:
                    throw new AssertionError();
            }
            
        } while (opcion!=5);
        
    }
    
}
