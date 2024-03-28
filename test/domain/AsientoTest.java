package domain;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AsientoTest {

    private Asiento asiento;

    @Before
    public void setUp() {
        // Inicializar el objeto Asiento antes de cada prueba
        asiento = new Asiento(10); // Creamos un asiento con lugar 10
    }

    @Test
    public void testConstructor1() {
        // Verificar que el lugar se inicializa correctamente en el constructor
        assertEquals(10, asiento.getLugar());
        assertFalse(asiento.isOcupado()); // Asegurarse de que el asiento no esté ocupado
    }

    @Test
    public void testConstructor2() {
        // Verificar que el lugar y el estado de ocupación se inicializan correctamente en el constructor
        Asiento asientoOcupado = new Asiento(20, true); // Creamos un asiento ocupado con lugar 20
        assertEquals(20, asientoOcupado.getLugar());
        assertTrue(asientoOcupado.isOcupado()); // Asegurarse de que el asiento esté ocupado
    }

    @Test
    public void testSetLugar() {
        // Verificar el método setLugar
        asiento.setLugar(15); // Cambiamos el lugar del asiento a 15
        assertEquals(15, asiento.getLugar());
    }

    @Test
    public void testSetOcupado() {
        // Verificar el método setOcupado
        asiento.setOcupado(true); // Marcamos el asiento como ocupado
        assertTrue(asiento.isOcupado());
    }

    @Test
    public void testToString() {
        // Verificar el método toString
        assertEquals("Asiento: 10", asiento.toString());
    }
}