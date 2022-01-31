import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;


public class Controlador {
    public void ProgramLogic() {
        ArrayList<Object> Array = new ArrayList<Object>();
        Stack<Object> Stack = new Stack<Object>();

        System.out.println("Hola, bienvenido a tu calculadora");
        File file = new File("datos.txt");

        //intentara buscar el archivo, por defecto existira un archivo con el nombre que se necesita.
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
            //los datos y caracteres en el documento txt han sido agregados a un arreglo

        }//no existe ningun archivo con ese nombre
        catch(IOException e){
            JOptionPane.showMessageDialog(null,"No existe un archivo llamado datos.txt dentro de la carpeta, agregue uno para poder ejecutar este programa");
            System.exit(0);
        }
    }
}
