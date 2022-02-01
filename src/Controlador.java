/**
 *  @author Pablo Herrera
 *  @since January 20th, 2022
 *  @Version 5.0
 *
 *  Controller of the project, this class contains the logic necessary for the project to workd
 */

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class Controlador {
    public void ProgramLogic() {
        ArrayList<Object> Array = new ArrayList<>();
        MyCalculator calculadora = new MyCalculator();

        System.out.println("Hola, bienvenido a tu calculadora");
        File file = new File("datos.txt");

        //Program tries to find de file. For default the file is already created and called datos.txt.
        try{
            FileReader data = new FileReader(file);
            int i = 0;
            while(i!=-1){
                i = data.read();
                char caracter = (char)i;
                //los caracteres se agregan al arreglo de Strings
                String command = String.valueOf(caracter);
                Array.add(command);
            }
            data.close();
            Collections.reverse(Array);

            //if the document contains any characters, the program will continue, otherwise it will end

            if(Array.isEmpty()){
                System.out.println("Tu Archivo .txt no tiene algun caracter, no se podra calcular nada. Editalo y corre nuevamente este programa");
                System.exit(0);
            }

            else{
                //the array will be added to a Stack
                MyStack string_stack = new MyStack(Array);
                String PostfixOperation="";
                while(!string_stack.empty()){
                    PostfixOperation = PostfixOperation+string_stack.remove();
                }
                System.out.println("Operacion PostFix " +PostfixOperation);
                double result = calculadora.calculate(PostfixOperation);
                System.out.println("Su resultado final es: "+result);
            }//if Array is not empty
        }

        catch(IOException e){
            JOptionPane.showMessageDialog(null,"No existe un archivo llamado datos.txt dentro de la carpeta, agregue uno para poder ejecutar este programa");
            System.exit(0);
        }
    }
}
