import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    @Test
    void add() {
        ArrayList<Object> array = new ArrayList<>();
        String cadena = "cadena";
        int numero = 1;
        double decimal = 0.5;
        array.add(cadena);
        array.add(numero);
        array.add(decimal);

        assertEquals(0.5,array.get(2));
        assertEquals(1,array.get(1));
        assertEquals("cadena",array.get(0));
    }

    @Test
    void remove() {
        ArrayList<Object> array = new ArrayList<>();
        String cadena = "cadena";
        int numero = 1;
        double decimal = 0.5;
        array.add(cadena);
        array.add(numero);
        array.add(decimal);

        array.remove(2);
        int size = array.size();
        assertEquals(2,size);
    }

    @Test
    void peek() {
        ArrayList<Object> array = new ArrayList<>();
        String cadena = "cadena";
        int numero = 1;
        double decimal = 0.5;
        array.add(cadena);
        array.add(numero);
        array.add(decimal);

        assertEquals(1,array.get(1));
    }

    @Test
    void empty() {
        ArrayList<Object> array = new ArrayList<>();
        boolean empty = array.isEmpty();
        assertEquals(true,empty);
    }

    @Test
    void size() {
        ArrayList<Object> array = new ArrayList<>();
        int size = array.size();
        assertEquals(0,size);
    }
}