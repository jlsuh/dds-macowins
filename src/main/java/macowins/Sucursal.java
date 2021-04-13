package macowins;

import java.util.LinkedList;
import java.util.List;
import macowins.venta.Venta;

public class Sucursal {

  private List<Venta> ventas = new LinkedList<>();

  public double gananciasDelDia() {
    return ventas.stream().mapToDouble(venta -> venta.montoTotal()).sum();
  }

  public void addVentas(Venta venta) {
    ventas.add(venta);
  }

}
