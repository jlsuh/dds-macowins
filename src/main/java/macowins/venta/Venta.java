package macowins.venta;

import java.util.LinkedList;
import java.util.List;

public class Venta {

  private List<RegistroVenta> registrosVentas = new LinkedList<>();

  public void addRegistroVenta(RegistroVenta unRegistroVenta) {
    registrosVentas.add(unRegistroVenta);
  }

  public double montoTotal() {
    return registrosVentas.stream()
        .mapToDouble(registroVenta -> registroVenta.montoRegistro())
        .sum();
  }

  public List<RegistroVenta> getRegistrosVentas() {
    return this.registrosVentas;
  }

}
