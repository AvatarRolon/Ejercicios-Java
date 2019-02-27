/*
 *  Author:         Carlos Guillermo Rolon Fabian
 *  Description:    Class Cuadrado
 *  Date:           27/20/2019
 */
/*-------------------------------------------------------------------------*/

// Package name
package figuras;

/*-------------------------------------------------------------------------*/

// Import Area

/*-------------------------------------------------------------------------*/
// Class Area
public class Cuadrado {
    
    /*-------------------------------------------------------------------------*/
    // Attrs Area
    protected double side; 
    
    /*-------------------------------------------------------------------------*/
    // Getters, Setters Area
    
    // Set Side
    public void setSide(double side){
        this.side = side;
    }
    
    // Get Side
    public Double getSide(){
        return this.side;
    }    
    
    /*-------------------------------------------------------------------------*/
    // Functions Area
    
    // Calculates Area
    public Double calcularArea(){
        return Math.pow(this.side, 2);
    }
    
    // Calculate Perimeter
    public Double calcularPerimetro(){
        return this.side * 4;
    }
    
    /*-------------------------------------------------------------------------*/
    // Constructors Area
    public Cuadrado (){
        this.side = 0;
    }
    
    public Cuadrado(double side){
        this.side = side;
    }
}
