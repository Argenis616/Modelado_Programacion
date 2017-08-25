% Hiram Ehecatl Lujano Pastrana
% Jorge Argenis
% Ken Gai Huang
% Marco Antonio Hurtado
%

% Pequeño programita que calcula las combinaciones de K en N

   fact(0,1).          % Caso Base del factorial

% Definimos la Funcion Factorial
fact(N,F):- 
     (
     N>0 ->
         ( 
          N1 is N-1,
          fact(N1,F1),
          F is 	N*F1
         );
      write('***Error 404, Por favor ingrese un numero natural***')
     )
    .
combinaciones(S,S,1).  % Abarca todo los casos para las  combinaciones igual a 1 


% Definimos la funcion de combinaciones

combinaciones(S,K,D):- 
( 
 S>K ->
    (
	fact(S,T),     % Recibe S,lo guarda en T(numerador).

	
	fact(S-K,J),   % Recibe S-K,lo guarda en J(denominador).
	
	fact(K,U),     % Recibe K,lo guarda en U(denominador).

	D is T/(J*U)  % Realiza la operacion los valores de las variables.	

  );
 write('Error 666, K no puede ser mas grande que N')
  )
.
   
    




