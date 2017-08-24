% Pequeño programita que calcula las combinaciones de K en N

   fact(0,1).          % Caso Base del factorial

% Definimos la Funcion Factorial
fact(N,F):-
          N1 is N-1,
          fact(N1,F1),
          F is 	N*F1.

combinaciones(S,S,1).  % Abarca todo los casos para las  combinaciones igual a 1 


% Definimos la funcion de combinaciones

combinaciones(S,K,D):- 
	fact(S,T),     % Factorial de la parte del numerador

	
	fact(S-K,J),   % Factorial de la parte del denominador
	
	fact(K,U),     % Factorial de la parte del denominador

	D is T/(J*U).


   
    




