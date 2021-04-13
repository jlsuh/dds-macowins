package macowins;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import macowins.prenda.Camisa;
import macowins.prenda.Liquidacion;
import macowins.prenda.Nueva;
import macowins.prenda.Pantalon;
import macowins.prenda.Saco;
import macowins.venta.RegistroVenta;
import macowins.venta.Venta;
import macowins.venta.VentaConTarjeta;

public class VentaTest {

  @Test
  public void montoDeVentaAlContadoEsCorrecto() {
    RegistroVenta rv1 = new RegistroVenta(new Saco(100, new Nueva()), 100);
    RegistroVenta rv2 = new RegistroVenta(new Pantalon(100, new Liquidacion()), 100);
    Venta unaVenta = new Venta();
    Sucursal macowins = new Sucursal();
    unaVenta.addRegistroVenta(rv1);
    unaVenta.addRegistroVenta(rv2);
    macowins.addVentas(unaVenta);
    assertEquals(macowins.gananciasDelDia(), 15000);
  }

  @Test
  public void montoDeVentaConTarjetaCreditoEsCorrecto() {
    RegistroVenta rv1 = new RegistroVenta(new Camisa(100, new Nueva()), 100);
    RegistroVenta rv2 = new RegistroVenta(new Saco(100, new Liquidacion()), 100);
    VentaConTarjeta ventaTarjeta = new VentaConTarjeta(3, 2);
    Sucursal macowins = new Sucursal();
    ventaTarjeta.addRegistroVenta(rv1);
    ventaTarjeta.addRegistroVenta(rv2);
    macowins.addVentas(ventaTarjeta);
    assertEquals(macowins.gananciasDelDia(), 15000 + (100 + 50) + 3 * 2);
  }

  @Test
  public void noHayVentasEnMacowins() {
    Sucursal macowins = new Sucursal();
    assertEquals(macowins.gananciasDelDia(), 0);
  }

  // faltan más tests :p

}
