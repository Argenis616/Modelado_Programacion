//FILE : calcula_impuestos.c

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "multiplica.c"

#define MEX "MEXICO"
#define iva 16
#define EUA "EUA"
#define tax 3.45
#define COL "COLOMBIA"
#define renta 15

double total = 0;
double entrada = 0;

int main(int argc, char **argv)
{
	if(argc < 3)
		printf ("El programa va a tronar\n");
	if(strcmp(argv[ 1 ], MEX) == 0)
	{
		double amount = atof( argv [ 2 ] );
		if(amount != 0)
		{
			entrada += amount ;
			printf("Pagar al SAT: %f \n",entrada);
			total = multiplica(entrada , iva );
			printf("IVA: %f \n",total);
		}
	}
	else if(strcmp(argv[ 1 ] ,EUA) == 0 )
	{
		double amount = atof ( argv [ 2 ] ) ;
		if(amount != 0)
		{
			entrada += amount;
			printf ("Pay to US Government: %f \n",entrada);
			total = multiplica (entrada, tax) ;
			printf ("Tax: %f \n", total);
		}
	}
	else if(strcmp(argv[ 1 ], COL) == 0)
	{
		double amount = atof(argv[ 2 ]);
		if( amount != 0 )
		{
			entrada += amount ;
			printf("Pagar al Ministerio de Hacienda: %f \n",entrada);
			total = multiplica(entrada, renta);
			printf ("Renta: %f \n", total);
		}
	}
	
	double multiplica(double entrada, double tax)
	{
		return entrada * tax;
	}
	
	return 0;
}

