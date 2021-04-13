package macowins.prenda;

public abstract class Prenda {

  private int precioBase;
  private EstadoPrenda estadoPrenda;

  public Prenda(int precioBase, EstadoPrenda estadoPrenda) {
    this.precioBase = precioBase;
    this.estadoPrenda = estadoPrenda;
  }

  public double precioPrenda() {
    return estadoPrenda.precioModificado(this);
  }
  
  public abstract String tipo();

  public double getPrecioBase() {
    return this.precioBase;
  }

}
