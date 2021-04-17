package macowins.prenda;

public class Liquidacion implements EstadoPrenda {

  @Override
  public double precioModificado(int precioBase) {
    return precioBase - precioBase * 0.5;
  }

}
