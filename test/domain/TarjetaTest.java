package domain;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TarjetaTest {

    private Tarjeta tarjeta;
    private Usuario usuario;
    private Avion avion;

    @Before
    public void setUp() {
        usuario = new Usuario("Nombre", "Apellido", "correo@example.com");
        avion = new Avion();
        tarjeta = new Tarjeta(123, "A1", usuario, avion, System.currentTimeMillis(), 1);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals(123, tarjeta.getnEmbarque());
        assertEquals("A1", tarjeta.getPuertaEmbarque());
        assertEquals(usuario, tarjeta.getUser());
        assertEquals(avion, tarjeta.getAvion());
        assertTrue(tarjeta.getHoraSalida() > 0);
        assertEquals(1, tarjeta.getAsiento());
    }

    @Test
    public void testSetters() {
        tarjeta.setnEmbarque(456);
        assertEquals(456, tarjeta.getnEmbarque());

        tarjeta.setPuertaEmbarque("B2");
        assertEquals("B2", tarjeta.getPuertaEmbarque());

        Usuario nuevoUsuario = new Usuario("Nuevo", "Usuario", "nuevo@example.com");
        tarjeta.setUser(nuevoUsuario);
        assertEquals(nuevoUsuario, tarjeta.getUser());

        Avion nuevoAvion = new Avion();
        tarjeta.setAvion(nuevoAvion);
        assertEquals(nuevoAvion, tarjeta.getAvion());

        long nuevaHoraSalida = System.currentTimeMillis() + 1000;
        tarjeta.setHoraSalida(nuevaHoraSalida);
        assertEquals(nuevaHoraSalida, tarjeta.getHoraSalida());

        tarjeta.setAsiento(2);
        assertEquals(2, tarjeta.getAsiento());
    }

    @Test
    public void testLongAFechaHora() {
        // Verificar si la fecha y hora se formatea correctamente
        String formattedDate = tarjeta.LongAFechaHora(System.currentTimeMillis());
        assertNotNull(formattedDate);
        System.out.println("Fecha y hora formateada: " + formattedDate);
    }

    @Test
    public void testToString() {
        // Verificar si el método toString devuelve el número de embarque
        assertEquals("Tarjeta de Embarque: 123", tarjeta.toString());
    }
}