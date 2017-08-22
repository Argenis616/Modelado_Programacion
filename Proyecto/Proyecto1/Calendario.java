//package Poyecto01.Proyecto.Modelado_Programacion;
/**<p>Clase Calendario aqui diseñaremos un calendario Tonalpohualli</p>
 * Este calendario se denota por dias meses y años
 */
public class Calendario{
	private int dia;
	private int mes;
	private int año;
	private boolean error;
	/**Constructor único. Como no tenemos seter's nuestras fechas son inmutables.
	 * @param dia primer entrada de la fecha.
	 * @param mes segunda entrada de la fecha.
	 * @param año tercer entrada de la fecha.
	 * Tambien nos dice si la fecha es con el cambio Gregoriano.
	 */
	public Calendario( int dia, int mes, int año){
		this.dia = dia;
		this.mes = mes;
		this.año = año;
		/*tomaremos la fecha de america latina la reform gregoriana*/
		if(año > 1583){
			error = true;
		}else if(dia > 5 && mes >= 10 && año==1583){
			error = true;
			}else{
				error = false;
			}

	}
	/**Metodo para calcular el dia juliano
	 *@param añojuliano primer entrada para conocer la fecha juliana.
	 *@param mesjuliano segunda entrada para conocer la fecha juliana.
	 *@param diajuliano tercera entrada para conocer la fecha juliana.
	 *@param varAux guarda la fecha correcta en el valor juliano.
	 *@return regresa la fecha juliana.
	 */
	 private int juliano(){
		 int añoJuliano;
		 int mesJuliano;
		 int diaJuliano;
		 int varAux;

		 diaJuliano = (14-mes)/12;
		 añoJuliano = año + 4800 -diaJuliano;
		 mesJuliano = mes + (12*diaJuliano - 3);
		 if(error){
			 varAux = dia +((153 * mesJuliano + 2) / 5) + (365 * añoJuliano) + (añoJuliano/4) - (añoJuliano/100) + (añoJuliano/400) - 32045;
		 }else{
			 varAux = dia +((153 * mesJuliano + 2) / 5) + (365 * añoJuliano) + (añoJuliano/4) - 32083;

		 }
		 return varAux;
	 }
	 /**Método para regresar el dia en el calendario maya
	  *@return regresa el dia en maya.
	  */
	  private int getDiaCalendarioM(){
		  int diaMaya;
		  diaMaya = juliano() - 2276184;
		  int aux;
		  aux = ((Math.floorMod(diaMaya,13)+13)%13)+1;
		  return aux;
	  }
	  /**Método para regresar el signo del dia en el calendario maya
	   *@return regresa el signo en maya.
	   */
	   private int getSignoMaya(){
		   int diaMayaS;
		   diaMayaS = juliano() - 2276184;
		   int aux2;
		   aux2 = ((Math.floorMod(diaMayaS, 20) + 20) % 20) < 0 ? ((Math.floorMod(diaMayaS, 20) + 20) % 20) + 20 : (Math.floorMod(diaMayaS, 20) + 20) % 20;
		   return aux2;

	   }
	   /**Método para regresar el año en el clendario maya
	    *@return regresa el año en maya.
	    */
	    private int getAnoClendarioM(){
			int añoMaya;
			añoMaya = juliano() - 2276184;
			int aux3;
			aux3 = (int) Math.round(añoMaya/365);
			int aux4;
			aux4 = ((Math.floorMod(aux3, 13) + 13) % 13) + 3 > 13 ? ((((Math.floorMod(aux3, 13) + 13) % 13) + 3) - 13) : (Math.floorMod(aux3, 13) + 13) % 13 + 3;
			return aux4;
		}
		/**Método para regresar el simbolo maya
		 *@return regresa el signo en maya.
		 */
		 private int getAsignoMaya(){
			 double añoMayaS;
			 añoMayaS = juliano() - 2276184;
			 int aux5;
			 aux5 = (int) Math.round(añoMayaS/365);
			 int aux6;
			 aux6 = ((Math.floorMod(aux5, 4) + 4) % 4);
			 return aux6;
		 }
		 /**Método que asigna el signo a la fecha del calendario
		  *@return el formato que lleva la fecha.
		  */
		  public String getSigno(){
			  String españolDia = "";
			  String nahuatlDia = "";
			  String españolAño = "";
			  String nahuatlAño = "";
			  String s = "";
			  switch(getSignoMaya()){
				  case 0:
					españolDia = "Lagarto";
					nahuatlDia = "Cipactli";
					break;
				case 1:
					españolDia = "Viento";
					nahuatlDia = "Ehecatl";
					break;
				case 2:
					españolDia = "Casa";
					nahuatlDia = "Calli";
					break;
				case 3:
					españolDia = "Lagartija";
					nahuatlDia = "Cuetzpalin";
					break;
				case 4:
					españolDia = "Serpiente";
					nahuatlDia = "Cóatl";
					break;
				case 5:
					españolDia = "Muerte";
					nahuatlDia = "Miquztli";
					break;
				case 6:
					españolDia = "Venado";
					nahuatlDia = "Mazatl";
					break;
				case 7:
					españolDia = "Conejo";
					nahuatlDia = "Tochtli ";
					break;
				case 8:
					españolDia = "Agua";
					nahuatlDia = "Atl";
					break;
				case 9:
					españolDia = "Perro";
					nahuatlDia = "Itzcuintli";
					break;
				case 10:
					españolDia = "Mono";
					nahuatlDia = "Ozomatli";
					break;
				case 11:
					españolDia = "Hierba";
					nahuatlDia = "Malinalli";
					break;
				case 12:
					españolDia = "Caña";
					nahuatlDia = "Ácatl";
					break;
				case 13:
					españolDia = "Jaguar";
					nahuatlDia = "Ocelotl";
					break;
				case 14:
					españolDia = "Águila";
					nahuatlDia = "Cuauhtli";
					break;
				case 15:
					españolDia = "Buitre";
					nahuatlDia = "Cozcaquauhtli";
					break;
				case 16:
					españolDia = "Movimiento";
					nahuatlDia = "Ollin";
					break;
				case 17:
					españolDia = "Pedernal";
					nahuatlDia = "Técpatl";
					break;
				case 18:
					españolDia = "Lluvia";
					nahuatlDia = "Quiahuitl";
					break;
				case 19:
					españolDia = "Flor";
					nahuatlDia = "Xochitl";
					break;
			  }
			  switch(getAsignoMaya()){
				  case 0 :
					españolAño = "Casa";
					nahuatlAño = "Calli";
					break;
				case 1 :
					españolAño = "Conejo";
					nahuatlAño = "Tochtli";
					break;
				case 2 :
					españolAño = "Caña";
					nahuatlAño = "Ácatl";
					break;
				case 3 :
					españolAño = "Pedernal";
					nahuatlAño = "Técpatl";
					break;
			  }
			  s+= String.format("Día %d-%s del año %d-%s o %d-%s, %d-%s", getDiaCalendarioM(), españolDia, getAnoClendarioM(), españolAño, getDiaCalendarioM(), nahuatlDia, getAnoClendarioM(), nahuatlAño);
		 return s;
		  }
}
