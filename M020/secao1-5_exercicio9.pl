% https://swish.swi-prolog.org/
% Secao 1.5, Exercicio 9

patrao(miguel,joana).
patrao(judite,miguel).
patrao(anita,judite).
patrao(judite,kim).
patrao(kim,henrique).
patrao(anita,samuel).
patrao(henrique,jeferson).
patrao(miguel,hamal).

supervisor(X,Y) :- patrao(X,Y).

supervisor(X,Y) :- patrao(X,Z), supervisor(Z,Y).

% a)
% patrao(X,samuel).

% b)
% patrao(judite,X).

% c)
% supervisor(anita,X).
