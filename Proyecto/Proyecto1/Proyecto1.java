package Poyecto01.Proyecto.Modelado_Programacion;
import java.io.*;
/**Main de java aqui se introduce los metodos del programa y el como seran ejecutados
 * */
public class Proyecto1 {
	
	public static void main (String args[]) {
		int dia= 0;
		int mes= 0;
		int año= 0;
		BufferedReader reader;
		String fecha= "";
		String[] meses= {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
		System.out.println("Introduce la fecha que desees conocer en Tonalpohualli:");
		System.out.println("No se aceptan símbolos de ninguana clase. \n Formato dd/mmm/aaaa");
		System.out.println("Solo son para fechas después de cristo.");
		try {
			reader= new BufferedReader(new InputStreamReader (System.in));
			fecha= reader.readLine();
			reader.close();
		} catch (IOException e) {
			System.out.println("La fecha que deseas ingresar no es valida");
		}
		
		String slash= "[/]+";
		String[] fechaSplit= fecha.split(slash);
		if (fechaSplit.length < 3) {
			System.err.println("Introduce el formato antes mencionado");
			return;
		}
		try {
			dia= Integer.parseInt(fechaSplit[0]);
		} catch (NumberFormatException nfe) {
			System.err.println("El número no válido en los dias");
			return;
		}
		String mesaux= fechaSplit[1].toLowerCase();
		if ( mesaux.length()== 3 ) {
			switch(mesaux) {
				case "Ene":
					 mes= 1;
					 break;
				case "Feb":
					 mes= 2;
					 break;
				case "Mar":
					 mes= 3;
					 break;
				case "Abr":
					 mes= 4;
					 break;
				case "May":
					 mes= 5;
					 break;
				case "Jun":
					 mes= 6;
					 break;
				case "Jul":
					 mes= 7;
					 break;
				case "Ago":
					 mes= 8;
					 break;
				case "Sep":
					 mes= 9;
					 break;
				case "Oct":
					 mes= 10;
					 break;
				case "Nov":
					 mes= 11;
					 break;
				case "Dic":
					 mes= 12;
					 break;
			}
		} else {
			for (int i= 0; i < meses.length; i++) {
				if (meses[i].equals(mesaux)) { 
					mes= (i + 1);
					break;
				}
			}
		}
		if (mes== 0) {
			System.err.println("ERROR Mes no valido");
			return;
		}
		if (fechaSplit[2].length()!= 4) {
			System.err.println("ERROR en el año");
			return;
		}
		try {
			año= Integer.parseInt(fechaSplit[2]);
		} catch (NumberFormatException nfe) {
			System.err.println("Introduce un año válido");
			return;
		}
		Calendario calendario= new Calendario(dia, mes, año);
		System.out.println(calendario.getSigno());
	}
}

