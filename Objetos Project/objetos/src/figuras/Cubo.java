/*
 *  Author:         Carlos Guillermo Rolon Fabian
 *  Description:    Class Cubo
 *  Date:           27/20/2019
 */
/*-------------------------------------------------------------------------*/

// Package name
package figuras;

/*-------------------------------------------------------------------------*/

// Import Area

/*-------------------------------------------------------------------------*/
// Class Area
public class Cubo extends Cuadrado{
    /*-------------------------------------------------------------------------*/
    // Functions Area
    
    // Calculates Volume
    public Double calcularVolumen(){
        return Math.pow(this.side, 3);
    }
    
    // Calculates Perimeter for cube
    @Override
    public Double calcularPerimetro(){
        return super.calcularPerimetro() * 3;
    }
}
