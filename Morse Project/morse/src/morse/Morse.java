/*
 *  Author:         Carlos Guillermo Rolon Fabian
 *  Description:    Algorithm to translate text to morse and morse to text
 *  Date:           26/20/2019
 */
/*-------------------------------------------------------------------------*/

// Package name
package morse;

/*-------------------------------------------------------------------------*/

// Import Area
import java.util.Scanner;
import java.util.HashMap;

/*-------------------------------------------------------------------------*/
// Class Area
public class Morse {    
    
    // Hashmap containing the k,v for text to morse and opposite
    private static HashMap <String, String> translation = new HashMap<String, String>();
    
    // Array for text
    private static String[] text = {"A", "B", "C", "D", "E", "F", "G", "H", "I", 
                    "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", 
                    "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", 
                    "8", "9", "0", " "};
    
    // Array for morse
    private static String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", 
                     "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
                     "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", 
                     ".--", "-..-", "-.--", "--..", ".----", "..---", "...--", 
                     "....-", ".....", "-....", "--...", "---..", "----.", "-----",
                     "  "};
    
    // Fills the HashMap with Key, Value
    public static void fillHashMap(String[] key, String[] value){
        for(int i = 0; i < key.length; i++){
            Morse.translation.put(key[i], value[i]);
        }
    }
    
    // Trnaslates text to morse
    public static String textToMorse(String text){
        // Translated text
        String resultText = "";
        
        // Fill Hahsmap with text as keys and morse as values
        fillHashMap(Morse.text, Morse.morse);
        
        // Force capital on var text 
        text = text.toUpperCase();
        
        // Transforms string into charArray
        char[] textArray = text.toCharArray();
        
        // convert char by char to morse
        for(int i = 0; i < textArray.length; i++){
            resultText += Morse.translation.get(String.valueOf(textArray[i]));
            if(textArray[i] != ' '){
                resultText += " ";
            }
        }
        
        // Clear the HashMap
        Morse.translation.clear();
        
        // Returns the translated text to morse
        return resultText;
    }
    
    // Trnaslates morse to text
    public static String morseToText(String morse){
        // Translated text
        String resultText = "";
        
        // Fill Hahsmap with morse as keys and text as values
        fillHashMap(Morse.morse, Morse.text);
        
        // Split the morse code into morse words
        String[] morseWords = morse.split("   ");
        
        // Translate morse to text
        for(int i = 0; i < morseWords.length; i++){
            // Converts every morse word into array or morse
            String[] morseArray = morseWords[i].split(" ");
            
            // Finally Converts the morse string into text string
            for(int j = 0; j < morseArray.length; j++){
                resultText += Morse.translation.get(morseArray[j]);
            }
            
            resultText += " ";
        }
        
        // Clear the HashMap
        Morse.translation.clear();
        
        // Returns the translated text to morse
        return resultText;
    }
    
    // Main function
    public static void main(String[] args) {
        
        // Scammer for reading data
        Scanner sc = new Scanner(System.in);
        
        // var option
        byte op = 0;
        
        // String data to translate
        String translate = null;
        
        // do-while execution program
        do{
            
            // Data input
            System.out.println("---------------------------------------------");
            System.out.println("Seleccione Opción");
            System.out.println("1 : Texto a Morse");
            System.out.println("2 : Morse a Texto");
            System.out.println("0 : Abortar programa");
            
            try{
                op = sc.nextByte();
                sc.nextLine();
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
            // if op is equal to 1 then translate text to morse
            if(op == 1){
                
                // Read data input
                System.out.println("---------------------------------------------");
                System.out.println("Inserte los datos para traducir de texto a morse");
                
                try{
                    translate = sc.nextLine();
                }catch(Exception e){
                    e.printStackTrace();
                }                
                
                // make translation and print to display
                System.out.println("Texto en morse: " + textToMorse(translate));
                System.out.println("");
            }else if (op == 2){
                
                // Read data input
                System.out.println("---------------------------------------------");
                System.out.println("Inserte los datos para traducir de morse a texto");
                
                try{
                    translate = sc.nextLine();
                }catch(Exception e){
                    e.printStackTrace();
                }                              
                
                // make translation and print to display
                System.out.println("Morse en texto: " + morseToText(translate));
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
            
        }while(op != 0 ); // Execute while option different to 0
    }
    
}
