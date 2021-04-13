package macowins.venta;

import macowins.prenda.Prenda;

public class RegistroVenta {

  private Prenda prenda;
  private int cantidad;

  public RegistroVenta(Prenda prenda, int cantidad) {
    this.prenda = prenda;
    this.cantidad = cantidad;
  }

  public double montoRegistro() {
    return this.prenda.precioPrenda() * this.cantidad;
  }

}
