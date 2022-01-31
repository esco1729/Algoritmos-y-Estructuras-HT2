import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class Controlador {
    public void ProgramLogic() {
        ArrayList<Object> Array = new ArrayList<>();


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
            //los datos y caracteres en el documento txt han sido agregados a un arreglo, de no haber el programa se terminara
            if(Array.isEmpty()){
                System.out.println("Tu Archivo .txt no tiene algun caracter, no se podra calcular nada. Editalo y corre nuevamente este programa");
                System.exit(0);
            }
            //si el archivo si tiene algun caracter con el cual trabajar...
            else{
                //se crean dos arreglos y Stacks para poder manipularlos
                ArrayList<Object> caracters = new ArrayList<>();
                ArrayList<Object> Arithmetic_Commands = new ArrayList<>();
                MyStack num_stack = new MyStack(caracters);
                MyStack commands_stack = new MyStack(Arithmetic_Commands);

                //se revisa el arreglo original, si es un operando se agrega al arreglo de comandos aritmeticos, de lo contrario se agrega a caracters
                for(Object a : Array){
                    if(a.getClass().getSimpleName() == "Integer" || a.getClass().getSimpleName() == "Double"){
                        String a_to_String = (String)a;
                        double number = Double.parseDouble(a_to_String);
                        num_stack.add(number);
                    }//si el dato no se puede tratar como un numero de alguna forma
                    else{
                        commands_stack.add(a);
                    }
                    }//fin ciclo
                }//fin condicional
            //Para este momento ya se han separado los numeros de los comandos aritmeticos, ahora es momento de operarlos en formato PostFix



        }//no existe ningun archivo con ese nombre
        catch(IOException e){
            JOptionPane.showMessageDialog(null,"No existe un archivo llamado datos.txt dentro de la carpeta, agregue uno para poder ejecutar este programa");
            System.exit(0);
        }
    }
}
