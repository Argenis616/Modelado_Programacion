#include <string.h> 
#include <stdio.h>
#include <gmp.h>// nos permite jugar con numeros muy grandes

/**
* Para compilar y ejecutar se necesita la biblioteca gmp 6.1.2 instalada
* y se compila con el siguiente comando
*
* $ gcc Combinaciones.c -lgmp
*
* ejecutandose con 
*
* $ ./a.out
*
* si estas en una distribucion de Debian/Ubuntu, o
*
* $ a.exe
*
* si estas en una distribucion de Windows
*
* El programa no acepta n = r ni numeros inferiores a 2 por problemas causados por "gmp"
*/

mpz_t r;// la usaremos para almacenar el resultado de un factorial

/**
* @brief Nos calcula el factorial de una "n" dada y la almacena en "r"
* @param n -  la n del cual sacaremos su factorial
*/
void factorial(int n) {
	mpz_set_ui(r, n); //asignamos "n" en "r"
	while (n > 1) {
		mpz_mul_ui(r, r, n-1); //multiplicamos "r" por "n-1" y lo guardamos en "r"
		--n;
	}
}


/**
* @brief metodo principal
*/
void main()
{
	int a, b;
	printf("Introduce n y r separados por un espacio: \n");
	scanf(" %d %d", &a, &b);

	if (a < b || a <= 0 || b <= 0 || a == b)
	{
      	printf("No introdujiste una entrada valida\n");
	}else {

		mpz_init(r);//inicializamos "r"

		mpz_t facA;
		mpz_t facA_B;
		mpz_t facB;
		factorial(a); // calculamos el factorial de "a" y se almacena en "r"
		mpz_init_set(facA,r); // asignamos "r" a "facA" al mismo tiempo que inicializamos "facA"
		factorial(a - b);
		mpz_init_set(facA_B,r);
		factorial(b);
		mpz_init_set(facB,r);


		mpz_mul(facB,facB,facA_B);//multiplicamos "facB" por "facA_B" y lo guardamos en "facB"
		mpz_divexact(r,facA,facB);//dividimos "facA" entre "facB" y lo guardamos en "r"
		
		gmp_printf ("Resultado: %Zd\n", r);//imprimimos "r"

		mpz_clear(facA);
		mpz_clear(facA_B);
		mpz_clear(facB);
		mpz_clear(r);
	}
}
