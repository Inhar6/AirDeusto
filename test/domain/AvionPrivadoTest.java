package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class AvionPrivadoTest {

    private AvionPrivado avionPrivado;
    private Usuario usuario;

    @Before
    public void setUp() {
        // Inicializar el objeto AvionPrivado antes de cada prueba
        usuario = new Usuario("12345678A", "Juan", "Perez");
        avionPrivado = new AvionPrivado(usuario, 10.5f);
    }

    @Test
    public void testConstructor() {
        // Verificar que los atributos se inicializan correctamente en el constructor
        assertEquals(usuario, avionPrivado.getUser());
        assertEquals(10.5f, avionPrivado.getTamanyo(), 0.001);
    }

    @Test
    public void testSettersAndGetters() {
        // Verificar los métodos setters y getters
        Usuario usuario2 = new Usuario("87654321B", "Pedro", "Gomez");
        avionPrivado.setUser(usuario2);
        avionPrivado.setTamanyo(15.7f);
        assertEquals(usuario2, avionPrivado.getUser());
        assertEquals(15.7f, avionPrivado.getTamanyo(), 0.001);
    }

    @Test
    public void testToString() {
        // Verificar el método toString
        assertEquals("AvionPrivado [user=" + usuario + ", tamaï¿½o=" + 10.5f + "]", avionPrivado.toString());
    }
}