
/* -----------------------------------------------------------------
 * main.c
 * version 1.0
 * Copyright (C) 2017  Jorge Argenis Hernández Chávez.
 * Facultad de Ciencias,
 * Universidad Nacional Autonoma de Mexico, Mexico.
 *
 * Este programa es software libre; se puede redistribuir
 * y/o modificar en los terminos establecidos por la
 * Licencia Publica General de GNU tal como fue publicada
 * por la Free Software Foundation en la version 2 o
 * superior.
 *
 * Este programa es distribuido con la esperanza de que
 * resulte de utilidad, pero SIN GARANTIA ALGUNA; de hecho
 * sin la garantia implicita de COMERCIALIZACION o
 * ADECUACION PARA PROPOSITOS PARTICULARES. Vease la
 * Licencia Publica General de GNU para mayores detalles.
 *
 * Con este programa se debe haber recibido una copia de la
 * Licencia Publica General de GNU, de no ser asi, visite el
 * siguiente URL:
 * http://www.gnu.org/licenses/gpl.html
 * o escriba a la Free Software Foundation Inc.,
 * 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 * -----------------------------------------------------------------
 */
 /**
 * @file Combinacion.java
 * @author Jorge Argenis Hernández Chávez
 * @date 24 Ago 2017
 * @brief File containing just Combinate funtion.
 *
 * El uso de este programa es hacer funcionar la formula de combinatoria.
 *
 * El programa usa el estandar de documentacion que define el uso de 
 * doxygen.
 *
 * @see http://www.stack.nl/~dimitri/doxygen/manual/index.html
 *
 */
/* equipo 
 * Orientación a Objetos: Hernández Chávez Jorge Argenis(JAVA)
 * Estructutado:Hiram Ehecatl Lujano Pastrana (C)
 * Funcional:Hurtado Gutiérrez Marco Antonio (HASKELL)
 * Logico: Ken Gai Huang (Lógico)
 */



import java.util.Scanner;
import java.math.BigInteger;
//import java.io.*;

public class Combinacion {
	public static void main (String args[]) {
		try{
			Scanner in = new Scanner(System.in);
			System.out.println("Escribe el numero n");
			BigInteger n = new BigInteger(in.nextLine());
			System.out.println("Escribe el numero r");
			BigInteger r = new BigInteger(in.nextLine());
			Factorial combinaciones = new Factorial(n, r);
			System.out.println(combinaciones.toString());
		} catch (Exception e) {
			System.out.println("No es un numero!");
		
		}
			
		
	}
}


