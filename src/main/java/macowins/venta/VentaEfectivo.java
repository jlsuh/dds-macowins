package macowins.venta;

import java.time.LocalDate;

public class VentaEfectivo extends Venta {

  public VentaEfectivo(LocalDate fecha) {
    super(fecha);
  }

  @Override
  public double montoConRecargo(double precioBase) {
    return precioBase;
  }

}
