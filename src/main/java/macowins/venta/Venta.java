package macowins.venta;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public abstract class Venta {

  private List<RegistroVenta> registrosVentas = new LinkedList<>();
  private LocalDate fecha;

  public Venta(LocalDate fecha) {
    this.fecha = fecha;
  }

  public abstract double montoConRecargo(double precioBase);

  public void addRegistroVenta(RegistroVenta unRegistroVenta) {
    registrosVentas.add(unRegistroVenta);
  }

  public double montoTotal() {
    return this.montoConRecargo( // Template method
        registrosVentas.stream().mapToDouble(rv -> rv.montoRegistro()).sum());
  }

  public LocalDate getFecha() {
    return this.fecha;
  }

}
