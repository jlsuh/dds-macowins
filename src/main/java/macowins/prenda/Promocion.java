package macowins.prenda;

public class Promocion implements EstadoPrenda {

  private double valorFijo;

  public Promocion(double valorFijo) {
    this.valorFijo = valorFijo;
  }

  @Override
  public double precioModificado(int precioBase) {
    return precioBase - valorFijo;
  }

}
