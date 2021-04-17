package macowins;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;
import macowins.venta.Venta;

public class Sucursal {

  private List<Venta> ventas = new LinkedList<>();

  public double gananciasDelDia(LocalDate fechaTarget) {
    return ventasDelDia(fechaTarget).mapToDouble(v -> v.montoTotal()).sum();
  }

  private Stream<Venta> ventasDelDia(LocalDate fechaTarget) {
    return ventas.stream().filter(v -> v.getFecha().compareTo(fechaTarget) == 0);
  }

  public void addVentas(Venta venta) {
    ventas.add(venta);
  }

}
