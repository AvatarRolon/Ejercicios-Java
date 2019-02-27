/*
 *  Author:         Carlos Guillermo Rolon Fabian
 *  Description:    Make different operations of a cube or square
 *  Date:           27/20/2019
 */
/*-------------------------------------------------------------------------*/

// Package name
package objetos;

/*-------------------------------------------------------------------------*/

// Import Area
import java.util.Scanner;
import figuras.*;

/*-------------------------------------------------------------------------*/
// Class Area
public class Objetos {

    // Make different operations of a cube or square
    public static void main(String[] args) {
        // Scanner for reading data
        Scanner sc = new Scanner(System.in);
        
        // var option
        byte op = 0;
        
        // input number 
        
        double side = 0;
        
        // do-while execution program
        do{
            // Data input
            System.out.println("---------------------------------------------");
            System.out.println("Introduzca tamaño del lado");
            
            try{
                side = sc.nextDouble();
                sc.nextLine();
            }catch(Exception e){
                e.printStackTrace();
            }
            
            do{
                // Select operation
                System.out.println("---------------------------------------------");
                System.out.println("Seleccione Operación");
                System.out.println("1 : Área de un cuadrado");
                System.out.println("2 : Perímetro de un cuadrado");
                System.out.println("3 : Volumen de un cubo");
                System.out.println("4 : Area de una cara del cubo");
                System.out.println("5 : Perímetro de un cubo");
                System.out.println("6 : Introducir el lado de nuevo");
                System.out.println("0 : Abortar programa");

                try{
                    op = sc.nextByte();
                    sc.nextLine();
                }catch(Exception e){
                    e.printStackTrace();
                }
                
                if(op == 1 || op == 2){ // Operations for square
                    
                    // Square definition
                    Cuadrado square = new Cuadrado(side);
                    
                    if(op == 1){ 

                        // Area                        
                        System.out.println("---------------------------------------------");
                        System.out.println("Calculo de Área del cuadrado");
                        System.out.println("El área es: " + square.calcularArea());
                        
                    }else{ 
                        
                        // Perimeter                        
                        System.out.println("---------------------------------------------");
                        System.out.println("Calculo de Perímetro del cuadrado");
                        System.out.println("El área es: " + square.calcularPerimetro());
                    }
                    
                }else if(op == 3 || op == 4 || op == 5){ // Operations for cube
                    
                    // Cube definition
                    Cubo cube = new Cubo();
                    
                    // Side assignation
                    cube.setSide(side);
                    
                    if(op == 3){
                        
                        // Volume
                        System.out.println("---------------------------------------------");
                        System.out.println("Calculo de volumen del cubo");
                        System.out.println("El volumen es: " + cube.calcularVolumen());
                    }else if(op == 4){
                        
                        // Area
                        System.out.println("---------------------------------------------");
                        System.out.println("Calculo de Área de una de las caras del cubo");
                        System.out.println("El área es: " + cube.calcularArea());
                    }else if(op == 5){
                        
                        // Perimetro del cubo
                        System.out.println("---------------------------------------------");
                        System.out.println("Calculo de Perímetro del cubo");
                        System.out.println("El área es: " + cube.calcularPerimetro());                        
                    }
                
                }else if (op == 0){
                
                    // Final Message
                    System.out.println("---------------------------------------------");
                    System.out.println("El programara ha terminado su ejecución");
                }
                
            }while(op != 6 && op != 0);
            
        }while(op != 0); // Execute while option different to 0
    }
    
}
