package macowins.prenda;

public class Promocion implements EstadoPrenda {

  private double valorFijo;

  public Promocion(double valorFijo) {
    this.valorFijo = valorFijo;
  }

  @Override
  public double precioModificado(Prenda unaPrenda) {
    return unaPrenda.getPrecioBase() - valorFijo;
  }

}
