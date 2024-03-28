package domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class UsuarioTest {

    private Usuario usuario;

    @Before
    public void setUp() {
        // Inicializar el objeto Usuario antes de cada prueba
        usuario = new Usuario("12345678A", "Juan", "Perez");
    }

    @Test
    public void testConstructor1() {
        // Verificar que los atributos se inicializan correctamente en el constructor
        assertEquals("12345678A", usuario.getDNI());
        assertEquals("Juan", usuario.getNombre());
        assertEquals("Perez", usuario.getApellido());
        assertEquals(null, usuario.getnUsuario());
        assertEquals(null, usuario.getContrasena());
        assertEquals(0, usuario.getEdad());
        assertEquals(0, usuario.getCartera().size()); // La cartera deber�a estar vac�a al principio
    }

    @Test
    public void testConstructor2() {
        // Verificar que los atributos se inicializan correctamente en el constructor con par�metros adicionales
        List<Tarjeta> cartera = new ArrayList<>();
        Tarjeta tarjeta1 = new Tarjeta(1, "A1", null, null, System.currentTimeMillis(), 1);
        Tarjeta tarjeta2 = new Tarjeta(2, "B2", null, null, System.currentTimeMillis(), 2);
        cartera.add(tarjeta1);
        cartera.add(tarjeta2);
        Usuario usuarioCompleto = new Usuario("12345678B", "Pedro", "Lopez", "pedro123", "contrase�a", 30, cartera);
        assertEquals("12345678B", usuarioCompleto.getDNI());
        assertEquals("Pedro", usuarioCompleto.getNombre());
        assertEquals("Lopez", usuarioCompleto.getApellido());
        assertEquals("pedro123", usuarioCompleto.getnUsuario());
        assertEquals("contrase�a", usuarioCompleto.getContrasena());
        assertEquals(30, usuarioCompleto.getEdad());
        assertEquals(2, usuarioCompleto.getCartera().size()); // La cartera deber�a contener dos tarjetas
    }

    @Test
    public void testSettersAndGetters() {
        // Verificar los m�todos setters y getters
        usuario.setDNI("87654321B");
        usuario.setNombre("Ana");
        usuario.setApellido("Garcia");
        usuario.setnUsuario("ana123");
        usuario.setContrasena("password");
        usuario.setEdad(25);
        assertEquals("87654321B", usuario.getDNI());
        assertEquals("Ana", usuario.getNombre());
        assertEquals("Garcia", usuario.getApellido());
        assertEquals("ana123", usuario.getnUsuario());
        assertEquals("password", usuario.getContrasena());
        assertEquals(25, usuario.getEdad());
    }

    @Test
    public void testAddTarjeta() {
        // Verificar el m�todo addTarjeta
        Tarjeta tarjeta = new Tarjeta(1, "A1", null, null, System.currentTimeMillis(), 1);
        usuario.addTarjeta(tarjeta);
        assertEquals(1, usuario.getCartera().size()); // La cartera deber�a contener una tarjeta despu�s de agregarla
    }

    @Test
    public void testToString() {
        // Verificar el m�todo toString
        assertEquals("Juan, Perez (12345678A)", usuario.toString());
    }
}