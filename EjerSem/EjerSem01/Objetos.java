import java.util.Scanner;
import java.math.BigInteger;
//import java.io.*;

public class Objetos {
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


