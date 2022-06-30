package c2ejercicio5;

import javax.swing.JOptionPane;


public class Operaciones {

    private Bebida[][] shelf;
   
    //Constructores
    public Operaciones(int rows, int columns) {
        shelf = new Bebida[rows][columns];
    }

    public Operaciones() {
        shelf = new Bebida[5][5];
    }

    //Metodos
    
    /**
     * Agega una bebida, primera posicion que encuentre
     * @param b 
     */
    public void addBebida(Bebida b) {

        try {
           boolean found = false;
        //System.out.println("\n Longitud del arreglo: "+estanteria.length);
        for (int i=0; i <= shelf.length && !found; i++) {
            for (int j = 0; j <= shelf[0].length && !found; j++) {
                if (shelf[i][j] == null) {
                    shelf[i][j] = b; //inserto la bebida
                    //System.out.println(estanteria[i][j]);
                    found = true; //Salgo
                }
            }  
        }
         
        //Indico si se ha añadiddo la bebida o no
        if (found) {
            JOptionPane.showMessageDialog(null, "Bebida Añadida");
            //System.out.println("Bebida añadida");
        } else {
            JOptionPane.showMessageDialog(null, "No se ha podido añadir la bebida");
            //System.out.println("No se ha podido añadir la bebida");
        }
      } catch (Exception e){
          JOptionPane.showMessageDialog(null, "Almacen lleno...");
      }
    }
    
    /**
     * Elimina la bebida con el id que le pasen, sino esta se indica
     * @param id 
     */
    public void deleteBebida(int id) {

        boolean found = false;
        for (int i = 0; i < shelf.length && !found; i++) {
            for (int j = 0; j < shelf[0].length && !found; j++) {
                if (shelf[i][j] != null) {
                    if (shelf[i][j].getId() == id) {
                        shelf[i][j] = null; //Elimino la bebida
                        found = true; //Salgo
                    }
                }
            }
        }

        //Indico si se ha eliminado
        if (found) {
            JOptionPane.showMessageDialog(null, "Bebida eliminada");

            //System.out.println("Bebida eliminada");
        } else {
            JOptionPane.showMessageDialog(null, "No existe la bebida");
            
            //System.out.println("No existe la bebida"); 
        }

    }

    /**
     * Recorro las estantenrias y muestro las bebidas
     */
    public String showBebida() {
    String printBebida = "";    
        for (int i = 0; i < shelf.length; i++) {
            for (int j = 0; j < shelf[0].length; j++) {
                if (shelf[i][j] != null) {//controlo nulos
                printBebida += "fila " + i + ", columna: " + j + " Bebida: " + shelf[i][j].toString() + "\n";
                }
            }
        }
       return printBebida;
    }
    /**
     * Calculo el precio de todas las bebidas
     * @return 
     */
    public String calculateBebidaPrecio1() {

        String cd1 = "";
        double totalPrecio = 0;
        for (int i = 0; i < shelf.length; i++) {
            for (int j = 0; j < shelf[0].length; j++) {
                if (shelf[i][j] != null) {//controlo nulos
                    totalPrecio += shelf[i][j].getPrecio();//acumulo el precio
                    cd1 = totalPrecio + "";
                }
            }
        }
        return cd1;
    }

    /**
     * Calculo el precio de todas las bebidas de una marca
     * @param marca
     * @return 
     */
    public String calcularBebidaPrecioCocaCola(String marca) {
        
        String cd2 = "";
        double totalPrecio = 0;
        for (int i = 0; i < shelf.length; i++) {
            for (int j = 0; j < shelf[0].length; j++) {
                if (shelf[i][j] != null) {//controlo nulos
                    totalPrecio = shelf[i][j].getPrecio(); //acumulo el precio
                     cd2 = totalPrecio + "";
                }
            }
        }
        return cd2;

    }
    public String calcularBebidaPrecioAguaMineral(String marca) {
        String cd21 = "";
        double totalPrecio2 = 0;
        for (int i = 0; i < shelf.length; i++) {
            for (int j = 0; j < shelf[0].length; j++) {
                if (shelf[i][j] != null) {//controlo nulos
                    if (shelf[i][j].getMarca().equalsIgnoreCase(marca))
                        totalPrecio2 += shelf[i][j].getPrecio(); //acumulo el precio
                    cd21 = totalPrecio2 + "";
                }
            }
        }
        return cd21;
    }
    
    /**
     * Calculo el precio de todas las bebidas de una determinada columna
     * @param columna
     * @return 
     */
    public String calcularBebidaPrecio3(int columna) {
        String cd3 = "";
        double totalPrecio = 0;
        if (columna >= 0 && columna < shelf[0].length) {
            for (int i = 0; i < shelf.length; i++) {
                if (shelf[i][columna] != null) { //controlo nulos
                    totalPrecio += shelf[i][columna].getPrecio(); //acumulo el precio
                    cd3 = totalPrecio + "";
                }
            }
        } else {
            JOptionPane.showMessageDialog(null,"La columna debe estar entre 0 y " + shelf[0].length);
        }
        return cd3;
    }
}
