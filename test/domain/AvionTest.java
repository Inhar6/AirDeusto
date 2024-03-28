package domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class AvionTest {

    private Avion avion;

    @Before
    public void setUp() {
        // Inicializar el objeto Avion antes de cada prueba
        avion = new Avion(1, "Origen", "Destino", 150, 5.5, System.currentTimeMillis(), new ArrayList<>(), new HashMap<>(), "Compania", 100);
    }

    @Test
    public void testConstructor1() {
        // Verificar que los atributos se inicializan correctamente en el constructor
        assertEquals(1, avion.getId());
        assertEquals("Origen", avion.getPaisOrg());
        assertEquals("Destino", avion.getPaisDest());
        assertEquals(150, avion.getCapacidad());
        assertEquals(5.5, avion.getDuracionViaje(), 0.001);
        assertNotNull(avion.getHoraSalida());
        assertEquals(0, avion.getPasajeros().size());
        assertEquals(0, avion.getMapaPasajeros().size());
        assertEquals("Compania", avion.getCompania());
        assertEquals(100, avion.getPrecio());
    }

    @Test
    public void testConstructor2() {
        // Verificar que los atributos se inicializan correctamente en el constructor con parámetros adicionales
        List<Tarjeta> pasajeros = new ArrayList<>();
        Map<Asiento, Tarjeta> mapaPasajeros = new HashMap<>();
        Tarjeta tarjeta1 = new Tarjeta(1, "A1", null, null, System.currentTimeMillis(), 1);
        Tarjeta tarjeta2 = new Tarjeta(2, "B2", null, null, System.currentTimeMillis(), 2);
        pasajeros.add(tarjeta1);
        pasajeros.add(tarjeta2);
        mapaPasajeros.put(new Asiento(1), tarjeta1);
        mapaPasajeros.put(new Asiento(2), tarjeta2);
        Avion avionCompleto = new Avion(2, "Origen", "Destino", 200, 6.0, System.currentTimeMillis(), pasajeros, mapaPasajeros, "Compania2", 150);
        assertEquals(2, avionCompleto.getId());
        assertEquals("Origen", avionCompleto.getPaisOrg());
        assertEquals("Destino", avionCompleto.getPaisDest());
        assertEquals(200, avionCompleto.getCapacidad());
        assertEquals(6.0, avionCompleto.getDuracionViaje(), 0.001);
        assertNotNull(avionCompleto.getHoraSalida());
        assertEquals(2, avionCompleto.getPasajeros().size());
        assertEquals(2, avionCompleto.getMapaPasajeros().size());
        assertEquals("Compania2", avionCompleto.getCompania());
        assertEquals(150, avionCompleto.getPrecio());
    }

    @Test
    public void testSettersAndGetters() {
        // Verificar los métodos setters y getters
        avion.setId(3);
        avion.setPaisOrg("Origen2");
        avion.setPaisDest("Destino2");
        avion.setCapacidad(250);
        avion.setDuracionViaje(7.5);
        avion.setHoraSalida(System.currentTimeMillis());
        avion.setCompania("Compania3");
        avion.setPrecio(200);
        assertEquals(3, avion.getId());
        assertEquals("Origen2", avion.getPaisOrg());
        assertEquals("Destino2", avion.getPaisDest());
        assertEquals(250, avion.getCapacidad());
        assertEquals(7.5, avion.getDuracionViaje(), 0.001);
        assertNotNull(avion.getHoraSalida());
        assertEquals("Compania3", avion.getCompania());
        assertEquals(200, avion.getPrecio());
    }

    @Test
    public void testAddLstPasajero() {
        // Verificar el método addLstPasajero
        Tarjeta tarjeta1 = new Tarjeta(1, "A1", null, null, System.currentTimeMillis(), 1);
        Tarjeta tarjeta2 = new Tarjeta(2, "B2", null, null, System.currentTimeMillis(), 2);
        avion.addLstPasajero(tarjeta1);
        avion.addLstPasajero(tarjeta2);
        assertEquals(2, avion.getPasajeros().size());
    }

    @Test
    public void testAddMapPasajeros() {
        // Verificar el método addMapPasajeros
        Tarjeta tarjeta1 = new Tarjeta(1, "A1", null, null, System.currentTimeMillis(), 1);
        Tarjeta tarjeta2 = new Tarjeta(2, "B2", null, null, System.currentTimeMillis(), 2);
        avion.addMapPasajeros(new Asiento(1), tarjeta1);
        avion.addMapPasajeros(new Asiento(2), tarjeta2);
        assertEquals(2, avion.getMapaPasajeros().size());
    }

    @Test
    public void testAddPasajerosMapa() {
        // Verificar el método addPasajerosMapa
        Tarjeta tarjeta = new Tarjeta(1, "A1", null, null, System.currentTimeMillis(), 1);
        avion.addPasajerosMapa(tarjeta);
        assertEquals(1, avion.getMapaPasajeros().size());
    }

    @Test
    public void testLlenarListasAvion() {
        // Verificar el método llenarListasAvion
        Usuario usuario = new Usuario("12345678A", "Juan", "Perez");
        Tarjeta tarjeta = new Tarjeta(1, "A1", null, avion, System.currentTimeMillis(), 1);
        usuario.addTarjeta(tarjeta);
        List<Usuario> lstUsuario = new ArrayList<>();
        lstUsuario.add(usuario);
        avion.llenarListasAvion(lstUsuario);
        assertEquals(1, avion.getPasajeros().size());
        assertEquals(1, avion.getMapaPasajeros().size());
    }

    @Test
    public void testLongAFecha() {
        // Verificar el método LongAFecha
        long currentTime = System.currentTimeMillis();
        String fecha = avion.LongAFecha(currentTime);
        assertNotNull(fecha);
    }

    @Test
    public void testToString() {
        // Verificar el método toString
        assertEquals("Avion [id=1, paisOrg=Origen, paisDest=Destino, capacidad=150, duracionViaje=5.5, horaSalida=" + avion.getHoraSalida() + ", pasajeros=[]]", avion.toString());
    }

    @Test
    public void testCompareTo() {
        // Verificar el método compareTo
        Avion avion2 = new Avion(2, 200);
        assertTrue(avion.compareTo(avion2) < 0); // Debería ser menor que 0 porque el ID de avion es 1 y el de avion2 es 2
    }
}