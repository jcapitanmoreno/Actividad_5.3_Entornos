package dam.ed;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
    // Definimos el objeto para usarlo en todos los tests
    static Calculadora miCalculadora;

    @BeforeAll
    public static void setUpClass() {
        miCalculadora = new Calculadora();
    }

    @Test
    @DisplayName("Suma dos números")
    void testSumar() {
        assertEquals(12, miCalculadora.suma(5, 7));
        assertEquals(17, miCalculadora.suma(8, 9));
        assertEquals(3.9000000000000004, miCalculadora.suma(1.3, 2.6));
        assertEquals(3.2, miCalculadora.suma(1.7, 1.5));
    }
    @Test
    @DisplayName("Resta dos números")
    void testResta() {
        assertEquals(1, miCalculadora.resta(3, 2));
        assertEquals(3, miCalculadora.resta(4, 1));
        assertEquals(3.3, miCalculadora.resta(7.5, 4.2));
        assertEquals(3.8, miCalculadora.resta(5.5, 1.7));
    }


    @Test
    @DisplayName("Multiplica dos números")
    void testMultiplicar() {
        assertEquals(6, miCalculadora.multiplica(2, 3));
        assertEquals(0, miCalculadora.multiplica(5, 0));
        assertEquals(16, miCalculadora.multiplica(4, 4));
        assertEquals(-5, miCalculadora.multiplica(-5, 1));
    }

    @Test
    @DisplayName("Divisiones enteras y reales")
    void testDivisionesEnterasYReales() throws Exception {
        assertEquals(2, miCalculadora.divide(4, 2));
        assertEquals(2.5, miCalculadora.divide(10, 4));
        assertEquals(4, miCalculadora.divide(10, 2.5));
        assertEquals(3.2, miCalculadora.divide(8, 2.5));
        assertEquals(0.5, miCalculadora.divide(2, 4));
    }

    @Test
    @DisplayName("Divisiones positivos y negativos")
    void testDivisionesPositivosYNegativos() throws Exception {
        assertTrue(miCalculadora.divide(4, 2) > 0);
        assertTrue(miCalculadora.divide(4, -2) < 0);
        assertTrue(miCalculadora.divide(-4, 2) < 0);
        assertTrue(miCalculadora.divide(-4, -2) > 0);
    }

    @Test
    @DisplayName("potencia positivos y negativos")
    void testPotencia() throws Exception {
        assertEquals(32, miCalculadora.potencia(2, 5));
        assertEquals(27, miCalculadora.potencia(3, 3));
        assertEquals(-3125.0, miCalculadora.potencia(-5, 5));
        assertEquals(1, miCalculadora.potencia(17, 0));

    }
    @Test
    @DisplayName("Raiz cuadrada de numeros positivos")
    void testRaizCuadrada() throws Exception{
        assertEquals(1, miCalculadora.raizCuadrada(1));
        assertEquals(0, miCalculadora.raizCuadrada(0));
        assertEquals(2, miCalculadora.raizCuadrada(4));
        Exception thrown = assertThrows(Exception.class, () -> {
            miCalculadora.raizCuadrada(-1);
        });

        assertEquals("El radicando no puede ser negativo", thrown.getMessage());
    }

    @Test
    @DisplayName("División por cero causa excepción")
    void testDivisionPorCero() {
        Exception thrown = assertThrows(Exception.class, () -> {
            miCalculadora.divide(5, 0);
        });

        assertEquals("El divisor es 0", thrown.getMessage());
    }
}
