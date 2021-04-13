package macowins.prenda;

public class Camisa extends Prenda {

  public Camisa(int precioBase, EstadoPrenda estadoPrenda) {
    super(precioBase, estadoPrenda);
  }

  @Override
  public String tipo() {
    return "camisa";
  }

}
