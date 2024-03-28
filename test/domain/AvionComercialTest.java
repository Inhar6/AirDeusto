package domain;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class AvionComercialTest {

    private AvionComercial avionComercial;
    private Map<Integer, String> productos;

    @Before
    public void setUp() {
        // Inicializar el objeto AvionComercial antes de cada prueba
        productos = new HashMap<>();
        productos.put(1, "Producto1");
        productos.put(2, "Producto2");
        productos.put(3, "Producto3");

        avionComercial = new AvionComercial("Producto principal", productos, 100);
    }

    @Test
    public void testConstructor() {
        // Verificar que los atributos se inicializan correctamente en el constructor
        assertEquals("Producto principal", avionComercial.getProducto());
        assertEquals(productos, avionComercial.getProductos());
        assertEquals(100, avionComercial.getPesoMax());
    }

    @Test
    public void testSettersAndGetters() {
        // Verificar los métodos setters y getters
        Map<Integer, String> nuevosProductos = new HashMap<>();
        nuevosProductos.put(4, "Producto4");
        nuevosProductos.put(5, "Producto5");

        avionComercial.setProducto("Nuevo producto");
        avionComercial.setProductos(nuevosProductos);
        avionComercial.setPesoMax(200);

        assertEquals("Nuevo producto", avionComercial.getProducto());
        assertEquals(nuevosProductos, avionComercial.getProductos());
        assertEquals(200, avionComercial.getPesoMax());
    }

    @Test
    public void testToString() {
        // Verificar el método toString
        String expectedToString = "AvionComercial [producto=Producto principal, productos={1=Producto1, 2=Producto2, 3=Producto3}, pesoMax=100]";
        assertEquals(expectedToString, avionComercial.toString());
    }
}