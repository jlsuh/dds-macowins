package macowins.prenda;

public class Saco extends Prenda {

  public Saco(int precioBase, EstadoPrenda estadoPrenda) {
    super(precioBase, estadoPrenda);
  }

  @Override
  public String tipo() {
    return "saco";
  }
  
}
