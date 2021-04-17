package macowins.venta;

import java.time.LocalDate;

public class VentaTarjeta extends Venta {

  private int cantidadCuotas;
  private int coeficienteFijo;

  public VentaTarjeta(int cantidadCuotas, int coeficienteFijo, LocalDate fecha) {
    super(fecha);
    this.coeficienteFijo = coeficienteFijo;
    this.cantidadCuotas = cantidadCuotas;
  }

  @Override
  public double montoConRecargo(double precioBase) {
    return precioBase + cantidadCuotas * coeficienteFijo + 0.01 * precioBase;
  }

}
