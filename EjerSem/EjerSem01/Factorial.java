import java.math.BigInteger;
/** Clase Factorial aqui diseñamos el programa para la Formula de combinatoria (N en R)
 */
public class Factorial{
	private BigInteger n;
	private BigInteger r;
	/** Constructor único que es inmutable
	 */
	public Factorial(BigInteger n, BigInteger r){
		this.n = n;
		this.r = r;
	}
	/** Método que regresa el Factorial de N
	 * @return Regresa el factoril de un numero 
	 */
	public BigInteger factorial(BigInteger num){
		if(num.equals(new BigInteger("0"))) {
			return new BigInteger("1");
		} else {
			return num.multiply(factorial(num.subtract(new BigInteger("1"))));
		}
	}
	/**Método que regresa la formula de combinaciones de n en r
	 * @return regresa la fórmula de combinatoria
	 */
	public BigInteger combinatoria() {
		if(n.compareTo(r) == 1){
			BigInteger comb = factorial(n).divide((factorial(r).multiply(factorial(n.subtract(r)))));
			return comb;
		}else{
			System.out.println("Escribe el numero n mayor que r");
			return null;
		} 
	}
	/**Método que regresa el formato de salida
	 * @return Formato de salida
	 */
	public String toString(){
		String s = "Las combinaciones son: \n";
		s += "Combinaciones " + combinatoria() ;
		 return s;
	}
}
