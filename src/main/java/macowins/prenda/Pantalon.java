package macowins.prenda;

public class Pantalon extends Prenda {

  public Pantalon(int precioBase, EstadoPrenda estadoPrenda) {
    super(precioBase, estadoPrenda);
  }

  @Override
  public String tipo() {
    return "pantalon";
  }

}
