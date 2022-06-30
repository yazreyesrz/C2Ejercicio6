package c2ejercicio5;

public class CocaCola extends Bebida {
 private double azucarPorcentaje;
    private boolean descuento;

    public CocaCola(double azucarPorcentaje, boolean descuento, double cantidad, double precio, String marca) {
        super(cantidad, precio, marca);
        this.azucarPorcentaje = azucarPorcentaje;
        this.descuento = descuento;
    }

    public double getAzucarPorcentaje() {
        return azucarPorcentaje;
    }

    public void setAzucarPercentaje(double azucarPorcentaje) {
        this.azucarPorcentaje = azucarPorcentaje;
    }

    public boolean enDescuento() {
        return descuento;
    }

    public void setDescuento(boolean descuento) {
        this.descuento = descuento;
    }
    
 @Override
    public double getPrecio(){
        if(enDescuento()){
            return super.getPrecio()*0.9;
        }else{
            return super.getPrecio();
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Porcentaje de Azúcar= " + azucarPorcentaje + ", Promoción= " + descuento ;
    }
}