package src;

import javax.swing.*;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class Controlador {
	
	MyStack num_stack = null;
    MyStack commands_stack = null;
    double FinalResult;
    
    
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
                num_stack = new MyStack(caracters);
                commands_stack = new MyStack(Arithmetic_Commands);

                //the values in the Array are reviewed
                for(int n = 0;n<Array.size();n++) {
                    String element = String.valueOf(Array.get(n));
                    //if a value matches an arithmetic sign, it pushes to the commands stack
                    if (element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/")) {
                        commands_stack.add(Array.get(n));
                    }
                    else{
                        try {
                            double num = Double.parseDouble(element);
                            num_stack.add(num);
                        }catch (Exception e){
                            Array.remove(n);
                            System.out.println("Se ha eliminado un dato invalido para la calculadora");
                        }
                    }
                }
                
                
                //Elements had been added up to each stack
                boolean loop = true;
                
                do{
                    System.out.println("Resultado actual de la calculadora..." + num_stack.peek());

                    String ConstantA = String.valueOf(num_stack.remove());
                    String ConstantB = String.valueOf(num_stack.remove());

                    double A;
                    double B;

                    try{
                        A = Double.parseDouble(ConstantA);
                        B = Double.parseDouble(ConstantB);
                    }catch (NumberFormatException e){
                        loop = false;
                        A=0;
                        B=0;
                    }
                    
                    
                    double result;

                    String math_operator = String.valueOf(commands_stack.remove());
                    
                    result = operaciones(math_operator, A, B);
                    FinalResult = result;
            		num_stack.add(result);
                    
                   
                   /* switch (math_operator) {
					case "+":
						result = A+B;
						FinalResult = result;
						num_stack.add(result);
						break;
					default:
						
						switch (math_operator) {
						case "-":
							result = A-B;
							FinalResult = result;
							num_stack.add(result);
							break;
						default:
							switch (math_operator) {
							case "*":
								result = A*B;
								FinalResult = result;
								num_stack.add(result);
								break;
							default:
								switch (math_operator) {
								case "/":
									result = A/B;
									FinalResult = result;
									num_stack.add(result);
									break;
								default:
									if(math_operator.equals("+") && !math_operator.equals("-") && !math_operator.equals("*") && !math_operator.equals("+"))
										System.out.println("Operador invalido, intente agregar un + al final del documento o bien revise e intente de nuevo");
									break;
								}
								break;
							}
							break;
						}
						break;
					}*/
                }while(loop);
                System.out.println("Ha finalizado la ejecucion");
            }//if Array is not empty
        }//no existe ningun archivo con ese nombre
        catch(IOException e){
            JOptionPane.showMessageDialog(null,"No existe un archivo llamado datos.txt dentro de la carpeta, agregue uno para poder ejecutar este programa");
            System.exit(0);
        }      
    }
    
    public double operaciones(String math_operator, double A, double B) {
    	double result = 0;
    	
    	switch(math_operator) {
    		case "+":
    			result = operacionSuma(A, B);
    			break;
    		case "-":
    			result = operacionResta(A,B);
    			break;
    		case "*":
    			result = operacionMulti(A,B);
    			break;
    		case "/":
    			result = operacionResta(A,B);
    			break;
    		default:
    			if(math_operator.equals("+") && !math_operator.equals("-") && !math_operator.equals("*") && !math_operator.equals("+"))
					System.out.println("Operador invalido, intente agregar un + al final del documento o bien revise e intente de nuevo");
    			break;
    	
    	}
    	return result;
    }
    
    public double operacionSuma(double A, double B) {
			return A+B;
     }
    
    public double operacionResta(double A, double B) {
    	return A-B;
    
    }
    
    public double operacionMulti(double A, double B) {
    	return A*B;
    }
    
    public double operacionDivision(double A, double B) {
    	return A/B;
    
    }
} 