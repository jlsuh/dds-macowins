package macowins;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import macowins.prenda.Liquidacion;
import macowins.prenda.Nueva;
import macowins.prenda.Prenda;
import macowins.prenda.Promocion;
import macowins.prenda.Tipo;

public class PrendaTest {

  Nueva nueva = new Nueva();
  Liquidacion liquidacion = new Liquidacion();

  @Test
  public void unaPrendaNuevaNoModificaSuPrecioBase() {
    Prenda camisa = new Prenda(100, nueva, Tipo.CAMISA);
    assertEquals(camisa.getPrecioBase(), camisa.precioPrenda());
  }

  @Test
  public void unaPrendaEnLiquidacionDescuentaEnUnCincuentaPorcientoAlPrecioBase() {
    Prenda camisa = new Prenda(100, liquidacion, Tipo.CAMISA);
    assertEquals(camisa.getPrecioBase() - camisa.getPrecioBase() * 0.5, camisa.precioPrenda());
  }

  @Test
  public void unaPrendaEnPromocionDescuentaUnCiertoValorElegidoPorElCliente() {
    Prenda camisa = new Prenda(100, new Promocion(20), Tipo.CAMISA);
    assertEquals(camisa.getPrecioBase() - 20, camisa.precioPrenda());
  }

  @Test
  public void precioDeCamisaEnLiquidacionEsCorrecta() {
    Prenda camisa = new Prenda(100, liquidacion, Tipo.CAMISA);
    assertEquals(camisa.precioPrenda(), 50);
  }

  @Test
  public void precioDePantalonEnLiquidacionEsCorrecta() {
    Prenda pantalon = new Prenda(50, liquidacion, Tipo.PANTALON);
    assertEquals(pantalon.precioPrenda(), 25);
  }

  @Test
  public void precioDeSacoEnLiquidacionEsCorrecta() {
    Prenda saco = new Prenda(60, liquidacion, Tipo.SACO);
    assertEquals(saco.precioPrenda(), 30);
  }

  @Test
  public void precioDeCamisaEnPromocionEsCorrecta() {
    Prenda camisa = new Prenda(60, new Promocion(10), Tipo.SACO);
    assertEquals(camisa.precioPrenda(), 50);
  }

  @Test
  public void precioDePantalonEnPromocionEsCorrecta() {
    Prenda pantalon = new Prenda(30, new Promocion(10), Tipo.SACO);
    assertEquals(pantalon.precioPrenda(), 20);
  }

  @Test
  public void precioDeSacoEnPromocionEsCorrecta() {
    Prenda saco = new Prenda(76, new Promocion(10), Tipo.SACO);
    assertEquals(saco.precioPrenda(), 66);
  }

  @Test
  public void precioDeCamisaNuevaEsCorrecta() {
    Prenda camisa = new Prenda(100, nueva, Tipo.SACO);
    assertEquals(camisa.precioPrenda(), 100);
  }

  @Test
  public void precioDePantalonNuevaEsCorrecta() {
    Prenda pantalon = new Prenda(70, nueva, Tipo.SACO);
    assertEquals(pantalon.precioPrenda(), 70);
  }

  @Test
  public void precioDeSacoNuevaEsCorrecta() {
    Prenda saco = new Prenda(150, nueva, Tipo.SACO);
    assertEquals(saco.precioPrenda(), 150);
  }

  @Test
  public void tipoDeCamisaEsCorrecto() {
    Prenda camisa = new Prenda(100, nueva, Tipo.CAMISA);
    assertEquals(camisa.getTipo(), Tipo.CAMISA);
  }

  @Test
  public void tipoDePantalonEsCorrecto() {
    Prenda pantalon = new Prenda(100, nueva, Tipo.PANTALON);
    assertEquals(pantalon.getTipo(), Tipo.PANTALON);
  }

  @Test
  public void tipoDeSacoEsCorrecto() {
    Prenda saco = new Prenda(100, nueva, Tipo.SACO);
    assertEquals(saco.getTipo(), Tipo.SACO);
  }

  @Test
  public void estadoPrendaPromocionNoAdmiteValorNuloDeValorFijo() {
    IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,
        () -> new Prenda(100, new Promocion(0), Tipo.SACO));
    assertEquals("El valor fijo de la promocion debe ser positivo", e.getMessage());
  }

  @Test
  public void estadoPrendaPromocionNoAdmiteValorNegativoDeValorFijo() {
    IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,
        () -> new Prenda(100, new Promocion(-1), Tipo.SACO));
    assertEquals("El valor fijo de la promocion debe ser positivo", e.getMessage());
  }

  @Test
  public void precioPrendaEnPromocionEsNuloAnteUnValorFijoIgualQueElPrecio() {
    Prenda pantalon = new Prenda(100, new Promocion(100), Tipo.PANTALON);
    assertTrue(pantalon.precioPrenda() == 0);
  }

  @Test
  public void precioPrendaEnPromocionEsNuloAnteUnValorFijoMayorQueElPrecio() {
    Prenda pantalon = new Prenda(100, new Promocion(101), Tipo.PANTALON);
    assertTrue(pantalon.precioPrenda() == 0);
  }

}
