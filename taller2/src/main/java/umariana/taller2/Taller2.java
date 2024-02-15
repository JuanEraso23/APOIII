package umariana.taller2;

import java.util.ArrayList;
import java.util.Scanner;
import mundo.Producto;

/**
 *
 * @author Juan Eraso
 */
public class Taller2 {

    public static void main(String[] args) {
        
        Scanner lector=new Scanner(System.in);
        ArrayList<Producto> misProductos=new ArrayList<>();
        
        boolean activo=true;
        
        do {
            System.out.println("==========");
            System.out.println("INVENTARIO");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Mostrar Inventario");
            System.out.println("3. Mostrar Inventario (En Forma Descendente)");
            System.out.println("4. Eliminar Producto");
            System.out.println("5. Salir");
            System.out.println("==========");
            
            int opcion=lector.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("==========");
                    System.out.println("Ingrese la información");
                    
                    System.out.println("Id:");
                    int id_Producto=lector.nextInt();
                    
                    lector.nextLine();
                    System.out.println("Nombre:");
                    String nombre=lector.nextLine();
                    
                    System.out.println("Precio:");
                    int precio=lector.nextInt();
                    
                    System.out.println("Cantidad: ");
                    int cantidad=lector.nextInt();
                    
                    //Creación del OBJ
                    //Llenar la información
                    Producto nuevoProducto=new Producto(id_Producto, nombre, precio, cantidad);
                    //Almacena del OBJ en la contenedora
                    misProductos.add(nuevoProducto);
                    System.out.println("Tarea agregada satisfactorio");
                    System.out.println("==========");
                    break;
                case 2:
                    System.out.println("==========");
                    System.out.println("TAREAS REGISTRADAS");
                    
                    for(Producto t: misProductos) {
                        System.out.println("Id: "+t.getId_Producto());
                        System.out.println("Nombre: "+t.getNombre());
                        System.out.println("Precio: "+t.getPrecio());
                        System.out.println("Cantidad: "+t.getCantidad());
                        System.out.println("==========");
                    }
                    break;
                case 3:
                    System.out.println("==========");
                    System.out.println("MOSTRAR EN FORMA DESCENDENTE");
                    
                    /**
                     * Orden de burbuja para reorganizar las tareas
                     * Según su prioridad
                     * (Mayor a Menor)
                    */
                    int n=misProductos.size();
                    for(int i=0; i<n-1; i++) {
                        for(int j=0; j<n-i-1; j++) {
                            if(misProductos.get(j).getCantidad() > misProductos.get(j+1).getCantidad()) {
                                //Reorganizar las tareas en orden descendente
                                Producto temp=misProductos.get(j);
                                misProductos.set(j, misProductos.get(j+1));
                                misProductos.set(j+1, temp);
                            }
                        }
                    }
                    for(Producto t: misProductos) {
                        System.out.println("Id: "+t.getId_Producto());
                        System.out.println("Nombre: "+t.getNombre());
                        System.out.println("Precio: "+t.getPrecio());
                        System.out.println("Cantidad: "+t.getCantidad());
                        System.out.println("==========");
                    }
                    break;
                case 4:
                    System.out.println("==========");
                    System.out.println("ELIMINAR PRODUCTO");
                    
                    break;
                case 5:
                    activo=false;
                    System.out.println("==========");
                    System.out.println("Hasta Pronto...");
                    System.out.println("==========");
                    break;
                default:
                    System.out.println("¡ERROR!");
            }
        } while (activo);
    }
}