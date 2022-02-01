import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class Controlador {
    public void ProgramLogic() {
        ArrayList<Object> Array = new ArrayList<>();
        ArrayList<Object> caracters = new ArrayList<>();
        ArrayList<Object> Arithmetic_Commands = new ArrayList<>();

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
                //The stacks are created from the interface the class and the interface created before
                MyStack num_stack = new MyStack(caracters);
                MyStack commands_stack = new MyStack(Arithmetic_Commands);

                //the values in the Array are reviewed
                for(int n = 0;n<Array.size();n++) {
                    String elemento = String.valueOf(Array.get(n));
                    //if a value matches an arithmetic sign, it pushes to the commands stack
                    if (elemento.equals("+") || elemento.equals("-") || elemento.equals("*") || elemento.equals("/")) {
                        commands_stack.add(Array.get(n));
                    }
                    //if a value is null, it does nothing
                    if (elemento == null) {
                        elemento = null;
                    }
                    //if a value is a number (I am not considering other cases) it will be pushed to the num_stack
                    else {
                        num_stack.add(Array.get(n));
                    }
                }
                //Elements had been added up to each stack

                String math_operator = String.valueOf(commands_stack.remove());

                String ConstantA = String.valueOf(num_stack.remove());
                String ConstantB = String.valueOf(num_stack.remove());

                double A = Double.parseDouble(ConstantA);
                double B = Double.parseDouble(ConstantB);

                double result;
                if(math_operator.equals("+")){
                    result = A+B;
                    num_stack.add(result);
                }
                else{
                    //if not a sum, program checks if it is a take away
                    if(math_operator.equals("-")){
                        result = A-B;
                        num_stack.add(result);
                    }
                    else{
                        //if not a sum or a take away, program checks if it is a multiplication
                        if(math_operator.equals("*")){
                            result = A*B;
                            num_stack.add(result);
                        }
                        else{
                            //if not a sum, take away or multiplication, program checks if it is a division
                            if(math_operator.equals("/")){
                                result = A/B;
                                num_stack.add(result);
                            }else{
                                //if not any of the above
                                if(math_operator.equals("+") || math_operator.equals("-") || math_operator.equals("*") || math_operator.equals("/")){
                                    System.out.println("Operador aritmetico invalido");
                                }
                            }//not any arithmetic operator
                        }//not a multiplication
                    }//not a take away
                }//not a sum
                System.out.println(num_stack.peek());


            }//if Array is not empty



        }//no existe ningun archivo con ese nombre
        catch(IOException e){
            JOptionPane.showMessageDialog(null,"No existe un archivo llamado datos.txt dentro de la carpeta, agregue uno para poder ejecutar este programa");
            System.exit(0);
        }
    }
}
