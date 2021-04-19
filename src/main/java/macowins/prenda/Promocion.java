package macowins.prenda;

public class Promocion implements EstadoPrenda {

  private double valorFijo;

  public Promocion(double valorFijo) {
    if (valorFijo <= 0) {
      throw new IllegalArgumentException("El valor fijo de la promocion debe ser positivo");
    }
    this.valorFijo = valorFijo;
  }

  @Override
  public double precioModificado(int precioBase) {
    return Math.max(0, precioBase - valorFijo);
  }

}
