package macowins.venta;

public class VentaConTarjeta extends Venta {

  private int cantidadCuotas;
  private int coeficienteFijo;

  public VentaConTarjeta(int cantidadCuotas, int coeficienteFijo) {
    this.coeficienteFijo = coeficienteFijo;
    this.cantidadCuotas = cantidadCuotas;
  }

  @Override
  public double montoTotal() {
    return super.montoTotal() + this.recargo();
  }

  private double recargo() {
    return super.getRegistrosVentas().stream()
        .mapToDouble(registroVenta -> registroVenta.montoRegistro() * 0.01)
        .sum() + cantidadCuotas * coeficienteFijo;
  }

}
