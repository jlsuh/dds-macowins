package macowins;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.Test;
import macowins.prenda.Liquidacion;
import macowins.prenda.Nueva;
import macowins.prenda.Prenda;
import macowins.prenda.Promocion;
import macowins.prenda.Tipo;
import macowins.venta.RegistroVenta;
import macowins.venta.VentaEfectivo;
import macowins.venta.VentaTarjeta;

public class VentaTest {

  LocalDate diaActual = LocalDate.now();
  LocalDate diaPandemia = LocalDate.of(2020, Month.MARCH, 11);

  @Test
  public void gananciaConSoloUnaVentaEnEfectivoAlDiaActualEsCorrecto() {
    RegistroVenta rv1 = new RegistroVenta(new Prenda(100, new Promocion(10), Tipo.SACO), 100);
    RegistroVenta rv2 = new RegistroVenta(new Prenda(100, new Liquidacion(), Tipo.PANTALON), 100);
    VentaEfectivo unaVenta = new VentaEfectivo(diaActual);
    Sucursal macowins = new Sucursal();
    unaVenta.addRegistroVenta(rv1);
    unaVenta.addRegistroVenta(rv2);
    macowins.addVentas(unaVenta);
    assertEquals(macowins.gananciasDelDia(diaActual), 9000 + 5000);
  }

  @Test
  public void montoDeVentaConSoloUnaVentaDeTarjetaCreditoAlDiaActualEsCorrecto() {
    RegistroVenta rv1 = new RegistroVenta(new Prenda(100, new Nueva(), Tipo.CAMISA), 100);
    RegistroVenta rv2 = new RegistroVenta(new Prenda(100, new Nueva(), Tipo.SACO), 100);
    VentaTarjeta ventaTarjeta = new VentaTarjeta(3, 2, diaActual);
    Sucursal macowins = new Sucursal();
    ventaTarjeta.addRegistroVenta(rv1);
    ventaTarjeta.addRegistroVenta(rv2);
    macowins.addVentas(ventaTarjeta);
    assertEquals(macowins.gananciasDelDia(diaActual), 20000 + 3 * 2 + 0.01 * 20000);
  }

  @Test
  public void montoDeVentaConEfectivoYTarjetaCreditoEnDiaPandemiaEsCorrecto() {
    LocalDate diaPandemia = LocalDate.of(2020, Month.MARCH, 11);

    RegistroVenta rv1 = new RegistroVenta(new Prenda(100, new Promocion(10), Tipo.SACO), 100);
    RegistroVenta rv2 = new RegistroVenta(new Prenda(100, new Liquidacion(), Tipo.PANTALON), 100);
    VentaEfectivo v1 = new VentaEfectivo(diaPandemia);
    v1.addRegistroVenta(rv1);
    v1.addRegistroVenta(rv2);

    RegistroVenta rv3 = new RegistroVenta(new Prenda(100, new Liquidacion(), Tipo.CAMISA), 100);
    RegistroVenta rv4 = new RegistroVenta(new Prenda(100, new Nueva(), Tipo.SACO), 100);
    VentaTarjeta v2 = new VentaTarjeta(3, 2, diaPandemia);
    v2.addRegistroVenta(rv3);
    v2.addRegistroVenta(rv4);

    Sucursal macowins = new Sucursal();
    macowins.addVentas(v1);
    macowins.addVentas(v2);
    assertEquals(macowins.gananciasDelDia(diaPandemia), 9000 + 5000 + 15000 + 3 * 2 + 0.01 * 15000);
  }

  @Test
  public void macowinsSoloTieneEnCuentaLasVentasEnElDiaQueComenzoLaPandemia() {
    RegistroVenta rv1 = new RegistroVenta(new Prenda(100, new Nueva(), Tipo.SACO), 100);
    RegistroVenta rv2 = new RegistroVenta(new Prenda(50, new Liquidacion(), Tipo.PANTALON), 100);
    VentaEfectivo v1 = new VentaEfectivo(diaPandemia);
    v1.addRegistroVenta(rv1);
    v1.addRegistroVenta(rv2);

    RegistroVenta rv3 = new RegistroVenta(new Prenda(55, new Promocion(10), Tipo.SACO), 100);
    RegistroVenta rv4 = new RegistroVenta(new Prenda(75, new Liquidacion(), Tipo.PANTALON), 100);
    VentaTarjeta v2 = new VentaTarjeta(5, 5, diaPandemia);
    v2.addRegistroVenta(rv3);
    v2.addRegistroVenta(rv4);

    RegistroVenta rv5 = new RegistroVenta(new Prenda(100, new Nueva(), Tipo.SACO), 100);
    RegistroVenta rv6 = new RegistroVenta(new Prenda(100, new Nueva(), Tipo.PANTALON), 100);
    VentaTarjeta v3 = new VentaTarjeta(3, 2, diaActual);
    v3.addRegistroVenta(rv5);
    v3.addRegistroVenta(rv6);

    Sucursal macowins = new Sucursal();
    macowins.addVentas(v1);
    macowins.addVentas(v2);
    macowins.addVentas(v3);

    assertEquals(macowins.gananciasDelDia(diaPandemia),
        12500 + (4500 + 3750) + 5 * 5 + 0.01 * (4500 + 3750));
  }

  @Test
  public void noHuboVentasEnMacowinsEnElDiaActual() {
    Sucursal macowins = new Sucursal();
    assertEquals(macowins.gananciasDelDia(diaActual), 0);
  }

  @Test
  public void noHuboVentasEnMacowinsEnElDiaQueComenzoLaPandemia() {
    Sucursal macowins = new Sucursal();
    assertEquals(macowins.gananciasDelDia(diaPandemia), 0);
  }

}
