package macowins.prenda;

public class Liquidacion implements EstadoPrenda {

  @Override
  public double precioModificado(Prenda unaPrenda) {
    return unaPrenda.getPrecioBase() - unaPrenda.getPrecioBase() * 0.5;
  }

}
