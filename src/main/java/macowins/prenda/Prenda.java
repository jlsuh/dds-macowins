package macowins.prenda;

public class Prenda {

  private int precioBase;
  private EstadoPrenda estadoPrenda;
  private Tipo tipo;

  public Prenda(int precioBase, EstadoPrenda estadoPrenda, Tipo tipo) {
    this.precioBase = precioBase;
    this.estadoPrenda = estadoPrenda;
    this.tipo = tipo;
  }

  public double precioPrenda() {
    return estadoPrenda.precioModificado(precioBase); // Strategy
  }

  public double getPrecioBase() {
    return this.precioBase;
  }

  public Tipo getTipo() {
    return this.tipo;
  }

}
