/*
 *  Author:         Carlos Guillermo Rolon Fabian
 *  Description:    Algorithm to translate text to morse and morse to text
 *  Date:           26/20/2019
 */
/*-------------------------------------------------------------------------*/

// Package name
package romanos;

/*-------------------------------------------------------------------------*/

// Import Area
import java.util.Scanner;
import java.util.ArrayList;

/*-------------------------------------------------------------------------*/
// Class Area
public class Romanos {
    
    // Constants Area
    public static final int CINCO = 5;
    
    // transform the number into an array of integers
    public static ArrayList<Integer> splitNumbers(String number){        
        // Transform the string into char array to control the number
        char[] numberS = number.toCharArray();
        
        // Initialization of int array 
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        
        // fills array numbers with numberS casted to int
        for(char numberC : numberS){
            numbers.add(Integer.parseInt(String.valueOf(numberC)));
        }
        
        return numbers;
    }
    
    // Transforms thousands
    public static String thousandsToRoman(int thousands){
        return "M";
    }
    
    // Transforms hundreds
    public static String hundredsToRoman(int hundreds){
        // String Return 
        String result = "";
        
        // Conversión to roman
        if(hundreds == 0){
            return "";
        }else if(hundreds == 1){
            result += "C";
        }else if(hundreds > 1 && hundreds <= 3){
            for(int i = 0; i < hundreds; i++){
                result += "C";
            }
        }else if(hundreds == (Romanos.CINCO - 1)){
            result += "CD";
        }else if(hundreds == Romanos.CINCO){
            result += "D";
        }else if(hundreds > Romanos.CINCO && hundreds <= 8){
            result += "D";
            for(int i = 0; i < (hundreds-Romanos.CINCO); i++){
                result += "C";
            }
        }else{
            result += "CM";
                    
        }
        
        return result;
    }
    
    // Transforms tens
    public static String tensToRoman(int tens){
        // String Return 
        String result = "";
        
        // Conversión to roman
        if(tens == 0){
            return "";
        }else if(tens == 1){
            result += "X";
        }else if(tens > 1 && tens <= 3){
            for(int i = 0; i < tens; i++){
                result += "X";
            }
        }else if(tens == (Romanos.CINCO - 1)){
            result += "IX";
        }else if(tens == Romanos.CINCO){
            result += "L";
        }else if(tens > Romanos.CINCO && tens <= 8){
            result += "L";
            for(int i = 0; i < (tens-Romanos.CINCO); i++){
                result += "X";
            }
        }else{
            result += "XC";
                    
        }
        
        return result;
    }
    
    // Transforms units
    public static String unitsToRoman(int units){
        // String Return 
        String result = "";
        
        // Conversión to roman
        if(units == 0){
            return "";
        }else if(units == 1){
            result += "I";
        }else if(units > 1 && units <= 3){
            for(int i = 0; i < units; i++){
                result += "I";
            }
        }else if(units == (Romanos.CINCO - 1)){
            result += "IV";
        }else if(units == Romanos.CINCO){
            result += "V";
        }else if(units > Romanos.CINCO && units <= 8){
            result += "V";
            for(int i = 0; i < (units-Romanos.CINCO); i++){
                result += "I";
            }
        }else{
            result += "IX";
                    
        }
        
        return result;
    }

    // Transforms common numbers to roman numerals
    public static void main(String[] args) {
        // Scanner for reading data
        Scanner sc = new Scanner(System.in);
        
        // var option
        byte op = 0;
        
        // input number 
        
        String number = null;
        
        // do-while execution program
        do{
            
            // Data input
            System.out.println("---------------------------------------------");
            System.out.println("Seleccione Opción");
            System.out.println("1 : Convertir números a romanos del 1 al 1000");           
            System.out.println("0 : Abortar programa");
            
            try{
                op = sc.nextByte();
                sc.nextLine();
            }catch(Exception e){
                e.printStackTrace();
            } 
            
            if(op == 1){ // if op is equal to 1 then convert number to roman
                
                // Read data input
                System.out.println("---------------------------------------------");
                System.out.println("Inserte los datos para transformar el número común a números romanos");
                System.out.println("El número debe estar en el rango del 1 al 1000");
                
                try{
                    number = sc.nextLine();
                }catch(Exception e){
                    e.printStackTrace();
                }                
                
                if(Integer.parseInt(number) >= 1 && Integer.parseInt(number) <= 1000){
                    // recives the numbers array
                    ArrayList<Integer> numbersArray = splitNumbers(number);
                    
                    // size of numbersArray
                    byte sizeOfNumbers = (byte) numbersArray.size();
                    
                    // Roman result
                    String resultRoman = "";
                    
                    switch(sizeOfNumbers){
                        case 4:{
                            resultRoman += Romanos.thousandsToRoman(numbersArray.get(0));
                            numbersArray.remove(0);
                        }
                        case 3:{
                            resultRoman += Romanos.hundredsToRoman(numbersArray.get(0));
                            numbersArray.remove(0);
                        }
                        case 2:{
                            resultRoman += Romanos.tensToRoman(numbersArray.get(0));
                            numbersArray.remove(0);
                        }
                        case 1:{
                            resultRoman += Romanos.unitsToRoman(numbersArray.get(0));
                            numbersArray.remove(0);
                            
                            // Clear numbersArray
                            numbersArray.clear();
                            
                            break;
                        }
                        default:{
                            System.out.println("Ocurrió un error al convertir el número a romanos1");
                            break;
                        }
                    }
                    
                    // Print result on display
                    System.out.println("El número es: " + number);
                    System.out.println("Su conversión romana es: " + resultRoman);
                    
                }else{
                    System.out.println("---------------------------------------------");
                    System.out.println("El número debe estar en el rango del 1 al 1000");
                    System.out.println("Intentelo de nuevo");
                }
                
                System.out.println("");
            }else if (op == 0){
                
                // Final Message
                System.out.println("---------------------------------------------");
                System.out.println("El programara ha terminado su ejecución");
            }else{
                
                // Error Message
                System.out.println("---------------------------------------------");
                System.out.println("Seleccione una opción valida");
            }
            
        }while(op != 0); // Execute while option different to 0
    }
    
}
