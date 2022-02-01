import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MyCalculatorTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void calculate() {
        String op = "12*4+3+";
        String[] chars = op.split("");
        ArrayList<String> expresion = new ArrayList<>(Arrays.asList(chars));

        ArrayList<Double> numeros = new ArrayList<>();
        ArrayList<String> operadores = new ArrayList<>();

        for (String s : expresion) {
            try {
                Double num = Double.parseDouble(s);
                numeros.add(num);
            } catch (NumberFormatException e) {
                operadores.add(s);
            }
        }
        double result = numeros.get(0);
        assertEquals(1.0,result);
    }
}