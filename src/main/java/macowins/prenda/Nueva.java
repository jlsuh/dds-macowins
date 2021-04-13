package macowins.prenda;

public class Nueva implements EstadoPrenda {

  @Override
  public double precioModificado(Prenda unaPrenda) {
    return unaPrenda.getPrecioBase();
  }

}
